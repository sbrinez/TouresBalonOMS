package com.touresbalon.oms.model;

/**
 *
 * @author SergioDavid
 */
public enum EstadoOrdenEnum {
    
    REGISTRADA(1, "Registrada"),
    
    AUTORIZADA(2,"Autorizada"),
    
    EN_PROCESO(3, "En proceso"),
    
    PROCESADA(4, "Procesada"),
    
    CANCELADA(5, "Cancelada"),
    
    RECHAZADA(6, "Rechazada");
    
    
    private Integer codigo;
    
    private String descripcion;
    
    
    private EstadoOrdenEnum(Integer codigo, String descripcion) {
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
