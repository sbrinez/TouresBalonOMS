package com.touresbalon.oms.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author SergioDavid
 */
public class OrdenesPorMesDTO implements Serializable {
    
    
    private String mes;
    
    private Integer numeroOrdenes;
    
    private BigDecimal totalFactutado;

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * @return the numeroOrdenes
     */
    public Integer getNumeroOrdenes() {
        return numeroOrdenes;
    }

    /**
     * @param numeroOrdenes the numeroOrdenes to set
     */
    public void setNumeroOrdenes(Integer numeroOrdenes) {
        this.numeroOrdenes = numeroOrdenes;
    }

    /**
     * @return the totalFactutado
     */
    public BigDecimal getTotalFactutado() {
        return totalFactutado;
    }

    /**
     * @param totalFactutado the totalFactutado to set
     */
    public void setTotalFactutado(BigDecimal totalFactutado) {
        this.totalFactutado = totalFactutado;
    }
    
}
