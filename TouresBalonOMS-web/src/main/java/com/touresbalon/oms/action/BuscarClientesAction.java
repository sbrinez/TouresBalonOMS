package com.touresbalon.oms.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;

import com.touresbalon.oms.constant.ConstantesAppWeb;
import com.touresbalon.oms.constant.ConstantesMensajesKey;
import com.touresbalon.oms.constant.ConstantesResourcesBundle;
import com.touresbalon.oms.model.ClienteDTO;
import com.touresbalon.oms.proxy.ClientesProxy;

import org.primefaces.context.RequestContext;

/**
 *
 * @author SergioDavid
 */
@javax.faces.bean.ManagedBean(name = "buscarClientesAction")
@javax.faces.bean.ViewScoped
public class BuscarClientesAction extends AbstractAction implements Serializable {
    
    
    private String numIdentificacionBusqueda;
    
    private String codigoProductoBusqueda;
    
    private List<ClienteDTO> listaClientes;
    
    private ClienteDTO clienteSeleccionado;
    
    private boolean agregar;
    
    private Date fechaInicialMayorFacturacion;
    
    private Date fechaFinalMayorFacturacion;

    
    public BuscarClientesAction() {
    }
    
    public void buscarClientes() {
        
        if (codigoProductoBusqueda == null || numIdentificacionBusqueda.isEmpty()) {
            if (numIdentificacionBusqueda == null || numIdentificacionBusqueda.isEmpty()) {
                listaClientes = ClientesProxy.getInstance().consultarClientes();
            } else {
                //Buscar el cliente en la bbdd
                System.out.println("Buscando el cliente " + numIdentificacionBusqueda + "en la bbdd"); 
                if (listaClientes == null) {
                    listaClientes = new ArrayList<>();
                } else {
                    listaClientes.clear();
                }
                listaClientes.add(ClientesProxy.getInstance().consultarCliente(numIdentificacionBusqueda));
            }             
        } else {
            System.out.println("Haciendo la busqueda de clientes por producto");
            //Buscar el cliente en la bbdd
            if (listaClientes == null) {
                listaClientes = new ArrayList<>();
            } else {
                listaClientes.clear();
            }
            listaClientes.add(ClientesProxy.getInstance().consultarCliente(numIdentificacionBusqueda));            
        }
    }
    
    
    public void buscarClientesMayorFacturacion() {
        
        System.out.println("Buscando clientes de mayor facturación para el rango "
                + fechaInicialMayorFacturacion + " y " + fechaInicialMayorFacturacion);
        listaClientes = ClientesProxy.getInstance().consultarClientes();
    }
    
    public void iniciarNuevoCliente() {
        System.out.println("Inicializando objeto para nuevo cliente");
        clienteSeleccionado = new ClienteDTO();
        agregar = true;
    }
    
    public void iniciarActualizacionCliente(ClienteDTO clienteDTO) {
        System.out.println("Seteando objeto para actualizacion de cliente");
        clienteSeleccionado = clienteDTO;
        agregar = false;
    }
    
    public void agregarCliente() {
        System.out.println("Agregando cliente");
        
        //Aqui llamar a servicio de entidad Cliente capacidad agergar
        RequestContext.getCurrentInstance().execute("PF('modalDetalle').hide()");
        listaClientes.add(clienteSeleccionado);
        clienteSeleccionado = null;
    }
    
    public void actualizarCliente() {
        
        boolean exitoActualizacion = true;//Aqui llamar a servicio de entidad Cliente capacidad actualizar
        System.out.println("BuscarClientesAction.actualizarCliente() " +exitoActualizacion);
        
        if (exitoActualizacion) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    obtenerMensaje(ConstantesResourcesBundle.MENSAJES,
                            ConstantesMensajesKey.GENERAL_MENSAJE_CONFIRMACION),
                    obtenerMensaje(ConstantesResourcesBundle.MENSAJES,
                            ConstantesMensajesKey.GENERAL_REGISTRO_ACTUALIZADO));
            RequestContext.getCurrentInstance().showMessageInDialog(message);
            RequestContext.getCurrentInstance().execute("PF('modalDetalle').hide()");
        } 
    }
    
    public void eliminarCliente(ClienteDTO clienteDTO) {
        System.out.println("Eliminando cliente "+clienteDTO.getNumeroIdentificacion());
        
        //Aqui llamar a servicio de entidad Cliente capacidad eliminar
        
        listaClientes.remove(clienteDTO);
        clienteSeleccionado = null;
    }    

    /**
     * @return the listaClientes
     */
    public List<ClienteDTO> getListaClientes() {
        return listaClientes;
    }

    /**
     * @param listaClientes the listaClientes to set
     */
    public void setListaClientes(List<ClienteDTO> listaClientes) {
        this.listaClientes = listaClientes;
    }

    /**
     * @return the clienteSeleccionado
     */
    public ClienteDTO getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    /**
     * @param clienteSeleccionado the clienteSeleccionado to set
     */
    public void setClienteSeleccionado(ClienteDTO clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }

    /**
     * @return the agregar
     */
    public boolean isAgregar() {
        return agregar;
    }

    /**
     * @param agregar the agregar to set
     */
    public void setAgregar(boolean agregar) {
        this.agregar = agregar;
    }    

    /**
     * @return the numIdentificacionBusqueda
     */
    public String getNumIdentificacionBusqueda() {
        return numIdentificacionBusqueda;
    }

    /**
     * @param numIdentificacionBusqueda the numIdentificacionBusqueda to set
     */
    public void setNumIdentificacionBusqueda(String numIdentificacionBusqueda) {
        this.numIdentificacionBusqueda = numIdentificacionBusqueda;
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
     * @return the fechaInicialMayorFacturacion
     */
    public Date getFechaInicialMayorFacturacion() {
        return fechaInicialMayorFacturacion;
    }

    /**
     * @param fechaInicialMayorFacturacion the fechaInicialMayorFacturacion to set
     */
    public void setFechaInicialMayorFacturacion(Date fechaInicialMayorFacturacion) {
        this.fechaInicialMayorFacturacion = fechaInicialMayorFacturacion;
    }

    /**
     * @return the fechaFinalMayorFacturacion
     */
    public Date getFechaFinalMayorFacturacion() {
        return fechaFinalMayorFacturacion;
    }

    /**
     * @param fechaFinalMayorFacturacion the fechaFinalMayorFacturacion to set
     */
    public void setFechaFinalMayorFacturacion(Date fechaFinalMayorFacturacion) {
        this.fechaFinalMayorFacturacion = fechaFinalMayorFacturacion;
    }
    
}
