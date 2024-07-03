package com.campus.modules.paises.application;

import java.util.List;
import java.util.Optional;

import com.campus.modules.paises.adapter.out.PaisMySQLRepository;
import com.campus.modules.paises.domain.Pais;

public class PaisService {
    PaisMySQLRepository paisMySQLRepository;

    public PaisService(PaisMySQLRepository paisMySQLRepository) {
        this.paisMySQLRepository = paisMySQLRepository;
    }

    public void savePais(Pais pais){
        paisMySQLRepository.save(pais);
    }

    public void deletePais(int id){
        paisMySQLRepository.delete(id);
    }

    public void updatePais(Pais pais){
        paisMySQLRepository.update(pais);
    }
    
    public Optional<Pais> findByIdPais(int id){
        return paisMySQLRepository.findById(id);
    }

    public List<Pais> findAllPais(){
        return paisMySQLRepository.findAll();
    }
    
}
