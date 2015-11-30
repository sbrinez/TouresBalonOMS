package com.touresbalon.oms.security;

import com.touresbalon.oms.cache.CacheResourceLoader;
import com.touresbalon.oms.menu.BarraMenusDTO;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Familia
 */
public class AuthenticatorDelegate {
    
    
    public static boolean autenticarUsuario(String username, String password) {
        return true;
    }
    
    
    public static UserTO getUserTO(String username, HttpServletRequest request) {
        UserTO userTO = new UserTO();
        userTO.setUsername(username);
        userTO.setEmail(username);
        userTO.setUltimoAcceso(new Date());
        userTO.setIpOrigen(request.getRemoteAddr());
        userTO.setPerfil("SUPER_USER");
        return userTO;
    }
    
    
    public static BarraMenusDTO construirMenu(UserTO userTO) {
        
        if (userTO.getPerfil() != null) {
            //Se asume que cada usuario únicamente tiene un rol
            return CacheResourceLoader.getRolesMenus().get(userTO.getPerfil());
        }
        return null;
    }
    
}
