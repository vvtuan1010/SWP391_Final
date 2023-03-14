/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author user
 */
public class Account {
    private String usergmail;
    private String password;
    private int role;

    public Account() {
    }

    public Account(String usergmail, String password, int role) {
        this.usergmail = usergmail;
        this.password = password;
        this.role = role;
    }

    public String getUsergmail() {
        return usergmail;
    }

    public void setUsergmail(String usergmail) {
        this.usergmail = usergmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    
}
