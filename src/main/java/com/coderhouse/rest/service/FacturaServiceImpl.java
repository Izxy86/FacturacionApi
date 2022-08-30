package com.coderhouse.rest.service;

import com.coderhouse.rest.dto.CompraDto;
import com.coderhouse.rest.entity.DetalleFactura;
import com.coderhouse.rest.entity.Factura;
import com.coderhouse.rest.repository.FacturaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    public Factura getFactura(Long id) {
        Factura facturaAObtener = facturaRepository.findById(id).orElseThrow(RuntimeException::new);
        return facturaAObtener;
    }


    public Factura guardarFacturaEnLaBaseDeDatos(Factura factura) {
        return facturaRepository.save(factura);
    }
    public List<Factura> traerFacturas(){return facturaRepository.findAll();}

    public Factura agregarDetalle (DetalleFactura detalleFactura){
        Factura factura= new Factura();
        factura.setDetalleFactura(detalleFactura);
        return facturaRepository.save(factura);
    }

}

