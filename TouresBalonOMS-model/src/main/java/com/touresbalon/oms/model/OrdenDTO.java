package com.touresbalon.oms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author SergioDavid
 */
public class OrdenDTO implements Serializable {
    
    private Integer codigoOrden;
    
    private Date fecha;
    
    private ClienteDTO clienteDTO;
    
    private List<ItemOrdenDTO> items;
    
    private String estado;
    
    private BigDecimal valorTotal;
    
    /**
     * Calcula el valor total de la orden y lo almacena en valorTotal
     * @return 
     */
    public BigDecimal calcularValorTotal() {
        if (valorTotal == null) {
            valorTotal = BigDecimal.ZERO;
            if (items != null && !items.isEmpty()) {
                for (ItemOrdenDTO item : items) {
                    valorTotal = valorTotal.add(item.calcularValor());
                }
            } 
        }
        return valorTotal;
    }
    
    public boolean validarCancelacion() {
        return estado.equals(EstadoOrdenEnum.REGISTRADA.getDescripcion()) 
                || estado.equals(EstadoOrdenEnum.AUTORIZADA.getDescripcion());
    }

    /**
     * @return the codigoOrden
     */
    public Integer getCodigoOrden() {
        return codigoOrden;
    }

    /**
     * @param codigoOrden the codigoOrden to set
     */
    public void setCodigoOrden(Integer codigoOrden) {
        this.codigoOrden = codigoOrden;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the clienteDTO
     */
    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    /**
     * @param clienteDTO the clienteDTO to set
     */
    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the items
     */
    public List<ItemOrdenDTO> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<ItemOrdenDTO> items) {
        this.items = items;
    }
    
}
