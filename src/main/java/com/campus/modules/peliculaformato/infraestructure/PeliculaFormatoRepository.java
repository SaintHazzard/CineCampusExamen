package com.campus.modules.peliculaformato.infraestructure;

import java.util.List;

import com.campus.modules.peliculaformato.domain.PeliculaFormato;

public interface PeliculaFormatoRepository {

  PeliculaFormato save(PeliculaFormato peliculaFormato);

  PeliculaFormato update(PeliculaFormato peliculaFormato);

  void delete(int idPelicula, int idFormato);

  PeliculaFormato findById(int idPelicula);

  List<PeliculaFormato> findAll();

}
