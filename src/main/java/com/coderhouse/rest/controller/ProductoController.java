package com.coderhouse.rest.controller;

import com.coderhouse.rest.dto.CompraDto;
import com.coderhouse.rest.dto.ProductoDto;
import com.coderhouse.rest.entity.Producto;
import com.coderhouse.rest.repository.ProductoRepository;
import com.coderhouse.rest.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class ProductoController {

    @Autowired
    ProductoService productoServiceImpl;

    @Autowired
    ProductoRepository productoRepository;

    @GetMapping("/getProducto/{id}")
    public Producto getProducto(@PathVariable(value="id")Long id){
        return productoServiceImpl.getProducto(id);}

    @GetMapping("/traerProductos")
    public List<Producto> getProductos(){
        return productoServiceImpl.traerProductos();
    }

    @PostMapping("/postProducto")
    public Producto guardarProducto(@Validated @RequestBody Producto producto){
        return productoServiceImpl.guardarProductoEnLaBaseDeDatos(producto);
    }

    @PutMapping("/editarProducto")
    public Producto modificarProducto(@RequestBody Producto producto){
        return productoServiceImpl.modificarProductoEnLaBaseDeDatos(producto);
    }

    @PutMapping("/restarStock")
    public Producto restarStock(@RequestBody ProductoDto productoDto){
        return productoServiceImpl.restarStockBaseDeDatos(productoDto.getId(), productoDto.getCantidadARestar());
    }


    @DeleteMapping("/borrarProducto/{id}")
    public String borrarEmpresa(@PathVariable("id")Long id){
        return productoServiceImpl.borrarProducto(id);
    }
}
