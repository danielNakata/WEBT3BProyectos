<%-- 
    Document   : Apps
    Created on : 24/07/2015, 02:05:24 PM
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String ipDescarga = request.getRemoteAddr();
    String usr = session.getAttribute("usuarioLog").toString();
%>
<div ng-controller="listaAppsController">
    <section class="tab" ng-controller="ControlTab as tabs">
        <ul class="nav nav-pills" >
            <li ng-repeat="dato in apps.datos" ng-class="{active: tabs.isSetTab(dato.idApp)}" >
                <a href ng-click="tabs.setTab(dato.idApp)" >{{dato.nombre}}</a>
            </li>
        </ul>
        <div ng-show="tabs.isSetTab(dato.idApp)" ng-repeat="dato in apps.datos">
            <h1>{{dato.nombre}}</h1>
            <h3>{{dato.descripcion}}</h3>
            <h3>Responsable: {{dato.responsable}}</h3>
            <h3>Formato Descarga: {{dato.formatoDescarga}}</h3>
            <h2>Version: {{dato.version}}</h2>
            <h3><button class="btn btn-primary" href ng-click="realizaDescargaApp(dato.idApp, '<%=usr%>', '<%= ipDescarga%>', dato.rutaDescarga)">Descargar</button></h3>
        </div>
    </section>
</div>
