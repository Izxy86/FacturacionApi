package com.coderhouse.rest.service;

import com.coderhouse.rest.dto.ClienteDto;
import com.coderhouse.rest.dto.ProductoDto;
import com.coderhouse.rest.entity.Cliente;
import com.coderhouse.rest.entity.Producto;
import com.coderhouse.rest.exception.DbException;
import com.coderhouse.rest.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;


    public Producto getProducto(Long id) {
        Producto productoAObtener = productoRepository.findById(id).orElseThrow(RuntimeException::new);
        return productoAObtener;
    }

    public List<Producto> traerProductos(){
        return productoRepository.findAll();
    }


    public ProductoDto getProductoDto(Long id) {
        Producto productoAObtener = productoRepository.findById(id).orElseThrow(RuntimeException::new);
        ProductoDto productoDto = new ProductoDto();
        productoDto.setNombre(productoAObtener.getNombre());
        return productoDto;
    }


    public Producto guardarProductoEnLaBaseDeDatos(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto modificarStockProducto(Producto producto){
        Producto productomodificado = productoRepository.findById(producto.getId()).get();
        productomodificado.setCantidad_en_Stock(producto.getCantidad_en_Stock());
        return productoRepository.save(productomodificado);
    }


    public Producto modificarProductoEnLaBaseDeDatos(com.coderhouse.rest.entity.Producto producto) {
        com.coderhouse.rest.entity.Producto productoModificado = productoRepository.findById(producto.getId()).get();
        productoModificado.setNombre(producto.getNombre());
        return productoRepository.save(producto);
    }

    public Producto restarStockBaseDeDatos(Long id, int cantADescontar){
        Producto stockArticulo = productoRepository.findById(id).get();
        int Total;
        int cantParaDescontar;
        int cantStockInicial;
        cantStockInicial = stockArticulo.getCantidad_en_Stock();
        cantParaDescontar= cantADescontar;
        Total =  cantStockInicial - cantParaDescontar;

        int stock = stockArticulo.getCantidad_en_Stock();

        if (Total > 0){
            stockArticulo.setCantidad_en_Stock(Total);
            productoRepository.save(stockArticulo);
        }
        else{
            throw new DbException("No hay más productos de : "+ stockArticulo.getNombre());
        }
        return stockArticulo;
    }



    public String borrarProducto(Long id) {
        com.coderhouse.rest.entity.Producto producto = productoRepository.findById(id).get();
        productoRepository.deleteById(id);
        return "borrastes el producto"+ producto.getNombre();
    }


}
