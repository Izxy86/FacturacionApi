package com.coderhouse.rest.service;


import com.coderhouse.rest.dto.ProductoDto;
import com.coderhouse.rest.entity.Producto;

import java.util.List;


public interface ProductoService {

    com.coderhouse.rest.entity.Producto getProducto(Long id);

    com.coderhouse.rest.entity.Producto guardarProductoEnLaBaseDeDatos(com.coderhouse.rest.entity.Producto producto);

    com.coderhouse.rest.entity.Producto modificarProductoEnLaBaseDeDatos(com.coderhouse.rest.entity.Producto producto);

    String borrarProducto(Long id);

    List<com.coderhouse.rest.entity.Producto> traerProductos();

    ProductoDto getProductoDto(Long id);

    Producto modificarStockProducto(Producto producto);

    Producto restarStockBaseDeDatos(Long id, int cantADescontar);





}
