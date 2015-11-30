package com.touresbalon.oms.action;

import com.touresbalon.oms.model.CategoriaClienteEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Familia
 */
@javax.faces.bean.ManagedBean(name = "datosCacheAction")
@javax.faces.bean.ApplicationScoped
public class DatosCacheAction {
    
    
    private List<String> tiposEspectaculo;
    
    private List<String> ciudades;
    
    private List<String> categoriasCliente;
    
    
    public DatosCacheAction() {
        ciudades = Arrays.asList("Bogota", "Cali", "Cartagena", "Bucaramanga", "Sao Paulo", "Santiago", "Buenos Aires", "Miami", "Rio de Janeiro", "Lima");
        tiposEspectaculo = Arrays.asList("Fútbol", "Hockey", "Rugby", "Golf", "Baloncesto", "Automovilismo", "Voleyball", "Patinaje");
        categoriasCliente = new ArrayList<>();
        for (CategoriaClienteEnum categoriaCliente: CategoriaClienteEnum.values()) {
            categoriasCliente.add(categoriaCliente.getDescripcion());
        }
        
    }

    /**
     * @return the tiposEspectaculo
     */
    public List<String> getTiposEspectaculo() {
        return tiposEspectaculo;
    }

    /**
     * @param tiposEspectaculo the tiposEspectaculo to set
     */
    public void setTiposEspectaculo(List<String> tiposEspectaculo) {
        this.tiposEspectaculo = tiposEspectaculo;
    }

    /**
     * @return the ciudades
     */
    public List<String> getCiudades() {
        return ciudades;
    }

    /**
     * @param ciudades the ciudades to set
     */
    public void setCiudades(List<String> ciudades) {
        this.ciudades = ciudades;
    }

    /**
     * @return the categoriasCliente
     */
    public List<String> getCategoriasCliente() {
        return categoriasCliente;
    }

    /**
     * @param categoriasCliente the categoriasCliente to set
     */
    public void setCategoriasCliente(List<String> categoriasCliente) {
        this.categoriasCliente = categoriasCliente;
    }
    
}
