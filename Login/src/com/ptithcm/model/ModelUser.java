/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.model;
import javax.swing.Icon;

/**
 *
 * @author ImMonster
 */
public class ModelUser {
    private int userID;
    private String userName;
    private Icon profile;

    public ModelUser() {
    }
    
    public ModelUser(int userID, String userName, Icon profile) {
        this.userID = userID;
        this.userName = userName;
        this.profile = profile;
    }
    
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

    public Icon getProfile() {
        return profile;
    }

    public void setProfile(Icon profile) {
        this.profile = profile;
    }
    
}
