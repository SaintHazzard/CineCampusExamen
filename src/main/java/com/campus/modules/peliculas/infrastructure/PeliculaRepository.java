package com.campus.modules.peliculas.infrastructure;

import com.campus.modules.peliculas.domain.Pelicula;

public interface PeliculaRepository {

  Pelicula save(Pelicula pelicula);

  void delete(Pelicula pelicula);

}
