package com.campus.modules.formatos.application;

import java.util.List;

import com.campus.modules.formatos.adapter.out.FormatoMySQLRepository;
import com.campus.modules.formatos.domain.Formato;

public class FormatoService {

  private FormatoMySQLRepository formatoMySQLRepository;

  private String url = "jdbc:mysql://127.0.0.1:3306/CampusCine";
  private String user = "campus2023";
  private String password = "campus2023";

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
