package com.liverpool.components;

import com.liverpool.model.ModelWork;
import com.liverpool.model.Model_Card;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;


public class Card extends javax.swing.JPanel {

    
    private Color color1;
    private Color color2;
    
    public Card() {
        initComponents();
        setOpaque(false);
        color1 = Color.BLACK;
        color2 = Color.WHITE;

    }
    
    public Card(ModelWork work) {
        initComponents();
        setOpaque(false);
        
        WorkColor wc = new WorkColor();
        color1 = wc.getColor1(work.getType());
        color2 = wc.getColor2(work.getType());
        setData(new Model_Card(work));       
    }
    
    public Card(Color color1, Color color2, Model_Card data) {
        initComponents();
        setOpaque(false);
        this.color1 = color1;
        this.color2 = color2;
        setData(data);
    }
    
    
    public void setData (Model_Card data) {
        lbIcon.setIcon(data.getIcon());
        lbTitle.setText(data.getTitle());
        lbValues.setText(data.getValues());
        lbDescription.setText(data.getDescription());
    }
    
    public void setColor(Color color1, Color color2){
        this.color1 = color1;
        this.color2 = color2;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        lbValues = new javax.swing.JLabel();
        lbDescription = new javax.swing.JLabel();

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/liverpool/icon/icons8-connect-32.png"))); // NOI18N

        lbTitle.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setText("Title");

        lbValues.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbValues.setForeground(new java.awt.Color(255, 255, 255));
        lbValues.setText("Values");

        lbDescription.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbDescription.setForeground(new java.awt.Color(255, 255, 255));
        lbDescription.setText("Description");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbValues)
                    .addComponent(lbTitle)
                    .addComponent(lbIcon)
                    .addComponent(lbDescription))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbValues)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(lbDescription)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gg= new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(gg);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        
        g2.setColor(new Color (255, 255, 255, 50));
        g2.fillOval(getWidth() - getHeight() / 2, 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - getHeight() / 2 - 20, getHeight() / 2 + 20, getHeight(), getHeight());

        super.paintComponent(g);
    }
    
    
    

    

    public Card(Color color1, Color color2, JLabel lbDescription, JLabel lbIcon, JLabel lbTitle, JLabel lbValues) {
        this.color1 = color1;
        this.color2 = color2;
        this.lbDescription = lbDescription;
        this.lbIcon = lbIcon;
        this.lbTitle = lbTitle;
        this.lbValues = lbValues;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbValues;
    // End of variables declaration//GEN-END:variables

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }
}
