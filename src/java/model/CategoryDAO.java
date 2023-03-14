/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import context.DBContext;
import entity.Category;
import entity.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duke
 */
public class CategoryDAO {

    public List<Category> getAll() throws Exception {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Category";
        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category obj = new Category();
                obj.setCategory_id(rs.getInt("category_id"));
                obj.setCategory_name(rs.getString("category_name"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
    
    public Category getOne(int id) throws Exception {
        String sql = "SELECT * FROM Category where category_id = ?";
        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category obj = new Category();
                obj.setCategory_id(rs.getInt("category_id"));
                obj.setCategory_name(rs.getString("category_name"));
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
