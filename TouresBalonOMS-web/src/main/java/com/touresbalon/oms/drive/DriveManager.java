package com.touresbalon.oms.drive;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.ParentReference;
import com.touresbalon.oms.cache.CacheResourceLoader;

/**
 *
 * @author sbrinez
 */
public class DriveManager {
    
    
    public String subirArchivo(Long idProducto, File archivo) {
        
        Drive driveService = CacheResourceLoader.getDriveService();
        com.google.api.services.drive.model.File body = new com.google.api.services.drive.model.File();
        body.setTitle(idProducto.toString());
        body.setDescription(idProducto.toString());
        body.setMimeType("image/png");

        // Set the parent folder.
//        if (parentId != null && parentId.length() > 0) {
//            body.setParents(Arrays.asList(new ParentReference().setId(parentId)));
//        }

        // File's content.
        FileContent mediaContent = new FileContent("image/png", archivo);
        try {
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
