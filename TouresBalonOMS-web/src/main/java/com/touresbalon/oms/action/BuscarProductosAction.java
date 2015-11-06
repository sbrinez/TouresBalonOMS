package com.touresbalon.oms.action;

import com.touresbalon.oms.model.ProductoDTO;
import com.touresbalon.oms.proxy.ProductosProxy;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author SergioDavid
 */
@Named("buscarProductosAction")
@ConversationScoped
public class BuscarProductosAction implements Serializable {

    
    private StreamedContent foto;
    
    private String criterioBusqueda;
    
    private List<ProductoDTO> listaProductos;
    
    private ProductoDTO productoSeleccionado;
    
    
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
     * @return the foto
     */
    public StreamedContent getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(StreamedContent foto) {
        this.foto = foto;
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
    
}
