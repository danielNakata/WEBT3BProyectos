<%-- 
    Document   : consultaLogDescargas
    Created on : 3/08/2015, 05:46:31 PM
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="t3b.webproyectos.dto.*" %>
<%@page import="t3b.webproyectos.dto.out.*" %>
<%@page import="t3b.webproyectos.db.imp.ConsultasDAO" %>
<%
    RespGralDTO resp = new ConsultasDAO().consultaDescargas();
    String salidaJSON = "{\"res\":\""+resp.getRes()+"\", \"msg\":\""+resp.getMsg()+"\"}";
    String listaDatos = "";
    if(resp.getRes() == 1){
        salidaJSON = "{\"res\":\""+resp.getRes()+"\", \"msg\":\""+resp.getMsg()+"\", \"numReg\":\""+resp.getNumReg()+"\" ";
        for(LogDescargaDTO dto: resp.getListaLogDescargaDTO()){
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
