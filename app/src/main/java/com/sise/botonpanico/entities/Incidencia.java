package com.sise.botonpanico.entities;

import java.util.Date;

public class Incidencia {
    private Integer idIncidencia;
    private TipoIncidencia tipoIncidencia;
    private String descripcion;
    private EstadoIncidencia estadoIncidencia;
    private Date fechaHoraReporte;
    private Date fechaHoraAtencion;
    private String latitud;
    private String longitud;
    private String estadoAuditoria;
    private Date fechaCreacionAuditoria;

    public Integer getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(Integer idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public TipoIncidencia getTipoIncidencia() {
        return tipoIncidencia;
    }

    public void setTipoIncidencia(TipoIncidencia tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoIncidencia getEstadoIncidencia() {
        return estadoIncidencia;
    }

    public void setEstadoIncidencia(EstadoIncidencia estadoIncidencia) {
        this.estadoIncidencia = estadoIncidencia;
    }

    public Date getFechaHoraReporte() {
        return fechaHoraReporte;
    }

    public void setFechaHoraReporte(Date fechaHoraReporte) {
        this.fechaHoraReporte = fechaHoraReporte;
    }

    public Date getFechaHoraAtencion() {
        return fechaHoraAtencion;
    }

    public void setFechaHoraAtencion(Date fechaHoraAtencion) {
        this.fechaHoraAtencion = fechaHoraAtencion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
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
