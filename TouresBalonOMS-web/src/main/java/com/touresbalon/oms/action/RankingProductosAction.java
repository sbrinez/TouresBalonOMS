package com.touresbalon.oms.action;

import com.touresbalon.oms.model.ProductoDTO;
import com.touresbalon.oms.proxy.ProductosProxy;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Familia
 */
@javax.faces.bean.ManagedBean(name = "rankingProductosAction")
@javax.faces.bean.ViewScoped
public class RankingProductosAction extends AbstractAction implements Serializable {
    
    
    private Date fechaInicial;
    
    private Date fechaFinal;
    
    private List<ProductoDTO> productos;
    
    private ProductoDTO productoSeleccionado;
    
    
    public RankingProductosAction() {
    }
    
    
    public void consultarRankingProductosMasVendidos() {
        System.out.println("RankingProductosAction.consultarRankingProductosMasVendidos()");
        productos = ProductosProxy.getInstance().consultarProductos();
    }
    
    public void consultarDetallesProducto() {
        System.out.println("RankingProductosAction.consultarDetallesProducto()");
        System.out.println("Producto seleccionado es "+productoSeleccionado.getNombreProducto());
    }

    /**
     * @return the fechaInicial
     */
    public Date getFechaInicial() {
        return fechaInicial;
    }

    /**
     * @param fechaInicial the fechaInicial to set
     */
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    /**
     * @return the fechaFinal
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param fechaFinal the fechaFinal to set
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * @return the productos
     */
    public List<ProductoDTO> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
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
