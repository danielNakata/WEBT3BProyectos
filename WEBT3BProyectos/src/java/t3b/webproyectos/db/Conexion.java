/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3b.webproyectos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import t3b.webproyectos.utils.Config;

/**
 *
 * @author daniel
 */
public class Conexion {
    
    private Connection conex = null;
    
    public Conexion(){
        try{
            Class.forName(Config.dbdriver);
            this.conex = DriverManager.getConnection(Config.dburl+Config.dbhost+":"+Config.dbport+"/"+Config.dbbase
                    , Config.dbuser, Config.dbpass);
            System.out.println("Conectado");
        }catch(Exception ex){
            System.out.println(this.getClass().toString() + " Constructor EX: " + ex.toString());
            conex = null;
        }
    }

    public Connection getConex() {
        return conex;
    }

    public void setConex(Connection conex) {
        this.conex = conex;
    }
    
    
}
