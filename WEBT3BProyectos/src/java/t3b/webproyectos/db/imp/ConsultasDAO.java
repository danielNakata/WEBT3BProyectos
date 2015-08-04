/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3b.webproyectos.db.imp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import t3b.webproyectos.db.BaseDAO;
import t3b.webproyectos.db.Conexion;
import t3b.webproyectos.db.qry.IConsultas;
import t3b.webproyectos.dto.CampoDTO;
import t3b.webproyectos.dto.RespGralDTO;
import t3b.webproyectos.dto.out.AplicacionDTO;
import t3b.webproyectos.dto.out.LogDescargaDTO;
import t3b.webproyectos.dto.out.ResponsableDTO;
import t3b.webproyectos.dto.param.ConsultaBaseDTO;

/**
 *
 * @author daniel
 */
public class ConsultasDAO extends BaseDAO implements IConsultas{
    
    private Conexion conex = null;
    
    /**
     * Metodo para iniciar la sesion 
     * @param param
     * @return 
     */
    public RespGralDTO inicioSesion(ConsultaBaseDTO param){
        RespGralDTO resp = new RespGralDTO();
        Connection con = null;
        CallableStatement st = null;
        ResultSet rs = null;
        String sql = "";
        int paramIn = 1, paramOut = 1;
        try{
            conex = new Conexion();
            con = conex.getConex();
            resp.setMsg("NO SE PUDO REALIZAR LA CONEXION A LA BASE DE DATOS");
            if(con != null){
                st = con.prepareCall(spInicioSesion);
                st.setString(paramIn++, param.getUsuario());
                st.setString(paramIn++, param.getContrasena());
                paramOut = paramIn;
                st.registerOutParameter(paramIn++, java.sql.Types.INTEGER);
                st.registerOutParameter(paramIn++, java.sql.Types.VARCHAR);
                
                st.execute();
                
                resp.setRes(st.getInt(paramOut++));
                resp.setMsg(st.getString(paramOut++));
            }
        }catch(Exception ex){
            resp.setRes(0);
            resp.setMsg("EXCEPCION: "+ex.getMessage());
        }finally{
            cerrar(con, st, rs);
        }
        return resp;
    }
    
