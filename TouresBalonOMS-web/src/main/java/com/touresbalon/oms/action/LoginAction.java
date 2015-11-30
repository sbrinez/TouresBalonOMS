package com.touresbalon.oms.action;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.touresbalon.oms.constant.ConstantesAppWeb;
import com.touresbalon.oms.security.AuthenticatorDelegate;
import com.touresbalon.oms.security.UserTO;
import javax.servlet.http.HttpSession;

/**
 * @author sbrinez
 */
@javax.faces.bean.ManagedBean(name = "loginAction")
@javax.faces.bean.RequestScoped
public class LoginAction extends AbstractAction {
    
    
    private String username;
    
    private String password;

    /**
     * Creates a new instance of LoginAction
     */
    public LoginAction() {
    }
    
    public void login() {
        System.out.println("Ejecutando el método login");
        boolean autenticado = AuthenticatorDelegate.autenticarUsuario(username, password);
        if (autenticado) {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request = (HttpServletRequest) ec.getRequest();            
            UserTO usuario = AuthenticatorDelegate.getUserTO(username, request);
            request.getSession().setAttribute(ConstantesAppWeb.USERNAME, usuario);
            redirect(ConstantesAppWeb.PAGINA_BUSCAR_PRODUCTOS);
        }
    }
    
    public void logout() {
        System.out.println("Haciendo logout");
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();  
        HttpSession session = request.getSession(false);
        if (session != null) {
            System.out.println("Invalidando sesion");
            session.invalidate();
        }
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
