package com.campus.modules.paises.infrastructure;

import java.util.List;
import java.util.Optional;
import com.campus.modules.paises.domain.Pais;

public interface PaisRepository {
    void save(Pais pais);
    void delete(int id);
    void update(Pais pais);
    Optional<Pais> findById(int id);
    List<Pais> findAll();
    
}
