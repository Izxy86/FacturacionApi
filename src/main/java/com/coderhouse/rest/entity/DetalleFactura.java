package com.coderhouse.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "detalle_factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleFactura {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private List<Producto> Productos;



}