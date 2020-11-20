/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Clases.operaciones;
import DAO.DAOoperaciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andie
 */
public class ctrlOperaciones extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
                DAOoperaciones dao = new DAOoperaciones(); 
                operaciones opes = new operaciones();
                List<operaciones> data = new ArrayList<>();
                String respuesta="";
            
                if(request.getParameter("btnGuardar")!=null && request.getParameter("opcion")!=null)
                {
                    String op = request.getParameter("opcion");
                    
                    if(op.equals("nuevo"))
                    {
                        pac.setNombresPaciente(request.getParameter("txtnomPac"));
                        pac.setApellidosPaciente(request.getParameter("txtapePac"));
                        pac.setFechaNacPaciente(sqlDate);
                        pac.setTelPaciente(request.getParameter("txttelPac"));
                        pac.setEmailPaciente(request.getParameter("txtemail"));
                        pac.setDireccionPaciente(request.getParameter("txtdirPac"));
                        pac.setNombreemergPaciente(request.getParameter("txtnomEme"));
                        pac.setTelemergPaciente(request.getParameter("txttelEme"));
                        
                        respuesta= dao.insertar(pac);                        
                        request.setAttribute("respuesta", respuesta);
                        response.sendRedirect(request.getContextPath() + "/vistas/vExpediente.jsp");
                    }
                    
                    
                    if(op.equals("modificar"))
                    {
                        String txtfechaNac = request.getParameter("txtfechaNac");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date date = sdf.parse(txtfechaNac);
                        java.sql.Date sqlDate = new Date(date.getTime());

                        pac.setIdPaciente(Integer.parseInt(request.getParameter("txtidPac")));
                        pac.setNombresPaciente(request.getParameter("txtnomPac"));
                        pac.setApellidosPaciente(request.getParameter("txtapePac"));
                        pac.setFechaNacPaciente(sqlDate);
                        pac.setTelPaciente(request.getParameter("txttelPac"));
                        pac.setEmailPaciente(request.getParameter("txtemail"));
                        pac.setDireccionPaciente(request.getParameter("txtdirPac"));
                        pac.setNombreemergPaciente(request.getParameter("txtnomEme"));
                        pac.setTelemergPaciente(request.getParameter("txttelEme"));
                        
                        respuesta= dao.modificar(pac);                        
                        request.setAttribute("respuesta", respuesta);
                        response.sendRedirect(request.getContextPath() + "/vistas/vExpediente.jsp");
                    }
                    
                    
                    if(op.equals("eliminar"))
                    {
                        pac.setIdPaciente(Integer.parseInt(request.getParameter("txtidPac")));
                        
                        respuesta= dao.eliminar(pac);                        
                        request.setAttribute("respuesta", respuesta);
                        response.sendRedirect(request.getContextPath() + "/vistas/vExpediente.jsp");
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
