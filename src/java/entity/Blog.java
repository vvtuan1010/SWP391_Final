/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author hp
 */
public class Blog {
   private int blog_id;
   private String blog_title;
   private String blog_detail;
   private String blog_image;
   private Date blog_date;

    public Blog() {
    }
   

    public Blog(int blog_id, String blog_title, String blog_detail, String blog_image, Date blog_date) {
        this.blog_id = blog_id;
        this.blog_title = blog_title;
        this.blog_detail = blog_detail;
        this.blog_image = blog_image;
        this.blog_date = blog_date;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public String getBlog_title() {
        return blog_title;
    }

    public void setBlog_title(String blog_title) {
        this.blog_title = blog_title;
    }

    public String getBlog_detail() {
        return blog_detail;
    }

    public void setBlog_detail(String blog_detail) {
        this.blog_detail = blog_detail;
    }

    public String getBlog_image() {
        return blog_image;
    }

    public void setBlog_image(String blog_image) {
        this.blog_image = blog_image;
    }

    public Date getBlog_date() {
        return blog_date;
    }

    public void setBlog_date(Date blog_date) {
        this.blog_date = blog_date;
    }

    @Override
    public String toString() {
        return "Blog{" + "blog_id=" + blog_id + ", blog_title=" + blog_title + ", blog_detail=" + blog_detail + ", blog_image=" + blog_image + ", blog_date=" + blog_date + '}';
    }
   
   

    
}
