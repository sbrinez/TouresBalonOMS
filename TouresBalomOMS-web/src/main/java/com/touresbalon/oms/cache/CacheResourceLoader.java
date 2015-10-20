package com.touresbalon.oms.cache;

import com.touresbalon.oms.menu.BarraMenusDTO;
import com.touresbalon.oms.menu.MenuDTO;
import com.touresbalon.oms.menu.MenuItemDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
     * Bloque de inicialización que permite cargar los menus de cada rol desde
     * el archivo de configuración XML
     */
    static {
        rolesMenus = new HashMap<String, BarraMenusDTO>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(FacesContext.getCurrentInstance().
                    getExternalContext().getResourceAsStream("/WEB-INF/MenusRoles.xml"));
            
            NodeList roles = doc.getElementsByTagName("Rol");
            for (int i=0 ; i < roles.getLength() ; i++) {
                Node rol = roles.item(i);
                //El 0 es el nodo de texto que no sirve pa nada en este caso
                Node menusNodo = rol.getChildNodes().item(1);
                if (menusNodo != null) {
                    BarraMenusDTO barraMenusDTO = new BarraMenusDTO();
                    NodeList menusNodeList = menusNodo.getChildNodes();
                    if (menusNodeList != null) {
                        List<MenuDTO> menusDTO = new ArrayList<MenuDTO>();
                        for (int j=0 ; j < menusNodeList.getLength() ; j++) {
                            Node menuNode = menusNodeList.item(j);
                            if (menuNode.getNodeType() != Node.ELEMENT_NODE) {
                                continue;
                            }
                            MenuDTO menuDTO = new MenuDTO();
                            menuDTO.setNombre(menuNode.getAttributes().getNamedItem("nombre").getTextContent());
                            NodeList menuItemNodes = menuNode.getChildNodes();
                            if (menuItemNodes != null) {
                                List<MenuItemDTO> menuItemsDTO = new ArrayList<MenuItemDTO>();
                                for (int k=0 ; k < menuItemNodes.getLength() ; k++) {
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
     * @return El mapa de roles con su respectiva barra de menús
     */
    public static Map<String, BarraMenusDTO> getRolesMenus() {
        return rolesMenus;
    } 
    
}
