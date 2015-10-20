package com.touresbalon.oms.action;

import com.touresbalon.oms.model.ProductoDTO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
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

    
    @PostConstruct
    public void buscarProductos() {
        //
        //Llamar servicio de busqueda de productos para llenar listaProductos
        foto = null;
        try { // Call Web Service Operation
//            com.touresbalon.oms.client.NewSessionBean port = service.getNewSessionBeanPort();
//            // TODO process result here
//            java.util.List<com.touresbalon.oms.client.ProductoDTO> resultSet = port.consultarProductos();
//            
//            System.out.println("Result = "+resultSet);
//            for (com.touresbalon.oms.client.ProductoDTO result : resultSet) {
//                ProductoDTO productoDTO = new ProductoDTO();
//                productoDTO.setNombreProducto(result.getNombreProducto());
//                FileInputStream fis = new FileInputStream("C:\\Users\\Familia\\Pictures\\80852955.jpg");
//                foto = new DefaultStreamedContent(new ByteArrayInputStream(result.getFotoProducto()));
//            }            
         
        } catch (Exception ex) {
            ex.printStackTrace();
            // TODO handle custom exceptions here
        }

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
    
}
