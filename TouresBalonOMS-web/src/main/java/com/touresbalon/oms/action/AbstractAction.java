package com.touresbalon.oms.action;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.touresbalon.oms.constant.ConstantesAppWeb;
import com.touresbalon.oms.menu.BarraMenusDTO;
import com.touresbalon.oms.security.GranularidadFinaManger;

/**
 *
 * @author Familia
 */
public abstract class AbstractAction {
    
    
    private boolean fullAccess;

    
    public void validarAutorizacionAccion() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        BarraMenusDTO barraMenusDTO = (BarraMenusDTO) request.getSession().getAttribute(ConstantesAppWeb.BARRA_MENUS);
        String url = request.getRequestURI();
        System.out.println("Verificando permisos de granularidad fina para el recurso "+url);
        setFullAccess(GranularidadFinaManger.validarAutorizacionAccion(barraMenusDTO, url));
    }

    protected void redirect(String url) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/" + ConstantesAppWeb.NOMBRE_APP_WEB + url);
        } catch (IOException ex) {
            Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected String obtenerMensaje(String resourceBundleName, String resourceBundleKey) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ResourceBundle bundle = facesContext.getApplication()
                .getResourceBundle(facesContext, resourceBundleName);
        return bundle.getString(resourceBundleKey);
    }

    /**
     * @return the fullAccess
     */
    public boolean isFullAccess() {
        return fullAccess;
    }

    /**
     * @param fullAccess the fullAccess to set
     */
    public void setFullAccess(boolean fullAccess) {
        this.fullAccess = fullAccess;
    }

}
