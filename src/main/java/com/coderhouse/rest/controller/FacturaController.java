package com.coderhouse.rest.controller;

import com.coderhouse.rest.dto.CompraDto;
import com.coderhouse.rest.entity.Factura;
import com.coderhouse.rest.repository.FacturaRepository;
import com.coderhouse.rest.service.DetalleFacturaService;
import com.coderhouse.rest.service.DetalleFacturaServiceImpl;
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


    @PutMapping("/nuevaCompra")
    public Factura nuevaCompra(@RequestBody CompraDto compraDto){return facturaServiceImpl.nuevaCompra(compraDto);}

    @GetMapping("/facturaPorCliente/{id}")
    public List<Factura> facturasPorCliente(@PathVariable(value = "id")Long id){return facturaServiceImpl.facturasCliente(id);}



}
