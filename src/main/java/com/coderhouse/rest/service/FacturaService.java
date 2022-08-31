package com.coderhouse.rest.service;

import com.coderhouse.rest.dto.CompraDto;
import com.coderhouse.rest.entity.DetalleFactura;
import com.coderhouse.rest.entity.Factura;

import java.util.List;

public interface FacturaService {

    Factura getFactura(Long id);

    Factura guardarFacturaEnLaBaseDeDatos(Factura factura);

    List<Factura> traerFacturas();

    Factura nuevaCompra(CompraDto compraDto);

   Factura saveFactura(Factura factura);

    List<Factura> facturasCliente(Long idCliente);



}
