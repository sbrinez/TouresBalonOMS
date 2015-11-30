package com.touresbalon.oms.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author SergioDavid
 */
public class ItemOrdenDTO implements Serializable {
    
    private Integer numero;
    
    private ProductoDTO productoDTO;
    
    private Integer cantidad;
    
    private BigDecimal valor;

    /**
     * Calcula el valor del item
     * @return el valor del item
     */
    public BigDecimal calcularValor() {
        if (valor == null) {
            valor = BigDecimal.ZERO;
            if (productoDTO != null && cantidad != null) {
                valor = productoDTO.getValorTotal().multiply(new BigDecimal(cantidad));
            }
        }
        return valor;
    }    

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the productoDTO
     */
    public ProductoDTO getProductoDTO() {
        return productoDTO;
    }

    /**
     * @param productoDTO the productoDTO to set
     */
    public void setProductoDTO(ProductoDTO productoDTO) {
        this.productoDTO = productoDTO;
    }

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
}