    /**
     * Metodo para registrar la descarga de la aplicacion
     * @param param
     * @return 
     */
    public RespGralDTO registraDescarga(ConsultaBaseDTO param){
        RespGralDTO resp = new RespGralDTO();
        Connection con = null;
        CallableStatement st = null;
        ResultSet rs = null;
        String sql = "";
        int paramIn = 1, paramOut = 1;
        try{
            conex = new Conexion();
            con = conex.getConex();
            resp.setMsg("NO SE PUDO REALIZAR LA CONEXION A LA BASE DE DATOS");
            if(con != null){
                st = con.prepareCall(spRegistraDescarga);
                st.setInt(paramIn++, param.getIdApp());
                st.setString(paramIn++, param.getUsuario());
                st.setString(paramIn++, param.getIpDescarga());
                paramOut = paramIn;
                st.registerOutParameter(paramIn++, java.sql.Types.INTEGER);
                st.registerOutParameter(paramIn++, java.sql.Types.VARCHAR);
                
                st.execute();
                
                resp.setRes(st.getInt(paramOut++));
                resp.setMsg(st.getString(paramOut++));
            }
        }catch(Exception ex){
            resp.setRes(0);
            resp.setMsg("EXCEPCION: "+ex.getMessage());
        }finally{
            cerrar(con, st, rs);
        }
        return resp;
    }
    
    
    /**
     * Metodo para realizar la consulta de las aplicaciones 
     * @return 
     */
    public RespGralDTO consultaAplicaciones(){
        RespGralDTO resp = new RespGralDTO();
        Connection con = null;
        CallableStatement st = null;
        ResultSet rs = null;
        String sql = "";
        int paramIn = 1, paramOut = 1;
        ArrayList<CampoDTO> listaCampos = new ArrayList();
        ArrayList<AplicacionDTO> lista = new ArrayList();
        try{
            conex = new Conexion();
            con = conex.getConex();
            resp.setMsg("NO SE PUDO REALIZAR LA CONEXION A LA BASE DE DATOS");
            if(con != null){
                st = con.prepareCall(spConsultaAplicaciones);
                resp.setMsg("NO SE PUDO REALIZAR LA CONSULTA");
                rs = st.executeQuery();
                if(rs != null){
                    resp.setMsg("NO SE PUDO OBTENER LA LISTA DE CAMPOS");
                    listaCampos = getListaCampos(rs.getMetaData());
                    if(listaCampos != null){
                        int numReg = 0;
                        while(rs.next()){
                            AplicacionDTO fila = new AplicacionDTO();
                            for(CampoDTO campo: listaCampos){
                                switch(campo.getIdTipo()){
                                    case java.sql.Types.INTEGER:
                                        fila.getClass().getField(campo.getEtiqueta()).set(fila, rs.getObject(campo.getEtiqueta())!=null?rs.getInt(campo.getEtiqueta()):0);
                                        break;
                                        
                                    case java.sql.Types.BIGINT:
                                        fila.getClass().getField(campo.getEtiqueta()).set(fila, rs.getObject(campo.getEtiqueta())!=null?rs.getInt(campo.getEtiqueta()):0);
                                        break;
                                        
                                    case java.sql.Types.DOUBLE:
                                        fila.getClass().getField(campo.getEtiqueta()).set(fila, rs.getObject(campo.getEtiqueta())!=null?rs.getDouble(campo.getEtiqueta()):0);
                                        break;
                                        
                                    case java.sql.Types.VARCHAR:
                                        fila.getClass().getField(campo.getEtiqueta()).set(fila, rs.getObject(campo.getEtiqueta())!=null?rs.getString(campo.getEtiqueta()):"");
                                        break;
                                        
                                    default:
                                        fila.getClass().getField(campo.getEtiqueta()).set(fila, rs.getObject(campo.getEtiqueta())!=null?rs.getObject(campo.getEtiqueta()).toString():"");
                                        break;
                                }
                            }
                            lista.add(fila);
                            numReg++;
                        }
                        
                        resp.setMsg("NO SE OBTUVERON DATOS DE LA CONSULTA");
                        if(numReg>0){
                            resp.setRes(1);
                            resp.setMsg("DATOS OBTENIDOS");
                            resp.setNumReg(numReg);
                            resp.setListaCampoDTO(listaCampos);
                            resp.setListaAplicacionDTO(lista);
                        }
                    }
                }
                
            }
        }catch(Exception ex){
            resp.setRes(0);
            resp.setMsg("EXCEPCION: "+ex.getMessage());
        }finally{
            cerrar(con, st, rs);
        }
        System.out.println(resp.toString());
        return resp;
    }
    
    /**
     * Metodo para consultar a los responsables 
     * @return 
     */
    public RespGralDTO consultaResponsables(){
        RespGralDTO resp = new RespGralDTO();
        Connection con = null;
        CallableStatement st = null;
        ResultSet rs = null;
        String sql = "";
        int paramIn = 1, paramOut = 1;
        ArrayList<CampoDTO> listaCampos = new ArrayList();
        ArrayList<ResponsableDTO> lista = new ArrayList();
        try{
            conex = new Conexion();
            con = conex.getConex();
            resp.setMsg("NO SE PUDO REALIZAR LA CONEXION A LA BASE DE DATOS");
            if(con != null){
                st = con.prepareCall(spConsultaResponsables);
                resp.setMsg("NO SE PUDO REALIZAR LA CONSULTA");
                rs = st.executeQuery();
                if(rs != null){
                    resp.setMsg("NO SE PUDO OBTENER LA LISTA DE CAMPOS");
                    listaCampos = getListaCampos(rs.getMetaData());
                    if(listaCampos != null){
                        int numReg = 0;
                        while(rs.next()){
                            ResponsableDTO fila = new ResponsableDTO();
                            for(CampoDTO campo: listaCampos){
                                switch(campo.getIdTipo()){
                                    case java.sql.Types.INTEGER:
                                        fila.getClass().getField(campo.getEtiqueta()).set(fila, rs.getObject(campo.getEtiqueta())!=null?rs.getInt(campo.getEtiqueta()):0);
                                        break;
                                        
                                    case java.sql.Types.BIGINT:
                                        fila.getClass().getField(campo.getEtiqueta()).set(fila, rs.getObject(campo.getEtiqueta())!=null?rs.getInt(campo.getEtiqueta()):0);
                                        break;
                                        
                                    case java.sql.Types.DOUBLE:
                                        fila.getClass().getField(campo.getEtiqueta()).set(fila, rs.getObject(campo.getEtiqueta())!=null?rs.getDouble(campo.getEtiqueta()):0);
                                        break;
                                        
                                    case java.sql.Types.VARCHAR:
                                        fila.getClass().getField(campo.getEtiqueta()).set(fila, rs.getObject(campo.getEtiqueta())!=null?rs.getString(campo.getEtiqueta()):"");
                                        break;
                                        
                                    default:
                                        fila.getClass().getField(campo.getEtiqueta()).set(fila, rs.getObject(campo.getEtiqueta())!=null?rs.getObject(campo.getEtiqueta()).toString():"");
                                        break;
                                }
                            }
                            lista.add(fila);
                            numReg++;
                        }
                        
                        resp.setMsg("NO SE OBTUVERON DATOS DE LA CONSULTA");
                        if(numReg>0){
                            resp.setRes(1);
                            resp.setMsg("DATOS OBTENIDOS");
                            resp.setNumReg(numReg);
                            resp.setListaCampoDTO(listaCampos);
                            resp.setListaResponsableDTO(lista);
                        }
                    }
                }
            }
        }catch(Exception ex){
            resp.setRes(0);
            resp.setMsg("EXCEPCION: "+ex.getMessage());
        }finally{
            cerrar(con, st, rs);
        }
        System.out.println(resp.toString());
        return resp;
    }
    
