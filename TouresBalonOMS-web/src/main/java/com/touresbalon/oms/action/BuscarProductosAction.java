package com.touresbalon.oms.action;

import java.io.Serializable;
import java.util.List;

//import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
//import javax.inject.Named;

import com.touresbalon.oms.constant.ConstantesMensajesKey;
import com.touresbalon.oms.constant.ConstantesResourcesBundle;

import com.touresbalon.oms.model.ProductoDTO;
import com.touresbalon.oms.proxy.ProductosProxy;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author SergioDavid
 */
@javax.faces.bean.ManagedBean(name = "buscarProductosAction")
@javax.faces.bean.ViewScoped
public class BuscarProductosAction extends AbstractAction implements Serializable {

    
    private String criterioBusqueda;
    
    private List<ProductoDTO> listaProductos;
    
    private ProductoDTO productoSeleccionado;
    
    private boolean modalVisible;
    
    private UploadedFile archivoImagen;
    
    private String mensajeError;
    
    
    public BuscarProductosAction() {
        System.out.println("Constructor BuscarProductosAction");
    } 
    
        
    public void buscarProductos() {
        //
        //Llamar servicio de busqueda de productos para llenar listaProductos
        try { // Call Web Service Operation
            
            listaProductos = ProductosProxy.getInstance().consultarProductos();            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            // TODO handle custom exceptions here
        }
    }
    
    public void consultarDetalleProducto() {
        
        //No se asigna porque no está retornando nada pero esa es la idea cuando
        //este implementado el WS
        ProductosProxy.getInstance().consultarProducto(productoSeleccionado.getCodigoProducto());
        modalVisible = true;
    }
    
    /**En este momento este metodo no se esta llamando desde ninguna parte*/
    public void inicializarProductoDTO() {
        System.out.println("Reinicializando ProductoDTO");
        productoSeleccionado = new ProductoDTO();            
    }
    
    public void actualizarProducto() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                obtenerMensaje(ConstantesResourcesBundle.MENSAJES,
                        ConstantesMensajesKey.GENERAL_MENSAJE_CONFIRMACION),
                obtenerMensaje(ConstantesResourcesBundle.MENSAJES,
                        ConstantesMensajesKey.GENERAL_REGISTRO_ACTUALIZADO));
        RequestContext.getCurrentInstance().showMessageInDialog(message);        
        System.out.println("Actualizando producto");
    }
    
    public void eliminarProducto() {
        System.out.println("Eliminando producto");
        listaProductos.remove(productoSeleccionado);
    }

    /**
     * @return the criterioBusqueda
     */
    public String getCriterioBusqueda() {
        return criterioBusqueda;
    }

    /**
     * @param criterioBusqueda the criterioBusqueda to set
     */
    public void setCriterioBusqueda(String criterioBusqueda) {
        this.criterioBusqueda = criterioBusqueda;
    }

    /**
     * @return the listaProductos
     */
    public List<ProductoDTO> getListaProductos() {
        return listaProductos;
    }

    /**
     * @param listaProductos the listaProductos to set
     */
    public void setListaProductos(List<ProductoDTO> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * @return the productoSeleccionado
     */
    public ProductoDTO getProductoSeleccionado() {
        return productoSeleccionado;
    }

    /**
     * @param productoSeleccionado the productoSeleccionado to set
     */
    public void setProductoSeleccionado(ProductoDTO productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    /**
     * @return the modalVisible
     */
    public boolean isModalVisible() {
        return modalVisible;
    }

    /**
     * @param modalVisible the modalVisible to set
     */
    public void setModalVisible(boolean modalVisible) {
        this.modalVisible = modalVisible;
    }

    /**
     * @return the archivoImagen
     */
    public UploadedFile getArchivoImagen() {
        return archivoImagen;
    }

    /**
     * @param archivoImagen the archivoImagen to set
     */
    public void setArchivoImagen(UploadedFile archivoImagen) {
        this.archivoImagen = archivoImagen;
    }

    /**
     * @return the mensajeError
     */
    public String getMensajeError() {
        return mensajeError;
    }

    /**
     * @param mensajeError the mensajeError to set
     */
    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
    
}
