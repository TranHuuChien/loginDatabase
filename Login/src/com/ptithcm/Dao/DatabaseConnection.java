package com.ptithcm.Dao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private Connection DatabaseConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-E2I98S5\\SQLEXPRESS:1433;user=sa;password=1234;useUnicode=true;characterEncoding=UTF-8;databaseName=QUAN_LY_PHAN_CONG_DO_AN");
            //connection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-OSBTFHG:1433;user=sa;password=thinh123;useUnicode=true;characterEncoding=UTF-8;databaseName=QUAN_LY_PHAN_CONG_DO_AN");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
//    public static void main(String[] args) throws SQLException {
//        String server = "DESKTOP-OSBTFHG";
//        String port = "1433";
//        String database = "QUAN_LY_PHAN_CONG_DO_AN";
//        String userName = "sa";
//        String password = "thinh123";
//        try(Connection conn = java.sql.DriverManager.getConnection("jdbc:sqlserver://DESKTOP-OSBTFHG:1433;user=sa;password=thinh123;useUnicode=true;characterEncoding=UTF-8;databaseName=QUAN_LY_PHAN_CONG_DO_AN");Statement stmt = conn.createStatement();
//){
//            System.out.println("kết nối thành công");
//            String SQL = "SELECT TOP 10 * FROM LOP";
//            ResultSet rs = stmt.executeQuery(SQL);
//            while(rs.next()){
//                System.out.println(rs.getString("IDLop")+"  "+rs.getString("TenLop"));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
}
