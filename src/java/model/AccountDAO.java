/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import context.DBContext;
import entity.Account;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class AccountDAO extends DBContext {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account getAcount(String user, String pass) {
        String sql = "select * from account where user_gmail=? and password=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getInt(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public User getUser(String userGmail) {
        String sql = "select * from [User] where user_gmail=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userGmail);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getString(1), rs.getString(2), rs.getString(3),rs.getDate(4),rs.getBoolean(5), rs.getInt(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Account login(String user, String pass) {
        String querry = "select * from Account\n"
                + "where user_gmail = ?\n"
                + "and password = ?";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {

                return (new Account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3)));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public boolean checkAccountExist(String user) {
        String querry = "select * from Account\n"
                + "where user_gmail = ?\n";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {

                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }
    
    public void updateUserByEmail(String userGmail, String userName, String phoneNumber, String dob, boolean gender) {
        String querry = "UPDATE [User]\n"
                + "SET user_name=?,phone=?,dob=?,gender=?\n"
                + "WHERE user_gmail=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            ps.setString(1, userName);
            ps.setString(2, phoneNumber);
            Date date = Date.valueOf(dob);
            ps.setDate(3, date);
            ps.setBoolean(4, gender);
            ps.setString(5, userGmail);
            ps.executeUpdate();
            rs = ps.executeQuery();

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        dao.updateUserByEmail("vvtuan1010@gmail.com", "vu tuan", "0869937283", "2002-10-10", true);
    }

    public void signUp(String userGmail, String userName, String phoneNumber, String dob, boolean gender, String password) {
        String querry = "INSERT INTO [User](user_gmail,user_name,phone,dob,gender,role_id)\n"
                + "VALUES (?,?,?,?,?,2)" + "GO" + "INSERT INTO Account (user_gmail,password,role_id)\n"
                + "VALUES (?,?,2)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            ps.setString(1, userGmail);
            ps.setString(2, userName);
            ps.setString(3, phoneNumber);
            Date date = Date.valueOf(dob);
            ps.setDate(4, date);
            ps.setBoolean(5, gender);
            ps.executeUpdate();
            ps.setString(6, userGmail);
            ps.setString(7, password);
            rs = ps.executeQuery();

            ps.executeUpdate();

        } catch (Exception e) {
        }
    }


    public void signUp1(String userGmail, String userName, String phoneNumber, String dob, boolean gender) {
        String querry = "INSERT INTO [User](user_gmail,user_name,phone,dob,gender,role_id)\n"
                + "VALUES (?,?,?,?,?,2)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            ps.setString(1, userGmail);
            ps.setString(2, userName);
            ps.setString(3, phoneNumber);
            Date date = Date.valueOf(dob);
            ps.setDate(4, date);
            ps.setBoolean(5, gender);
            rs = ps.executeQuery();
            ps.executeUpdate();
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }
        public void signUp2(String userGmail, String password) {
        String querry = "INSERT INTO [Account](user_gmail,password,role_id)\n"
                + "VALUES (?,?,2)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            ps.setString(1, userGmail);
            ps.setString(2, password);
            rs = ps.executeQuery();
            ps.executeUpdate();
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }
    
    

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String querry = "select * from Account";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {

                list.add(new Account(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (Exception e) {
        }
        return list;

    }

    public void changePasswordByEmail(String pass, String email) {

        String querry = "update Account\n"
                + "set password = ?\n"
                + "where user_gmail = ?";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            ps.setString(1, pass);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    public int getAllNumberPage() {
        String querry = "select count(*) from [Account]";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = total / 5;
                if (total % 5 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (Exception e) {
        }
        return 0;
    }
    public Account getAccount(String userGmail) {
        String sql = "select * from [Account] where user_gmail=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userGmail);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getInt(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int getUserNumberPage() {
        String querry = "select count(*) from [Account]\n"
                + "where role_id = 2";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = total / 5;
                if (total % 5 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getSellerNumberPage() {
        String querry = "select count(*) from [Account]\n"
                + "where role_id = 4";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = total / 5;
                if (total % 5 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getExpertNumberPage() {
        String querry = "select count(*) from [Account]\n"
                + "where role_id = 3";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = total / 5;
                if (total % 5 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Account> getAllAccountByPaging(int index) {
        List<Account> list = new ArrayList<>();
        String querry = " select * from [Account]\n"
                + " order by user_gmail\n"
                + " offset ? rows\n"
                + " fetch first 5 rows only";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<Account> getUserAccountByPaging(int index) {
        List<Account> list = new ArrayList<>();
        String querry = "select * from [Account]\n"
                + "where role_id = 2\n"
                + "order by user_gmail\n"
                + "offset ? rows\n"
                + "fetch first 5 rows only";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<Account> getSellerAccountByPaging(int index) {
        List<Account> list = new ArrayList<>();
        String querry = "select * from [Account]\n"
                + "where role_id = 4\n"
                + "order by user_gmail\n"
                + "offset ? rows\n"
                + "fetch first 5 rows only";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<Account> getExpertAccountByPaging(int index) {
        List<Account> list = new ArrayList<>();
        String querry = "select * from [Account]\n"
                + "where role_id = 3\n"
                + "order by user_gmail\n"
                + "offset ? rows\n"
                + "fetch first 5 rows only";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }

        } catch (Exception e) {
        }
        return list;
    }

    public void changeRole(int roleId, String userGmail) {
        String querry = "  update [Account]\n"
                + "  set role_id = ?\n"
                + "  where user_gmail = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            ps.setInt(1, roleId);
            ps.setString(2, userGmail);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void deleteAccountByGmail(String userGmail) {
        String querry = "  delete from [Account]\n"
                + "  where user_gmail = ?\n";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            ps.setString(1, userGmail);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void deleteAccountBlogByGmail(String userGmail) {
        String querry = "  delete from [Account_Blog]\n"
                + "  where user_gmail = ?\n";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            ps.setString(1, userGmail);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }
    
        public void deleteAccountEnroll(String userGmail) {
        String querry = "  delete from [Enroll]\n"
                + "  where user_gmail = ?\n";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            ps.setString(1, userGmail);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }
    
    public Account searchAccountByGmail(String userGmail){
        String querry = "SELECT * FROM [Account] WHERE user_gmail = '?'";   
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(querry);
            ps.setString(1, userGmail);
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new Account(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (Exception e) {
        }
        return null;
    }
}
