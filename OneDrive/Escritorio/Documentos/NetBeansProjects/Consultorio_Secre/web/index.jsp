<%-- 
    Document   : index
    Created on : Nov 13, 2020, 9:53:47 PM
    Author     : andie
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="DAO.Database"%>
<%@page import="Clases.pacientes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Clases.citas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRINCIPAL</title>
        <link rel="stylesheet" type="text/css" href="mycss.css"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous"></link>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"></link>
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        
        <style>
            img
            {
                width: 30px; 
                height: 30px; 
            }
        </style>
        
        <script>
            function cargarMO(idcit,idpac,fecha,hora,status,idus)
            {
                document.modalito.txtidCita.value=idcit; 
                document.modalito.selidPaciente.value=idpac;
                document.modalito.txtfechaCita.value=fecha;
                document.modalito.txthoraCita.value=hora;
                document.modalito.selStatusCita.value=status;
                document.modalito.txtidUsuario.value=idus;
                
                document.modalito.opcion.value='modificar';
                document.modalito.btnGuardar.value='Modificar';
                document.modalito.btnGuardar.className='btn btn-success';
                
            }
            
            function cargarDel(idcit,idpac,fecha,hora,status,idus)
            {
                document.modalito.txtidCita.value=idcit; 
                document.modalito.selidPaciente.value=idpac;
                document.modalito.txtfechaCita.value=fecha;
                document.modalito.txthoraCita.value=hora;
                document.modalito.selStatusCita.value=status;
                document.modalito.txtidUsuario.value=idus;
                
                document.modalito.opcion.value='eliminar';
                document.modalito.btnGuardar.value='Eliminar';
                document.modalito.btnGuardar.className='btn btn-danger';
                
            }
        </script>
        
    </head>
    <body>
        <div class="bg">
        <%
            HttpSession sesion = request.getSession(); 
            //validar que solo si hay sesion activa pueda entrar
            //la unica sesion es usuario y nivel
            if(sesion.getAttribute("usuario")==null && sesion.getAttribute("tipousuario")==null)
            {
                response.sendRedirect("login/index_login.jsp");
            }
            
            if(sesion.getAttribute("usuario")!=null && sesion.getAttribute("tipousuario")!=null)
            {
                String useruser = sesion.getAttribute("usuario").toString();
                String iduseruser = sesion.getAttribute("iduser").toString();
                String tipouser = sesion.getAttribute("tipousuario").toString();
                if(!tipouser.equals("secretaria"))
                {
                    response.sendRedirect("login/index_login.jsp");
                } 
                    
        %>

            <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

            <hr>
            <p style="background-color:#0090b8; color:white; font-size: 20px;"> Bienvenido <%=useruser%> (Tipo de Usuario: <%=tipouser%>) | <a style="color:white;" href="login/index_login.jsp?cerrar=true">Cerrar Sesión</a> |</p> 
            <hr>

            </nav>
                    
            <div class="modal fade" id="miModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Formulario de Registro</h4>
                        </div>
                        <div class="modal-body">
                           <div class="form-group">
                                <form action="${pageContext.request.contextPath}/ctrlCitas" method="POST" name="modalito">
                                    <input type="text" name="txtidCita" placeholder="idCita" readonly="readonly" class="form-control" /><br>
                                    <select name="selidPaciente" id="select1">
                                        <option value="" disabled selected hidden>Seleccione el Paciente</option>
        <%
            Database db = new Database(); 
            Class.forName(db.getDriver());
            Connection conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            PreparedStatement psmnt = conn.prepareStatement("select * from pacientes");
            ResultSet results = psmnt.executeQuery();
            while(results.next()){
            String name = results.getString(2);
            String apes = results.getString(3);
            String id = results.getString(1);
        %>
                                            
                                        <option value="<%=id%>"><%out.println(name); out.println(" "); out.println(apes);%></option>
        <%
            }
            results.close(); psmnt.close();
        %>
                                    </select><br><br>
                                    <input type="text" name="txtfechaCita" placeholder="Fecha Cita: AAAA-MM-DD" class="form-control" /><br>
                                    <input type="text" name="txthoraCita" placeholder="Hora Cita: 00:00:00" class="form-control" /><br>
                                    <select name="selStatusCita" id="select2">
                                        <option value="" disabled selected hidden>Seleccione el Status de la Cita</option>
                                        <option value="Completada">Completada</option>
                                        <option value="Cancelada">Cancelada</option>
                                        <option value="Pendiente">Pendiente</option>
                                    </select><br><br>
                                    <input type="text" name="txtidUsuario" value="<%=iduseruser%>" readonly="readonly" class="form-control" /><br>
                                    <input type="submit" name="btnGuardar" class="btn btn-primary" value="Guardar"/><br>
                                    <input type="hidden" value="nuevo" name="opcion" /><br>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                    
     
        <%
            }
            response.setHeader("Pragma","no-cache");
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
            response.setDateHeader ("Expires", 0);

        %>
        <div style="margin-left: 4%;" class="row">
                <div class="span6">
                    <button style="font-family: Verdana; font-size: 17px;" type="button" class="btn btn-warning btn-lg" data-toggle="modal" data-target="#miModal">
                        Ingresar Nueva Cita
                    </button><br><br>
                </div>  
                <div class="span6">
                    <form style="margin-left: 10%; font-family: Verdana; font-size: 17px; " action="${pageContext.request.contextPath}/ctrlExpediente" method="POST" name="formu">
                        <input type="submit" name="btnMandarAExpediente" class="btn btn-primary btn-lg" value="Expedientes Pacientes"/><br>
                     </form>  
                </div>    
            </div>    
            <br><br>
            <h1 style="margin-left: 75px">Citas del día de Hoy</h1>
            <hr>       
                    
        <%
            DAO.DAOcitas dao = new DAO.DAOcitas();
            List<citas> data = new ArrayList<>();
            data = dao.consultar2();
            List<citas> data2 = new ArrayList<>();
            data2 = dao.consultar3();
        %>            
        
            <div style="width: 1000px; position: relative; margin-left: 4%;">
        
            <table border="1" class="table table-dark">
                <thead class="thead-dark" style="font-size: 18px; font-weight: 900;">
                    <tr>
                        <th>ID CITA</th>
                        <th>NOMBRES PACIENTE</th>
                        <th>APELLIDOS PACIENTE</th>
                        <th>FECHA CITA</th>
                        <th>HORA CITA</th>
                        <th>STATUS CITA</th>
                        <th>INGRESADA POR</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody style="font-size: 16px; font-weight: 700; ">
        <%
            for(citas c : data)
            {                                      
        %>
                    <tr>
                        <td><%= c.getIdCita()%></td>
                        <td><%= c.getIdPaciente().getNombresPaciente()%></td>
                        <td><%= c.getIdPaciente().getApellidosPaciente() %></td>
                        <td><%= c.getFechaCita()%></td>
                        <td><%= c.getHoraCita()%></td>
                        <td><%= c.getStatusCita()%></td>
                        <td><%= c.getIdUsuario().getNombreUsuario()%></td>
                        <td>
                            <a href="javascript:cargarMO('<%= c.getIdCita()%>','<%= c.getIdPaciente().getIdPaciente()%>','<%= c.getFechaCita()%>','<%= c.getHoraCita()%>','<%= c.getStatusCita()%>','<%= c.getIdUsuario().getIdUsuario()%>');">
                                <img src="${pageContext.request.contextPath}/recursos/editar.jpg" data-toggle="modal" data-target="#miModal">
                            </a>
                            <a href="javascript:cargarDel('<%= c.getIdCita()%>','<%= c.getIdPaciente().getIdPaciente()%>','<%= c.getFechaCita()%>','<%= c.getHoraCita()%>','<%= c.getStatusCita()%>','<%= c.getIdUsuario().getIdUsuario()%>');">
                                <img src="${pageContext.request.contextPath}/recursos/eliminar.jpg" data-toggle="modal" data-target="#miModal">
                            </a>
                        </td>
                        
                    </tr>
        <%
            }
        %>
                </tbody>
            </table>
        </div>        
        
        <br><br>
        <h1 style="margin-left: 75px">Citas Futuras</h1>
        <hr>
        
        <div style="width: 1000px; position: relative; margin-left: 4%;">
        
            <table border="1" class="table table-dark">
                <thead class="thead-dark" style="font-size: 18px; font-weight: 900;">
                    <tr>
                        <th>ID CITA</th>
                        <th>NOMBRES PACIENTE</th>
                        <th>APELLIDOS PACIENTE</th>
                        <th>FECHA CITA</th>
                        <th>HORA CITA</th>
                        <th>STATUS CITA</th>
                        <th>INGRESADA POR</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody style="font-size: 16px; font-weight: 700;">
        <%
            for(citas ci : data2)
            {
        %>
                    <tr>
                        <td><%= ci.getIdCita()%></td>
                        <td><%= ci.getIdPaciente().getNombresPaciente()%></td>
                        <td><%= ci.getIdPaciente().getApellidosPaciente() %></td>
                        <td><%= ci.getFechaCita()%></td>
                        <td><%= ci.getHoraCita()%></td>
                        <td><%= ci.getStatusCita()%></td>
                        <td><%= ci.getIdUsuario().getNombreUsuario() %></td>
                        <td>
                            <a href="javascript:cargarMO('<%= ci.getIdCita()%>','<%= ci.getIdPaciente().getIdPaciente()%>','<%= ci.getFechaCita()%>','<%= ci.getHoraCita()%>','<%= ci.getStatusCita()%>','<%= ci.getIdUsuario().getIdUsuario()%>');">
                                <img src="${pageContext.request.contextPath}/recursos/editar.jpg" data-toggle="modal" data-target="#miModal">
                            </a>
                            <a href="javascript:cargarDel('<%= ci.getIdCita()%>','<%= ci.getIdPaciente().getIdPaciente()%>','<%= ci.getFechaCita()%>','<%= ci.getHoraCita()%>','<%= ci.getStatusCita()%>','<%= ci.getIdUsuario().getIdUsuario()%>');">
                                <img src="${pageContext.request.contextPath}/recursos/eliminar.jpg" data-toggle="modal" data-target="#miModal">
                            </a>
                        </td>
                        
                    </tr>
        <%
            }
        %>
                </tbody>
            </table>
        </div> 
    </body>
</html>
