package com.coderhouse.rest.service;


import com.coderhouse.rest.dto.EmpresaDto;
import com.coderhouse.rest.entity.Empresa;
import com.coderhouse.rest.repository.EmpresaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmpresaServiceImpl  implements EmpresaService{

    @Autowired
    EmpresaRepository empresaRepository;


    public Empresa getEmpresa(Long id) {
        Empresa empresaAObtener = empresaRepository.findById(id).orElseThrow(RuntimeException::new);
        return empresaAObtener;
    }

    public EmpresaDto getEmpresaDto(long id) {
        Empresa empresaAObtener= empresaRepository.findById(id).orElseThrow(RuntimeException::new);
        EmpresaDto empresaDto= new EmpresaDto();
        return empresaDto;
    }


    public Empresa guardarEmpresaEnLaBaseDeDatos(Empresa empresa){return empresaRepository.save(empresa);}

    public Empresa modificarEmpresaEnLaBaseDeDatos(Empresa empresa) {
        Empresa empresaModificado = empresaRepository.findById(empresa.getId()).get();
        empresaModificado.setNombre(empresa.getNombre());
        return empresaRepository.save(empresa);
    }

    public String borrarEmpresa(Long id){
        Empresa empresa= empresaRepository.findById(id).get();
        empresaRepository.deleteById(id);
        return "borrastes a "+empresa.getNombre();
    }


}
