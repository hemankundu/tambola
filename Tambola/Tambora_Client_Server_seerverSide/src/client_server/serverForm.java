package client_server;

import java.io.*;
import static java.lang.Thread.sleep;
import java.net.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import java.util.Timer;

public class serverForm extends javax.swing.JFrame {
    private boolean regEnabled,tokenSent;
    private final Server ser;
    int hemanCount;
    public JLabel[] cliLbl;
    public serverForm() {
        initComponents();
        ser=Client_Server.server;
        tokenSent=regEnabled=false;
        hemanCount=0;
        sendBtn.setVisible(false);
        sendTxt.setVisible(false);
        initCliLbl();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serStatLabel = new javax.swing.JLabel();
        regTogBtn = new javax.swing.JToggleButton();
        sendBtn = new javax.swing.JButton();
        sendTxt = new javax.swing.JTextField();
        connectBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        clientPanel = new javax.swing.JPanel();
        cliLbl1 = new javax.swing.JLabel();
        cliLbl2 = new javax.swing.JLabel();
        cliLbl3 = new javax.swing.JLabel();
        cliLbl4 = new javax.swing.JLabel();
        cliLbl5 = new javax.swing.JLabel();
        cliLbl6 = new javax.swing.JLabel();
        cliLbl7 = new javax.swing.JLabel();
        cliLbl8 = new javax.swing.JLabel();
        sendTokenBtn = new javax.swing.JButton();
        sendRandomNumber = new javax.swing.JButton();
        randomLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        hemanLbl = new javax.swing.JLabel();
        notiLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        serStatLabel.setText("Server status: Unknown");

        regTogBtn.setText("Registration: OFF");
        regTogBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                regTogBtnItemStateChanged(evt);
            }
        });

        sendBtn.setText("Send");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        connectBtn.setText("Connect to clients");
        connectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Clients");

        clientPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout clientPanelLayout = new javax.swing.GroupLayout(clientPanel);
        clientPanel.setLayout(clientPanelLayout);
        clientPanelLayout.setHorizontalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cliLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cliLbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cliLbl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cliLbl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cliLbl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cliLbl6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cliLbl7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cliLbl8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        clientPanelLayout.setVerticalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cliLbl1)
                .addGap(18, 18, 18)
                .addComponent(cliLbl2)
                .addGap(18, 18, 18)
                .addComponent(cliLbl3)
                .addGap(18, 18, 18)
                .addComponent(cliLbl4)
                .addGap(18, 18, 18)
                .addComponent(cliLbl5)
                .addGap(18, 18, 18)
                .addComponent(cliLbl6)
                .addGap(18, 18, 18)
                .addComponent(cliLbl7)
                .addGap(18, 18, 18)
                .addComponent(cliLbl8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sendTokenBtn.setText("Send Tokens to Clients");
        sendTokenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendTokenBtnActionPerformed(evt);
            }
        });

        sendRandomNumber.setText("Send New Random Number");
        sendRandomNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendRandomNumberActionPerformed(evt);
            }
        });

        jScrollPane1.setAutoscrolls(true);

        log.setEditable(false);
        log.setColumns(20);
        log.setRows(5);
        log.setAutoscrolls(false);
        jScrollPane1.setViewportView(log);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Tambora Server");

        hemanLbl.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        hemanLbl.setText("hemanKundu");
        hemanLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hemanLblMouseClicked(evt);
            }
        });

        notiLbl.setFont(new java.awt.Font("Dialog", 3, 20)); // NOI18N
        notiLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notiLbl.setText("Turn on registration to start!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(serStatLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                            .addComponent(clientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addComponent(sendRandomNumber)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(randomLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(69, 69, 69))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(363, 363, 363)
                                .addComponent(sendTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sendBtn)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sendTokenBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                    .addComponent(regTogBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(connectBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addComponent(notiLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hemanLbl)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(regTogBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(connectBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendTokenBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(notiLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(randomLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 22, Short.MAX_VALUE)
                                .addComponent(sendRandomNumber)
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serStatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hemanLbl))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regTogBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_regTogBtnItemStateChanged
        if(regTogBtn.isSelected()){
            regTogBtn.setText("Registration: ON");
            regEnabled=true;
            NotifyLbl("Server waiting for clients..",0);
            if(!ser.threadAck.isAlive()){
                ser.threadAck.start();
                //System.err.println("start");
            }
            else{
                ser.threadAck.resume();
                //System.out.println("resume");
            }
        }
        else{
            regTogBtn.setText("Registration: OFF");
            NotifyLbl("Registration closed!", 1000);
            regEnabled = false;
            ser.threadAck.suspend();
        }
    }//GEN-LAST:event_regTogBtnItemStateChanged
    public void NotifyLbl(String msg,int delay){
        notiLbl.setText(msg);
        Thread notification=new Thread(){
            @Override
            public void run() {
                //super.start(); //To change body of generated methods, choose Tools | Templates.
                notiLbl.setText(msg);
                if(delay!=0){
                    try {
                        Thread.sleep((long)delay);
                        notiLbl.setText("");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(serverForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                stop();
            }
        };
        notification.start();
    }
    private void initCliLbl(){
        cliLbl=new JLabel[8];
        cliLbl[0]=cliLbl1;
        cliLbl[1]=cliLbl2;
        cliLbl[2]=cliLbl3;
        cliLbl[3]=cliLbl4;
        cliLbl[4]=cliLbl5;
        cliLbl[5]=cliLbl6;
        cliLbl[6]=cliLbl7;
        cliLbl[7]=cliLbl8;
    }
    
    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        ser.sendMessage=sendTxt.getText();
        for(int i=0;i<ser.clients.size();i++)
            ser.send("rn",sendTxt.getText(),i);
            
        
    }//GEN-LAST:event_sendBtnActionPerformed

    private String getRandomStr(int upBound,int numCount){
        String randomStr="";
        ArrayList<Integer> numbers=new ArrayList<>(upBound);
        for(int i=1;i<=upBound;i++)
            numbers.add(i);
        Random random=new Random();
        for(int i=0;i<numCount;i++){
            int rn=random.nextInt(numbers.size());
            randomStr+=" "+String.valueOf(numbers.get(rn));
            numbers.remove(rn);
        }
        return randomStr;
    }
    private void setRandomNumbers(int upBound) {
        String randomStr = "";
        ArrayList<Integer> numbers = new ArrayList<>(upBound);
        for (int i = 1; i <= upBound; i++) {
            numbers.add(i);
        }
        Random random = new Random();
        ser.randomNumbers=new ArrayList<>(upBound);
        for (int i = 0; i < upBound; i++) {
            int rn = random.nextInt(numbers.size());
            ser.randomNumbers.add(numbers.get(rn));
            numbers.remove(rn);
        }
    }
    
    private void connectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectBtnActionPerformed
        if(ser.clients.isEmpty()){
            NotifyLbl("There are no clients registered!", 1500);
        }
        else if(regEnabled){
            NotifyLbl("Please colse registration befire connecting to clients!", 1000);
        }
        else{
            boolean success = ser.connect();
            if (success) {
                NotifyLbl("Connections to clients established!", 1000);
            } else {
                NotifyLbl("Oops! There was an error connecting to clients!", 1500);
            }
        }
    }//GEN-LAST:event_connectBtnActionPerformed

    private void sendTokenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendTokenBtnActionPerformed
        NotifyLbl("Sending tokens to clients..", 1000);
        boolean success=true;
        int i;
        for (i = 0; i < ser.clients.size(); i++) {
            String tokenStr = getRandomStr(20,12); //....................................token upbound
            success=success & ser.send("token", tokenStr, i);
        }
        setRandomNumbers(20);
        if(i==0){
            NotifyLbl("Oops! No clients registered!", 1500);
        }
        else if(success){
            NotifyLbl("Tokens sent!", 1000);
            tokenSent=true;
        }
        else{
            NotifyLbl("Oops! there was an error sending tokens!", 1500);
            tokenSent=false;
        }
    }//GEN-LAST:event_sendTokenBtnActionPerformed

    private void sendRandomNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendRandomNumberActionPerformed
        if(ser.clients.isEmpty()){
            NotifyLbl("More than zero clients required to start!", 1500);
        }
        else if(!tokenSent){
            NotifyLbl("Please send tokens to the clients first!", 1500);
        }
        else{
            if (!ser.randomNumbers.isEmpty()) {
                NotifyLbl(String.valueOf("Sending Random Number: " + ser.randomNumbers.get(0) + "!"), 1000);
                for (int i = 0; i < ser.clients.size(); i++) {
                    ser.send("rn", String.valueOf(ser.randomNumbers.get(0)), i);
                }
                ser.randomNumbers.remove(0);
                //ser.curClient=(ser.curClient+1)%(ser.clients.size());
            }
        }
       
    }//GEN-LAST:event_sendRandomNumberActionPerformed

    private void hemanLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hemanLblMouseClicked
        hemanCount++;
        if(hemanCount==3){
            hemanCount=0;
            boolean visible=sendBtn.isVisible();
            sendBtn.setVisible(!visible);
            sendTxt.setVisible(!visible);
            
        }
    }//GEN-LAST:event_hemanLblMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(serverForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(serverForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(serverForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(serverForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new serverForm().setVisible(true);
                
            }
        });
        
     
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel cliLbl1;
    public javax.swing.JLabel cliLbl2;
    public javax.swing.JLabel cliLbl3;
    public javax.swing.JLabel cliLbl4;
    public javax.swing.JLabel cliLbl5;
    public javax.swing.JLabel cliLbl6;
    public javax.swing.JLabel cliLbl7;
    public javax.swing.JLabel cliLbl8;
    public javax.swing.JPanel clientPanel;
    private javax.swing.JButton connectBtn;
    private javax.swing.JLabel hemanLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea log;
    public javax.swing.JLabel notiLbl;
    private javax.swing.JLabel randomLbl;
    private javax.swing.JToggleButton regTogBtn;
    private javax.swing.JButton sendBtn;
    private javax.swing.JButton sendRandomNumber;
    private javax.swing.JButton sendTokenBtn;
    private javax.swing.JTextField sendTxt;
    public javax.swing.JLabel serStatLabel;
    // End of variables declaration//GEN-END:variables
}
