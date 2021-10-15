package com.ayesa.crud.dto;

import com.ayesa.crud.model.Cliente;
import lombok.Data;

@Data
public class ClienteDTO {

    private boolean errors;
    private Cliente cliente;
    private String mensaje;

    public ClienteDTO(Boolean e, Cliente c, String m) {
        this.errors = e;
        this.cliente = c;
        this.mensaje = m;
    }
}
