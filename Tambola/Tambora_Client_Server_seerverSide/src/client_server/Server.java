package client_server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private String ip,name,id;
    public ArrayList<Socket> sock;
    public ServerSocket ackSock;
    public String curIp;
    public String sendMessage;
    boolean threadSendAlive;
    ArrayList<Client> clients;
    Integer startPort,curClient;
    ArrayList<Integer> randomNumbers;
    ArrayList<Claim> claimReq,claims;
   
    private serverForm serForm;
    public Server(){
        ip=getHostIp();
        name="Main Server";
        threadSendAlive = false;
        sock = new ArrayList<>();
        clients = new ArrayList<>();
        curClient=0;
        claims=new ArrayList<>(14);
        claimReq=new ArrayList<>(7);
    }
    public boolean connect(){
        boolean success=true;
        Integer clientCount=clients.size();
        for(int i=0;i<clientCount;i++){
            try {
                sock.add(new Socket(clients.get(i).ip,Integer.valueOf(clients.get(i).port)));
                printLog(ip + ": Sender ready for "+clients.get(i).ip);
            } catch (IOException e) {
                printLog(String.valueOf(e));
                success=false;
            }
        }
        threadReceive.start();
        threadSend.start();
        return success;
    }
    public void show(){
        //connect();
        serForm = new serverForm();
        serForm.setVisible(true);
        
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

    public void acknowledge() throws IOException {
        while(true){
            try {
                ackSock = new ServerSocket(2500);
                printLog("Server waiting for clients..");
                serForm.serStatLabel.setText("Server running at " + ip);
                try {
                    Socket socket = ackSock.accept();
                    InputStream istream = socket.getInputStream();
                    BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
                    String cliInfo = receiveRead.readLine();
                    int delemeter = cliInfo.indexOf('|');
                    String ipLocal = cliInfo.substring(0, delemeter);
                    String portLocal=cliInfo.substring(delemeter + 1);
                    delemeter = portLocal.indexOf('|');
                    String nameLocal=portLocal.substring(delemeter + 1);
                    portLocal=portLocal.substring(0, delemeter);
                    clients.add(new Client(nameLocal, ipLocal,portLocal));
                    printLog("New client added: " +ipLocal+" : "+portLocal);
                    addClientToForm(clients.get(clients.size() - 1));
                    ackSock.close();
                } catch (IOException e) {
                    printLog(String.valueOf(e));
                }

            } catch (IOException e) {
                printLog(String.valueOf(e));
            }
        }
        
    }

    public void receive() {
        Integer clientCount = clients.size();
        String[] receivedMessage = new String[20];
        boolean claimPending=false;
        while (true) {
            claimPending=false;
            for (int i = 0; i < clientCount; i++) {
                try {
                    InputStream istream = sock.get(i).getInputStream();
                    InputStreamReader isReader = new InputStreamReader(istream);
                    BufferedReader receiveRead = new BufferedReader(isReader);
                    //if(isReader.ready()||receiveRead.ready())
                        //System.out.println(isReader.ready()+"    "+receiveRead.ready());
                    //receivedMessage[i] = receiveRead.readLine();
                    //System.out.println("receivedMessage :"+receivedMessage[i]);
                    if (receiveRead.ready()) {
                        receivedMessage[i] = receiveRead.readLine();
                        //System.out.println("receivedMessage :" + receivedMessage[i]);
                        printLog(curIp + " Received: " + receivedMessage[i]);
                        int delemeter=receivedMessage[i].indexOf('|');
                        String msgType=receivedMessage[i].substring(0, delemeter);
                        String ipMsg=receivedMessage[i].substring(delemeter+1);
                        delemeter=ipMsg.indexOf('|');
                        String clientIp=ipMsg.substring(0, delemeter);
                        String msg=ipMsg.substring(delemeter+1);
                        if(msgType.equals("claim")){
                            claimPending=true;
                            Scanner in=new Scanner(msg);
                            Claim claim=new Claim();
                            claim.rowCol=in.nextInt(); //row or column
                            claim.rowColNum=in.nextInt(); //row or coulmn number
                            /*int j;
                            for(j=0;j<clientCount;j++){
                                System.out.println(clientIp+"  "+clients.get(j).ip);
                                if(clients.get(j).ip.equals(clientIp))
                                    break;
                            }*/
                            claim.clientIndex=i;
                            claimReq.add(claim);
                            printLog(claim.clientIndex+" claiming for "+ claim.rowCol+" "+claim.rowColNum);
                        }
                    }
                } catch (IOException e) {
                    printLog(String.valueOf(e));
                }
            }
            if(claimPending){
                processClaimReq();
            }
        }

        //return receiveMessage;
    }

    public void broadcast(String sendMessage) {
        Integer clientCount = clients.size();
        for (int i = 0; i < clientCount; i++) {
            send("broadcast",sendMessage,i);
            
        }
    }

    public boolean send(String header,String sendMessage,int i) {
        boolean success=true;
        if(i==-1) return true;
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sock.get(i).getOutputStream()));
            printLog("Sending from " + curIp + " to " + sock.get(i).getInetAddress() + " :" + header+"|"+sendMessage);
            out.write(header+"|"+sendMessage);
            out.newLine();
            out.flush();
        } catch (IOException e) {
            printLog(String.valueOf(e));
            success=false;
        }
        return success;
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
            threadSendAlive = true;
            send("",sendMessage,-1);
        }
    };
    public Thread threadAck = new Thread(){
        @Override
        public void run() {
            try{
                acknowledge();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    private void addClientToForm(Client client) {
        String str=client.name+" ("+client.ip+" : "+client.port+")";
        serForm.cliLbl[clients.size()-1].setText(str);
        
    }
    private void processClaimReq(){
        ArrayList<Claim> curClaims=new ArrayList<>();
        for(int i=0;i<claimReq.size();i++){
            //search if already taken
            boolean won=true;
            for(int j=0;j<claims.size();j++){
                if((claims.get(j).rowCol==claimReq.get(i).rowCol)
                        &&(claims.get(j).rowColNum==claimReq.get(i).rowColNum)){
                    //taken
                    won=false;
                    break;
                }
            }
            if(won){
                curClaims.add(claimReq.get(i));
                printLog(claimReq.get(i).clientIndex+" won.");
            }    
            else{
                send("prize", "0",claimReq.get(i).clientIndex); //inform client
            }
            
        }
        //check for draw
        ArrayList<Integer>[] clientWon=new ArrayList[7]; 
        for(int i=0;i<7;i++){ //3 rows 4 cols
            clientWon[i]=new ArrayList<>();
        }
        for(int i=0;i<curClaims.size();i++){
            if(curClaims.get(i).rowCol==1&&curClaims.get(i).rowColNum==1){ 
                //R1
                clientWon[0].add(curClaims.get(i).clientIndex);
            }
            else if (curClaims.get(i).rowCol == 1 && curClaims.get(i).rowColNum == 2) {
                //R2
                clientWon[1].add(curClaims.get(i).clientIndex);
            }
            else if (curClaims.get(i).rowCol == 1 && curClaims.get(i).rowColNum == 3) {
                //R3
                clientWon[2].add(curClaims.get(i).clientIndex);
            }
            else if (curClaims.get(i).rowCol == 2 && curClaims.get(i).rowColNum == 1) {
                //c1
                clientWon[3].add(curClaims.get(i).clientIndex);
            }
            else if (curClaims.get(i).rowCol == 2 && curClaims.get(i).rowColNum == 2) {
                //c2
                clientWon[4].add(curClaims.get(i).clientIndex);
            }
            else if (curClaims.get(i).rowCol == 2 && curClaims.get(i).rowColNum == 3) {
                //c3
                clientWon[5].add(curClaims.get(i).clientIndex);
            }
            else if (curClaims.get(i).rowCol == 2 && curClaims.get(i).rowColNum == 4) {
                //c4
                clientWon[6].add(curClaims.get(i).clientIndex);
            }
        }
        //send prize
        for(int i=0;i<7;i++){
            String winName="",winPos="";
            if(!clientWon[i].isEmpty()){
                if(i<3){
                    winPos="Row "+String.valueOf(i+1);//0 1 2 to 1 2 3
                }
                else{
                    winPos="Column "+String.valueOf(i-2);//3 4 5 6 to 1 2 3 4
                }
                int prize=(int)(100/clientWon[i].size()); //break prize into pieces
                for (int j = 0; j < clientWon[i].size(); j++) {
                    send("prize",String.valueOf(prize),clientWon[i].get(j));
                    Client tmpCli=clients.get(clientWon[i].get(j));
                    winName=winName+tmpCli.name+"("+tmpCli.ip+":"+tmpCli.port+"), ";
                }
                broadcast(winPos+"|"+winName);
            }
        }
        //add as claimed
        for(int i=0;i<curClaims.size();i++){
            claims.add(curClaims.get(i));
        }
        claimReq.clear();
    }
    public void printLog(String str){
        try{
            serForm.log.append("[.] "+str+"\n");
            //serForm.jScrollPane1.
            //serForm.log.setText(serForm.log.getText()+"[.] "+str+"\n");
        }
        catch(NullPointerException e){
            System.out.println(str);
        }
    }
}
