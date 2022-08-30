package com.coderhouse.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDto {
    private String tipoFactura;
    private int total;
    EmpresaDto empresaDto;
    ClienteDto clienteDto;

}
