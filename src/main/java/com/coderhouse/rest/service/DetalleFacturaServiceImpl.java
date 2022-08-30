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

@Service
@Slf4j
public class DetalleFacturaServiceImpl implements DetalleFacturaService {
    @Autowired
    ClienteService clienteService;

    @Autowired
    ProductoService productoService;

    @Autowired
    EmpresaService empresaService;

    @Autowired
    FacturaService facturaService;

    @Autowired
    DetalleFacturaRepository detalleFacturaRepository;

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    ProductoRepository productoRepository;


}
