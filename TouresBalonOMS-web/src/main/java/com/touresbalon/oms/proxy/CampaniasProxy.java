package com.touresbalon.oms.proxy;

import com.touresbalon.oms.model.CampaniaDTO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author sbrinez
 */
public class CampaniasProxy {
    
    private static CampaniasProxy instance = new CampaniasProxy();
    
    private CampaniasProxy() {
    }
    
    public static CampaniasProxy getInstance() {
        return instance;
    }    
    
    
    public List<CampaniaDTO> consultarCampanias() {
        List<CampaniaDTO> campanias = new ArrayList<>();
        
        for (int i = 0; i < 20; i++) {
            CampaniaDTO campaniaDTO = new CampaniaDTO();
            campaniaDTO.setCodigo(i+1);
            campaniaDTO.setNombreProducto("Campaña "+(i+1));
            Calendar fechaInicioVigencia = Calendar.getInstance();
            fechaInicioVigencia.set(2015, 11, i+1, 0, 0, 0);            
            campaniaDTO.setFechaInicioVigencia(fechaInicioVigencia.getTime());
            Calendar fechaFinVigencia = (Calendar)fechaInicioVigencia.clone();
            fechaFinVigencia.add(Calendar.DATE, 5);
            campaniaDTO.setFechaFinVigencia(fechaFinVigencia.getTime());
            campanias.add(campaniaDTO);
        }
        return campanias;
    }
    
}
