package client_server;

import java.io.*;
import java.net.*;

public class rpc {
 
    public Socket reqSock,socket;
    public ServerSocket sersock;
    public String curIp;
    public String sendMessage;
    boolean threadSendAlive;
    
    public rpc(){
        threadSendAlive=false;
    }
    public String getHostIp() {
        String localIp = "127.0.0.1";
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            localIp = String.valueOf((localhost.getHostAddress()).trim());
            System.out.println("Your ip: " + localIp);
        } catch (UnknownHostException e) {
            System.out.println(e);
        }
        curIp=localIp;
        return localIp;
    }

    public String receive() {
        String receiveMessage = "";
        try {
            socket = sersock.accept();
            System.out.println("Ready to recieve..");
            InputStream istream = socket.getInputStream();
            BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
            while (true) {
                if(receiveRead.ready()){
                    receiveMessage = receiveRead.readLine();
                    if (receiveMessage != null) {
                        System.out.println(curIp + " Received: " + receiveMessage);
                        int delemeter=receiveMessage.indexOf('|');
                        String msgType=receiveMessage.substring(0,delemeter );
                        if(msgType.equals("token")){
                            
                        }
                    }
                } 
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return receiveMessage;
    }

    public void send() {
        try {
            //socket = sersock.accept();
            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Sending from " + curIp + ": " + sendMessage);
            out.write(sendMessage);
            out.newLine();
            out.flush();
        } catch (IOException e) {
            System.out.println(e);
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
            threadSendAlive=true;
            send();
        }
    };
}
