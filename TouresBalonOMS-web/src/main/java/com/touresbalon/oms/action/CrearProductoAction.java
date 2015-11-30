package com.touresbalon.oms.action;

import com.touresbalon.oms.constant.ConstantesAppWeb;
import com.touresbalon.oms.drive.DriveManager;
import java.io.Serializable;

//import javax.enterprise.context.RequestScoped;
//import javax.inject.Named;
import com.touresbalon.oms.model.ProductoDTO;
import com.touresbalon.oms.proxy.ProductosProxy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author SergioDavid
 */
@javax.faces.bean.ManagedBean(name = "crearProductoAction")
@javax.faces.bean.ViewScoped
public class CrearProductoAction extends AbstractAction implements Serializable {
    

    private ProductoDTO producto = new ProductoDTO();

    private UploadedFile archivoImagen;
    

    public CrearProductoAction() {
        System.out.println("Constructor CrearProductosAction");
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Cargue exitoso", "El archivo "
                + event.getFile().getFileName() + " ha sido cargado correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        if (archivoImagen != null) {
            //Si ya se ha cargado antes un archivo se elimina del directorio temporal
            File archivo = new File(ConstantesAppWeb.DIRECTORIO_TEMP_CARGUE_ARCHIVOS + archivoImagen.getFileName());
            archivo.delete();
        }
        archivoImagen = event.getFile();
        try {
            guardarArchivo(archivoImagen.getFileName(), archivoImagen.getInputstream());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private void guardarArchivo(String fileName, InputStream in) {
        try {
            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(ConstantesAppWeb.DIRECTORIO_TEMP_CARGUE_ARCHIVOS + fileName));
            int read;
            byte[] bytes = new byte[4096];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            System.out.println("Archivo guardado temporalmente en directorio local");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void agregarProducto() {
        System.out.println("Agregando producto");
        //Primero se debe guardar el archivo en base de datos y recuperar el id
        //Despues usar el id para enviar el nombre al metodo DriveManager.subirArchivo
        Integer idProducto = 1;
        if (archivoImagen != null) {
            System.out.println(archivoImagen.getFileName());
            File archivo = new File(ConstantesAppWeb.DIRECTORIO_TEMP_CARGUE_ARCHIVOS + archivoImagen.getFileName());
            DriveManager.subirArchivo(idProducto, archivo, archivoImagen.getContentType());
            archivo.delete();
            producto = new ProductoDTO();
            archivoImagen = null;
        }

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
     * @return the producto
     */
    public ProductoDTO getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

}
