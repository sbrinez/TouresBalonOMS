package com.touresbalon.oms.action;

import com.touresbalon.oms.model.OrdenesPorMesDTO;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author SergioDavid
 */
@javax.faces.bean.ManagedBean(name = "ordenesPorMesAction")
@javax.faces.bean.ViewScoped
public class OrdenesPorMesAction extends AbstractAction implements Serializable {
    
    
    private List<OrdenesPorMesDTO> listaOrdenesPorMes;
    
    
    public OrdenesPorMesAction() {
        OrdenesPorMesDTO ordenesPorMesDTO = new OrdenesPorMesDTO();
        ordenesPorMesDTO.setMes("02/2015");
        ordenesPorMesDTO.setNumeroOrdenes(543);
        ordenesPorMesDTO.setTotalFactutado(new BigDecimal("647364000"));
        listaOrdenesPorMes = new java.util.ArrayList<>();
        listaOrdenesPorMes.add(ordenesPorMesDTO);
        //Hacer aqui la consulta para llenar la lista
    }

    /**
     * @return the listaOrdenesPorMes
     */
    public List<OrdenesPorMesDTO> getListaOrdenesPorMes() {
        return listaOrdenesPorMes;
    }

    /**
     * @param listaOrdenesPorMes the listaOrdenesPorMes to set
     */
    public void setListaOrdenesPorMes(List<OrdenesPorMesDTO> listaOrdenesPorMes) {
        this.listaOrdenesPorMes = listaOrdenesPorMes;
    }
    
    
}
