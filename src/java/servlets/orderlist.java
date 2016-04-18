/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Pending;
import beans.foods;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Sairam Pillai
 */
public class orderlist extends HttpServlet {

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
        String[] foods = request.getParameterValues("selectedfoods");// all checked ids of food items    
        if(foods!=null){
        ArrayList list=((ArrayList)request.getSession().getAttribute("list"));
        String username=(String)request.getSession().getAttribute("username");
        Session session = null;
        ArrayList<beans.Pending> pendinglist= new ArrayList<beans.Pending>();
        try{
            
            for(String i : foods){
                if(i!=null){
                SessionFactory sessionFactory =new Configuration().configure().buildSessionFactory();
                session = sessionFactory.openSession();
                Transaction tx = session.beginTransaction();
                beans.Pending pending= new Pending();
                foods foodObj = (foods)list.get(Integer.parseInt(i)-1);
                pending.setUname(username);
                pending.setName(foodObj.getName());
                pending.setHotel(foodObj.getHotel());
                pending.setPrice(foodObj.getPrice());
                session.save(pending);
                System.out.println("Db: "+i+" "+username+" "+foodObj.getName()+" "+foodObj.getHotel()+" "+foodObj.getPrice());
                //if (!tx.wasCommitted())
                tx.commit();
                }
            }
            response.sendRedirect("dashboard.jsp");
        }catch(Exception e){
            System.out.println("Error "+ Arrays.toString(e.getStackTrace())+ " "+e);
        }
        finally{
            session.close();
            
        }
        }else{
            response.sendRedirect("order.jsp");
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
