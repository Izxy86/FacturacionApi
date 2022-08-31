package com.coderhouse.rest.service;

import com.coderhouse.rest.dto.CompraDto;
import com.coderhouse.rest.dto.ProductoDto;
import com.coderhouse.rest.entity.Cliente;
import com.coderhouse.rest.entity.DetalleFactura;
import com.coderhouse.rest.entity.Factura;
import com.coderhouse.rest.entity.Producto;
import com.coderhouse.rest.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    ClienteRepository  clienteRepository;

    @Autowired
    DetalleFacturaRepository detalleFacturaRepository;

    @Autowired
    ClienteService clienteService;

    @Autowired
    ProductoService productoService;

    @Autowired
    DetalleFacturaService detalleFacturaService;

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    EmpresaService empresaService;

    @Autowired
    EmpresaRepository empresaRepository;

    public Factura getFactura(Long id) {
        Factura facturaAObtener = facturaRepository.findById(id).orElseThrow(RuntimeException::new);
        return facturaAObtener;
    }

    public Factura saveFactura(Factura factura){
        return facturaRepository.save(factura);
    }


    public Factura guardarFacturaEnLaBaseDeDatos(Factura factura) {
        return facturaRepository.save(factura);
    }
    public List<Factura> traerFacturas(){return facturaRepository.findAll();}

    public Factura nuevaCompra(CompraDto compraDto){
        Factura factura= new Factura();
        Cliente cliente= clienteService.getCliente(compraDto.getClienteDto().getId());
        clienteService.getClienteByDni(cliente);
        factura.setCliente(cliente);

        List<DetalleFactura> detalleFacturaList= new ArrayList<>();
        List<Producto>productosList= new ArrayList<>();

        for (ProductoDto productoDto : compraDto.getProductoDtoList()) {
            Producto producto= productoService.getProducto(productoDto.getId());
            productosList.add(producto);
            detalleFacturaList.add(detalleFacturaService.agregarProductos(productoDto));
            productoService.restarStockBaseDeDatos(productoDto.getId(),productoDto.getCantidadARestar());
        }
        detalleFacturaRepository.saveAll(detalleFacturaList);
        int aux=0;
        for (DetalleFactura detalleFactura : detalleFacturaList) {
           aux = aux + detalleFactura.getSubtotal();
        }



        factura.setTipofactura("B");

        factura.setFecha(LocalDate.now());
        factura.setTotal(aux);
        factura.setDetalleFactura(detalleFacturaList);


        factura.setEmpresa(empresaService.getEmpresa(1L));
        factura.setCliente(clienteService.getCliente(cliente.getId()));

        facturaRepository.save(factura);

        return factura;

    }







}

