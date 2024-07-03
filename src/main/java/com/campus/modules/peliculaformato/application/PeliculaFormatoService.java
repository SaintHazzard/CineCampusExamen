package com.campus.modules.peliculaformato.application;

import java.util.List;

import com.campus.ConfiguracionProyecto;
import com.campus.modules.peliculaformato.adapter.out.MySQLPeliculaFormatoRepository;
import com.campus.modules.peliculaformato.domain.PeliculaFormato;
import com.campus.modules.peliculaformato.infraestructure.PeliculaFormatoRepository;

public class PeliculaFormatoService {

  private PeliculaFormatoRepository peliculaFormatoRepository;

  String url = ConfiguracionProyecto.URL();
  String user = ConfiguracionProyecto.USER();
  String password = ConfiguracionProyecto.PASSWORD();

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

  public PeliculaFormato getPeliculaFormatoById(int idPelicula, int idFormato) {
    return peliculaFormatoRepository.findById(idPelicula, idFormato);

  }
}
