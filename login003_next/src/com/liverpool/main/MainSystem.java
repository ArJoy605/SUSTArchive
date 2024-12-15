
package com.liverpool.main;

import com.liverpool.event.EventMenuSelected;
import com.liverpool.form.*;
import com.liverpool.model.ModelUser;
import com.liverpool.model.ModelWork;
import com.liverpool.services.RecentDemoWorks;
import com.liverpool.services.UserDoDemoWork;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class MainSystem extends javax.swing.JFrame{   
    private ImageIcon icon;
    private ArrayList recentWorks;
    
    public MainSystem(ModelUser user) {
        initComponents();
        menu.setAvatar("Welcome "+ user.getUserName());
        menu.setAvatarType(user.getUserTypeString());
        setBackground(new Color(0, 0, 0,  0));
        icon = new ImageIcon(getClass().getResource("/com/liverpool/icon/icon.png"));
        setIconImage(icon.getImage());
        
        
        cmdClose.setToolTipText("EXIT");
        cmdMinus.setToolTipText("Minimize");
        
        cmdMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                systemMinimize();
            }
        });
        
        cmdClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmToExit();
            }
        });
        
        ActionListener uploadEvent = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("woorrkkiinngg");
                UploadCompletingMsg();
            }
        };
        
        
        
        new UserDoDemoWork(user);
        recentWorks = new ArrayList<ModelWork> ();
        new RecentDemoWorks(recentWorks);
        
        menu.initMoving(this);
        menu.addEventMenuSelected(new EventMenuSelected (){
            @Override
            public void selected(int index) {
                if(index == 0){
                    setForm(new Form_0(user));
                }else if(index == 1){
                    setForm(new Form_1(user));
                }else if(index == 2){
                    setForm(new Form_2(recentWorks));
                }else if(index == 3){
                    setForm(new Form_3(uploadEvent, user, recentWorks));
                }else if(index == 4){
                    setForm(new Form_4());
                }else if(index == 5){
                    setForm(new Form_5());
                }else{
                    confirmation();
                }              
             }
        });
        setForm(new Form_2(recentWorks));
    }
    
    private void setForm(JComponent com){
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    
    private void confirmation(){
        ForLogout x = new ForLogout();
        x.setVisible(true);
        this.setEnabled(false);
        x.addEventButtonYes(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                end();
                x.dispose();
            }
        });
        x.addCancelButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableMainSystem();
                x.dispose();
            }           
       });   
        
    }

      
    public void enableMainSystem(){
        this.setEnabled(true);
    }
    
    private void end(){
        this.dispose();
        Main main  = new Main();
        main.setVisible(true);
    }
    
    private void systemExit(){
        System.exit(0);
    }
    
    private void systemMinimize(){
        this.setExtendedState(ICONIFIED);
    }
    
    private void confirmToExit(){
        ExitConfirmation confirm = new ExitConfirmation();
        confirm.setVisible(true);
        this.setEnabled(false);
        confirm.addEventButtonYes(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        confirm.addEventButtonNo(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableMainSystem();
                confirm.dispose();
            }
        });
    }
    
    public void UploadCompletingMsg(){
        UploadCompleted complete = new UploadCompleted();
        complete.setVisible(true);
        this.setEnabled(false);
        complete.addEventButtonOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableMainSystem();
                complete.dispose();
                
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        panelBorder1 = new com.liverpool.swing.PanelBorder();
        header2 = new com.liverpool.components.Header();
        mainPanel = new javax.swing.JPanel();
        menu = new com.liverpool.components.Menu();
        cmdMinus = new com.liverpool.swing.MyButton();
        cmdClose = new com.liverpool.swing.MyButton();

        jCheckBox1.setText("jCheckBox1");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(242, 242, 242));
        panelBorder1.setForeground(new java.awt.Color(204, 204, 204));

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        cmdMinus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/liverpool/icon/minus.png"))); // NOI18N

        cmdClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/liverpool/icon/close.png"))); // NOI18N

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdMinus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE))
            .addComponent(menu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModelUser admin = new ModelUser();
                admin.setUserName("Admin");
                new MainSystem(admin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.liverpool.swing.MyButton cmdClose;
    private com.liverpool.swing.MyButton cmdMinus;
    private com.liverpool.components.Header header2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel mainPanel;
    private com.liverpool.components.Menu menu;
    private com.liverpool.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables

}
