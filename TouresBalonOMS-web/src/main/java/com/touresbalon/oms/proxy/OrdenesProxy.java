package com.touresbalon.oms.proxy;

import com.touresbalon.oms.model.ItemOrdenDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.touresbalon.oms.model.OrdenDTO;

/**
 *
 * @author SergioDavid
 */
public class OrdenesProxy {
    
    
    private static OrdenesProxy instance = new OrdenesProxy();
    
    
    private OrdenesProxy() {
    }
    
    public static OrdenesProxy getInstance() {
        return instance;
    }
    
    public List<OrdenDTO> consultarOrdenes() {
        
        List<ItemOrdenDTO> items = new ArrayList<>();
        
        for (int i = 1; i <= 5; i++) {
            ItemOrdenDTO itemOrdenDTO = new ItemOrdenDTO();
            itemOrdenDTO.setNumero(i);
            itemOrdenDTO.setCantidad(i);
            itemOrdenDTO.setProductoDTO(ProductosProxy.getInstance().consultarProducto(i));
            itemOrdenDTO.calcularValor();
            items.add(itemOrdenDTO);
        }
        
        List<OrdenDTO> ordenes = new ArrayList<>();
        
        for (int i = 1; i <= 10; i++) {
            OrdenDTO ordenDTO = new OrdenDTO();
            ordenDTO.setCodigoOrden(i);
            ordenDTO.setFecha(new Date());
            ordenDTO.setItems(items);
            ordenDTO.setEstado(i>5 ? "Autorizada" : "Procesada");
            ordenDTO.setClienteDTO(ClientesProxy.getInstance().consultarCliente("56756"));
            ordenes.add(ordenDTO);
        }
        return ordenes;
    }
    
}
