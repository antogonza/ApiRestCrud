package com.ayesa.crud.services;

import com.ayesa.crud.dto.ClienteSinIdDTO;
import com.ayesa.crud.model.Cliente;
import com.ayesa.crud.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepository repo;

    public List<Cliente> findAll() {
        return repo.findAll();
    }

    public Cliente save(ClienteSinIdDTO cliente) {
        return repo.save(new Cliente(null, cliente.getNombre(), cliente.getTlf()));
    }

    public Optional<Cliente> findById(Long id){
        return repo.findById(id);
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }

    public Cliente update(Cliente cliente) {
        return repo.save(cliente);
    }

}
