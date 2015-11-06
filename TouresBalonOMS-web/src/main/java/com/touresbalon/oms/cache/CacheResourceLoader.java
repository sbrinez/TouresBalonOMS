package com.touresbalon.oms.cache;

import java.util.Arrays;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.Drive;
import com.touresbalon.oms.menu.BarraMenusDTO;
import com.touresbalon.oms.menu.MenuDTO;
import com.touresbalon.oms.menu.MenuItemDTO;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Familia
 */
public class CacheResourceLoader {

    /**
     * Mapa de roles con su respectiva barra de menús
     */
    private final static Map<String, BarraMenusDTO> rolesMenus;

    /**
     * Mapa de roles con su respectiva barra de menús
     */
    private final static Drive drive;

    /**
     * Application name.
     */
    private static final String APPLICATION_NAME = "TouresBalon";

    /**
     * Global instance of the {@link FileDataStoreFactory}.
     */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    /**
     * Global instance of the HTTP transport.
     */
    private static HttpTransport HTTP_TRANSPORT;

    /**
     * Global instance of the scopes required by this quickstart.
     */
    private static final List<String> SCOPES = Arrays.asList(DriveScopes.DRIVE_METADATA_READONLY);

    /**
     * Bloque de inicialización que permite cargar los menus de cada rol desde
     * el archivo de configuración XML
     */
    static {
        rolesMenus = new HashMap<String, BarraMenusDTO>();
        cargarMenus();
        drive = cargarDatosAutenticacionGoogleAccount();
        if (drive != null) {
            System.out.println("Autenticacion a Drive cargada existosamente");
        }
    }

    private static void cargarMenus() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(FacesContext.getCurrentInstance().
                    getExternalContext().getResourceAsStream("/WEB-INF/MenusRoles.xml"));

            NodeList roles = doc.getElementsByTagName("Rol");
            for (int i = 0; i < roles.getLength(); i++) {
                Node rol = roles.item(i);
                //El 0 es el nodo de texto que no sirve pa nada en este caso
                Node menusNodo = rol.getChildNodes().item(1);
                if (menusNodo != null) {
                    BarraMenusDTO barraMenusDTO = new BarraMenusDTO();
                    NodeList menusNodeList = menusNodo.getChildNodes();
                    if (menusNodeList != null) {
                        List<MenuDTO> menusDTO = new ArrayList<MenuDTO>();
                        for (int j = 0; j < menusNodeList.getLength(); j++) {
                            Node menuNode = menusNodeList.item(j);
                            if (menuNode.getNodeType() != Node.ELEMENT_NODE) {
                                continue;
                            }
                            MenuDTO menuDTO = new MenuDTO();
                            menuDTO.setNombre(menuNode.getAttributes().getNamedItem("nombre").getTextContent());
                            NodeList menuItemNodes = menuNode.getChildNodes();
                            if (menuItemNodes != null) {
                                List<MenuItemDTO> menuItemsDTO = new ArrayList<MenuItemDTO>();
                                for (int k = 0; k < menuItemNodes.getLength(); k++) {
                                    Node menuItemNode = menuItemNodes.item(k);
                                    if (menuItemNode.getNodeType() != Node.ELEMENT_NODE) {
                                        continue;
                                    }
                                    MenuItemDTO menuItemDTO = new MenuItemDTO();
                                    menuItemDTO.setNombre(menuItemNode.getAttributes().getNamedItem("nombre").getTextContent());
                                    menuItemDTO.setUrlDestino(menuItemNode.getAttributes().getNamedItem("urlDestino").getTextContent());
                                    menuItemsDTO.add(menuItemDTO);
                                }
                                menuDTO.setItems(menuItemsDTO);
                            }
                            menusDTO.add(menuDTO);
                        }
                        barraMenusDTO.setMenus(menusDTO);
                    }
                    rolesMenus.put(rol.getAttributes().getNamedItem("nombre").getTextContent(), barraMenusDTO);
                }
            }
            System.out.println(roles.getLength());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo encargado de cargar la refrencia para el acceso a Google Drive
     */
    private static Drive cargarDatosAutenticacionGoogleAccount() {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(new File(
            System.getProperty("user.home"), ".credentials/googledrive-java"));
            // Load client secrets.
            InputStream in = CacheResourceLoader.class.getClassLoader().getResourceAsStream("client_secret.json");
            GoogleClientSecrets clientSecrets
                    = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
            
            // Build flow and trigger user authorization request.
            GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                    HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                    .setDataStoreFactory(DATA_STORE_FACTORY)
                    .setAccessType("offline").build();
            
            Credential credential = new AuthorizationCodeInstalledApp(
                    flow, new LocalServerReceiver()).authorize("user");
            
            return new Drive.Builder(
                    HTTP_TRANSPORT, JSON_FACTORY, credential)
                    .setApplicationName(APPLICATION_NAME).build();
        } catch (IOException ex) {
            Logger.getLogger(CacheResourceLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(CacheResourceLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @return El mapa de roles con su respectiva barra de menús
     */
    public static Map<String, BarraMenusDTO> getRolesMenus() {
        return rolesMenus;
    }

    /**
     * @return La referencia para el acceso a Google Drive
     */
    public static Drive getDriveService() {
        return drive;
    }    

}
