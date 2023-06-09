    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.metodos.servlet;

import co.edu.unipiloto.metodos.session.CalBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jhon1
 */
@WebServlet(name = "CalServlet", urlPatterns = {"/CalServlet"})
public class CalServlet extends HttpServlet {

    @EJB
    private CalBeanLocal calBean;

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
int val1;
        try {
            val1 = Integer.parseInt(request.getParameter("value1"));
        } catch (Exception e) {
            val1 = -1;
        }
        
        int val2;
        try {
            val2 = Integer.parseInt(request.getParameter("value2"));
        } catch (Exception e) {
            val2 = -1;
        }
        

        String action = request.getParameter("action");

        double resultado = 0;
        switch (action) {
            case "Sumar":
                resultado = calBean.suma(val1, val2);
                break;
            case "Restar":
                resultado = calBean.resta(val1, val2);
                break;
            case "Multiplicar":
                resultado = calBean.multiplicacion(val1, val2);
                break;
            case "Dividir":
                resultado = calBean.division(val1, val2);
                break;
            case "Modulo":
                resultado = calBean.modulo(val1, val2);
                break;
            case "Raiz":
                resultado = calBean.raiz(val1);
                break;
        }
        

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalServlet at " + request.getContextPath() + "</h1>");
            out.println("<p>La respuesta es: " + resultado + "</p>");
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
