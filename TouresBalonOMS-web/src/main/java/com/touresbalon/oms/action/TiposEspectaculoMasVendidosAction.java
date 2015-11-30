package com.touresbalon.oms.action;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.touresbalon.oms.model.TipoEspectaculoMasVendidoDTO;

/**
 *
 * @author SergioDavid
 */
@javax.faces.bean.ManagedBean(name = "tiposEspectaculoMasVendidosAction")
@javax.faces.bean.ViewScoped
public class TiposEspectaculoMasVendidosAction extends AbstractAction implements Serializable {
    
    
    private Date fechaInicialBusqueda;
    
    private Date fechaFinalBusqueda;
    
    
    private List<TipoEspectaculoMasVendidoDTO> listaTiposEspectaculo;
    
    
    public TiposEspectaculoMasVendidosAction() {

    }    
    
    public void consultarTiposEspectaculosMasVendidos() {
        TipoEspectaculoMasVendidoDTO tipoEspectaculoMasVendidoDTO = new TipoEspectaculoMasVendidoDTO();
        tipoEspectaculoMasVendidoDTO.setTipoEspectaculo("Futbol");
        tipoEspectaculoMasVendidoDTO.setNumeroVentas(433);
        tipoEspectaculoMasVendidoDTO.setTotalFacturado(new BigDecimal("957364000"));
        listaTiposEspectaculo = new java.util.ArrayList<>();
        listaTiposEspectaculo.add(tipoEspectaculoMasVendidoDTO);
        //Hacer aqui la consulta para llenar la lista        
    }


    /**
     * @return the listaTiposEspectaculo
     */
    public List<TipoEspectaculoMasVendidoDTO> getListaTiposEspectaculo() {
        return listaTiposEspectaculo;
    }

    /**
     * @param listaTiposEspectaculo the listaTiposEspectaculo to set
     */
    public void setListaTiposEspectaculo(List<TipoEspectaculoMasVendidoDTO> listaTiposEspectaculo) {
        this.listaTiposEspectaculo = listaTiposEspectaculo;
    }

    /**
     * @return the fechaInicialBusqueda
     */
    public Date getFechaInicialBusqueda() {
        return fechaInicialBusqueda;
    }

    /**
     * @param fechaInicialBusqueda the fechaInicialBusqueda to set
     */
    public void setFechaInicialBusqueda(Date fechaInicialBusqueda) {
        this.fechaInicialBusqueda = fechaInicialBusqueda;
    }

    /**
     * @return the fechaFinalBusqueda
     */
    public Date getFechaFinalBusqueda() {
        return fechaFinalBusqueda;
    }

    /**
     * @param fechaFinalBusqueda the fechaFinalBusqueda to set
     */
    public void setFechaFinalBusqueda(Date fechaFinalBusqueda) {
        this.fechaFinalBusqueda = fechaFinalBusqueda;
    }

    
}
