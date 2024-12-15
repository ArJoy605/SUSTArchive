
package com.liverpool.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ModelWork {
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkType getType() {
        return type;
    }

    public void setType(WorkType type) {
        this.type = type;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
    
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public ModelWork(String date, String name,String author, WorkType type, int views, StatusType status) {
        this.date = date;
        this.name = name;
        this.author = author;
        this.type = type;
        this.views = views;
        this.status = status;
        dateTime = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy   hh:mm");  
        String strDate = dateFormat.format(dateTime);
        this.upTime = strDate;
    }
    
    private Date dateTime;
    private String date;
    private String name;
    private WorkType type;
    private int views;
    private StatusType status;
    private String author;
    private String upTime;

    
    
}
