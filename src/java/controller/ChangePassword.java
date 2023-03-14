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
import jakarta.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AccountDAO;

/**
 *
 * @author ADMIN
 */
public class ChangePassword extends HttpServlet {

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
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        String oldpass = request.getParameter("oldpass");
        String passEncode = EncodePassword.encode(oldpass);
        String newpass = request.getParameter("newpass");
        String renewpass = request.getParameter("renewpass");
        AccountDAO dao = new AccountDAO();
        entity.Account a = (entity.Account) session.getAttribute("acc");
        if (oldpass == "") {
            request.setAttribute("mess1", "This field does not empty!!!");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
        } else {
            if (passEncode.equals(a.getPassword())) {
                if (newpass == "") {
                    request.setAttribute("mess2", "This field does not empty!!!");
                    request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                } else {
                    if (renewpass == "") {
                        request.setAttribute("mess3", "This field does not empty!!!");
                        request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                    } else {
                        if (newpass.equals(renewpass)) {
                            String pass = EncodePassword.encode(newpass);
                            dao.changePasswordByEmail(pass, a.getUsergmail());
                            request.getRequestDispatcher("Home.jsp").forward(request, response);
                        } else {
                            request.setAttribute("mess4", "Re-enter password does not match");
                            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                        }
                    }
                }
            } else {
                request.setAttribute("mess", "Wrong password!!!");
                request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
        }
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
