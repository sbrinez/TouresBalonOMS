package com.touresbalon.oms.security;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 */
public class UserTO implements Serializable {
    
    private String username;
    
    private String nombre;
    
    private Date ultimoAcceso;
    
    private String ipOrigen;
    
    private String email;
    
    private List<String> perfiles; 

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
     * @return the ultimoAcceso
     */
    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    /**
     * @param ultimoAcceso the ultimoAcceso to set
     */
    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    /**
     * @return the ipOrigen
     */
    public String getIpOrigen() {
        return ipOrigen;
    }

    /**
     * @param ipOrigen the ipOrigen to set
     */
    public void setIpOrigen(String ipOrigen) {
        this.ipOrigen = ipOrigen;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the perfiles
     */
    public List<String> getPerfiles() {
        return perfiles;
    }

    /**
     * @param perfiles the perfiles to set
     */
    public void setPerfiles(List<String> perfiles) {
        this.perfiles = perfiles;
    }
    
}
