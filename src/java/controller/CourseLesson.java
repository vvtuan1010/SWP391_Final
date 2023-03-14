/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Course;
import entity.Lesson;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CourseDAO;
import model.LessonDAO;

/**
 *
 * @author ACER
 */
@WebServlet(name = "CourseLesson", urlPatterns = {"/courselesson"})
public class CourseLesson extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CourseLesson</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseLesson at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int mid = Integer.parseInt(request.getParameter("mid"));
//        try {
            //         CourseDAO dao = new CourseDAO();
//        try {
//            Course course = dao.getOne(mid);
//        } catch (Exception ex) {
//            Logger.getLogger(CourseLesson.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         
//        List<Lesson> listL = dao.getAllLessonByCourseID();
    
//        Course course = null;
//        try {
//            course = new CourseDAO().getOne(mid);
//        } catch (Exception ex) {
//            Logger.getLogger(CourseLesson.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        CourseDAO daoc = new CourseDAO();
         LessonDAO daol = new LessonDAO();
         Course c = null;
        try {
            c = daoc.getOne(mid);
        } catch (Exception ex) {
            Logger.getLogger(CourseLesson.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Lesson> listL = daol.getAllLesson();
        request.setAttribute("listL", listL);
        request.setAttribute("c", c);
        request.getRequestDispatcher("CourseLesson.jsp").forward(request, response);
   

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    }
}
