package com.coderhouse.rest.controller;

import com.coderhouse.rest.dto.ClienteDto;
import com.coderhouse.rest.entity.Cliente;
import com.coderhouse.rest.repository.ClienteRepository;
import com.coderhouse.rest.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteServiceImpl;

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/getCliente/{id}")
    public Cliente getCliente(@PathVariable(value = "id") Long id) {
        return clienteServiceImpl.getCliente(id);
    }

    @GetMapping("/traerClientes")
    public List<Cliente> getClientes() {
        return clienteServiceImpl.traerClientes();
    }



    @PostMapping("/postCliente")
    public Cliente guardarCliente(@Validated @RequestBody Cliente cliente) {
        return clienteServiceImpl.guardarClienteEnLaBaseDeDatos(cliente);
    }

    @PutMapping("/editarCliente")
    public Cliente modificarCliente(@RequestBody Cliente cliente){
        return clienteServiceImpl.modificarClienteEnLaBaseDeDatos(cliente);
    }

    @DeleteMapping("/borrarCliente/{id}")
    public String borrarCliente(@PathVariable("id") Long id){
       return clienteServiceImpl.borrarCliente(id);
    }

}
