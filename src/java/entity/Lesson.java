/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ACER
 */
public class Lesson {
    private int lessonID;
    private String lessonName;
    private String lessonDescription;
    private int courseID;

    public Lesson() {
    }

    public Lesson(int lessonID, String lessonName, String lessonDescription, int courseID) {
        this.lessonID = lessonID;
        this.lessonName = lessonName;
        this.lessonDescription = lessonDescription;
        this.courseID = courseID;
    }

    public int getLessonID() {
        return lessonID;
    }

    public String getLessonName() {
        return lessonName;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setLessonID(int leesonID) {
        this.lessonID = leesonID;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "Lesson{" + "lessonID=" + lessonID + ", lessonName=" + lessonName + ", lessonDescription=" + lessonDescription + ", courseID=" + courseID + '}';
    }
    
    
}
