<%-- 
    Document   : index
    Created on : 16/07/2015, 12:03:00 PM
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="listaApps">
    <head>
        <title>T3B Descarga de Proyectos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="css/dashboard.css" rel="stylesheet" type="text/css" />
        <link href="css/ng-table.min.css" rel="stylesheet" type="text/css" />
        <script src="js/jquery.min.js"></script>
        <script src="css/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/angular.min.js"></script>
        <script type="text/javascript" src="js/aplicaciones.js"></script>
        <script type="text/javascript" src="js/ng-table.min.js"></script>
        <script src="js/funciones.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed"></button>
                    <a class="navbar-brand" href="#">T3B Proyectos</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse" >
                    <ul class="nav navbar-nav navbar-right">
                        <li id="navPrin"><a href="menuPrincipal.jsp" onclick="">Principal</a></li>
                        <li id="navAcerca"><a href="index.jsp" onclick="">Salir</a></li>                        
                    </ul>
                    <form class="navbar-form navbar-right">
                        <input type="text" ng-model="search" class="form-control" placeholder="Buscar..." />
                    </form>
                </div>
            </div>
        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar">
                        <li id="optApp"><a href="#" class="divLink active" onclick="muestraDivMenuPrin('contenido', 'divapps')" >Aplicaciones</a></li>
                        <li id="optDesc"><a href="#" ref="" class="divLink" onclick="muestraDivMenuPrin('contenido', 'divlogs')" >Log de Descargas</a></li>
                        <li id="optResp"><a href="#" ref="" class="divLink" onclick="muestraDivMenuPrin('contenido', 'divresps')">Responsables</a></li>
                        <li id="optUsr"><a href="#" ref="" class="divLink" >Usuarios</a></li>
                    </ul>
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <div id="contenido" class="container-fluid" >
                        <div id="divapps" ng-include="'pages/Apps.jsp'"></div>
                        <div id="divlogs" ng-include="'pages/LogDescargas.jsp'" style="visibility: hidden" >Log de paginas</div>
                        <div id="divresps" ng-include="'pages/Responsables.jsp'" style="visibility: hidden"></div>
                        
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
