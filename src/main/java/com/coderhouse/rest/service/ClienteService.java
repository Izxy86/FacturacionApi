package com.coderhouse.rest.service;

import com.coderhouse.rest.dto.ClienteDto;
import com.coderhouse.rest.entity.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente getCliente(Long id);

    List<Cliente> traerClientes();

    ClienteDto getClienteDto(Long id);

    Cliente guardarClienteEnLaBaseDeDatos(Cliente cliente);

    Cliente modificarClienteEnLaBaseDeDatos(Cliente cliente);

    String borrarCliente(Long id);

    Cliente getClienteByDni(Cliente cliente);



}
