package com.coderhouse.rest.service;


import com.coderhouse.rest.dto.ProductoDto;
import com.coderhouse.rest.entity.Producto;

import java.util.List;


public interface ProductoService {

    Producto getProducto(Long id);

    Producto guardarProductoEnLaBaseDeDatos(Producto producto);

    Producto modificarProductoEnLaBaseDeDatos(Producto producto);

    String borrarProducto(Long id);

    List<Producto> traerProductos();

    ProductoDto restarStock(ProductoDto productoDto);



}
