package com.coderhouse.rest.service;

import com.coderhouse.rest.dto.ClienteDto;
import com.coderhouse.rest.entity.Cliente;
import com.coderhouse.rest.exception.DbException;

import java.util.List;

public interface ClienteService {

    Cliente getCliente(Long id);

    List<Cliente> traerClientes();


    Cliente guardarClienteEnLaBaseDeDatos(Cliente cliente);

    Cliente modificarClienteEnLaBaseDeDatos(Cliente cliente);

    String borrarCliente(Long id);





}
