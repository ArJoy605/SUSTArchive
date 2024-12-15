
package com.liverpool.form;

import com.liverpool.model.ModelWork;
import com.liverpool.model.Model_Card;
import com.liverpool.model.WorkType;
import com.liverpool.model.ModelUser;
import com.liverpool.swing.ScrollBarCustom;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.ImageIcon;

public class Form_0 extends javax.swing.JPanel {

    ModelUser user;
    
    public Form_0(ModelUser user) {
        initComponents();
        this.user = user;
        
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/liverpool/icon/project.png")), "Project", "Published: " + user.getProjectPublished(), "Submitted: " + user.getProjectSubmission()));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/liverpool/icon/thesis.png")), "Thesis", "Published: " + user.getThesisPublished(), "Submitted: " + user.getThesisSubmission()));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/liverpool/icon/research.png")), "Research", "Published: " + user.getResearchPublished(), "Submitted: " + user.getResearchSubmission()));
        
        addRow ();
        
        
    }
    
    public void addRow () {
        
        ArrayList<ModelWork> works = user.getWorks();
        
        ListIterator<ModelWork> rit = works.listIterator(works.size());
        
        while (rit.hasPrevious()) addRow(rit.previous());
        
    }
    
    public void addRow (ModelWork work) {
        System.out.println("Added in My Work");
        
                 
        table.addRow(new Object[]{work.getUpTime(), work.getName(), work.getType(), work.getDate(), work.getViews(), work.getStatus()});
        
        if (work.getType() == WorkType.PROJECT) {
            card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/liverpool/icon/project.png")), "Project", "Published: " + user.getProjectPublished(), "Submitted: " + user.getProjectSubmission()));
        }
        
        if (work.getType() == WorkType.THESIS) {
            card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/liverpool/icon/thesis.png")), "Thesis", "Published: " + user.getThesisPublished(), "Submitted: " + user.getThesisSubmission()));
        }
        
        if (work.getType() == WorkType.RESEARCH) {
            card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/liverpool/icon/research.png")), "Research", "Published: " + user.getResearchPublished(), "Submitted: " + user.getResearchSubmission()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new com.liverpool.components.Card();
        card2 = new com.liverpool.components.Card();
        card3 = new com.liverpool.components.Card();
        panelBorder1 = new com.liverpool.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new com.liverpool.swing.Table();

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 250));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 164, 61));
        panel.add(card3);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Standard table design");

        jScrollPane1.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Upload Date", "Name", "Type", "Working Year", "Views", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.liverpool.components.Card card1;
    private com.liverpool.components.Card card2;
    private com.liverpool.components.Card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLayeredPane panel;
    private com.liverpool.swing.PanelBorder panelBorder1;
    private com.liverpool.swing.Table table;
    // End of variables declaration//GEN-END:variables
}
