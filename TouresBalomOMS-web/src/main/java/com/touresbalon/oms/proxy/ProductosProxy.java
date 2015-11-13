package com.touresbalon.oms.proxy;

import com.touresbalon.oms.model.ProductoDTO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Familia
 */
public class ProductosProxy {
    
    
    private String[] ciudades = {"Bogota", "Cali", "Cartagena", "Sao Paulo", "Santiago"};
    
    
    private static ProductosProxy instance = new ProductosProxy();
    
    private ProductosProxy() {
    }
    
    public static ProductosProxy getInstance() {
        return instance;
    }
    
    public List<ProductoDTO> consultarProductos() {
        
        List<ProductoDTO> productosDTO = new ArrayList<ProductoDTO>();
        Calendar fechaEspectaculo = Calendar.getInstance();
        fechaEspectaculo.set(2015, 9, 23, 0, 0, 0);
        fechaEspectaculo.set(Calendar.MILLISECOND, 0);
        for (int i = 0; i < 10; i++) {
            fechaEspectaculo.add(Calendar.DATE, i);
            ProductoDTO p = new ProductoDTO();
            p.setCiudadDestino(ciudades[new Random().nextInt(4)]);
            p.setCiudadOrigen(ciudades[new Random().nextInt(4)]);
            p.setCodigoProducto(i+1);
            p.setDescripcionProducto("Esta es la descripción del producto "+i+1);
            p.setFechaEspectaculo(fechaEspectaculo);
            
            Calendar fechaLLegada = (Calendar) fechaEspectaculo.clone();
            fechaLLegada.add(Calendar.DATE, -3);
            p.setFechaLlegada(fechaLLegada);
            
            Calendar fechaSalida = (Calendar) fechaEspectaculo.clone();
            fechaSalida.add(Calendar.DATE, 3);
            p.setFechaSalida(fechaSalida);
            
            p.setNombreProducto("Nombre del producto "+i+1);
            p.setTipoEspectaculo("Tipo espectaculo");
            p.setValorTotal(new BigDecimal("200000").multiply(new BigDecimal(i+1)));
            
            productosDTO.add(p);
        }
        return productosDTO;
    }
    
     public ProductoDTO consultarProducto(Integer idProducto) {
         return null;
     }
    
}
