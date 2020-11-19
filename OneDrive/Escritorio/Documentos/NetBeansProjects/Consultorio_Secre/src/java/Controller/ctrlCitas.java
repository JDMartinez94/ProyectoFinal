/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Clases.citas;
import Clases.pacientes;
import Clases.usuarios;
import DAO.DAOcitas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andie
 */
public class ctrlCitas extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DAOcitas dao = new DAOcitas(); 
            citas cits = new citas();
            List<citas> data = new ArrayList<>();
            String respuesta="";
            
            try {
                if(request.getParameter("btnGuardar")!=null && request.getParameter("opcion")!=null)
                {
                    String op = request.getParameter("opcion");
                    
                    if(op.equals("nuevo"))
                    {
                        String idpac = request.getParameter("selidPaciente");
                        String txtfechaCita = request.getParameter("txtfechaCita");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date date = sdf.parse(txtfechaCita);
                        java.sql.Date sqlDate = new Date(date.getTime());

                        cits.setIdPaciente(new pacientes(Integer.parseInt(idpac)));
                        cits.setFechaCita(sqlDate);
                        cits.setHoraCita(Time.valueOf(request.getParameter("txthoraCita")));
                        cits.setStatusCita(request.getParameter("selStatusCita"));
                        cits.setIdUsuario(new usuarios(Integer.parseInt(request.getParameter("txtidUsuario"))));
                        
                        respuesta= dao.insertar(cits);                        
                        request.setAttribute("respuesta", respuesta);
                        response.sendRedirect(request.getContextPath() + "/index.jsp");
                    }
                    
                    
                    if(op.equals("modificar"))
                    {
                        String idpac = request.getParameter("selidPaciente");
                        String txtfechaCita = request.getParameter("txtfechaCita");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date date = sdf.parse(txtfechaCita);
                        java.sql.Date sqlDate = new Date(date.getTime());
                        
                        cits.setIdCita(Integer.parseInt(request.getParameter("txtidCita")));
                        cits.setIdPaciente(new pacientes(Integer.parseInt(idpac)));
                        cits.setFechaCita(sqlDate);
                        cits.setHoraCita(Time.valueOf(request.getParameter("txthoraCita")));
                        cits.setStatusCita(request.getParameter("selStatusCita"));
                        cits.setIdUsuario(new usuarios(Integer.parseInt(request.getParameter("txtidUsuario"))));
                        
                        respuesta= dao.modificar(cits);                        
                        request.setAttribute("respuesta", respuesta);
                        response.sendRedirect(request.getContextPath() + "/index.jsp");
                    }
                    
                    
                    if(op.equals("eliminar"))
                    {
                        cits.setIdCita(Integer.parseInt(request.getParameter("txtidCita")));
                        
                        respuesta= dao.eliminar(cits);                        
                        request.setAttribute("respuesta", respuesta);
                        response.sendRedirect(request.getContextPath() + "/index.jsp");
                    }
                         
                }
            } catch (Exception e) {
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
        } catch (ParseException ex) {
            Logger.getLogger(ctrlCitas.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(ctrlCitas.class.getName()).log(Level.SEVERE, null, ex);
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
