package com.campus.modules.tipoactor.application;

import java.util.List;
import java.util.Optional;

import com.campus.ConfiguracionProyecto;
import com.campus.modules.tipoactor.adapter.out.TipoActorMySQLRepository;
import com.campus.modules.tipoactor.domain.Tipoactor;
import com.campus.modules.tipoactor.infrastructure.TipoActorRepository;

public class TipoActorService {
    TipoActorRepository tipoActorRepository;

    private String url = ConfiguracionProyecto.URL();
    private String user = ConfiguracionProyecto.USER();
    private String password = ConfiguracionProyecto.PASSWORD();

    public TipoActorService() {
        this.tipoActorRepository = new TipoActorMySQLRepository(url, user, password);
    }

    public TipoActorService(TipoActorRepository tipoActorRepository) {
        this.tipoActorRepository = tipoActorRepository;
    }

    public void saveTipoactor(Tipoactor tipoactor) {
        tipoActorRepository.save(tipoactor);
    }

    public void deleteTipoactor(int id) {
        tipoActorRepository.delete(id);
    }

    public void updateTipoactor(Tipoactor tipoactor) {
        tipoActorRepository.update(tipoactor);
    }

    public Optional<Tipoactor> getByTipoActorId(int id) {
        return tipoActorRepository.findById(id);
    }

    public List<Tipoactor> findAllTipoactor() {
        return tipoActorRepository.findAll();
    }
}
