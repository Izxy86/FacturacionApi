package com.coderhouse.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

    private String nombre;

    private String apellido;

    private String dni;

    private String direccion;

    private String email;

}
