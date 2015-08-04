/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3b.webproyectos.dto.out;

/**
 *
 * @author daniel
 */
public class LogDescargaDTO {
    public int idapp = 0;
    public String login = "";
    public String fechadescarga = "";
    public String ipdescarga = "";
    public String nombre = "";
    public String descripcion = "";
    public int idresponsable = 0;
    public String version = "";
    public String nombreResponsable = "";
    public String apellidosResponsable = "";
    public String usuarioNombre = "";
    public String usuarioApellidos = "";

    public int getIdapp() {
        return idapp;
    }

    public void setIdapp(int idapp) {
        this.idapp = idapp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFechadescarga() {
        return fechadescarga;
    }

    public void setFechadescarga(String fechadescarga) {
        this.fechadescarga = fechadescarga;
    }

    public String getIpdescarga() {
        return ipdescarga;
    }

    public void setIpdescarga(String ipdescarga) {
        this.ipdescarga = ipdescarga;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdresponsable() {
        return idresponsable;
    }

    public void setIdresponsable(int idresponsable) {
        this.idresponsable = idresponsable;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public String getApellidosResponsable() {
        return apellidosResponsable;
    }

    public void setApellidosResponsable(String apellidosResponsable) {
        this.apellidosResponsable = apellidosResponsable;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioApellidos() {
        return usuarioApellidos;
    }

    public void setUsuarioApellidos(String usuarioApellidos) {
        this.usuarioApellidos = usuarioApellidos;
    }

    @Override
    public String toString() {
        return "LogDescargaDTO{" + "idapp=" + idapp + ", login=" + login + ", fechadescarga=" + fechadescarga + ", ipdescarga=" + ipdescarga + ", nombre=" + nombre + ", descripcion=" + descripcion + ", idresponsable=" + idresponsable + ", version=" + version + ", nombreResponsable=" + nombreResponsable + ", apellidosResponsable=" + apellidosResponsable + ", usuarioNombre=" + usuarioNombre + ", usuarioApellidos=" + usuarioApellidos + '}';
    }
    
    
}
