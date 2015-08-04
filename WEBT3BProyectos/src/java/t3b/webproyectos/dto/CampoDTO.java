/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3b.webproyectos.dto;

/**
 *
 * @author daniel
 */
public class CampoDTO {
    public String nombre = "";
    public String etiqueta = "";
    public int idTipo = 0;
    public String tipo = "";
    public String table = "";
    public String base = "";
    public int tamanio = 0;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return "CampoDTO{" + "nombre=" + nombre + ", etiqueta=" + etiqueta + ", idTipo=" + idTipo + ", tipo=" + tipo + ", table=" + table + ", base=" + base + ", tamanio=" + tamanio + '}';
    }
    
}
