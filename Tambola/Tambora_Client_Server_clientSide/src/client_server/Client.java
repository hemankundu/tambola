package client_server;

import java.awt.Color;
import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.Scanner;

public class Client {
    public String ip,name,id,serverIp;
    Integer sendPort,recPort,reqPort,score;
    Integer[][] token;
    boolean[][] cellDone;
    boolean[] claimed;
    public Socket reqSock, socket;
    public ServerSocket sersock;
    public String curIp;
    public String sendMessage;
    boolean threadSendAlive;
    private clientForm cliForm;
    public Client(){
        threadSendAlive=false;
        ip=getHostIp();
        name="Player";
        recPort=3000;
        reqPort=2500;
        serverIp="127.0.0.1";
        score=0;
        claimed=new boolean[7];
        for(int i=0;i<7;i++)
            claimed[i]=false;
    }
    
    public String getHostIp() {
        String localIp = "127.0.0.1";
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            localIp = String.valueOf((localhost.getHostAddress()).trim());
            printLog("Your ip: " + localIp);
        } catch (UnknownHostException e) {
            printLog(String.valueOf(e));
        }
        curIp = localIp;
        return localIp;
    }

    public String receive() {
        String receiveMessage = "";
        try {
            socket = sersock.accept();
            printLog("Ready to recieve..");
            InputStream istream = socket.getInputStream();
            BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
            while (true) {
                if (receiveRead.ready()) {
                    receiveMessage = receiveRead.readLine();
                    if (receiveMessage != null) {
                        printLog(curIp + " Received: " + receiveMessage);
                        int delemeter = receiveMessage.indexOf('|');
                        String msgType = receiveMessage.substring(0, delemeter);
                        if (msgType.equals("token")) {
                            loadToken(receiveMessage.substring(delemeter+1));
                        }
                        else if (msgType.equals("rn")) {
                            processRn(receiveMessage.substring(delemeter + 1));
                        }
                        else if (msgType.equals("prize")) {
                            updateScore(receiveMessage.substring(delemeter + 1));
                       
                           
                        }
                        else if (msgType.equals("broadcast")) {
                            updateClaimBoard(receiveMessage.substring(delemeter + 1));

                        }
                        else {
                            
                        }
                    }
                }
            }
        } catch (IOException e) {
            printLog(String.valueOf(e));
        }
        return receiveMessage;
    }

    public void send(String sendMessage) {
        if(sendMessage.equals(".init.")) return;
        try {
            //socket = sersock.accept();
            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            printLog("Sending from " + curIp + ": " + sendMessage);
            out.write(sendMessage);
            out.newLine();
            out.flush();
        } catch (IOException e) {
            printLog(String.valueOf(e));
        }
    }

    public Thread threadReceive = new Thread() {
        @Override
        public void run() {
            receive();
        }
    };
    public Thread threadSend = new Thread() {
        @Override
        public void run() {
            //threadSendAlive = true;
            send(".init.");
        }
    };
    
    private int getRandomPort(int low,int high){
        Random random=new Random();
        int rn=random.nextInt(high-low)+low;
        return rn;
    }
    
    public boolean request(){
        boolean success=true,portFound=false;
        while(!portFound){
            recPort=getRandomPort(3000,4000);
            try {
                sersock = new ServerSocket(recPort);
                printLog(ip + ": Receiver(" + recPort + ") ready");
                portFound=success=true;
            } catch (IOException e) {
                success = false;
                printLog(String.valueOf(e));
            }
        }
        try {
            ip=getHostIp();
            printLog("Requesting server..");
            reqSock = new Socket(serverIp,reqPort);
            printLog(ip + " Successful");
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(reqSock.getOutputStream()));
            printLog(curIp + " Sending client info..");
            String cliInfo = ip+"|"+recPort+"|"+name;
            out.write(cliInfo);
            out.newLine();
            out.flush();
            reqSock.close();
            printLog("Sent!");
        } 
        catch (IOException e) {
            printLog("Request to server failed!");
            success=false;
            printLog(String.valueOf(e));
        }
        if(success){
            threadReceive.start();
            threadSend.start();
        }
        return success;
        
    }
    public void show(){
        //connect();
        cliForm = new clientForm();
        cliForm.setVisible(true);
        
    }

    private void loadToken(String tokenStr) {
        token=new Integer[3][4];
        cellDone=new boolean[3][4];
        Scanner in=new Scanner(tokenStr);
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                token[i][j]=in.nextInt();
                cellDone[i][j]=false;
                cliForm.btnMat[i][j].setText(String.valueOf(token[i][j]));
            }
        }
    }
    public void processRn(String rnStr){
        Integer rn=Integer.valueOf(rnStr);
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                if(token[i][j]==rn.intValue()){
                    cellDone[i][j]=true;
                    cliForm.btnMat[i][j].setEnabled(false);
                    break;
                }
            }
        }
        checkWin();
    }
    public void checkWin(){
        for(int i=0;i<3;i++){
            boolean res=true;
            for(int j=0;j<4;j++)
                res&=cellDone[i][j];
            if(res&&!claimed[i]){ //this row not claimed before by this client
                String str="claim|"+ip+"|"+1+" "+(i+1); //1 indicates row
                cliForm.NotifyLbl("Claiming for row "+(i+1)+"...", 2000);
                send(str);
                claimed[i]=true;
            }
        }
        for (int i = 0; i < 4; i++) {
            boolean res = true;
            for (int j = 0; j < 3; j++) {
                res &= cellDone[j][i];
            }
            if (res&&!claimed[i+3]) {
                String str = "claim|"+ip+"|" + 2+" " + (i+1); //2 indicates column
                cliForm.NotifyLbl("Claiming for column "+(i+1)+"...", 2000);
                send(str);
                claimed[i+3]=true;
            }
        }
    }
    public void updateScore(String prize){
        int prizeInt=Integer.valueOf(prize);
        score+=prizeInt;
        if(prizeInt==0){
            cliForm.NotifyLbl("Claimed prize already taken!", 2000);
        }
        cliForm.scoreLbl.setText(String.valueOf(score));
    }
    public void printLog(String str){
        try{
            cliForm.Log.append("[.] "+str+"\n");
            //cliForm.Log.setText(cliForm.Log.getText()+"[.] "+str+"\n");
        }
        catch(NullPointerException e){
            System.out.println(str);
        }
    }

    private void updateClaimBoard(String str) {
        int delemeter=str.indexOf("|");
        String rowColStr=str.substring(0,delemeter);
        String winner=str.substring(delemeter+1);
        Scanner scanner=new Scanner(rowColStr);
        String rowCol=scanner.next();
        int rowColNum=scanner.nextInt();
        String curCli="("+ip+":"+recPort+")";
        boolean curWon=winner.contains(curCli.subSequence(0, curCli.length()));
        Color color=Color.RED;
        if(curWon){
            color=Color.GREEN;
        }
        cliForm.NotifyLbl(rowColStr+" Winner: "+winner, 2000);
        if(rowCol.equals("Row")){
            cliForm.claimBoard[rowColNum-1].setText("Row "+rowColNum+" : "+winner.substring(0, winner.length()-2));  
            for(int i=0;i<4;i++){
                Color curColor=cliForm.btnMat[rowColNum-1][i].getBackground();
                if(!(curColor.equals(Color.RED)||curColor.equals(Color.GREEN)))
                    cliForm.btnMat[rowColNum-1][i].setBackground(color);
                else if(!color.equals(curColor)){
                    cliForm.btnMat[rowColNum-1][i].setBackground(Color.MAGENTA);
                }
            }
        }
        else if (rowCol.equals("Column")) {
            cliForm.claimBoard[rowColNum + 2].setText("Column " + rowColNum + " : " + winner.substring(0, winner.length() - 2));
            for (int i = 0; i < 3; i++) {
                Color curColor=cliForm.btnMat[i][rowColNum-1].getBackground();
                if(!(curColor.equals(Color.RED)||curColor.equals(Color.GREEN)))
                    cliForm.btnMat[i][rowColNum-1].setBackground(color);
                else if(!color.equals(curColor)){
                    cliForm.btnMat[i][rowColNum-1].setBackground(Color.MAGENTA);
                }
            }
        }
    }
}
