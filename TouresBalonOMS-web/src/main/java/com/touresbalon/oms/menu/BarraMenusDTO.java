package com.touresbalon.oms.menu;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sbrinez
 */
public class BarraMenusDTO implements Serializable {
    
    
    private List<MenuDTO> menus;

    /**
     * @return the menus
     */
    public List<MenuDTO> getMenus() {
        return menus;
    }

    /**
     * @param menus the menus to set
     */
    public void setMenus(List<MenuDTO> menus) {
        this.menus = menus;
    }
    
}
