<%-- 
    Document   : index_login
    Created on : Nov 13, 2020, 9:16:32 PM
    Author     : andie
--%>

<%@page import="Clases.usuarios"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MI CONSULTORIO</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous"></link>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"></link>
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body class="bg-dark">
        
        <nav style="background-color:#0090b8 " class="navbar navbar-expand navbar-light static-top">
        
        <hr>
        <p style="color:white; font-weight: bold; font-size: 20px;"> BIENVENIDOS A SU CONSULTORIO</p> 
        <hr>
            
        </nav>
        
        <div class="container" style="width: 400px; position: relative; margin-left: 40%">
            <div class="card card-login mx-auto mt-5">
              <div class="card-header">Login</div>
              <div class="card-body">
                <form method="POST" action="${pageContext.request.contextPath}/ctrlLogin" style="width: 100%" id="myForm" class="form-group">
                  <div class="form-group">
                    <div class="form-label-group">
                      <input type="text" id="inputEmail" name="txtusuario" class="form-control" placeholder="Usuario" required="required" autofocus="autofocus">
                      <label for="Usuario">Usuario</label>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="form-label-group">
                      <input type="password" id="inputPassword" name="txtcontra" class="form-control" placeholder="Contraseña" required="required">
                      <label for="Contra">Contraseña</label>
                    </div>
                  </div>
                  <input type="submit" name="btningresar" value="Acceder" class="btn btn-primary"/>
                </form>
              </div>
            </div>
        </div>
                  
        <%
            //declarar variable de sesión
            HttpSession ses = request.getSession(); 

            //si el servlet me manda el error
            if(request.getAttribute("error")!=null)
                //para redirigir por medio de javascript window.location= 'login/index.jsp'
            {
                out.print("<script>alert('Error con el usuario, intente nuevamente');window.location= 'login/index_login.jsp';</script>");
            }
            //si el servlet me manda login
            if(request.getAttribute("login")!=null)
            {
                List<usuarios> data = (List<usuarios>)request.getAttribute("login");
                String uss = data.get(0).getNombreUsuario(); 
                String tipo = data.get(0).getTipoUsuario();
                
                ses.setAttribute("usuario", uss);
                ses.setAttribute("tipousuario", tipo);
                
                response.sendRedirect("index.jsp");
            }
            
            if(request.getParameter("cerrar")!=null)
            {
                ses.invalidate();
                response.sendRedirect("index_login.jsp");     
            }
            
        %>  
    </body>
</html>
