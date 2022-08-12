package com.coderhouse.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductoDto  {
    Long id;
    String nombre;
    int cantidad;
    int restarStock;
}
