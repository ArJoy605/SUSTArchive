
package com.liverpool.swing;

import com.liverpool.model.ModelMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class MenuItem extends javax.swing.JPanel {
    
    private boolean selected;
    private boolean over;

   

    public MenuItem(ModelMenu data) {
        initComponents();
        setOpaque(false);
        if(data.getType() == ModelMenu.Menutype.MENU){
            lbIcon.setIcon(data.toIcon());
            lbName.setText(data.getName());
        } else if(data.getType() == ModelMenu.Menutype.TITLE){
            lbIcon.setText(data.getName());
            lbIcon.setFont(new Font("sansserif", 1,12));
            lbName.setVisible(false);
        }else{
            lbName.setText("  ");
        }
    }
    
     public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }
     
    public void setOver(boolean over){
        this.over = over;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(selected || over){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255, 255, 255, 80));
        g2.fillRoundRect(10, 0, getWidth()-20, getHeight(), 5, 5);
        }
        super.paintComponent(g); 
    }
     
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();

        lbName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(255, 255, 255));
        lbName.setText("Menu Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbIcon)
                .addGap(18, 18, 18)
                .addComponent(lbName)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
