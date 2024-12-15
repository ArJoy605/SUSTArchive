
package com.liverpool.components;

import com.liverpool.event.EventMenuSelected;
import com.liverpool.model.ModelMenu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Menu extends javax.swing.JPanel {

    
    private EventMenuSelected event;
    public void addEventMenuSelected(EventMenuSelected event){
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }
    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }
    
    
    private void init(){
        listMenu1.addItem(new ModelMenu("1", "My Works", ModelMenu.Menutype.MENU));
        listMenu1.addItem(new ModelMenu("2", "Favourites", ModelMenu.Menutype.MENU));
        listMenu1.addItem(new ModelMenu("3", "Latest Uploads", ModelMenu.Menutype.MENU));
        listMenu1.addItem(new ModelMenu("4", "Upload Work", ModelMenu.Menutype.MENU));
        listMenu1.addItem(new ModelMenu("5", "Send Feedback", ModelMenu.Menutype.MENU));
        listMenu1.addItem(new ModelMenu("6", "Settings", ModelMenu.Menutype.MENU));
        listMenu1.addItem(new ModelMenu("7", "Logout", ModelMenu.Menutype.MENU));

    }

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gg= new GradientPaint(0, 0, Color.decode("#5B86E5"), 0, getHeight(), Color.decode("#36D1DC"));
        g2.setPaint(gg);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth()-20, 0, getWidth(), getHeight());
        super.paintChildren(g);
    }
    
    
    private int x;
    private int y;
    public void initMoving(JFrame fram) {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (fram.getExtendedState() != JFrame.MAXIMIZED_BOTH && SwingUtilities.isLeftMouseButton(me)) {
                    x = me.getX();
                    y = me.getY();
                }
            }

        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                if (fram.getExtendedState() != JFrame.MAXIMIZED_BOTH && SwingUtilities.isLeftMouseButton(me)) {
                    fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
                }
            }
        });
    }
    
    public void setAvatar(String name){
        avatarName.setText(name);
    }
    
    public void setAvatarType(String type){
        avatarType.setText("["+type+"]");
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listMenu1 = new com.liverpool.swing.ListMenu<>();
        profileAvatar1 = new com.liverpool.swing.ProfileAvatar();
        avatarName = new javax.swing.JLabel();
        avatarType = new javax.swing.JLabel();

        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/liverpool/icon/workforces.png"))); // NOI18N
        jLabel1.setText("WorkForces");

        profileAvatar1.setBorderSize(3);
        profileAvatar1.setBorderSpace(0);
        profileAvatar1.setGradientColor1(new java.awt.Color(51, 255, 255));
        profileAvatar1.setGradientColor2(new java.awt.Color(0, 102, 255));
        profileAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/liverpool/icon/avatar.jpg"))); // NOI18N

        avatarName.setBackground(new java.awt.Color(255, 255, 255));
        avatarName.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        avatarName.setForeground(new java.awt.Color(255, 255, 255));
        avatarName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avatarName.setText("Name");

        avatarType.setBackground(new java.awt.Color(255, 255, 255));
        avatarType.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        avatarType.setForeground(new java.awt.Color(255, 255, 255));
        avatarType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avatarType.setText("Admin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
            .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(avatarName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(profileAvatar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(avatarType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(profileAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(avatarName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(avatarType)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatarName;
    private javax.swing.JLabel avatarType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private com.liverpool.swing.ListMenu<String> listMenu1;
    private com.liverpool.swing.ProfileAvatar profileAvatar1;
    // End of variables declaration//GEN-END:variables
}
