package com.coderhouse.rest.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "nombre")
    @NotBlank
    private String nombre;

    @Column (name = "descripcion")
    @NotBlank
    private String descripcion;

    @Column (name = "precio")
    @NotBlank
    private int precio;

    @Column (name = "Cantidad_en_Stock")
    private int Cantidad_en_Stock;
}
