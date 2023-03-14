/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author duke
 */
public class Enroll {
    private String user_gmail;
    private Course course;

    public Enroll() {
    }

    public Enroll(String user_gmail, Course course) {
        this.user_gmail = user_gmail;
        this.course = course;
    }

    public String getUser_gmail() {
        return user_gmail;
    }

    public void setUser_gmail(String user_gmail) {
        this.user_gmail = user_gmail;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Enroll{" + "user_gmail=" + user_gmail + ", course=" + course + '}';
    }

   
    
    
}
