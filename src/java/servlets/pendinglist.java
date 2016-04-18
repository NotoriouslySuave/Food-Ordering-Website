/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Pending;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Sairam Pillai
 */
@WebServlet(name = "pendinglist", urlPatterns = {"/pendinglist"})
public class pendinglist extends HttpServlet {

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
        String username=(String)request.getSession().getAttribute("username");
        ArrayList<beans.Pending> pendinglist= new ArrayList<beans.Pending>();
        try{
            if(request.getSession().getAttribute("username")==username){
                    SessionFactory factory = new Configuration().configure().buildSessionFactory();
                    Session session = factory.openSession();
                    String query = "select id,name,hotel,price from Pending where uname=?";//use class variables not sqldb column name
                    org.hibernate.Query queryObj = session.createQuery(query);
                    queryObj.setString(0, username);//org.hibrenate.Query starts with 0
                    for(Iterator it=queryObj.iterate();it.hasNext();){
                        beans.Pending pending = new Pending();
                        Object[] row =(Object[]) it.next();
                            pending.setId((Integer)row[0] );
                            pending.setName((String)row[1]);
                            pending.setHotel((String)row[2]);
                            pending.setPrice((Integer)row[3]);
                            pendinglist.add(pending);
                    }
                    
                    request.getSession().setAttribute("pendinglist", pendinglist);
                    if(request.getParameter("web")!=null){
                        if(request.getParameter("web").equalsIgnoreCase("1") && request.getParameter("web")!=null){
                            response.sendRedirect("checkout.jsp");
                        }
                    }else{
                        response.sendRedirect("pending.jsp");
                    } 
                }
        }catch(Exception e){
            System.out.println("Error "+ Arrays.toString(e.getStackTrace())+ " "+e);
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
