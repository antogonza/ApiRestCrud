package com.ayesa.crud.dto;

import com.ayesa.crud.model.Cliente;
import lombok.Data;

import java.util.List;

@Data
public class ClienteListDTO {

    private Boolean errors;
    private List<Cliente> clientes;
    private String mensaje;

    public ClienteListDTO(Boolean e, List<Cliente> c, String m){
        this.errors = e;
        this.clientes = c;
        this.mensaje = m;
    }

}
