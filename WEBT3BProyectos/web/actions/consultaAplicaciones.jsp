<%-- 
    Document   : consultaAplicaciones
    Created on : 24/07/2015, 02:31:35 PM
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="t3b.webproyectos.dto.*" %>
<%@page import="t3b.webproyectos.dto.out.*" %>
<%@page import="t3b.webproyectos.db.imp.ConsultasDAO" %>
<%
    RespGralDTO resp = new ConsultasDAO().consultaAplicaciones();
    String salidaJSON = "{\"res\":\""+resp.getRes()+"\", \"msg\":\""+resp.getMsg()+"\"}";
    String listaDatos = "";
    if(resp.getRes() == 1){
        salidaJSON = "{\"res\":\""+resp.getRes()+"\", \"msg\":\""+resp.getMsg()+"\", \"numReg\":\""+resp.getNumReg()+"\" ";
        for(AplicacionDTO dto: resp.getListaAplicacionDTO()){
            listaDatos += "{";
            for(CampoDTO campo: resp.getListaCampoDTO()){
                listaDatos += "\""+campo.getEtiqueta()+"\":\""+dto.getClass().getField(campo.getEtiqueta()).get(dto) +"\", ";
            }
            listaDatos = listaDatos.substring(0, listaDatos.lastIndexOf(","));
            listaDatos += "},";
        }
        listaDatos = listaDatos.substring(0, listaDatos.lastIndexOf(","));
    }
    
    salidaJSON += ", \"datos\":["+listaDatos+"] }";
    out.println(salidaJSON);
%>