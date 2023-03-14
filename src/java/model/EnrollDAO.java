/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import context.DBContext;
import entity.Course;
import entity.Enroll;
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
public class EnrollDAO {

    public boolean Enroll(String user_gmail, int courseId) throws Exception {
        String sql = "Insert into Enroll (user_gmail , course_id)\n"
                + "Values" + "('" + user_gmail + "'," + courseId + ')';
        int check = 0;
        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {

            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean UnEnroll(String user_gmail, int courseId) throws Exception {
        String sql = "Delete from Enroll where user_gmail = ? AND course_id = ?";
        int check = 0;
        
        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, user_gmail);
            ps.setObject(2, courseId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public Enroll getOne(int id, String email) throws Exception {
        String sql = " SELECT * FROM Enroll where course_id = ? AND user_gmail=?";

        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, id);
            ps.setObject(2, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Course c = new Course();
                c.setCourse_id(rs.getInt("course_id"));
                return new Enroll(rs.getString("user_gmail"), c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    public List<Enroll> EnrolledCourse(String gmail) throws Exception {
        List<Enroll> enrol = new ArrayList<>();
        String sql = "Select e.user_gmail, c.course_id, c.course_name, c.course_description, c.course_image, c.category_id \n"
                + "from Enroll e join Course c on e.course_id = c.course_id Where e.user_gmail = '" + gmail + "'";
        try ( Connection con = new DBContext().getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Enroll obj = new Enroll();
                obj.setUser_gmail(rs.getString("user_gmail"));
                obj.setCourse(new Course(rs.getInt("course_id"), rs.getString("course_name"), rs.getString("course_description"), rs.getString("course_image"), rs.getInt("category_id")));

                enrol.add(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return enrol;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new EnrollDAO().UnEnroll("vietanhlm69@gmail.com", 2));
    }
}
