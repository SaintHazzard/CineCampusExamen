package com.campus.modules.peliculas.infrastructure;

import java.util.List;

import com.campus.modules.peliculas.domain.Pelicula;

public interface PeliculaRepository {

  Pelicula save(Pelicula pelicula);

  void delete(Pelicula pelicula);

  Pelicula update(Pelicula pelicula);

  Pelicula findById(int id);

  List<Pelicula> findAll();

}
