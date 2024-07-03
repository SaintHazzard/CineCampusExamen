package com.campus.modules.generos.infrastructure;

import java.util.List;
import java.util.Optional;
import com.campus.modules.actores.domain.Actor;
import com.campus.modules.generos.domain.Genero;

public interface GeneroRepository {
    
    void save(Genero genero);
    void delete(int id);
    void update(Genero genero);
    Optional<Genero> findById(int id);
    List<Genero> findAll();
}
