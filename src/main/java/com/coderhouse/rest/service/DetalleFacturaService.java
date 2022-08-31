package com.coderhouse.rest.service;

import com.coderhouse.rest.dto.CompraDto;
import com.coderhouse.rest.dto.ProductoDto;
import com.coderhouse.rest.entity.DetalleFactura;
import com.coderhouse.rest.entity.Factura;
import com.coderhouse.rest.entity.Producto;

import java.util.List;

public interface DetalleFacturaService {
    DetalleFactura agregarProductos( ProductoDto productoDto);

}