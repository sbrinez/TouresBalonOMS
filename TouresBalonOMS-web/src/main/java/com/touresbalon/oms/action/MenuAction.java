package com.touresbalon.oms.action;

import java.io.Serializable;

//import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
//import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.touresbalon.oms.constant.ConstantesAppWeb;
import com.touresbalon.oms.menu.BarraMenusDTO;
import com.touresbalon.oms.menu.MenuDTO;
import com.touresbalon.oms.menu.MenuItemDTO;
import com.touresbalon.oms.security.AuthenticatorDelegate;
import com.touresbalon.oms.security.UserTO;

/**
 *
 * @author Familia
 */
@javax.faces.bean.ManagedBean(name = "menuAction")
@javax.faces.bean.SessionScoped
public class MenuAction extends AbstractAction implements Serializable {
    
    
    private String menuHtml;
    
    
    public MenuAction() {
        System.out.println("En el constructor de MenuAction");
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)ctx.getExternalContext().getRequest();
        UserTO userTO = (UserTO) request.getSession().getAttribute(ConstantesAppWeb.USERNAME);
        BarraMenusDTO barraMenusDTO = AuthenticatorDelegate.construirMenu(userTO);
        request.getSession().setAttribute(ConstantesAppWeb.BARRA_MENUS, barraMenusDTO);
        if (barraMenusDTO != null) {
            StringBuilder sb = new StringBuilder();
            for (MenuDTO menuDTO : barraMenusDTO.getMenus()) {
                sb.append("<ul class=\"nav navbar-nav\">");
                sb.append("<li class=\"dropdown\">");
                sb.append("<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">");
                sb.append(menuDTO.getNombre());
                sb.append("<b class=\"caret\"></b></a>");
                sb.append("<ul class=\"dropdown-menu\">");
                for (MenuItemDTO menuItemDTO : menuDTO.getItems()) {
                    sb.append("<li><a href=\"");
                    sb.append("/");
                    sb.append(ConstantesAppWeb.NOMBRE_APP_WEB);                    
                    sb.append(menuItemDTO.getUrlDestino());
                    sb.append("\">");
                    sb.append(menuItemDTO.getNombre());
                    sb.append("</a></li>");
                }
                sb.append("</ul>");
                sb.append("</li>");
                sb.append("</ul>");
            }
            //sb.append("<p class=\"navbar-text pull-right\">Bienvenido </p>");
            sb.append("<ul class=\"nav navbar-nav pull-right\">");
            sb.append("<li class=\"dropdown\">");
            sb.append("<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">");            
            sb.append(userTO.getNombre());
            sb.append("<b class=\"caret\"></b></a>");
            sb.append("<ul class=\"dropdown-menu\">");
            sb.append("<li><a href=\"");
            sb.append("/");
            sb.append(ConstantesAppWeb.NOMBRE_APP_WEB);                    
            sb.append("/login.xhtml");
            sb.append("\">");
            sb.append("Salir");
            sb.append("</a></li>");
            menuHtml = sb.toString();
        }
    }  
    
    /**
     * @return the menuHtml
     */
    public String getMenuHtml() {
        return menuHtml;
    }

    /**
     * @param menuHtml the menuHtml to set
     */
    public void setMenuHtml(String menuHtml) {
        this.menuHtml = menuHtml;
    }    
    
}
