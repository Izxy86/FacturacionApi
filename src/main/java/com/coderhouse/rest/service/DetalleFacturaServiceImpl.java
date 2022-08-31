package com.coderhouse.rest.service;


import com.coderhouse.rest.dto.ProductoDto;
import com.coderhouse.rest.entity.Cliente;
import com.coderhouse.rest.entity.DetalleFactura;
import com.coderhouse.rest.entity.Factura;
import com.coderhouse.rest.entity.Producto;
import com.coderhouse.rest.exception.DbException;
import com.coderhouse.rest.repository.DetalleFacturaRepository;
import com.coderhouse.rest.repository.FacturaRepository;
import com.coderhouse.rest.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DetalleFacturaServiceImpl implements DetalleFacturaService {
    @Autowired
    ClienteService clienteService;

    @Autowired
    ProductoService productoService;

    @Autowired
    DetalleFacturaRepository detalleFacturaRepository;

    public DetalleFactura agregarProductos( ProductoDto productoDto){
        DetalleFactura detalleFactura= new DetalleFactura();
        Producto producto= productoService.getProducto(productoDto.getId());
        detalleFactura.setNombre(producto.getNombre());
        detalleFactura.setPrecioUnitario(producto.getPrecio());
        detalleFactura.setCantidad(productoDto.getCantidadARestar());
        detalleFactura.setDescripcion(producto.getDescripcion());
        detalleFactura.setSubtotal(detalleFactura.getCantidad() * producto.getPrecio());

        return detalleFactura;
    }




}
