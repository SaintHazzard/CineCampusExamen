package com.campus.modules.tipoactor.infrastructure;

import java.util.List;
import java.util.Optional;
import com.campus.modules.tipoactor.domain.Tipoactor;


public interface TipoActorRepository {
    void save(Tipoactor tipoActor);
    void delete(int id);
    void update(Tipoactor tipoActor);
    Optional<Tipoactor> findById(int id);
    List<Tipoactor> findAll();
}
