package com.touresbalon.oms.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author SergioDavid
 */
public class TipoEspectaculoMasVendidoDTO implements Serializable {
    
    
    private String tipoEspectaculo;
    
    private Integer numeroVentas;
    
    private BigDecimal totalFacturado;

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
     * @return the numeroVentas
     */
    public Integer getNumeroVentas() {
        return numeroVentas;
    }

    /**
     * @param numeroVentas the numeroVentas to set
     */
    public void setNumeroVentas(Integer numeroVentas) {
        this.numeroVentas = numeroVentas;
    }

    /**
     * @return the totalFacturado
     */
    public BigDecimal getTotalFacturado() {
        return totalFacturado;
    }

    /**
     * @param totalFacturado the totalFacturado to set
     */
    public void setTotalFacturado(BigDecimal totalFacturado) {
        this.totalFacturado = totalFacturado;
    }
    
}
