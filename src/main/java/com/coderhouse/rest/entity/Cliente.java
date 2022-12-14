package com.coderhouse.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")

    private String nombre;

    @Column (name = "apellido")

    private String apellido;

    @Column(name= "dni")

    private String dni;

    @Column (name= "direccion")
    private String direccion;

    @Column(name = "email")
    private String email;


}