package com.sise.botonpanico.entities;

import java.util.Date;

public class TipoIncidencia {
    private Integer idTipoIncidencia;
    private String descripcion;
    private String flagBoton;
    private String estadoAuditoria;
    private Date fechaCreacionAuditoria;

    public Integer getIdTipoIncidencia() {
        return idTipoIncidencia;
    }

    public void setIdTipoIncidencia(Integer idTipoIncidencia) {
        this.idTipoIncidencia = idTipoIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFlagBoton() {
        return flagBoton;
    }

    public void setFlagBoton(String flagBoton) {
        this.flagBoton = flagBoton;
    }

    public String getEstadoAuditoria() {
        return estadoAuditoria;
    }

    public void setEstadoAuditoria(String estadoAuditoria) {
        this.estadoAuditoria = estadoAuditoria;
    }

    public Date getFechaCreacionAuditoria() {
        return fechaCreacionAuditoria;
    }

    public void setFechaCreacionAuditoria(Date fechaCreacionAuditoria) {
        this.fechaCreacionAuditoria = fechaCreacionAuditoria;
    }
}
