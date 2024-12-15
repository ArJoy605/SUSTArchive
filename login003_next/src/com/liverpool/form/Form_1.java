package com.liverpool.form;

import com.liverpool.components.Card;
import com.liverpool.model.ModelUser;
import com.liverpool.model.ModelWork;
import com.liverpool.swing.ScrollBarCustom;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.ListIterator;

public class Form_1 extends javax.swing.JPanel {
    
    ModelUser user;

    public Form_1(ModelUser user) {
        initComponents();
        this.user = user;
        
        jPanel1.setLayout(new GridLayout(7, 3, 5, 5));
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        jScrollPane1.setHorizontalScrollBar(null);
        
        addWork(user.getWorks());
        
    }
    
    private void addWork(ArrayList<ModelWork> works) {
        ListIterator<ModelWork> rit = works.listIterator(works.size());
        
        while (rit.hasPrevious()) {
            addWork(rit.previous());
        }
    }
    
    private void addWork(ModelWork work) {
        jPanel1.add(new Card(work));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
