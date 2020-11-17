<%-- 
    Document   : index
    Created on : Nov 13, 2020, 9:53:47 PM
    Author     : andie
--%>

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
                String tipouser = sesion.getAttribute("tipousuario").toString();
                if(tipouser.equals("secretaria"))
                {
                    
        %>

                    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

                    <hr>
                    <p style="background-color:#0090b8; color:white; font-size: 20px;"> Bienvenido <%=useruser%> (Tipo de Usuario: <%=tipouser%>) | <a style="color:white;" href="login/index_login.jsp?cerrar=true">Cerrar Sesión</a> |</p> 
                    <hr>

                    </nav>
                    
                    <button style="margin-left: 4%; font-family: Verdana; font-size: 17px; " type="button" class="btn btn-warning btn-lg" onclick="location.href='${pageContext.request.contextPath}/vistas/vHistorialCitas.jsp'">
                        Consultar Historial de Citas
                    </button>
                    <button style="margin-left: 1%; font-family: Verdana; font-size: 17px; " type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#miModal">
                        Ingresar Nueva Cita
                    </button>
                
                    <br><br>
                    <h1 style="margin-left: 75px">Citas del día de Hoy</h1>
                    <hr>
                    
        <%
            DAO.DAOcitas dao = new DAO.DAOcitas();
            citas cits = new citas(); 
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
                        <td><%= c.getIdUsuario().getNombreUsuario() %></td>
                        
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
                        
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>        

        <%
                }else{
        %>
        
                    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

                    <hr>
                    <p style="color:white; font-size: 20px;"> Bienvenido <%=useruser%> (Tipo de Usuario: <%=tipouser%>) | <a style="color:white;" href="login/index_login.jsp?cerrar=true">Cerrar Sesión</a> |</p> 
                    <hr>

                    </nav>
                
                    <br><br>
                    <h3 style="margin-left: 75px">Estas en Formulario Teléfonos</h3>
                    <hr>

                    <lable>
                        <li style="margin-left: 75px">
                            <a href="${pageContext.request.contextPath}/vistas/vEmpleados.jsp">Soporte Tabla Empleados</a>
                        </li>
                        <li style="margin-left: 75px">
                            <a href="${pageContext.request.contextPath}/vistas/vDepartamentos.jsp">Soporte Tabla Departamentos</a>
                        </li>
                        <li style="margin-left: 75px">
                            <a href="${pageContext.request.contextPath}/vistas/vTelefonos.jsp">Soporte Tabla Teléfonos</a>
                        </li>
                    </lable>
        <%
                }
            }
            response.setHeader("Pragma","no-cache");
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
            response.setDateHeader ("Expires", 0);
        %>
        </div>
    </body>
</html>
