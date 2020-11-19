<%-- 
    Document   : vExpediente
    Created on : Nov 18, 2020, 6:22:47 PM
    Author     : andie
--%>

<%@page import="Clases.pacientes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DAO.DAOpacientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expediente</title>
        <link rel="stylesheet" type="text/css" href="../mycss.css"> 
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
            function cargarMO(id,nom,ape,fenac,telpac,email,dir,cont,telcont)
            {
                document.modalito.txtidPac.value=id; 
                document.modalito.txtnomPac.value=nom;
                document.modalito.txtapePac.value=ape;
                document.modalito.txtfechaNac.value=fenac;
                document.modalito.txttelPac.value=telpac;
                document.modalito.txtemail.value=email;
                document.modalito.txtdirPac.value=dir;
                document.modalito.txtnomEme.value=cont;
                document.modalito.txttelEme.value=telcont;
                
                document.modalito.opcion.value='modificar';
                document.modalito.btnGuardar.value='Modificar';
                document.modalito.btnGuardar.className='btn btn-success';
                
            }
            
            function cargarDel(id,nom,ape,fenac,telpac,email,dir,cont,telcont)
            {
                document.modalito.txtidPac.value=id; 
                document.modalito.txtnomPac.value=nom;
                document.modalito.txtapePac.value=ape;
                document.modalito.txtfechaNac.value=fenac;
                document.modalito.txttelPac.value=telpac;
                document.modalito.txtemail.value=email;
                document.modalito.txtdirPac.value=dir;
                document.modalito.txtnomEme.value=cont;
                document.modalito.txttelEme.value=telcont;;
                
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
                    
        %>
        
                    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

                    <hr>
                    <p style="background-color:#0090b8; color:white; font-size: 20px;"> Bienvenido <%=useruser%> (Tipo de Usuario: <%=tipouser%>) | <a style="color:white;" href="../index.jsp">Home</a> | | <a style="color:white;" href="../login/index_login.jsp?cerrar=true">Cerrar Sesión</a> |</p> 
                    <hr>

                    </nav>        
        
        <%
            }
            response.setHeader("Pragma","no-cache");
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
            response.setDateHeader ("Expires", 0);

        %>
        
            <button style="margin-left: 4%; font-family: Verdana; font-size: 17px; " type="button" class="btn btn-warning btn-lg" data-toggle="modal" data-target="#miModal">
                Crear Nuevo Expediente
            </button>
        
            <h1 style="margin-left: 75px">Información Pacientes</h1>
            <hr>            
        <%
            DAOpacientes dao = new DAOpacientes();
            List<pacientes> data = new ArrayList<>();
            data = dao.consultar();
        %>
        
            <div style="width: 1500px; position: relative; margin-left: 4%;">
        
            <table border="1" class="table table-dark">
                <thead class="thead-dark" style="font-size: 18px; font-weight: 900;">
                    <tr>
                        <th>ID PACIENTE</th>
                        <th>NOMBRES PACIENTE</th>
                        <th>APELLIDOS PACIENTE</th>
                        <th>FECHA NACIMIENTO</th>
                        <th>TELEFONO</th>
                        <th>EMAIL</th>
                        <th>DIRECCION</th>
                        <th>CONTACTO DE EMERGENCIA</th>
                        <th>TELEFONO DE CONTACTO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody style="font-size: 16px; font-weight: 700; ">        
        <%
            for(pacientes p : data)
            {                                      
        %>
                    <tr>
                        <td><%= p.getIdPaciente()%></td>
                        <td><%= p.getNombresPaciente()%></td>
                        <td><%= p.getApellidosPaciente() %></td>
                        <td><%= p.getFechaNacPaciente()%></td>
                        <td><%= p.getTelPaciente()%></td>
                        <td><%= p.getEmailPaciente()%></td>
                        <td><%= p.getDireccionPaciente()%></td>
                        <td><%= p.getNombreemergPaciente()%></td>
                        <td><%= p.getTelemergPaciente()%></td>
                        <td>
                            <a href="javascript:cargarMO('<%= p.getIdPaciente()%>','<%= p.getNombresPaciente()%>','<%= p.getApellidosPaciente() %>','<%= p.getFechaNacPaciente()%>','<%= p.getTelPaciente()%>','<%= p.getEmailPaciente()%>','<%= p.getDireccionPaciente()%>','<%= p.getNombreemergPaciente()%>','<%= p.getTelemergPaciente()%>');">
                                <img src="${pageContext.request.contextPath}/recursos/editar.jpg" data-toggle="modal" data-target="#miModal">
                            </a>
                            <a href="javascript:cargarDel('<%= p.getIdPaciente()%>','<%= p.getNombresPaciente()%>','<%= p.getApellidosPaciente() %>','<%= p.getFechaNacPaciente()%>','<%= p.getTelPaciente()%>','<%= p.getEmailPaciente()%>','<%= p.getDireccionPaciente()%>','<%= p.getNombreemergPaciente()%>','<%= p.getTelemergPaciente()%>');">
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

        <div class="modal fade" id="miModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">Formulario de Registro</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <form action="${pageContext.request.contextPath}/ctrlExpediente" method="POST" name="modalito">
                                <input type="text" name="txtidPac" placeholder="idPaciente" readonly="readonly" class="form-control" /><br>
                                <input type="text" name="txtnomPac" placeholder="Juan Jose" class="form-control" /><br>
                                <input type="text" name="txtapePac" placeholder="Cordero Mejía" class="form-control" /><br>
                                <input type="text" name="txtfechaNac" placeholder="Fecha Nac: AAAA-MM-DD" class="form-control" /><br>
                                <input type="text" name="txttelPac" placeholder="Tel: (503)2222-2222" class="form-control" /><br>
                                <input type="text" name="txtemail" placeholder="email: pedro@email.com" class="form-control" /><br>
                                <input type="text" name="txtdirPac" placeholder="Dirección" class="form-control" /><br>
                                <input type="text" name="txtnomEme" placeholder="Contacto Emergencia" class="form-control" /><br>
                                <input type="text" name="txttelEme" placeholder="Tel Emergencia: (503)2222-2222" class="form-control" /><br>
                                <input type="submit" name="btnGuardar" class="btn btn-primary" value="Guardar"/><br>
                                <input type="hidden" value="nuevo" name="opcion" /><br>
                             </form>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
</html>
