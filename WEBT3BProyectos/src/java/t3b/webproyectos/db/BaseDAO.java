/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3b.webproyectos.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import t3b.webproyectos.dto.CampoDTO;

/**
 *
 * @author daniel
 */
public class BaseDAO {
    
    /**
     * Metodo para obtener la lista de campos devueltos por la consulta
     * @param rsmd
     * @return 
     */
    public ArrayList<CampoDTO> getListaCampos(ResultSetMetaData rsmd){
        ArrayList<CampoDTO> lista = new ArrayList();
        try{
            if(rsmd != null){                
                for(int i = 1; i <= rsmd.getColumnCount(); i++){
                    CampoDTO campo = new CampoDTO();
                    System.out.println(
                            rsmd.getColumnName(i)+"\n"+
                                    rsmd.getColumnLabel(i)+"\n"+
                                    rsmd.getColumnTypeName(i)+"\n"+
                                    rsmd.getColumnType(i)+"\n"+
                                    rsmd.getSchemaName(i)+"\n"+
                                    rsmd.getTableName(i)+"\n"
                    );
                    campo.setNombre(rsmd.getColumnName(i));
                    campo.setEtiqueta(rsmd.getColumnLabel(i));
                    campo.setTipo(rsmd.getColumnTypeName(i));
                    campo.setIdTipo(rsmd.getColumnType(i));
                    campo.setBase(rsmd.getSchemaName(i));
                    campo.setTable(rsmd.getTableName(i));
                    lista.add(campo);
                }
                
            }
        }catch(Exception ex){
            lista = null;
        }
        return lista;
    }
    
    /**
     * Metodo para cerrar las conexiones
     * @param con
     * @param st
     * @param rs 
     */
    public void cerrar(Connection con, CallableStatement st, ResultSet rs){
        try{
            if(rs != null)
                rs.close();
            if(st != null)
                st.close();
            if(con != null)
                con.close();
        }catch(Exception ex){
            
        }
    }
}
