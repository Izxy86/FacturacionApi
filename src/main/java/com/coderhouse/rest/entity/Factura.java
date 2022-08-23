package com.coderhouse.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "factura")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name = "id")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DetalleFactura_id",referencedColumnName = "id")
    private Long id;

    @Column(name="fecha")
    private Date fecha;

    @Column(name="tipoFactura")
    private String tipofactura;

    @Column(name="total")
    private int total;
}
