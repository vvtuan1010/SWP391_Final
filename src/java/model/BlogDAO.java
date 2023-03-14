/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import context.DBContext;
import entity.Blog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class BlogDAO extends DBContext {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Blog> getBlog() {
        List<Blog> list = new ArrayList<>();
        String sql = "Select * from Blog";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Blog(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
public List<Blog> sortBlog() {
        List<Blog> list = new ArrayList<>();
        String sql = "SELECT * FROM blog ORDER BY blog_date DESC;";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Blog(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public void insertBlog(String id, String title, String detail, String image, String date) {
        String query = "insert into Blog values (?,?,?,?,?)";
        try {

            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, title);
            ps.setString(3, detail);
            ps.setString(4, image);
            ps.setString(5, date);
            rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (Exception e) {

        }

    }

    public void deleteBlogByID1(String id) {
        String querry1 = "delete from [Account_Blog] \n"
                + "  where blog_id = ?";
        try {
             con = new DBContext().getConnection();
            ps = con.prepareStatement(querry1);

            ps.setString(1, id);
            rs = ps.executeQuery();
            ps.executeUpdate();
        } catch (Exception e) {


        }
    }

    public void deleteBlogByID2(String id) {

        String querry2 = "  delete from Blog\n"
                + "  where blog_id = ?";

        try {
         con = new DBContext().getConnection();
            ps = con.prepareStatement(querry2);

            ps.setString(1, id);
            rs = ps.executeQuery();
            ps.executeUpdate();
        } catch (Exception ex) {

        }

    }

    public Blog getBlogID(String id) {
        String query = "select * from Blog\n"
                + "where blog_id = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Blog(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5));
            }

        } catch (Exception e) {

        }
        return null;
    }
public void updateBlog(String id, String title, String detail, String image, String date) {
        String query = "update blog set  blog_title=?, blog_detail=?, blog_image=?, blog_date=?\n" +
"				where blog_id=?";
        try {

            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, detail);
            ps.setString(3, image);
            ps.setString(4, date);
            ps.setString(5, id);
            rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (Exception e) {

        }

    }
    public static void main(String[] args) {
        BlogDAO bl = new BlogDAO();
       
        System.out.println(bl.sortBlog());
        
    }
}
