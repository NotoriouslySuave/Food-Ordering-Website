/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import beans.*;
import jdk.nashorn.internal.runtime.Context;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Sairam Pillai
 */
public class LoginAuthentication extends HttpServlet {

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
        try{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession httpSession = request.getSession(true);
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String query = "select username,password from users where username=? and password=?";//use class variables not sqldb column name
        org.hibernate.Query queryObj = session.createQuery(query);
        queryObj.setString(0, username);//org.hibrenate.Query starts with 0
        queryObj.setString(1, password);
        List<beans.users> records = queryObj.list();
        if(records.size()>0){
            request.setAttribute("loginstatus", "Login Successful.");
            httpSession.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);
            return;
        }else{
           request.setAttribute("loginstatus", "Username/Password do not match.");
           getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
           return;
        }
        }catch(Exception e){
            System.out.println("Error "+Arrays.toString(e.getStackTrace())+" "+e);
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
