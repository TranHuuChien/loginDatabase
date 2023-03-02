/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.Dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thinh nguyen
 */
public class ConnectDatabase {

    public static Connection openConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-E2I98S5\\SQLEXPRESS:1433;user=sa;password=1234;useUnicode=true;characterEncoding=UTF-8;databaseName=QUAN_LY_PHAN_CONG_DO_AN");
            //conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-OSBTFHG:1433;user=sa;password=thinh123;useUnicode=true;characterEncoding=UTF-8;databaseName=QUAN_LY_PHAN_CONG_DO_AN");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void closeConnection(Connection c){
        try {
            if (c!=null){
                c.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
//    public static void main(String[] args) {
//        Connection c;
//        try {
//            c = ConnectDatabase.getConnection();
//            System.out.println(c);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}

