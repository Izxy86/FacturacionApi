package com.coderhouse.rest.service;

import com.coderhouse.rest.dto.ProductoDto;
import com.coderhouse.rest.entity.Producto;
import com.coderhouse.rest.exception.DbException;
import com.coderhouse.rest.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    ProductoRepository productoRepository;


    public Producto getProducto(Long id) {
        Producto productoAObtener = productoRepository.findById(id).orElseThrow(RuntimeException::new);
        return productoAObtener;
    }

    public List<Producto> traerProductos(){
        return productoRepository.findAll();
    }





    public List<Producto> restarStockList(List<Producto> productosList) {
        for (Producto producto : productosList) {
            Producto productoEnBusqueda = getProducto(producto.getId());
            int resta = productoEnBusqueda.getCantidad_en_Stock()-producto.getCantidad_en_Stock();
            if (resta > 0){
                productoEnBusqueda.setCantidad_en_Stock(resta);
            }
            else{
                throw new DbException("No hay mas productos de : "+ producto.getCantidad_en_Stock());
            }

        }
        productoRepository.saveAll(productosList);


        return productosList;
    }





    public Producto guardarProductoEnLaBaseDeDatos(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto modificarProductoEnLaBaseDeDatos(Producto producto) {
        Producto productoModificado = productoRepository.findById(producto.getId()).get();
        productoModificado.setNombre(producto.getNombre());
        return productoRepository.save(producto);
    }

    public String borrarProducto(Long id) {
        Producto producto = productoRepository.findById(id).get();
        productoRepository.deleteById(id);
        return "borrastes el producto"+ producto.getNombre();
    }


}
