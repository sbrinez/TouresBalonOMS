package com.touresbalon.oms.action;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.touresbalon.oms.constant.ConstantesAppWeb;
import com.touresbalon.oms.model.EstadoOrdenEnum;
import com.touresbalon.oms.model.OrdenDTO;
import com.touresbalon.oms.proxy.OrdenesProxy;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

/**
 *
 * @author SergioDavid
 */
@javax.faces.bean.ManagedBean(name = "buscarOrdenesAction")
@javax.faces.bean.ViewScoped
public class BuscarOrdenesAction extends AbstractAction implements Serializable {
    
    
    private String numeroOrdenBusqueda;
    
    private String codigoProductoBusqueda;
    
    private Date fechaInicialBusqueda;
    
    private Date fechaFinalBusqueda;    
    
    private List<OrdenDTO> listaOrdenes;
    
    private OrdenDTO ordenSeleccionada;
    

    public BuscarOrdenesAction() {
    }    

    public void cancelarOrden() {
        System.out.println("Cancelando la orden");
        if (ordenSeleccionada.validarCancelacion()) {
            //Cancelar la orden
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("La orden ha sido cancelada correctamente"));
            ordenSeleccionada.setEstado(EstadoOrdenEnum.CANCELADA.getDescripcion());
        } else {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(
                    "No se puede cancelar órdenes en estado "+ordenSeleccionada.getEstado()));
        }
    }
    
    public void buscarOrdenes() {
        
        System.out.println("Buscando ordenes");
        listaOrdenes = OrdenesProxy.getInstance().consultarOrdenes();
    }
    
    public void consultarRankingOrdenesAbiertas() {
        System.out.println("Consultando el ranking de ordenes ambiertas...");
        listaOrdenes = OrdenesProxy.getInstance().consultarOrdenes();
    }
    
    public void consultarRankingOrdenesMayorValor() {
        System.out.println("Consultando el ranking de ordenes cerradas de mayor valor en "
                + "el rango de fechas "+fechaInicialBusqueda + " y " + fechaFinalBusqueda);
        listaOrdenes = OrdenesProxy.getInstance().consultarOrdenes();
    }

    /**
     * @return the listaOrdenes
     */
    public List<OrdenDTO> getListaOrdenes() {
        return listaOrdenes;
    }

    /**
     * @param listaOrdenes the listaOrdenes to set
     */
    public void setListaOrdenes(List<OrdenDTO> listaOrdenes) {
        this.listaOrdenes = listaOrdenes;
    }

    /**
     * @return the ordenSeleccionada
     */
    public OrdenDTO getOrdenSeleccionada() {
        return ordenSeleccionada;
    }

    /**
     * @param ordenSeleccionada the ordenSeleccionada to set
     */
    public void setOrdenSeleccionada(OrdenDTO ordenSeleccionada) {
        this.ordenSeleccionada = ordenSeleccionada;
    }

    /**
     * @return the numeroOrdenBusqueda
     */
    public String getNumeroOrdenBusqueda() {
        return numeroOrdenBusqueda;
    }

    /**
     * @param numeroOrdenBusqueda the numeroOrdenBusqueda to set
     */
    public void setNumeroOrdenBusqueda(String numeroOrdenBusqueda) {
        this.numeroOrdenBusqueda = numeroOrdenBusqueda;
    }

    /**
     * @return the codigoProductoBusqueda
     */
    public String getCodigoProductoBusqueda() {
        return codigoProductoBusqueda;
    }

    /**
     * @param codigoProductoBusqueda the codigoProductoBusqueda to set
     */
    public void setCodigoProductoBusqueda(String codigoProductoBusqueda) {
        this.codigoProductoBusqueda = codigoProductoBusqueda;
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
