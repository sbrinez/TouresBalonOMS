package com.touresbalon.oms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author SergioDavid
 */
public class ProductoDTO implements Serializable {
    
    private Integer codigoProducto;
    
    private String nombreProducto;
    
    private String descripcionProducto;
    
    private String urlFoto;
    
    private Date fechaEspectaculo;
    
    private Date fechaLlegada;
    
    private Date fechaSalida;
    
    private String ciudadOrigen;
    
    private String ciudadDestino;
    
    private BigDecimal valorEspectaculo;
    
    private BigDecimal valorTransporte;
    
    private BigDecimal valorHospedaje;
    
    private BigDecimal valorTotal;
    
    private String tipoEspectaculo;  

    /**
     * @return the codigoProducto
     */
    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * @param codigoProducto the codigoProducto to set
     */
    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the descripcionProducto
     */
    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    /**
     * @param descripcionProducto the descripcionProducto to set
     */
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    /**
     * @return the urlFoto
     */
    public String getUrlFoto() {
        return urlFoto;
    }

    /**
     * @param urlFoto the urlFoto to set
     */
    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    /**
     * @return the fechaEspectaculo
     */
    public Date getFechaEspectaculo() {
        return fechaEspectaculo;
    }

    /**
     * @param fechaEspectaculo the fechaEspectaculo to set
     */
    public void setFechaEspectaculo(Date fechaEspectaculo) {
        this.fechaEspectaculo = fechaEspectaculo;
    }

    /**
     * @return the fechaLlegada
     */
    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    /**
     * @param fechaLlegada the fechaLlegada to set
     */
    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    /**
     * @return the fechaSalida
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     * @param fechaSalida the fechaSalida to set
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * @return the ciudadOrigen
     */
    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    /**
     * @param ciudadOrigen the ciudadOrigen to set
     */
    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    /**
     * @return the ciudadDestino
     */
    public String getCiudadDestino() {
        return ciudadDestino;
    }

    /**
     * @param ciudadDestino the ciudadDestino to set
     */
    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    /**
     * @return the valorEspectaculo
     */
    public BigDecimal getValorEspectaculo() {
        return valorEspectaculo;
    }

    /**
     * @param valorEspectaculo the valorEspectaculo to set
     */
    public void setValorEspectaculo(BigDecimal valorEspectaculo) {
        this.valorEspectaculo = valorEspectaculo;
    }

    /**
     * @return the valorTransporte
     */
    public BigDecimal getValorTransporte() {
        return valorTransporte;
    }

    /**
     * @param valorTransporte the valorTransporte to set
     */
    public void setValorTransporte(BigDecimal valorTransporte) {
        this.valorTransporte = valorTransporte;
    }

    /**
     * @return the valorTotal
     */
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the tipoEspectaculo
     */
    public String getTipoEspectaculo() {
        return tipoEspectaculo;
    }

    /**
     * @param tipoEspectaculo the tipoEspectaculo to set
     */
    public void setTipoEspectaculo(String tipoEspectaculo) {
        this.tipoEspectaculo = tipoEspectaculo;
    }

    /**
     * @return the valorHospedaje
     */
    public BigDecimal getValorHospedaje() {
        return valorHospedaje;
    }

    /**
     * @param valorHospedaje the valorHospedaje to set
     */
    public void setValorHospedaje(BigDecimal valorHospedaje) {
        this.valorHospedaje = valorHospedaje;
    }
    
}
