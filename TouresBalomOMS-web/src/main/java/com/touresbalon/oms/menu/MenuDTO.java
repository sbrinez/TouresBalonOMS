package com.touresbalon.oms.menu;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sbrinez
 */
public class MenuDTO implements Serializable {
    
    
    private String nombre;
    
    private List<MenuItemDTO> items;

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
     * @return the items
     */
    public List<MenuItemDTO> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<MenuItemDTO> items) {
        this.items = items;
    }
    
}
