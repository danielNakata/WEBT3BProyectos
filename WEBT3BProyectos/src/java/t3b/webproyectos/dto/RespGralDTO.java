/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3b.webproyectos.dto;

import java.util.ArrayList;
import t3b.webproyectos.dto.out.AplicacionDTO;
import t3b.webproyectos.dto.out.LogDescargaDTO;
import t3b.webproyectos.dto.out.ResponsableDTO;

/**
 *
 * @author daniel
 */
public class RespGralDTO {
    
    private int res = 0;
    private String msg = "";
    private int numReg = 0;
    private ArrayList<CampoDTO> listaCampoDTO = null;
    private ArrayList<AplicacionDTO> listaAplicacionDTO = null;
    private ArrayList<ResponsableDTO> listaResponsableDTO = null;
    private ArrayList<LogDescargaDTO> listaLogDescargaDTO = null;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<AplicacionDTO> getListaAplicacionDTO() {
        return listaAplicacionDTO;
    }

    public void setListaAplicacionDTO(ArrayList<AplicacionDTO> listaAplicacionDTO) {
        this.listaAplicacionDTO = listaAplicacionDTO;
    }

    public ArrayList<CampoDTO> getListaCampoDTO() {
        return listaCampoDTO;
    }

    public void setListaCampoDTO(ArrayList<CampoDTO> listaCampoDTO) {
        this.listaCampoDTO = listaCampoDTO;
    }

    public int getNumReg() {
        return numReg;
    }

    public void setNumReg(int numReg) {
        this.numReg = numReg;
    }

    public ArrayList<ResponsableDTO> getListaResponsableDTO() {
        return listaResponsableDTO;
    }

    public void setListaResponsableDTO(ArrayList<ResponsableDTO> listaResponsableDTO) {
        this.listaResponsableDTO = listaResponsableDTO;
    }

    public ArrayList<LogDescargaDTO> getListaLogDescargaDTO() {
        return listaLogDescargaDTO;
    }

    public void setListaLogDescargaDTO(ArrayList<LogDescargaDTO> listaLogDescargaDTO) {
        this.listaLogDescargaDTO = listaLogDescargaDTO;
    }

    @Override
    public String toString() {
        return "RespGralDTO{" + "res=" + res + ", msg=" + msg + ", numReg=" + numReg + ", listaCampoDTO=" + listaCampoDTO + ", listaAplicacionDTO=" + listaAplicacionDTO + ", listaResponsableDTO=" + listaResponsableDTO + ", listaLogDescargaDTO=" + listaLogDescargaDTO + '}';
    }

}
