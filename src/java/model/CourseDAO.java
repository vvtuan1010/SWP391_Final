/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import context.DBContext;
import entity.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duke
 */
public class CourseDAO {

    public List<Course> getAll() throws Exception {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM Course";
        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Course obj = new Course();
                obj.setCourse_id(rs.getInt("course_id"));
                obj.setCourse_name(rs.getString("course_name"));
                obj.setCourse_description(rs.getString("course_description"));
                obj.setCourse_image(rs.getString("course_image"));
                obj.setCategory_id(rs.getInt("category_id"));
                ;
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public Course getOne(int id) throws Exception {
        String sql = " SELECT * FROM COURSE where course_id = ?";

        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
            Course obj = new Course();
            obj.setCourse_id(rs.getInt("course_id"));
            obj.setCourse_name(rs.getString("course_name"));
            obj.setCourse_description(rs.getString("course_description"));
            obj.setCourse_image(rs.getString("course_image"));
            obj.setCategory_id(rs.getInt("category_id"));
            return obj;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }
   

    public boolean add(Course obj) throws Exception {
        int check = 0;
        String sql = "INSERT INTO Course ([course_id], course_name, course_description, course_image, category_id)\n"
                + "VALUES(? , ?, ?, ?,?)";
        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, obj.getCourse_id());
            ps.setObject(2, obj.getCourse_name());
            ps.setObject(3, obj.getCourse_description());
            ps.setObject(4, obj.getCourse_image());
            ps.setObject(5, obj.getCategory_id());

            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(Course obj, int id) throws Exception {
        int check = 0;
        String sql = "update Course SET  course_id = ?, course_name = ?, [course_description] = ?,course_image = ?,category_id = ?  where course_id = ?";
        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, obj.getCourse_id());
            ps.setObject(2, obj.getCourse_name());
            ps.setObject(3, obj.getCourse_description());
            ps.setObject(4, obj.getCourse_image());
            ps.setObject(5, obj.getCategory_id());
            ps.setObject(6, id);
            check = ps.executeUpdate();
            System.out.println(check);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(int id) throws Exception {
        int check = 0;
        String sql = " DELETE from [Course] where course_id = ? ";
        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<Course> SortByCategory(int id) throws Exception {
        List<Course> list = new ArrayList<>();
        String sql = "select * from \n"
                + "Course c join Category ca on c.category_id = ca.category_id\n"
                + "where c.category_id = ?";
        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Course obj = new Course();
                obj.setCourse_id(rs.getInt("course_id"));
                obj.setCourse_name(rs.getString("course_name"));
                obj.setCourse_description(rs.getString("course_description"));
                obj.setCourse_image(rs.getString("course_image"));
                obj.setCategory_id(rs.getInt("category_id"));
                ;
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;

    }

//    public static void main(String[] args) throws Exception {
//        CourseDAO c = new CourseDAO();
//        c.getOne(1);
//        System.out.println();
//    }
}
