package com.campus.modules.formatos.application;

import java.util.List;

import com.campus.ConfiguracionProyecto;
import com.campus.modules.formatos.adapter.out.FormatoMySQLRepository;
import com.campus.modules.formatos.domain.Formato;

public class FormatoService {

  private FormatoMySQLRepository formatoMySQLRepository;

  String url = ConfiguracionProyecto.URL();
  String user = ConfiguracionProyecto.USER();
  String password = ConfiguracionProyecto.PASSWORD();

  public FormatoService() {
    this.formatoMySQLRepository = new FormatoMySQLRepository(url, user, password);
  }

  public void saveFormato(Formato formato) {
    formatoMySQLRepository.save(formato);
  }

  public void deleteFormato(Formato formato) {
    formatoMySQLRepository.delete(formato);
  }

  public void updateFormato(Formato formato) {
    formatoMySQLRepository.update(formato);
  }

  public Formato getFormatoById(int id) {
    return formatoMySQLRepository.findById(id);
  }

  public List<Formato> findAllFormatos() {
    return formatoMySQLRepository.findAll();
  }

}
