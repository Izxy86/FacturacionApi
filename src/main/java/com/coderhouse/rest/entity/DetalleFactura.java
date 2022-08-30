package com.coderhouse.rest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DETALLE_FACTURA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne(cascade = {CascadeType.MERGE})

    Producto producto;

    @Column(name = "subtotal")
    private int subtotal;


}
