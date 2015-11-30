package com.touresbalon.oms.action;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;

import com.touresbalon.oms.constant.ConstantesMensajesKey;
import com.touresbalon.oms.constant.ConstantesResourcesBundle;
import com.touresbalon.oms.model.CampaniaDTO;
import com.touresbalon.oms.proxy.CampaniasProxy;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Familia
 */
@javax.faces.bean.ManagedBean(name = "buscarCampaniasAction")
@javax.faces.bean.ViewScoped
public class BuscarCampaniasAction extends AbstractAction implements Serializable {
    
    
    private List<CampaniaDTO> listaCampanias;
    
    private CampaniaDTO campaniaSeleccionada;
    
    private boolean agregar;

    
    public BuscarCampaniasAction() {
        listaCampanias = CampaniasProxy.getInstance().consultarCampanias();
    }
    
    public void iniciarNuevaCampania() {
        System.out.println("Inicializando objeto para nueva campaña");
        campaniaSeleccionada = new CampaniaDTO();
        agregar = true;
    }
    
    public void iniciarActualizacionCampania(CampaniaDTO campaniaDTO) {
        System.out.println("Inicializando objeto para actualizacion de campaña");
        campaniaSeleccionada = campaniaDTO;
        agregar = false;
    }
    
    public void agregarCampania() {
        System.out.println("Agregando campaña");
        
        //Aqui llamar a servicio de entidad Campaña capacidad agergar
        RequestContext.getCurrentInstance().execute("PF('modalDetalle').hide()");
        listaCampanias.add(campaniaSeleccionada);
        campaniaSeleccionada = null;
    }
    
    public void actualizarCampania() {
        
        boolean exitoActualizacion = true;//Aqui llamar a servicio de entidad Campaña capacidad actualizar
        System.out.println("BuscarCampaniasAction.actualizarCampania() " +exitoActualizacion);
        
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
    
    public void eliminarCampania(CampaniaDTO campaniaDTO) {
        System.out.println("Eliminando campaña "+campaniaDTO.getCodigo());
        
        //Aqui llamar a servicio de entidad Campaña capacidad eliminar
        
        listaCampanias.remove(campaniaDTO);
        campaniaSeleccionada = null;
    }        

    /**
     * @return the listaCampanias
     */
    public List<CampaniaDTO> getListaCampanias() {
        return listaCampanias;
    }

    /**
     * @param listaCampanias the listaCampanias to set
     */
    public void setListaCampanias(List<CampaniaDTO> listaCampanias) {
        this.listaCampanias = listaCampanias;
    }

    /**
     * @return the campaniaSeleccionada
     */
    public CampaniaDTO getCampaniaSeleccionada() {
        return campaniaSeleccionada;
    }

    /**
     * @param campaniaSeleccionada the campaniaSeleccionada to set
     */
    public void setCampaniaSeleccionada(CampaniaDTO campaniaSeleccionada) {
        this.campaniaSeleccionada = campaniaSeleccionada;
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
    
}
