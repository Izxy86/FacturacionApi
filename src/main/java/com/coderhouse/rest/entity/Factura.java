package com.coderhouse.rest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column(name = "date")
    private LocalDate fecha;


    @Column(name="tipoFactura")
    private String tipofactura;

    @Column(name="total")
    private int total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    Cliente cliente;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "detalleFactura")
     private List<DetalleFactura> detalleFactura;










}
