/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.foods;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Sairam Pillai
 */
public class listfoods extends HttpServlet {

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
                SessionFactory factory = new Configuration().configure().buildSessionFactory();
                Session session = factory.openSession();
                foods foods=null;
                java.util.ArrayList<beans.foods> foodlist = new java.util.ArrayList<beans.foods>();
                String query = "select id,name,hotel,type,price from foods where 1=1";//use class variables not sqldb column name
                org.hibernate.Query queryObj = session.createQuery(query);
                for(Iterator it=queryObj.iterate();it.hasNext();){
                    foods = new foods();
                    Object[] row =(Object[]) it.next();
                    foods.setId((Integer)row[0]);
                    foods.setName((String)row[1]);
                    foods.setHotel((String)row[2]);
                    foods.setType((String)row[3]);
                    foods.setPrice((int)row[4]);
                    foodlist.add(foods);
                }
                HttpSession httpSession = request.getSession(false);
                if(httpSession.getAttribute("username")!=null){
                    httpSession.setAttribute("list",foodlist);
                    getServletContext().getRequestDispatcher("/order.jsp").forward(request, response);
                }else{
                    response.sendRedirect("index.html");
                }
            }catch(Exception e){
                System.out.println("Error"+Arrays.toString(e.getStackTrace())+" "+e);
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
