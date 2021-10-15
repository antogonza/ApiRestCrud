package com.ayesa.crud.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    Integer tlf;

    public Cliente() {
        this.id = null;
        this.nombre = "";
        this.tlf = null;
    }

    public Cliente(Long id, String nombre, Integer tlf){
        this.id = id;
        this.nombre = nombre;
        this.tlf = tlf;
    }
}
