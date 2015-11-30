package com.touresbalon.oms.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author SergioDavid
 */
public class ClienteDTO implements Serializable {
    
    
    private Integer codigo;
    
    private String numeroIdentificacion;
    
    private String nombres;
    
    private String apellidos;    
          
    private String celular;
    
    private String direccion;
    
    private String email;
    
    private String password;
    
    private Date fechaUltimoAcceso;
    
    private String categoria; 
    
    private String numeroTarjeta;
    
    private Date fechaExpiracionTarjeta;
    
    private String codigoSeguridadTarjeta;
    
    private String franquiciaTarjeta;  
    
    
    public String obtenerNombreCompleto() {
        return nombres + " " + apellidos;
    }
    
    /**
     * @return the numeroIdentificacion
     */
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    /**
     * @param numeroIdentificacion the numeroIdentificacion to set
     */
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }    

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the fechaUltimoAcceso
     */
    public Date getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }

    /**
     * @param fechaUltimoAcceso the fechaUltimoAcceso to set
     */
    public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the numeroTarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * @param numeroTarjeta the numeroTarjeta to set
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * @return the fechaExpiracionTarjeta
     */
    public Date getFechaExpiracionTarjeta() {
        return fechaExpiracionTarjeta;
    }

    /**
     * @param fechaExpiracionTarjeta the fechaExpiracionTarjeta to set
     */
    public void setFechaExpiracionTarjeta(Date fechaExpiracionTarjeta) {
        this.fechaExpiracionTarjeta = fechaExpiracionTarjeta;
    }

    /**
     * @return the codigoSeguridadTarjeta
     */
    public String getCodigoSeguridadTarjeta() {
        return codigoSeguridadTarjeta;
    }

    /**
     * @param codigoSeguridadTarjeta the codigoSeguridadTarjeta to set
     */
    public void setCodigoSeguridadTarjeta(String codigoSeguridadTarjeta) {
        this.codigoSeguridadTarjeta = codigoSeguridadTarjeta;
    }

    /**
     * @return the franquiciaTarjeta
     */
    public String getFranquiciaTarjeta() {
        return franquiciaTarjeta;
    }

    /**
     * @param franquiciaTarjeta the franquiciaTarjeta to set
     */
    public void setFranquiciaTarjeta(String franquiciaTarjeta) {
        this.franquiciaTarjeta = franquiciaTarjeta;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
