package com.liverpool.components;

import com.liverpool.model.ModelUser;
import com.liverpool.model.UserType;
import com.liverpool.services.LoginAuth;
import com.liverpool.swing.MyButton;
import com.liverpool.swing.MyPasswordField;
import com.liverpool.swing.MyRadioButton;
import com.liverpool.swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    public ModelUser getUser() {
        return user;
    }
    public boolean getExistingUser(){
        return existingUser;
    }
    
    public boolean getPassFlag(){
        return passFlag;
    }
    private ModelUser user;
    private boolean existingUser = false;
    private boolean passFlag = false;
    
    
    public PanelLoginAndRegister(ActionListener eventRegister, ActionListener eventLogin) {
        initComponents();
        initRegister(eventRegister);
        initLogin(eventLogin);
        login.setVisible(false);
        register.setVisible(true);
        
    }
    
    
    private void initRegister(ActionListener eventRegister){
        register.setLayout(new MigLayout("wrap", "push[center][center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(42, 168, 199));
        
        register.add(label,"span");
        MyTextField txtUser = new MyTextField();
        txtUser.setLabelText("Name");
        register.add(txtUser, "w 60%, span");
        
        MyTextField txtEmail = new MyTextField();
        txtEmail.setLabelText("Email");
        register.add(txtEmail, "w 60%,span");
         
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setLabelText("Password");
        register.add(txtPass, "w 60%,span");
        
        MyPasswordField txtPassConfirm = new MyPasswordField();
        txtPassConfirm.setLabelText("Confirm Password");
        register.add(txtPassConfirm, "w 60%,span");
        
        MyRadioButton txtStatus1 = new MyRadioButton("Student");
        MyRadioButton txtStatus2 = new MyRadioButton("Teacher");
        
        ButtonGroup txtStatus = new ButtonGroup();
        txtStatus.add(txtStatus1);
        txtStatus.add(txtStatus2);
        register.add(txtStatus1, "w 30%");
        register.add(txtStatus2, "w 30%");
        
        
        
        
        MyButton cmd = new MyButton();
        cmd.setBackground(new Color(42, 168, 199));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN UP");
        cmd.addActionListener(eventRegister);
        register.add(cmd, "w 40%, h 40,span" );
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = txtUser.getText().trim();
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                String confirmPassword = String.valueOf(txtPassConfirm.getPassword());
                if(password.equals(confirmPassword)){
                    passFlag = true;
                    txtPassConfirm.setText("");                                
                }
                user = new ModelUser(0 , userName, email, password, getSelectedButtonType(txtStatus));
                System.out.println(userName);
                System.out.println(email);
                System.out.println(password);
                System.out.println("Selecction "+getSelectedButtonText(txtStatus));
                System.out.println("OOKKKK======1");
                
                
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
    
    public UserType getSelectedButtonType(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            
            if (button.isSelected()) {
                if(button.getText() == "Student")
                    return UserType.STUDENT;
                else if(button.getText() == "Teacher")
                    return UserType.TEACHER;
            }
        }
        
        return null;
    }
    
    private void initLogin(ActionListener eventLogin){
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        
        JLabel label = new JLabel("Sign IN");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(42, 168, 199));
        login.add(label);
        
        MyTextField txtEmail = new MyTextField();
        txtEmail.setLabelText("Email");
        login.add(txtEmail, "w 60%");
         
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setLabelText("Password");
        login.add(txtPass, "w 60%");
        
         JButton cmdForget = new JButton("Forgot Your Password ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        cmdForget.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        
        login.add(cmdForget);
        
        MyButton cmd = new MyButton();
        cmd.setBackground(new Color(42, 168, 199));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN IN");
        cmd.addActionListener(eventLogin);
        login.add(cmd, "w 40%, h 40" );
        
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(" EveryThing is gone");
                String email = txtEmail.getText();
                String pass  = String.valueOf(txtPass.getPassword());
                System.out.println(pass);
                LoginAuth check = new LoginAuth();
                user = check.LoginCheck(email, pass);
            }
        });
    
    }
    
    public void showRegister(boolean show){
        if(show){
            login.setVisible(false);
            register.setVisible(true);
        }else{
            login.setVisible(true);
            register.setVisible(false);
        }
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
