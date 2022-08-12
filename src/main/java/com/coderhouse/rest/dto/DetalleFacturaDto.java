package com.coderhouse.rest.dto;


import com.coderhouse.rest.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleFacturaDto {

    private List<Producto> productosList;
}
