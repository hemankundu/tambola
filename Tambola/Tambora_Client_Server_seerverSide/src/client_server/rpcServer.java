package client_server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class rpcServer {
 
    public ArrayList<Socket> sock;
    public ServerSocket ackSock;
    public String curIp;
    public String sendMessage;
    boolean threadSendAlive;
    ArrayList<Client> clients;
    Integer startPort;
    public rpcServer(){
        threadSendAlive=false;
        sock=new ArrayList<>();
        clients=new ArrayList<>();
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

    public void acknowledge(){
        try {
            ackSock = new ServerSocket(2500);
            System.out.println("Server waiting for clients..");
            try {
                Socket socket = ackSock.accept();
                InputStream istream = socket.getInputStream();
                BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
                String cliInfo = receiveRead.readLine();
                int delemeter=cliInfo.indexOf('|');
                String ip = cliInfo.substring(0, delemeter);
                String name=cliInfo.substring(delemeter);
                //clients.add(new Client(name,ip));
                System.out.println("New client added: " + ip);
                addClientToForm();
                ackSock.close();  
            } catch (IOException e) {
                System.out.println(e);
            }
            
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public void receive() {
        Integer clientCount=clients.size();
        String [] receivedMessage =new String[20];
        while(true){
            for (int i = 0; i < clientCount; i++) {
                try {
                    InputStream istream = sock.get(i).getInputStream();
                    InputStreamReader isReader = new InputStreamReader(istream);
                    BufferedReader receiveRead = new BufferedReader(isReader);
                    if (receiveRead.ready()) {
                        receivedMessage[i] = receiveRead.readLine();
                        System.out.println(curIp + " Received: " + receivedMessage[i]);
                    }
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
        
        //return receiveMessage;
    }

    public void send(String sendMessage) {
        Integer clientCount=clients.size();
        for(int i=0;i<clientCount;i++){
            try {
                BufferedWriter out=new BufferedWriter(new OutputStreamWriter(sock.get(i).getOutputStream()));
                System.out.println("Sending from " + curIp + " to "+sock.get(i)+ " :"+ sendMessage);
                out.write(sendMessage);
                out.newLine();
                out.flush();
            } catch (IOException e) {
                System.out.println(e);
            }
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
            send(sendMessage);
        }
    };
    public Thread threadAck = new Thread() {
        @Override
        public void run() {
            //threadSendAlive = true;
            while(true)
                acknowledge();
        }
    };

    private void addClientToForm() {
        
    }
}
