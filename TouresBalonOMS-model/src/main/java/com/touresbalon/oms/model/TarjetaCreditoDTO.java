package com.touresbalon.oms.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author SergioDavid
 */
public class TarjetaCreditoDTO implements Serializable {
    
    
    private String numero;
    
    private Date fechaExpiracion;
    
    private String codigoSeguridad;
    
    private FranquiciaTarjetaEnum franquiciaTarjeta;
    
    private ClienteDTO clienteDTO;

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the fechaExpiracion
     */
    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    /**
     * @param fechaExpiracion the fechaExpiracion to set
     */
    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    /**
     * @return the codigoSeguridad
     */
    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    /**
     * @param codigoSeguridad the codigoSeguridad to set
     */
    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    /**
     * @return the franquiciaTarjeta
     */
    public FranquiciaTarjetaEnum getFranquiciaTarjeta() {
        return franquiciaTarjeta;
    }

    /**
     * @param franquiciaTarjeta the franquiciaTarjeta to set
     */
    public void setFranquiciaTarjeta(FranquiciaTarjetaEnum franquiciaTarjeta) {
        this.franquiciaTarjeta = franquiciaTarjeta;
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
    
}
