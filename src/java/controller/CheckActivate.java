/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import model.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="CheckActivate", urlPatterns={"/checkactivate"})
public class CheckActivate extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        
        AccountDAO dao = new AccountDAO();
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("codeActivation");
        String name = (String) session.getAttribute("userName");
        String email = (String) session.getAttribute("userEmail");
        String pass = (String) session.getAttribute("userPassWord");
        String dob = (String)session.getAttribute("userDob");
        String gender = (String)session.getAttribute("userGender");
        Boolean check = gender.equals("Male")?true:false;
        String phone = (String) session.getAttribute("userPhone");
        String c = request.getParameter("codeInput");

        if(code == null){
            request.setAttribute("mess1", "Activation code is time out. Please register again!!!");
            request.getRequestDispatcher("ActivateAccount.jsp").forward(request, response);
        }
        if(c.equals(code)){
            String passEncode = EncodePassword.encode(pass);
            dao.signUp1(email, name, phone, dob, check);
            dao.signUp2(email, passEncode);
            request.setAttribute("gioitinh", gender);
            request.setAttribute("ngaysinh", dob);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }else{
            request.setAttribute("mess", "Activation code is incorrect!!!");
            request.getRequestDispatcher("ActivateAccount.jsp").forward(request, response);
        }
    }
    
        

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
            Logger.getLogger(CheckActivate.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
            Logger.getLogger(CheckActivate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
