<%-- 
    Document   : Responsables
    Created on : 3/08/2015, 02:49:29 PM
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div ng-controller="listaResponsablesController">
    <table class="table table-hover">
        <tr>
            <th>ID Responsable</th>
            <th>Nombre</th>
            <th>Apellidos</th>
        </tr>
        <tr ng-repeat="dato in resps.datos">
            <td>
                {{dato.idResponsable}}
            </td>
            <td>
                {{dato.nombre}}
            </td>
            <td>
                {{dato.apellidos}}
            </td>
        </tr>
    </table>
</div>
