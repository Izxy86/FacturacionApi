package com.coderhouse.rest.service;

import com.coderhouse.rest.dto.EmpresaDto;
import com.coderhouse.rest.entity.Empresa;

public interface EmpresaService {
    Empresa getEmpresa (Long id);

    EmpresaDto getEmpresaDto (long id);

    Empresa guardarEmpresaEnLaBaseDeDatos( Empresa empresa);

    Empresa modificarEmpresaEnLaBaseDeDatos (Empresa empresa);

    String borrarEmpresa (Long id);
}
