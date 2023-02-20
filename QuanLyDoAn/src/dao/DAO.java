/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entity.TaiKhoan;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ImMonster
 */
public class DAO {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public TaiKhoan getTaiKhoan(String username, String password) {
        try {
            connection = new DBContext().getConnection();
            String query = "select * from TaiKhoan where TaiKhoan.Username = ? and password = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while(rs.next())
            {
                return new TaiKhoan(rs.getString(1),rs.getString(2),rs.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        DAO dao = new DAO();
        TaiKhoan taiKhoan = dao.getTaiKhoan("admin","123");
        System.out.println(taiKhoan.toString());
    }
    
    
}