    /**
     * Metodo para la consulta de las descargas realizadas
     * @return 
     */
    public RespGralDTO consultaDescargas(){
        RespGralDTO resp = new RespGralDTO();
        Connection con = null;
        CallableStatement st = null;
        ResultSet rs = null;
        String sql = "";
        int paramIn = 1, paramOut = 1;
        ArrayList<CampoDTO> listaCampos = new ArrayList();
        ArrayList<LogDescargaDTO> lista = new ArrayList();
        try{
            conex = new Conexion();
            con = conex.getConex();
            resp.setMsg("NO SE PUDO REALIZAR LA CONEXION A LA BASE DE DATOS");
            if(con != null){
                st = con.prepareCall(spConsultaDescargas);
                resp.setMsg("NO SE PUDO REALIZAR LA CONSULTA");
                rs = st.executeQuery();
                if(rs != null){
                    resp.setMsg("NO SE PUDO OBTENER LA LISTA DE CAMPOS");
                    listaCampos = getListaCampos(rs.getMetaData());
                    if(listaCampos != null){
                        int numReg = 0;
                        while(rs.next()){
                            LogDescargaDTO fila = new LogDescargaDTO();
                            for(CampoDTO campo: listaCampos){
                                switch(campo.getIdTipo()){
                                    case java.sql.Types.INTEGER:
                                        fila.getClass().getField(campo.getEtiqueta()).set(fila, rs.getObject(campo.getEtiqueta())!=null?rs.getInt(campo.getEtiqueta()):0);
                                        break;
                                        
                                    case java.sql.Types.BIGINT:
                                        fila.getClass().getField(campo.getEtiqueta()).set(fila, rs.getObject(campo.getEtiqueta())!=null?rs.getInt(campo.getEtiqueta()):0);
                                        break;
                                        
                                    case java.sql.Types.DOUBLE:
                                        fila.getClass().getField(campo.getEtiqueta()).set(fila, rs.getObject(campo.getEtiqueta())!=null?rs.getDouble(campo.getEtiqueta()):0);
                                        break;
                                        
                                    case java.sql.Types.VARCHAR:
                                        fila.getClass().getField(campo.getEtiqueta()).set(fila, rs.getObject(campo.getEtiqueta())!=null?rs.getString(campo.getEtiqueta()):"");
                                        break;
                                        
                                    default:
                                        fila.getClass().getField(campo.getEtiqueta()).set(fila, rs.getObject(campo.getEtiqueta())!=null?rs.getObject(campo.getEtiqueta()).toString():"");
                                        break;
                                }
                            }
                            lista.add(fila);
                            numReg++;
                        }
                        
                        resp.setMsg("NO SE OBTUVERON DATOS DE LA CONSULTA");
                        if(numReg>0){
                            resp.setRes(1);
                            resp.setMsg("DATOS OBTENIDOS");
                            resp.setNumReg(numReg);
                            resp.setListaCampoDTO(listaCampos);
                            resp.setListaLogDescargaDTO(lista);
                        }
                    }
                }
                
            }
        }catch(Exception ex){
            resp.setRes(0);
            resp.setMsg("EXCEPCION: "+ex.getMessage());
        }finally{
            cerrar(con, st, rs);
        }
        System.out.println(resp.toString());
        return resp;
    }
    
}
