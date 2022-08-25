package com.coderhouse.rest.controller;

import com.coderhouse.rest.entity.Factura;
import com.coderhouse.rest.repository.FacturaRepository;
import com.coderhouse.rest.service.FacturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class FacturaController {

    @Autowired
    FacturaService facturaServiceImpl;

    @GetMapping("/getFactura/{id}")
    public Factura getFactura(@PathVariable(value="id")Long id){
        return facturaServiceImpl.getFactura(id);
    }

    @GetMapping("/traerFacturas")
    public List<Factura> getFacturas(){return facturaServiceImpl.traerFacturas();}

    @PostMapping("/postFactura")
    public Factura guardarFactura(@Validated @RequestBody Factura factura){
        return facturaServiceImpl.guardarFacturaEnLaBaseDeDatos(factura);
    }

}
