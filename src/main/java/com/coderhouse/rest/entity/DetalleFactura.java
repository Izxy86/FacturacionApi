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

   @Column(name = "nombre")
   private String nombre;

    @Column(name = "precio_unitario")
    private int precioUnitario;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidadDelProducto")
    private int cantidad;

    @Column(name = "subtotal")
    private int subtotal;


}
