package com.touresbalon.oms.action;

import com.touresbalon.oms.menu.BarraMenusDTO;
import com.touresbalon.oms.menu.MenuDTO;
import com.touresbalon.oms.menu.MenuItemDTO;
import com.touresbalon.oms.security.AuthenticatorDelegate;
import com.touresbalon.oms.security.UserTO;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author sbrinez
 */
@Named(value = "loginAction")
@RequestScoped
public class LoginAction {
    
    
    private String username;
    
    private String password;

    /**
     * Creates a new instance of LoginAction
     */
    public LoginAction() {
    }
    
    public String login() {
        System.out.println("Ejecutando el método login");
        boolean autenticado = AuthenticatorDelegate.autenticarUsuario(username, password);
        if (autenticado) {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request = (HttpServletRequest) ec.getRequest();            
            UserTO usuario = AuthenticatorDelegate.getUserTO(username, request);
            request.getSession().setAttribute("USERNAME", usuario);
            return "EXITO";
        }
        return null;
    }
    
    public String construirMenuHtml() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)ctx.getExternalContext().getRequest();
        UserTO userTO = (UserTO) request.getSession().getAttribute("USERNAME");
        BarraMenusDTO barraMenusDTO = AuthenticatorDelegate.construirMenu(userTO);
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
                    sb.append(menuItemDTO.getUrlDestino());
                    sb.append("\">");
                    sb.append(menuItemDTO.getNombre());
                    sb.append("</a></li>");
                }
                sb.append("</ul>");
                sb.append("</li>");
                sb.append("</ul>");
            }
            return sb.toString();
        }
        return null;
    }    

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
