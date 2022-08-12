package com.coderhouse.rest.controller;

import com.coderhouse.rest.dto.EmpresaDto;
import com.coderhouse.rest.entity.Empresa;
import com.coderhouse.rest.repository.EmpresaRepository;
import com.coderhouse.rest.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpresaController {

    @Autowired
    EmpresaService empresaServiceImpl;

    @Autowired
    EmpresaRepository empresaRepository;

    @GetMapping("/getEmpresa/{id}")
    public Empresa getEmpresa(@PathVariable(value="id")Long id){return empresaServiceImpl.getEmpresa(id);}

    @GetMapping("/getEmpresaDto/{id}")
    public EmpresaDto getEmpresaDto(@PathVariable(value="id")Long id){return empresaServiceImpl.getEmpresaDto(id);}

    @PostMapping("/postEmpresa")
    public Empresa guardarEmpresa(@RequestBody Empresa empresa){
        return empresaServiceImpl.guardarEmpresaEnLaBaseDeDatos(empresa);
    }

    @PutMapping("/editarEmpresa")
    public Empresa modificarEmpresa(@RequestBody Empresa empresa){
        return empresaServiceImpl.modificarEmpresaEnLaBaseDeDatos(empresa);
    }

    @DeleteMapping("/borrarEmpresa/{id}")
    public String borrarEmpresa(@PathVariable("id")Long id){return empresaServiceImpl.borrarEmpresa(id);}
}
