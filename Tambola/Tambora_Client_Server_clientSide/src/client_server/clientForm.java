package client_server;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

public class clientForm extends javax.swing.JFrame {

    Client cli;
    int hemanCount;
    public clientForm() {
        initComponents();
        cli=Client_Server.client;
        initBtnMat();
        LogDialog.hide();
        hemanCount=0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogDialog = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        Log = new javax.swing.JTextArea();
        sendBtn = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        serverText = new javax.swing.JTextField();
        reqBtn = new javax.swing.JButton();
        nameLbl = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jbtnMat1 = new javax.swing.JButton();
        jbtnMat2 = new javax.swing.JButton();
        jbtnMat3 = new javax.swing.JButton();
        jbtnMat4 = new javax.swing.JButton();
        jbtnMat8 = new javax.swing.JButton();
        jbtnMat5 = new javax.swing.JButton();
        jbtnMat6 = new javax.swing.JButton();
        jbtnMat7 = new javax.swing.JButton();
        jbtnMat12 = new javax.swing.JButton();
        jbtnMat9 = new javax.swing.JButton();
        jbtnMat10 = new javax.swing.JButton();
        jbtnMat11 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        scoreLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hemanLbl = new javax.swing.JLabel();
        claimBoardRow1 = new javax.swing.JLabel();
        claimBoardRow2 = new javax.swing.JLabel();
        claimBoardRow3 = new javax.swing.JLabel();
        claimBoardColumn1 = new javax.swing.JLabel();
        claimBoardColumn2 = new javax.swing.JLabel();
        claimBoardColumn3 = new javax.swing.JLabel();
        claimBoardColumn4 = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        notiLbl = new javax.swing.JTextArea();

        LogDialog.setMinimumSize(new java.awt.Dimension(739, 400));

        Log.setEditable(false);
        Log.setColumns(20);
        Log.setRows(5);
        Log.setAutoscrolls(false);
        jScrollPane1.setViewportView(Log);

        sendBtn.setText("Send");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LogDialogLayout = new javax.swing.GroupLayout(LogDialog.getContentPane());
        LogDialog.getContentPane().setLayout(LogDialogLayout);
        LogDialogLayout.setHorizontalGroup(
            LogDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendBtn)
                .addGap(9, 9, 9))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                .addContainerGap())
        );
        LogDialogLayout.setVerticalGroup(
            LogDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LogDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendBtn))
                .addContainerGap())
        );

        jScrollPane1.getAccessibleContext().setAccessibleParent(jScrollPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Play Tambora [Client]");
        setBackground(new java.awt.Color(0, 153, 153));
        setForeground(java.awt.Color.red);

        serverText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        serverText.setText("127.0.1.1");
        serverText.setToolTipText("");
        serverText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverTextActionPerformed(evt);
            }
        });

        reqBtn.setText("Connect to server");
        reqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqBtnActionPerformed(evt);
            }
        });

        nameLbl.setText("Name");

        nameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameTextFocusLost(evt);
            }
        });

        jbtnMat1.setText(" ");

        jbtnMat2.setText(" ");

        jbtnMat3.setText(" ");

        jbtnMat4.setText(" ");

        jbtnMat8.setText(" ");

        jbtnMat5.setText(" ");

        jbtnMat6.setText(" ");

        jbtnMat7.setText(" ");

        jbtnMat12.setText(" ");

        jbtnMat9.setText(" ");

        jbtnMat10.setText(" ");

        jbtnMat11.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtnMat9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnMat10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnMat11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnMat12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtnMat5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnMat1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbtnMat6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnMat7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnMat8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbtnMat2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnMat3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnMat4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnMat4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnMat3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnMat2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnMat1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnMat6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnMat7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnMat5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnMat8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnMat10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnMat11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnMat9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnMat12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Score");

        scoreLbl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        scoreLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLbl.setText("0");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Play Tambora");

        hemanLbl.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        hemanLbl.setText("hemanKundu");
        hemanLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hemanLblMouseClicked(evt);
            }
        });

        claimBoardRow1.setText("Row 1 : ");

        claimBoardRow2.setText("Row 2 : ");

        claimBoardRow3.setText("Row 3 : ");

        claimBoardColumn1.setText("Column 1 : ");

        claimBoardColumn2.setText("Column 2 : ");

        claimBoardColumn3.setText("Column 3 : ");

        claimBoardColumn4.setText("Column 4 : ");

        notiLbl.setEditable(false);
        notiLbl.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selectedButtonForeground"));
        notiLbl.setColumns(20);
        notiLbl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        notiLbl.setForeground(new java.awt.Color(0, 153, 153));
        notiLbl.setRows(5);
        notiLbl.setBorder(null);
        scrollPane.setViewportView(notiLbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hemanLbl)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(claimBoardColumn4, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(claimBoardColumn3, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(claimBoardColumn2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(claimBoardColumn1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(claimBoardRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(claimBoardRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(claimBoardRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(182, 182, 182)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scoreLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addComponent(serverText, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reqBtn)
                        .addGap(20, 20, 20))))
            .addGroup(layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(serverText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reqBtn)
                        .addComponent(nameLbl)
                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scoreLbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(claimBoardRow1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(claimBoardRow2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(claimBoardRow3)
                .addGap(18, 18, 18)
                .addComponent(claimBoardColumn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(claimBoardColumn2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(claimBoardColumn3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(claimBoardColumn4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hemanLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        
        cli.send(jTextField1.getText());
        
    }//GEN-LAST:event_sendBtnActionPerformed

    private void reqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqBtnActionPerformed
        cli.serverIp=serverText.getText();
        boolean success=cli.request();
        if(success){
            NotifyLbl("Successfully connected to server!", 2000);
        }
        else{
            NotifyLbl("Oops! Something wrong happened, couldn't connect", 2000);
        }
    }//GEN-LAST:event_reqBtnActionPerformed

    private void initBtnMat(){
        btnMat = new JButton[3][4];
        btnMat[0][0] = jbtnMat1;
        btnMat[0][1] = jbtnMat2;
        btnMat[0][2] = jbtnMat3;
        btnMat[0][3] = jbtnMat4;
        btnMat[1][0] = jbtnMat5;
        btnMat[1][1] = jbtnMat6;
        btnMat[1][2] = jbtnMat7;
        btnMat[1][3] = jbtnMat8;
        btnMat[2][0] = jbtnMat9;
        btnMat[2][1] = jbtnMat10;
        btnMat[2][2] = jbtnMat11;
        btnMat[2][3] = jbtnMat12;
        
        claimBoard= new JLabel[7];
        claimBoard[0]=claimBoardRow1;
        claimBoard[1]=claimBoardRow2;
        claimBoard[2]=claimBoardRow3;
        claimBoard[3]=claimBoardColumn1;
        claimBoard[4]=claimBoardColumn2;
        claimBoard[5]=claimBoardColumn3;
        claimBoard[6]=claimBoardColumn4;
    }
    
    private void serverTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serverTextActionPerformed

    private void nameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTextFocusLost
        // TODO add your handling code here:
        String name=nameText.getText();
        if(name==""){
            name="Player("+cli.ip+")";
        }
        cli.name=name;
    }//GEN-LAST:event_nameTextFocusLost

    private void hemanLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hemanLblMouseClicked
        if(hemanCount==3){
            hemanCount=0;
            boolean show=LogDialog.isShowing();
            LogDialog.show(!show);
        }
        else{
            hemanCount++;
        }
        
    }//GEN-LAST:event_hemanLblMouseClicked

    public void NotifyLbl(String msg, int delay) {
        Thread notification = new Thread() {
            @Override
            public void run() {
                //super.start(); //To change body of generated methods, choose Tools | Templates.
                notiLbl.append(msg+"\n");
                if (delay != 0) {
                    try {
                        Thread.sleep((long) delay);
                        String text=notiLbl.getText();
                        text=text.replace(msg+"\n", "");
                        notiLbl.setText(text);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(clientForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                stop();
            }
        };
        notification.start();
    }
    
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(clientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new clientForm().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea Log;
    public javax.swing.JDialog LogDialog;
    private javax.swing.JLabel claimBoardColumn1;
    private javax.swing.JLabel claimBoardColumn2;
    private javax.swing.JLabel claimBoardColumn3;
    private javax.swing.JLabel claimBoardColumn4;
    private javax.swing.JLabel claimBoardRow1;
    private javax.swing.JLabel claimBoardRow2;
    private javax.swing.JLabel claimBoardRow3;
    private javax.swing.JLabel hemanLbl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbtnMat1;
    private javax.swing.JButton jbtnMat10;
    private javax.swing.JButton jbtnMat11;
    private javax.swing.JButton jbtnMat12;
    private javax.swing.JButton jbtnMat2;
    private javax.swing.JButton jbtnMat3;
    private javax.swing.JButton jbtnMat4;
    private javax.swing.JButton jbtnMat5;
    private javax.swing.JButton jbtnMat6;
    private javax.swing.JButton jbtnMat7;
    private javax.swing.JButton jbtnMat8;
    private javax.swing.JButton jbtnMat9;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameText;
    public javax.swing.JTextArea notiLbl;
    private javax.swing.JButton reqBtn;
    public javax.swing.JLabel scoreLbl;
    public javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton sendBtn;
    private javax.swing.JTextField serverText;
    // End of variables declaration//GEN-END:variables
    public JButton[][] btnMat;
    public JLabel[] claimBoard;
}
