/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.AccountDAO;

/**
 *
 * @author ADMIN
 */
public class SaveAccount extends HttpServlet {

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

        String name = request.getParameter("userNameChange");
        String email = request.getParameter("userEmailChange");
        String phone = request.getParameter("userPhoneChange");
        String dob = request.getParameter("userDobChange");
        String gender = request.getParameter("userGenderChange");
        Boolean check = gender.equals("Male") ? true : false;

        if (name == "") {
            request.setAttribute("messname", "Name does not empty!!!");
            request.getRequestDispatcher("LoadProfile.jsp").forward(request, response);
        } 
        else {
            LocalDateTime current = LocalDateTime.now();
            DateTimeFormatter formatted1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String day = current.format(formatted1);
            if (dob.compareTo(day) >= 0) {
                request.setAttribute("messdob", "Invalid date!!!");
                request.getRequestDispatcher("LoadProfile.jsp").forward(request, response);
            } 
            else {
                if (phone == "") {
                    request.setAttribute("messphone", "Phone does not empty!!!");
                    request.getRequestDispatcher("LoadProfile.jsp").forward(request, response);
                    } 
                else {
                    AccountDAO dao = new AccountDAO();
                    dao.updateUserByEmail(email, name, phone, dob, check);
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            }
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
