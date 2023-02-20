/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import java.io.Serializable;

/**
 *
 * @author ImMonster
 */
public class TaiKhoan implements Serializable {
    private String Username;
    private String password;
    private int IDQuyen;

    public TaiKhoan() {
    }

    public TaiKhoan(String Username, String password, int IDQuyen) {
        this.Username = Username;
        this.password = password;
        this.IDQuyen = IDQuyen;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "Username=" + Username + ", password=" + password + ", IDQuyen=" + IDQuyen + '}';
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIDQuyen() {
        return IDQuyen;
    }

    public void setIDQuyen(int IDQuyen) {
        this.IDQuyen = IDQuyen;
    }
    
}
