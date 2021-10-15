package com.ayesa.crud.dto;

import lombok.Data;

@Data
public class ClienteSinIdDTO {

    String nombre;
    Integer tlf;

    public ClienteSinIdDTO(String n, Integer t){
        this.nombre = n;
        this.tlf = t;
    }

}
