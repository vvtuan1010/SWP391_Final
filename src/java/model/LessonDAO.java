/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import context.DBContext;
import entity.Lesson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class LessonDAO extends DBContext {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Lesson> getAllLesson() {
        List<Lesson> list = new ArrayList<>();
        String query = "select * from Lesson";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Lesson(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;

    }
    
    public List<Lesson> getAllLessonByCourseID() {
        List<Lesson> list = new ArrayList<>();
        String query = "select * from Lesson where course_id = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Lesson(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;

    }


    public void deleteLesson(String id) {
        String query = "delete from Lesson\n"
                + "where lesson_id = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void createLesson(String lessonID, String name, String description, String courseID) {
        String query = "insert into \n"
                + "Lesson\n"
                + "values (?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, lessonID);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setString(4, courseID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Lesson getLessonByID(String lessonID) {
        String query = "Select * from Lesson \n"
                + "where lesson_id = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, lessonID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Lesson(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public Lesson searchLessonByName(String txtSearch) {
        String query = "Select * from Lesson\n"
                + " where lesson_name like ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Lesson(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateLesson(String lessonID, String name, String description, String courseID) {
        String query = "update Lesson\n"
                + "set lesson_name = ?,\n"
                + "lesson_description = ?,\n"
                + "course_id= ?\n"
                + "where lesson_id = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, courseID);
            ps.setString(4, lessonID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
