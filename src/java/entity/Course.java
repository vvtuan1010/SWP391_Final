/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import model.CourseDAO;

/**
 *
 * @author duke
 */
public class Course {

    private int course_id;
    private String course_name;
    private String course_description;
    private String course_image;
    private int category_id;

    public Course() {
    }

    
    public Course(int course_id, String course_name, String course_description, String course_image, int category_id) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_description = course_description;
        this.course_image = course_image;
        this.category_id = category_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public String getCourse_image() {
        return course_image;
    }

    public void setCourse_image(String course_image) {
        this.course_image = course_image;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Course{" + "course_id=" + course_id + ", course_name=" + course_name + ", course_description=" + course_description + ", course_image=" + course_image + ", category_id=" + category_id + '}';
    }

    
    public static void main(String[] args) throws Exception {
        CourseDAO c = new CourseDAO();
                                                                                                    
        System.out.println(c.getOne(1));
    }
}
