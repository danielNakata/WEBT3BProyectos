/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3b.webproyectos.actions;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import t3b.webproyectos.db.imp.ConsultasDAO;
import t3b.webproyectos.dto.RespGralDTO;
import t3b.webproyectos.dto.param.ConsultaBaseDTO;

/**
 *
 * @author daniel
 */
public class registraDescarga extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int idApp = 0;
        String slogin = "";
        String ipdescarga = "";
        String salidaJSON = "";
        try {
            try{
                idApp = Integer.parseInt(request.getParameter("idApp"));
            }catch(Exception ex){
                idApp = 0;
            }
            slogin = request.getParameter("slogin").equals("")?"-":request.getParameter("slogin");
            ipdescarga = request.getParameter("ipdescarga").equals("")?"-":request.getParameter("ipdescarga");
            
            ConsultaBaseDTO param = new ConsultaBaseDTO();
            param.setIdApp(idApp);
            param.setUsuario(slogin);
            param.setIpDescarga(ipdescarga);
            
            RespGralDTO resp = new ConsultasDAO().registraDescarga(param);
            
            salidaJSON = "{\"res\":\""+resp.getRes()+"\", \"msg\":\""+resp.getMsg()+"\"}";
        }catch(Exception ex){
            salidaJSON = "{\"res\":\"0\", \"msg\":\""+ex.toString().replaceAll("\"", "").replaceAll(",", " ")+"\"}";
        } finally {
            out.println(salidaJSON);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
