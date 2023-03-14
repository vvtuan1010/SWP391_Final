/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.AccountDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ADMIN
 */
public class Signup extends HttpServlet {

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

        String fullname = request.getParameter("fullname");
        String userName = request.getParameter("user");
        String passWord = request.getParameter("pass");
        String rePassWord = request.getParameter("repass");
        String date = request.getParameter("dob");
        Date dob = Date.valueOf(date);
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");

        if (fullname == "") {
            request.setAttribute("messname", "Name does not empty!!!");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else {
            if (userName == "") {
                request.setAttribute("messemail", "Email does not empty!!!");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            } else {
                if (passWord == "") {
                    request.setAttribute("messpass", "Password does not empty!!!");
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                } else {
                    if (phone == "") {
                        request.setAttribute("messphone", "Phone does not empty!!!");
                        request.getRequestDispatcher("Register.jsp").forward(request, response);
                    } else {
                        if (!passWord.equals(rePassWord)) {
                            request.setAttribute("mess2", "Password does not match!!!");
                            request.getRequestDispatcher("Register.jsp").forward(request, response);
                        } else {
                            LocalDateTime current = LocalDateTime.now();
                            DateTimeFormatter formatted1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                            String day = current.format(formatted1);
                            if (date.compareTo(day) >= 0) {
                                request.setAttribute("messdob", "Invalid date!!!");
                                request.getRequestDispatcher("Register.jsp").forward(request, response);
                            } else {
                                
                                AccountDAO dao = new AccountDAO();
                                Boolean check = dao.checkAccountExist(userName);
                                if (check == false) {
                                    HttpSession session = request.getSession();
                                    session.setAttribute("userName", fullname);
                                    session.setAttribute("userEmail", userName);
                                    session.setAttribute("userPassWord", passWord);
                                    session.setAttribute("userPhone", phone);
                                    session.setAttribute("userGender", gender);
                                    session.setAttribute("userDob", date);
                                    response.sendRedirect("ActivateAccount");
                                } else {
                                    request.setAttribute("mess1", "Account exist!!!");
                                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                                }
                            }
                        }
                    }
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
