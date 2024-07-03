package com.campus.modules.tipoactor.application;

import java.util.List;
import java.util.Optional;

import com.campus.modules.tipoactor.adapter.out.TipoActorMySQLRepository;
import com.campus.modules.tipoactor.domain.Tipoactor;

public class TipoActorService {
    TipoActorMySQLRepository tipoactorMySQLRepository;

    public TipoActorService(TipoActorMySQLRepository tipoactorMySQLRepository) {
        this.tipoactorMySQLRepository = tipoactorMySQLRepository;
    }

    public void saveTipoactor(Tipoactor tipoactor){
        tipoactorMySQLRepository.save(tipoactor);
    }

    public void deleteTipoactor(int id){
        tipoactorMySQLRepository.delete(id);
    }

    public void updateTipoactor(Tipoactor tipoactor){
        tipoactorMySQLRepository.update(tipoactor);
    }
    
    public Optional<Tipoactor> findByIdTipoactor(int id){
        return tipoactorMySQLRepository.findById(id);
    }

    public List<Tipoactor> findAllTipoactor(){
        return tipoactorMySQLRepository.findAll();
    }
}
