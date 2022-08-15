package com.coderhouse.rest.controller;

import com.coderhouse.rest.dto.ProductoDto;
import com.coderhouse.rest.entity.Producto;
import com.coderhouse.rest.repository.ProductoRepository;
import com.coderhouse.rest.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ProductoDto restarStock(@RequestBody ProductoDto productoDto){
        long productoid= productoDto.getId();
        int productoARestar= productoDto.getRestarStock();
        if (productoServiceImpl.getProducto(productoid).getCantidad_en_Stock()< productoARestar){
            log.info("Stock insuficiente"+productoServiceImpl.getProducto(productoid).getCantidad_en_Stock());
        } else{
            productoDto.setRestarStock(productoARestar);

        }
        return productoDto;
    }

    @PutMapping("/restarStockList")
    public List<Producto> restarStockList(@RequestBody List<Producto> productos){
        return productoServiceImpl.restarStockList(productos);
    }



    @DeleteMapping("/borrarProducto/{id}")
    public String borrarEmpresa(@PathVariable("id")Long id){
        return productoServiceImpl.borrarProducto(id);
    }
}
