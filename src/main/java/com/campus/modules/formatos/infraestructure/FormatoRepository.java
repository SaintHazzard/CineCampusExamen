package com.campus.modules.formatos.infraestructure;

import java.util.List;

import com.campus.modules.formatos.domain.Formato;

public interface FormatoRepository {

  Formato save(Formato formato);

  void delete(Formato formato);

  Formato update(Formato formato);

  Formato findById(int idFormato);

  List<Formato> findAll();

}
