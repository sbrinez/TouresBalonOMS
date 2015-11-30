package com.touresbalon.oms.proxy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.touresbalon.oms.model.CategoriaClienteEnum;
import com.touresbalon.oms.model.ClienteDTO;

/**
 *
 * @author SergioDavid
 */
public class ClientesProxy {
    
    private static ClientesProxy instance = new ClientesProxy();
    
    private ClientesProxy() {
    }
    
    public static ClientesProxy getInstance() {
        return instance;
    }    
    
    
    public List<ClienteDTO> consultarClientes() {
        List<ClienteDTO> clientes = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setCodigo(i+1);
            clienteDTO.setNumeroIdentificacion(Integer.toString(i+1));
            clienteDTO.setNombres("Pepito"+(i+1));            
            clienteDTO.setApellidos("Suarez"+(i+1));            
            clienteDTO.setEmail("pepito"+(i+1)+"@gmail.com");
            clienteDTO.setCategoria(CategoriaClienteEnum.DORADO.getDescripcion());
            clienteDTO.setCelular("64736247");
            clienteDTO.setDireccion("Cra 7 # 40-53");
            clienteDTO.setFechaUltimoAcceso(new Date());
            clientes.add(clienteDTO);
        }
        return clientes;
    }    
    
    public ClienteDTO consultarCliente(String numeroIdentificacion) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setCodigo(Integer.valueOf(numeroIdentificacion));
        clienteDTO.setNumeroIdentificacion(numeroIdentificacion);
        clienteDTO.setNombres("Juanito");            
        clienteDTO.setApellidos("Perez");            
        clienteDTO.setEmail("juanito@gmail.com");
        clienteDTO.setCategoria(CategoriaClienteEnum.PLATEADO.getDescripcion());
        clienteDTO.setCelular("31864736247");
        clienteDTO.setFechaUltimoAcceso(new Date());
        return clienteDTO;
    }    
    
}
