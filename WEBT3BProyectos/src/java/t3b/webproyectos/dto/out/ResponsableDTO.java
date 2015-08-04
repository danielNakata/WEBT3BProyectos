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
public class ResponsableDTO {
    
    public int idResponsable = 0;
    public String nombre = "";
    public String apellidos = "";

    public int getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "ResponsableDTO{" + "idResponsable=" + idResponsable + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }
    
}
