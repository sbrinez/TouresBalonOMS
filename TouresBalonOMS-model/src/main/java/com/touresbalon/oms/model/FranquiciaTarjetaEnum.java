package com.touresbalon.oms.model;

/**
 *
 * @author SergioDavid
 */
public enum FranquiciaTarjetaEnum {
    
 
    VISA(1, "Visa"),
    
    MASTER_CARD(2, "Master Card"),
    
    AMERICAN_EXPRESS(3, "American Express");
    
    
    private Integer codigo;
    
    private String descripcion;
    
    
    private FranquiciaTarjetaEnum(Integer codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
