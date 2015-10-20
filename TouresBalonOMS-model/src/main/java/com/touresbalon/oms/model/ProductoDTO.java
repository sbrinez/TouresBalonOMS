package com.touresbalon.oms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author SergioDavid
 */
public class ProductoDTO implements Serializable {
    
    private Integer codigoProducto;
    
    private String nombreProducto;
    
    private String descripcionProducto;
    
    private byte[] fotoProducto;
    
    private Calendar fechaEspectaculo;
    
    private Calendar fechaLlegada;
    
    private Calendar fechaSalida;
    
    private String ciudadOrigen;
    
    private String ciudadDestino;
    
    private BigDecimal valorEspectaculo;
    
    private BigDecimal valorTransporte;
    
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
     * @return the fotoProducto
     */
    public byte[] getFotoProducto() {
        return fotoProducto;
    }

    /**
     * @param fotoProducto the fotoProducto to set
     */
    public void setFotoProducto(byte[] fotoProducto) {
        this.fotoProducto = fotoProducto;
    }

    /**
     * @return the fechaEspectaculo
     */
    public Calendar getFechaEspectaculo() {
        return fechaEspectaculo;
    }

    /**
     * @param fechaEspectaculo the fechaEspectaculo to set
     */
    public void setFechaEspectaculo(Calendar fechaEspectaculo) {
        this.fechaEspectaculo = fechaEspectaculo;
    }

    /**
     * @return the fechaLlegada
     */
    public Calendar getFechaLlegada() {
        return fechaLlegada;
    }

    /**
     * @param fechaLlegada the fechaLlegada to set
     */
    public void setFechaLlegada(Calendar fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    /**
     * @return the fechaSalida
     */
    public Calendar getFechaSalida() {
        return fechaSalida;
    }

    /**
     * @param fechaSalida the fechaSalida to set
     */
    public void setFechaSalida(Calendar fechaSalida) {
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
    
}
