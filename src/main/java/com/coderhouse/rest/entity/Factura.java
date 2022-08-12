package com.coderhouse.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = " factura")
@AllArgsConstructor
@NoArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "fecha")
    private Date fecha;
    @Column (name = "tipoFactura")
    private String tipoFactura;
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name = "detalle_factura_ID")
    private DetalleFactura detalleFactura;
}
