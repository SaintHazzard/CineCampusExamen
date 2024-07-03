package com.campus.modules.formatos.infraestructure;

import com.campus.modules.formatos.domain.Formato;

public interface FormatoRepository {

  Formato save(Formato formato);

  void delete(Formato formato);

  Formato update(Formato formato);

}
