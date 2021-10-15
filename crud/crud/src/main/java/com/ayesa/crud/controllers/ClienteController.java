package com.ayesa.crud.controllers;

import com.ayesa.crud.dto.ClienteDTO;
import com.ayesa.crud.dto.ClienteListDTO;
import com.ayesa.crud.dto.ClienteSinIdDTO;
import com.ayesa.crud.model.Cliente;
import com.ayesa.crud.services.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ClienteController {

    @Autowired
    ClienteServicio servicio;

    @GetMapping("/v1/clientes")
    public ClienteListDTO getAll() {
        try {
            List<Cliente> clientes = servicio.findAll();
            return new ClienteListDTO(null, clientes, "");
        } catch (Exception e) {
            return new ClienteListDTO(true, null, "Ha habido un error: " + e.getMessage());
        }
    }

    @PostMapping("v1/cliente")
    public ClienteDTO save(@RequestBody ClienteSinIdDTO newCliente) {
        Cliente cliente = null;
        try {
            cliente = servicio.save(newCliente);
            return new ClienteDTO(false, cliente, "");
        } catch (Exception e) {
            return new ClienteDTO(true, null, "Ha habido un error: " + e.getMessage());
        }
    }

    @GetMapping("/v1/cliente/{id}")
    public ClienteDTO getByID(@PathVariable Long id){
        try {
            Cliente cliente = servicio.findById(id).get();
            return new ClienteDTO(false, cliente, "");
        }catch (NoSuchElementException e){
            return new ClienteDTO(true, null, "Ha habido un error: " + e.getMessage());
        }
    }

    @PutMapping("/v1/cliente/{id}")
    public ClienteDTO updateById(
            @PathVariable Long id,
            @RequestBody Cliente modifiedCliente){
        try {
            Cliente cliente= servicio.findById(id).get();
            cliente.setNombre(modifiedCliente.getNombre());
            cliente.setTlf(modifiedCliente.getTlf());
            servicio.update(cliente);
            return new ClienteDTO(false, cliente, "");
        }catch (NoSuchElementException e){
            return new ClienteDTO(true, null, "Ha habido un error: " + e.getMessage());
        }
    }
    @DeleteMapping("/v1/cliente/{id}")
    public ClienteDTO deleteByID(@PathVariable Long id){
        try {
            Cliente cliente= servicio.findById(id).get();
            servicio.deleteById(id);
            return new ClienteDTO(false, cliente, "");
        }catch (NoSuchElementException e){
            return new ClienteDTO(true, null, "Ha habido un error: " + e.getMessage());
        }
    }

}
