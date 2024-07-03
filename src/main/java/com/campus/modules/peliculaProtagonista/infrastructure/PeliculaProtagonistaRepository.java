package com.campus.modules.peliculaProtagonista.infrastructure;

import java.util.List;
import java.util.Optional;

import com.campus.modules.peliculaProtagonista.domain.PeliculaProtagonista;

public interface PeliculaProtagonistaRepository {
    void save(PeliculaProtagonista peliculaProtagonista);

    void delete(int idPelicula, int idProtagonista);

    void update(PeliculaProtagonista peliculaProtagonista);

    Optional<PeliculaProtagonista> findById(int idPelicula, int idProtagonista);

    List<PeliculaProtagonista> findAll();

    List<PeliculaProtagonista> findByPelicula(int idPelicula);

}
