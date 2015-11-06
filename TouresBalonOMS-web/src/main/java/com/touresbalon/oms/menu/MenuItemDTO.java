package com.touresbalon.oms.menu;

import java.io.Serializable;

/**
 *
 * @author sbrinez
 */
public class MenuItemDTO implements Serializable {
    
    
    private String nombre;
    
    private String urlDestino;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the urlDestino
     */
    public String getUrlDestino() {
        return urlDestino;
    }

    /**
     * @param urlDestino the urlDestino to set
     */
    public void setUrlDestino(String urlDestino) {
        this.urlDestino = urlDestino;
    }
    
}
