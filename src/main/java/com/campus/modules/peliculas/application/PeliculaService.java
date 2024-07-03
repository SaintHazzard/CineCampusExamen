package com.campus.modules.peliculas.application;

import java.util.List;

import com.campus.modules.peliculas.adapter.out.PeliculaMySQLRepository;
import com.campus.modules.peliculas.domain.Pelicula;

public class PeliculaService {

  private PeliculaMySQLRepository peliculaMySQLRepository;

  private String url = "jdbc:mysql://127.0.0.1:3306/CampusCine";
  private String user = "campus2023";
  private String password = "campus2023";

  public PeliculaService() {
    this.peliculaMySQLRepository = new PeliculaMySQLRepository(url, user, password);
  }

  public void savePelicula(Pelicula pelicula) {
    peliculaMySQLRepository.save(pelicula);
  }

  public void updatePelicula(Pelicula pelicula) {
    peliculaMySQLRepository.update(pelicula);
  }

  public void deletePelicula(Pelicula pelicula) {
    peliculaMySQLRepository.delete(pelicula);
  }

  public Pelicula getPeliculaById(int id) {
    return peliculaMySQLRepository.findById(id);
  }

  public List<Pelicula> findAllPeliculas() {
    return peliculaMySQLRepository.findAll();
  }

}
