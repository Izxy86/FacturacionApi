package com.coderhouse.rest.service;

import com.coderhouse.rest.dto.ClienteDto;
import com.coderhouse.rest.entity.Cliente;
import com.coderhouse.rest.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente getCliente(Long id) {

        Cliente clienteAObtener = clienteRepository.findById(id).orElseThrow(RuntimeException::new);
        return clienteAObtener;
    }

    public List<Cliente> traerClientes() {
        return clienteRepository.findAll();
    }

    public ClienteDto getClienteDto(Long id) {
        Cliente clienteAObtener = clienteRepository.findById(id).orElseThrow(RuntimeException::new);
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNombre(clienteAObtener.getNombre());
        return clienteDto;
    }

    public Cliente getClienteByDni(Cliente cliente){
        Optional<Cliente> buscarCliente= clienteRepository.findByDni(cliente.getDni());
        if (buscarCliente.isPresent())
        {
            log.info("Ya existe Cliente");
            return getCliente(cliente.getId());
        }else{
            log.info("Se guardó un nuevo Cliente");
            return clienteRepository.save(cliente);
        }
    }

    public Cliente guardarClienteEnLaBaseDeDatos(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente modificarClienteEnLaBaseDeDatos(Cliente cliente) {
        Cliente clienteModificado = clienteRepository.findById(cliente.getId()).get();
        clienteModificado.setNombre(cliente.getNombre());
        return clienteRepository.save(cliente);
    }

    public String borrarCliente(Long id){
        Cliente cliente = clienteRepository.findById(id).get();
        clienteRepository.deleteById(id);
        return "borraste a "+ cliente.getNombre();
    }


}
