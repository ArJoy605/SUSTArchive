package com.liverpool.services;

import com.liverpool.connection.DataBaseConnection;
import com.liverpool.model.ModelUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ServiceUser {
    private final Connection con;
    
    public ServiceUser(){
        con = DataBaseConnection.getInstance().getConnection();
        if(con != null){
            System.out.println("Connection is alright");
        }
    }
    
    public void insertUser(ModelUser user) throws SQLException{
        try {PreparedStatement st = con.prepareStatement("INSERT INTO `userlist` (`userID`, `Name`,`userType`, `Email`, `Password`, `VerifyCode`, `Verified`) VALUES (NULL, ?, ?, ?, ?, ?, 0)", PreparedStatement.RETURN_GENERATED_KEYS);
        String code = "123456";
        st.setString(1, user.getUserName());
        st.setString(2, Integer.toString(user.getUserTypeServer()));
        st.setString(3, user.getEmail());
        st.setString(4, user.getPassword());
        st.setString(5, code);
        st.execute();
            System.out.println("SuccessFully Registered");
        ResultSet res = st.getGeneratedKeys();
        res.first();
        int userID = res.getInt(1);
        res.close();
        st.close();
        user.setUserID(userID);
        user.setVerifyCode(code); 
        System.out.println("No problem in insertion");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    
    public boolean checkDuplicateEmail(String user) throws SQLException{
        boolean duplicate = false;
        try {
            PreparedStatement st = con.prepareStatement("select userID from `userlist` where Email=? and `Verified` = '1' limit 1");
            st.setString(1, user);
            ResultSet res = st.executeQuery();
            if (res.next()) {
                duplicate = true;
            }
            res.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("problem is here in email");
        }
        return duplicate;
    }
    
    public void doneVerify(int userID) throws SQLException{
        try {
            PreparedStatement st = con.prepareStatement("update `userlist` set VerifyCode = '', `Verified` = '1' where userID=?");
            st.setInt(1, userID);
            st.execute();
            st.close();
        } catch (SQLException e) {
            System.out.println("BIg problem ");
            System.out.println(e);
        }
    }
    
    public boolean verifyCodeWithUser(int userID, String code) throws SQLException{
        boolean status = false;
        PreparedStatement st = con.prepareStatement("select userID from `userlist` where userID=? and VerifyCode =? limit 1");
        st.setInt(1, userID);
        st.setString(2, code);
        ResultSet res = st.executeQuery();
        if(res.next()){
            status = true;
        }
        res.close();
        st.close();
        
        return status;
    }
}
