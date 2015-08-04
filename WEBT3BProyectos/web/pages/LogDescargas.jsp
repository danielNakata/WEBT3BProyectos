<%-- 
    Document   : LogDescargas
    Created on : 3/08/2015, 05:47:12 PM
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div ng-controller="listaLogDescargasController">
    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID App</th>
                <th>Fecha Descarga</th>
                <th>IP Descarga</th>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Version</th>
                <th>ID Responsable</th>
                <th>Responsable</th>
                <th>Usuario</th>
                <th>Usuario Descarga</th>
            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="dato in resps.datos">
                <td style="text-align: center">{{dato.idapp}}</td>
                <td>{{dato.fechadescarga}}</td>
                <td style="text-align: center">{{dato.ipdescarga}}</td>
                <td>{{dato.nombre}}</td>
                <td>{{dato.descripcion}}</td>
                <td style="text-align: center">{{dato.version}}</td>
                <td style="text-align: center">{{dato.idresponsable}}</td>
                <td>{{dato.nombreResponsable}} {{dato.apellidosResponsable}}</td>
                <td style="text-align: center">{{dato.login}}</td>
                <td>{{dato.usuarioNombre}} {{dato.usuarioApellidos}}</td>
            </tr>
        </tbody>
        <tfoot>
            
        </tfoot>
    </table>
</div>
