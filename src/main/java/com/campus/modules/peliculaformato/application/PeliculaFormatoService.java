package com.campus.modules.peliculaformato.application;

import java.util.List;

import com.campus.modules.peliculaformato.adapter.out.MySQLPeliculaFormatoRepository;
import com.campus.modules.peliculaformato.domain.PeliculaFormato;
import com.campus.modules.peliculaformato.infraestructure.PeliculaFormatoRepository;

public class PeliculaFormatoService {

  private PeliculaFormatoRepository peliculaFormatoRepository;

  private String url = "jdbc:mysql://127.0.0.1:3306/CampusCine";
  private String user = "campus2023";
  private String password = "campus2023";

  public PeliculaFormatoService() {
    this.peliculaFormatoRepository = new MySQLPeliculaFormatoRepository(url, user, password);
  }

  public void savePeliculaFormato(PeliculaFormato peliculaFormato) {
    peliculaFormatoRepository.save(peliculaFormato);
  }

  public void deletePeliculaFormato(PeliculaFormato peliculaFormato) {
    peliculaFormatoRepository.delete(peliculaFormato.getIdPelicula(), peliculaFormato.getIdFormato());
  }

  public void updatePeliculaFormato(PeliculaFormato peliculaFormato) {
    peliculaFormatoRepository.update(peliculaFormato);
  }

  public PeliculaFormato getPeliculaFormatoById(int idPelicula) {
    return peliculaFormatoRepository.findById(idPelicula);
  }

  public List<PeliculaFormato> findAllPeliculaFormatos() {
    return peliculaFormatoRepository.findAll();
  }

}
