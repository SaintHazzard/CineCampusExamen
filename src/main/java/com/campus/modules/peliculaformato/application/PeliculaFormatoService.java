package com.campus.modules.peliculaformato.application;

import java.util.List;

import com.campus.modules.peliculaformato.adapter.out.MySQLPeliculaFormatoRepository;
import com.campus.modules.peliculaformato.domain.PeliculaFormato;
import com.campus.modules.peliculaformato.infraestructure.PeliculaFormatoRepository;

public class PeliculaFormatoService {

  private PeliculaFormatoRepository peliculaFormatoRepository;

  String url = "jdbc:mysql://localhost:3306/cinecampus";
  String user = "root";
  String password = "123456";

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
