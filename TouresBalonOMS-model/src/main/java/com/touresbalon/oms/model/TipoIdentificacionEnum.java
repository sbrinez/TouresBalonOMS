package com.touresbalon.oms.model;

/**
 *
 * @author SergioDavid
 */
public enum TipoIdentificacionEnum {
    
    
    CEDULA_CIUDADANIA(1, "Cédula de ciudadanía"),
    
    CEDULA_EXTRANJERIA(2, "Cédula de extranjería"),
    
    NIT(3, "Nit"),
    
    PASAPORTE(4, "Pasaporte");
    
    
    private Integer codigo;
    
    private String descripcion;
    
    
    private TipoIdentificacionEnum(Integer codigo, String descripcion) {
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
