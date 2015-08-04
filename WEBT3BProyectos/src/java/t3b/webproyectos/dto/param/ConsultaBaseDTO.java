/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3b.webproyectos.dto.param;

/**
 *
 * @author daniel
 */
public class ConsultaBaseDTO {
    private String usuario = "";
    private String contrasena = "";
    private String ipDescarga = "";
    private int idApp = 0;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getIpDescarga() {
        return ipDescarga;
    }

    public void setIpDescarga(String ipDescarga) {
        this.ipDescarga = ipDescarga;
    }

    public int getIdApp() {
        return idApp;
    }

    public void setIdApp(int idApp) {
        this.idApp = idApp;
    }

    @Override
    public String toString() {
        return "ConsultaBaseDTO{" + "usuario=" + usuario + ", contrasena=" + contrasena + ", ipDescarga=" + ipDescarga + ", idApp=" + idApp + '}';
    }

    
}
