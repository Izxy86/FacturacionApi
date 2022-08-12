package com.coderhouse.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "empresa")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Empresa {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "rubro")
    private String rubro;
}
