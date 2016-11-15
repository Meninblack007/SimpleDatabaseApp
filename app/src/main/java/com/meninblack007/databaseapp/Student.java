package com.meninblack007.databaseapp;

/**
 * Created by men_in_black007 on 15/11/16.
 */

public class Student {

    private String name;
    private String emailId;

    public Student(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}