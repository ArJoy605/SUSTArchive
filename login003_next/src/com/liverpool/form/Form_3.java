package com.liverpool.form;

import com.liverpool.main.UploadCompleted;
import com.liverpool.model.ModelUser;
import com.liverpool.model.ModelWork;
import com.liverpool.model.StatusType;
import com.liverpool.model.WorkType;
import com.liverpool.swing.MyButton;
import com.liverpool.swing.MyPasswordField;
import com.liverpool.swing.MyRadioButton;
import com.liverpool.swing.MyTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class Form_3 extends javax.swing.JPanel {

    public Form_3(ActionListener uploadEvent, ModelUser user, ArrayList recentWorks) {
        initComponents();
        workPanel.setLayout(new MigLayout());
        workPanel.setLayout(new MigLayout("wrap, fill ", "push[center][center][center]push", "[][][][][][]"));
        JLabel label = new JLabel("Upload A New Work");
        label.setFont(new Font("sansserif", 1, 30));
        label.setAlignmentX(CENTER_ALIGNMENT);
        label.setAlignmentY(CENTER_ALIGNMENT);
        label.setForeground(new Color(42, 168, 199));
        workPanel.add(label, "span, w 30%, alignx center");

        MyTextField workName = new MyTextField();
        workName.setLabelText("Work Name");
        workPanel.add(workName, "span, w 60%");

        MyTextField desWork = new MyTextField();
        desWork.setLabelText("Short Description");
        workPanel.add(desWork, "span, w 60%");

        MyTextField workYear = new MyTextField();
        workYear.setLabelText("Working Year");
        workPanel.add(workYear, "span, , w 60%");

        MyRadioButton workType1 = new MyRadioButton("Project");
        workType1.setFont(new Font("sansserif", 0, 16));
//        workType1.setHorizontalTextPosition(1);

        MyRadioButton workType2 = new MyRadioButton("Thesis");
        workType2.setFont(new Font("sansserif", 0, 16));

        MyRadioButton workType3 = new MyRadioButton("Research");
        workType3.setFont(new Font("sansserif", 0, 16));
        ButtonGroup workType = new ButtonGroup();
        workType.add(workType1);
        workType.add(workType2);
        workType.add(workType3);
        workPanel.add(workType1, "w 20%");
        workPanel.add(workType2, "w 20%");
        workPanel.add(workType3, "w 20%");

        MyTextField workFile = new MyTextField();
        workFile.setLabelText("Upload the file (zipped)");
        workPanel.add(workFile, "w 60%, span");

        MyButton cmd = new MyButton();
        cmd.setBackground(new Color(42, 168, 199));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("Upload");
        cmd.addActionListener(uploadEvent);
        workPanel.add(cmd, "w 60%, h 60, alignx center, span");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Uploaded SuccessFully");
                String wt = getSelectedButtonText(workType);
                WorkType type = "Project".equals(wt) ? WorkType.PROJECT : "Thesis".equals(wt) ? WorkType.THESIS : WorkType.RESEARCH;
                
                ModelWork currentWork = new ModelWork(workYear.getText(), workName.getText(), user.getUserName(), type, 0, StatusType.PENDING);
                
                user.addWork(currentWork);
                
                recentWorks.add(currentWork);
                
            }
        });
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
    
    
    
    public void enableMain(){
        this.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        workPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(242, 242, 242));

        workPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout workPanelLayout = new javax.swing.GroupLayout(workPanel);
        workPanel.setLayout(workPanelLayout);
        workPanelLayout.setHorizontalGroup(
            workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        workPanelLayout.setVerticalGroup(
            workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(workPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(workPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel workPanel;
    // End of variables declaration//GEN-END:variables
}
