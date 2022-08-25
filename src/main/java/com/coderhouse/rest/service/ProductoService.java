package com.coderhouse.rest.service;


import com.coderhouse.rest.dto.ProductoDto;
import com.coderhouse.rest.entity.Producto;
import com.coderhouse.rest.exception.DbException;

import java.util.List;


public interface ProductoService {

    Producto getProducto(Long id);

    Producto guardarProductoEnLaBaseDeDatos(Producto producto);

    Producto modificarProductoEnLaBaseDeDatos(Producto producto);

    String borrarProducto(Long id);

    List<Producto> traerProductos();


    public List<Producto> restarStockList(List<Producto> productosList);




}
