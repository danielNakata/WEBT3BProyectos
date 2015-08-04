<%--
    Document   : index
    Created on : 16/07/2015, 12:04:22 PM
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%
    String msgError = "";
    
    msgError = request.getParameter("msgError") == null?"":request.getParameter("msgError");
    session.setAttribute("usuarioLog", null);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>T3B Descarga de Aplicaciones</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="css/signin.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed"></button>
                    <a class="navbar-brand" href="#">T3B Proyectos</a>
                </div>
            </div>
        </nav>
        <div class="container">
            <form class="form-signin" action="InicioSesion">
                <h2 class="form-signin-heading">Inicio de Sesión</h2>
                <label for="txtLogin" class="sr-only">Usuario</label>
                <input type="text" name="txtLogin" id="txtLogin" class="form-control" placeholder="Usuario" required autofocus />
                <label for="txtPassword" class="sr-only">Contrasena</label>
                <input type="password" name="txtPassword" id="txtPassword" class="form-control" placeholder="Contraseña" required="" />
                <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
            </form>
            <% if(!msgError.equals("")){ %>
            <div class="alert alert-danger fade in">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Error!</strong> <%=msgError %>
            </div>
            <%}%>
        </div>
        
        <script src="js/jquery.min.js"></script>
        <script src="css/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
