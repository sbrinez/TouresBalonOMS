package com.touresbalon.oms.proxy;

import com.touresbalon.oms.constant.ConstantesAppWeb;
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
    
    
    private String[] ciudades = {"Bogota", "Cali", "Cartagena", "Bucaramanga", "Sao Paulo", "Santiago", "Buenos Aires", "Miami", "Rio de Janeiro", "Lima"};
    private String[] tiposEspectaculo = {"Fútbol", "Hockey", "Rugby", "Golf", "Baloncesto", "Automovilismo", "Voleyball", "Patinaje"};
    
    
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
            p.setCiudadDestino(ciudades[new Random().nextInt(10)]);
            p.setCiudadOrigen(ciudades[new Random().nextInt(10)]);
            p.setCodigoProducto(i+1);
            p.setDescripcionProducto("Esta es la descripción del producto "+i+1);
            p.setFechaEspectaculo(fechaEspectaculo.getTime());
            
            Calendar fechaLLegada = (Calendar) fechaEspectaculo.clone();
            fechaLLegada.add(Calendar.DATE, -3);
            p.setFechaLlegada(fechaLLegada.getTime());
            
            Calendar fechaSalida = (Calendar) fechaEspectaculo.clone();
            fechaSalida.add(Calendar.DATE, 3);
            p.setFechaSalida(fechaSalida.getTime());
            
            p.setNombreProducto("Nombre del producto "+i+1);
            p.setTipoEspectaculo("Tipo espectaculo");
            p.setValorTotal(new BigDecimal("200000").multiply(new BigDecimal(i+1)));
            p.setValorEspectaculo(p.getValorTotal().divide(new BigDecimal(3), 0, BigDecimal.ROUND_HALF_UP));
            p.setValorHospedaje(p.getValorTotal().divide(new BigDecimal(3), 0, BigDecimal.ROUND_HALF_UP));
            p.setValorTransporte(p.getValorTotal().divide(new BigDecimal(3), 0, BigDecimal.ROUND_HALF_UP));
            p.setUrlFoto(ConstantesAppWeb.URL_DIRECTORIO_IMAGENES_DRIVE + (i+1) + ".png");
            p.setTipoEspectaculo(tiposEspectaculo[new Random().nextInt(8)]);
            
            productosDTO.add(p);
        }
        return productosDTO;
    }
    
    public ProductoDTO consultarProducto(int i) {
        
        Calendar fechaEspectaculo = Calendar.getInstance();
        fechaEspectaculo.set(2015, 9, 23, 0, 0, 0);
        fechaEspectaculo.set(Calendar.MILLISECOND, 0);        
        
        ProductoDTO p = new ProductoDTO();
        p.setCiudadDestino(ciudades[new Random().nextInt(10)]);
        p.setCiudadOrigen(ciudades[new Random().nextInt(10)]);
        p.setCodigoProducto(i+1);
        p.setDescripcionProducto("Esta es la descripción del producto "+i+1);
        p.setFechaEspectaculo(fechaEspectaculo.getTime());

        Calendar fechaLLegada = (Calendar) fechaEspectaculo.clone();
        fechaLLegada.add(Calendar.DATE, -3);
        p.setFechaLlegada(fechaLLegada.getTime());

        Calendar fechaSalida = (Calendar) fechaEspectaculo.clone();
        fechaSalida.add(Calendar.DATE, 3);
        p.setFechaSalida(fechaSalida.getTime());

        p.setNombreProducto("Nombre del producto "+i+1);
        p.setTipoEspectaculo("Tipo espectaculo");
        p.setValorTotal(new BigDecimal("200000").multiply(new BigDecimal(i+1)));
        p.setValorEspectaculo(p.getValorTotal().divide(new BigDecimal(3), 0, BigDecimal.ROUND_HALF_UP));
        p.setValorHospedaje(p.getValorTotal().divide(new BigDecimal(3), 0, BigDecimal.ROUND_HALF_UP));
        p.setValorTransporte(p.getValorTotal().divide(new BigDecimal(3), 0, BigDecimal.ROUND_HALF_UP));
        p.setUrlFoto(ConstantesAppWeb.URL_DIRECTORIO_IMAGENES_DRIVE + (i+1) + ".png");
        p.setTipoEspectaculo(tiposEspectaculo[new Random().nextInt(8)]);

        return p;
    }
    
     public ProductoDTO consultarProducto(Integer codigoProducto) {
         return null;
     }
     
     public void crearProducto(ProductoDTO productoDTO) {
         
     }
     
     public void actualizarProducto(ProductoDTO productoDTO) {
         
     }
     
     public void eliminarProducto(Integer codigoProducto) {
         
     }
    
}
