package com.liverpool.services;

import com.liverpool.connection.DataBaseConnection;
import com.liverpool.model.ModelUser;
import com.liverpool.model.UserType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginAuth {
    Connection con = DataBaseConnection.getInstance().getConnection();
    ResultSet rs = null;

    
     private ModelUser user;
    public ModelUser LoginCheck(String email, String pass){
        try {
            PreparedStatement st = con.prepareStatement("Select * from userlist where Email=?");
            st.setString(1, email);
            System.out.println("Running ok");
            rs = st.executeQuery();
            System.out.println("Here is Your result");
            String id, name, type;
            if(rs.next()){
                 id = rs.getString("userID");
                type = rs.getString("userType");
                 name = rs.getString("Name");
                String pasString = rs.getString("Password");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("UserID: " + id);
                System.out.println("Password: "+ pasString);
                System.err.println("UserType: "+ type);
                
                if(pass.equals(pasString)){
                    user = new ModelUser();
                    user.setEmail(email);
                    user.setUserID(Integer.valueOf(id));
                    user.setUserName(name);
                    if(Integer.parseInt(type)==1){
                        user.setUserType(UserType.STUDENT);
                    }
                    else if(Integer.parseInt(type)==2){
                        user.setUserType(UserType.TEACHER);
                    }
                    
                    
                    return user;
                }
                else{
                    return user;
                }
            }
            else{
                System.out.println("Result Not found");
                return user;
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Result Not Found");
            return user;
        }
    }
    
}
