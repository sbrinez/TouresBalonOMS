package com.touresbalon.oms.security;

import com.touresbalon.oms.menu.BarraMenusDTO;
import com.touresbalon.oms.menu.MenuDTO;
import com.touresbalon.oms.menu.MenuItemDTO;

/**
 *
 * @author Familia
 */
public class GranularidadFinaManger {
    
    
    public static boolean validarAutorizacionAccion(BarraMenusDTO barraMenusDTO, String urlDestino) {
        for (MenuDTO menuDTO : barraMenusDTO.getMenus()) {
            for (MenuItemDTO menuItemDTO : menuDTO.getItems()) {
                if (menuItemDTO.getUrlDestino().contains(urlDestino)) {
                    return menuItemDTO.isControlCompleto();
                }
            }
        }
        return false;
    }
    
}
