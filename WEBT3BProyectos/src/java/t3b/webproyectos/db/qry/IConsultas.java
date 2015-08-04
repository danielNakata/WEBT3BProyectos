/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3b.webproyectos.db.qry;

import t3b.webproyectos.utils.Config;

/**
 *
 * @author daniel
 */
public interface IConsultas {
    
    
    public static String spInicioSesion = "{ call "+Config.dbbase+".SP_INICIO_SESION(?,?,?,?) }";
    
    public static String spConsultaAplicaciones = "{ call "+Config.dbbase+".SP_CONSULTA_APLICACIONES() }";
    
    public static String spConsultaResponsables = "{call "+Config.dbbase+".SP_CONSULTA_RESPONSABLES() }";
    
    public static String spRegistraDescarga = "{ call "+Config.dbbase+".SP_REGISTRA_DESCARGA(?,?,?,?,?)}";
    
    public static String spConsultaDescargas = "{call "+Config.dbbase+".SP_CONSULTA_DESCARGAS() }";
    
}
