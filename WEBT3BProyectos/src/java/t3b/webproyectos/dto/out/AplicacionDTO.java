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
public class AplicacionDTO {
    public int idApp = 0;
    public String nombre = "";
    public String descripcion = "";
    public int idResponsable = 0;
    public String responsable ="";
    public int idEstatus = 0;
    public String fechaRegistro = "";
    public String ultimaDescarga = "";
    public String version = "";
    public String rutaDescarga = "";
    public int idFormatoDescarga = 0;
    public String formatoDescarga = "";

    public int getIdApp() {
        return idApp;
    }

    public void setIdApp(int idApp) {
        this.idApp = idApp;
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

    public int getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUltimaDescarga() {
        return ultimaDescarga;
    }

    public void setUltimaDescarga(String ultimaDescarga) {
        this.ultimaDescarga = ultimaDescarga;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRutaDescarga() {
        return rutaDescarga;
    }

    public void setRutaDescarga(String rutaDescarga) {
        this.rutaDescarga = rutaDescarga;
    }

    public int getIdFormatoDescarga() {
        return idFormatoDescarga;
    }

    public void setIdFormatoDescarga(int idFormatoDescarga) {
        this.idFormatoDescarga = idFormatoDescarga;
    }

    public String getFormatoDescarga() {
        return formatoDescarga;
    }

    public void setFormatoDescarga(String formatoDescarga) {
        this.formatoDescarga = formatoDescarga;
    }

    @Override
    public String toString() {
        return "AplicacionDTO{" + "idApp=" + idApp + ", nombre=" + nombre + ", descripcion=" + descripcion + ", idResponsable=" + idResponsable + ", responsable=" + responsable + ", idEstatus=" + idEstatus + ", fechaRegistro=" + fechaRegistro + ", ultimaDescarga=" + ultimaDescarga + ", version=" + version + ", rutaDescarga=" + rutaDescarga + ", idFormatoDescarga=" + idFormatoDescarga + ", formatoDescarga=" + formatoDescarga + '}';
    }
    
    
}
