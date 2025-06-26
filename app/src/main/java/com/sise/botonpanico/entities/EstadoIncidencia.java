package com.sise.botonpanico.entities;

import java.util.Date;

public class EstadoIncidencia {
    private Integer idEstadoIncidencia;
    private String descripcion;
    private String estadoAuditoria;
    private Date fechaCreacionAuditoria;

    public Integer getIdEstadoIncidencia() {
        return idEstadoIncidencia;
    }

    public void setIdEstadoIncidencia(Integer idEstadoIncidencia) {
        this.idEstadoIncidencia = idEstadoIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public static EstadoIncidencia builder() {
        return new EstadoIncidencia();
    }
}
