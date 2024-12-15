package com.liverpool.model;

import java.util.ArrayList;


public class ModelUser {

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
    
    public UserType getUserType(){
        return type;
    }
    
    public int getUserTypeServer(){
        if(type == UserType.STUDENT)
            return 1;
        else if(type == UserType.TEACHER)
            return 2;
        else
            return 1;
    }
    
    
    public String getUserTypeString(){
        if(type == UserType.STUDENT)
            return "Student";
        else if(type == UserType.TEACHER)
            return "Teacher";
        else
            return "...";
    }
    
    public void setUserType(UserType type){
        this.type = type;
    }
    
    public int getProjectPublished() {
        return projectPublished;
    }

    public void setProjectPublished(int projectPublished) {
        this.projectPublished = projectPublished;
    }

    public int getProjectSubmission() {
        return projectSubmission;
    }

    public void setProjectSubmission(int projectSubmission) {
        this.projectSubmission = projectSubmission;
    }

    public int getThesisPublished() {
        return thesisPublished;
    }

    public void setThesisPublished(int thesisPublished) {
        this.thesisPublished = thesisPublished;
    }

    public int getThesisSubmission() {
        return thesisSubmission;
    }

    public void setThesisSubmission(int thesisSubmission) {
        this.thesisSubmission = thesisSubmission;
    }

    public int getResearchPublished() {
        return researchPublished;
    }

    public void setResearchPublished(int researchPublished) {
        this.researchPublished = researchPublished;
    }

    public int getResearchSubmission() {
        return researchSubmission;
    }

    public void setResearchSubmission(int researchSubmission) {
        this.researchSubmission = researchSubmission;
    }

    public ModelUser(int userID, String userName, String email, String password, String verifyCode) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.verifyCode = verifyCode;
    }
    
    public ModelUser(int userID, String userName, String email, String password, String verifyCode, UserType type) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.verifyCode = verifyCode;
        this.type = type;
    }
    
    public ModelUser(int userID, String userName, String email, String password) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
    
    
    public ModelUser(int userID, String userName, String email, String password, UserType type) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.type = type;
    }
    
    public void addWork (ModelWork work) {
        if (works == null) {
            works = new ArrayList<ModelWork> ();
        }
        
        System.out.println("Added in user");
        works.add(work);
        
        if (work.getType() == WorkType.PROJECT) {
            projectSubmission ++;
            if (work.getStatus() == StatusType.APPROVED) projectPublished ++;
        }
        
        if (work.getType() == WorkType.THESIS) {
            thesisSubmission ++;
            if (work.getStatus() == StatusType.APPROVED) thesisPublished ++;
        }
        
        if (work.getType() == WorkType.RESEARCH) {
            researchPublished ++;
            if (work.getStatus() == StatusType.APPROVED) researchPublished ++;
        }
    }
    
    
    public ModelUser() {
    }
    
    public ArrayList<ModelWork> getWorks () {
        return works;
    }
   
    
    int userID;
    String userName;
    String email;
    String password;
    String verifyCode;
    UserType type;
    private ArrayList works;
    private int projectPublished = 0, projectSubmission = 0;
    private int thesisPublished = 0, thesisSubmission = 0;
    private int researchPublished = 0, researchSubmission = 0;
}
