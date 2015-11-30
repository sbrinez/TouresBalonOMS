package com.touresbalon.oms.drive;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.ParentReference;
import com.touresbalon.oms.cache.CacheResourceLoader;
import com.touresbalon.oms.constant.ConstantesAppWeb;

/**
 *
 * @author sbrinez
 */
public class DriveManager {
    
    
    public static String subirArchivo(Integer idProducto, File archivo, String tipoArchivo) {

        try {
            Drive driveService = CacheResourceLoader.getDriveService();
            com.google.api.services.drive.model.File body = new com.google.api.services.drive.model.File();
            body.setTitle(idProducto.toString());
            body.setDescription(idProducto.toString());
            body.setMimeType(tipoArchivo);

            // Set the parent folder.
            body.setParents(Arrays.asList(new ParentReference().setId(ConstantesAppWeb.ID_DIRECTORIO_IMAGENES_DRIVE)));

            // File's content.
            FileContent mediaContent = new FileContent(tipoArchivo, archivo);            
            com.google.api.services.drive.model.File file = driveService.files().insert(body, mediaContent).execute();
            System.out.println("File ID: " + file.getId());
            System.out.println("File link: " + file.getWebContentLink());
            return file.getWebContentLink();
        } catch (IOException e) {
            System.out.println("An error occured: " + e);
            return null;
        }   
    }
    
}
