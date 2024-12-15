package com.liverpool.main;

import com.liverpool.components.Message;
import com.liverpool.components.PanelCover;
import com.liverpool.components.PanelLoading;
import com.liverpool.components.PanelLoginAndRegister;
import com.liverpool.components.PanelVerifyCode;
import com.liverpool.connection.DataBaseConnection;
import com.liverpool.model.ModelUser;
import com.liverpool.services.ServiceUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private PanelCover cover;
    private PanelLoading loading;
    private PanelVerifyCode verifyCode;
    private PanelLoginAndRegister loginAndRegister;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private ServiceUser service; 
    
    public Main() {
        initComponents();                                               
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/liverpool/icon/icon.png"));     //icon 
        setIconImage(icon.getImage());
        init();                                                                                     //initializing Login and Register Panel
        if(DataBaseConnection.getInstance().getConnection() == null){                              // Checking if Connected to Database or not
             showMessage(Message.MessageType.ERROR, "Error Connecting To The Network");
        }
    }
    
    private void init(){               
        service = new ServiceUser();
        layout = new MigLayout("fill, insets 0");                       //MigLayout used... It has online documentation
        cover = new PanelCover();                                   
        loading = new PanelLoading();
        verifyCode = new PanelVerifyCode();
        initMoving(this);
        
        
        ActionListener eventRegister = new ActionListener() {           //ActionListener 
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        };
        
        ActionListener eventLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                    login();
            }
        };
        
        
        
        loginAndRegister = new PanelLoginAndRegister(eventRegister, eventLogin);
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                if(fraction <= .5f){
                    size+=fraction *addSize;
                }else{
                    size += addSize - fraction *addSize;
                }
                if(isLogin){
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if(fraction>=0.5f){
                        cover.registerRight(fractionCover * 100);
                    }else{
                       cover.loginRight(fractionLogin * 100);
                    }
                }else{
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if(fraction<=0.5f){
                        cover.registerLeft(fraction*100);
                    }else{
                        cover.loginLeft((1f-fraction)*100);
                    }
                }
                if(fraction >= .5){
                    loginAndRegister.showRegister(isLogin);
                }
                
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos "+fractionCover+"al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width " + loginSize + "%, pos "+fractionLogin+"al 0 n 100%");

                bg.revalidate();
            }

            @Override
            public void end() {
               isLogin = !isLogin;
            }
            
        };
        
        
                
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0); // for smooth animation
        
        
        bg.setLayout(layout);
        bg.add(loading, "pos 0 0 100% 100%");
        bg.add(verifyCode, "pos 0 0 100% 100%");        
        bg.setLayer(loading, JLayeredPane.POPUP_LAYER);
        bg.setLayer(verifyCode, JLayeredPane.POPUP_LAYER);

        bg.add(cover, "width "+ coverSize + "%, pos 0al 0 n 100%");
        bg.add(loginAndRegister, "width "+loginSize+"%, pos 1al 0 n 100%"); // 1al as 100%
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(!animator.isRunning()){
                   animator.start();
               }
            }
        });
        
        
        
        verifyCode.addEventButtonOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ModelUser user = loginAndRegister.getUser();
                    System.out.println(user.getUserID());
                    System.out.println(user.getVerifyCode());
                    if(service.verifyCodeWithUser(user.getUserID(), verifyCode.getInputCode())){
                        service.doneVerify(user.getUserID());
                        showMessage(Message.MessageType.SUCCESS, "Congrats! Registration Successfull.");
                        verifyCode.setVisible(false);
                    }else{
                        showMessage(Message.MessageType.ERROR, "Incorrect Verification Code");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                    showMessage(Message.MessageType.ERROR, "Something Went Wrong!");
                }
            }
        });
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
    
    
    
    
    private void register(){
        ModelUser user = loginAndRegister.getUser();
        boolean passFlag = loginAndRegister.getPassFlag();
        if (passFlag) {
            try {
                if (service.checkDuplicateEmail(user.getEmail())) {
                    showMessage(Message.MessageType.ERROR, "Email Already Exists");
                } else {
                    System.out.println("OK Email not exists");
                    service.insertUser(user);
                    SendMain(user);
                }
            } catch (SQLException e) {
                showMessage(Message.MessageType.ERROR, "Something Went Wrong");
            }
        } else {
            showMessage(Message.MessageType.ERROR, "Password didn't Match");
        }
         
    }
    
    
    
    
    private void SendMain(ModelUser user){
    new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    loading.setVisible(true);
                    Thread.sleep(2000);
                    loading.setVisible(false);
                    verifyCode.setVisible(true);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }).start();
         
         }
    
    
    
    private void login(){
         if(loginAndRegister.getUser() != null){
            this.dispose();
            ModelUser user = loginAndRegister.getUser();
//            ModelUser user = new ModelUser();
//            user.setUserName("BOSS");
            MainSystem man = new MainSystem(user);
            man.setVisible(true);
         }
         else{
             showMessage(Message.MessageType.ERROR, "Invalid Email or Password!");
         }
        
    }
    
    private void showMessage(Message.MessageType messageType, String message){
        Message ms = new Message();
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void begin() {
               if(!ms.isShow()){
                   bg.add(ms, "pos 0.5al -30", 0); // INSERT TO BG FIRST INDEX 0
                   ms.setVisible(true);
                   ms.repaint();
               }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if(ms.isShow()){
                    f = 40 *(1f-fraction);
                }else{
                    f = 40 *fraction;
                }
                layout.setComponentConstraints(ms, "pos 0.5al "+(int)(f - 30));
                bg.repaint();
                bg.revalidate();
            }

            @Override
            public void end() {
                if(ms.isShow()){
                    bg.remove(ms);
                    bg.repaint();
                    bg.revalidate();
                }else{
                    ms.setShow(true);
                }
            }
            
            
            
        };
        
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                    animator.start();
                }catch(InterruptedException e){
                    System.out.println(e);
                }
            }
        }).start();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
        try {
            DataBaseConnection.getInstance().connectToDataBase();
        } catch (Exception e) {
            System.out.println(e);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
