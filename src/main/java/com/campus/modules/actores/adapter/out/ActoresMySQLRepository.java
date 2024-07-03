package com.campus.modules.actores.adapter.out;

import com.campus.modules.actores.domain.Actor;
import com.campus.modules.actores.infraestructure.ActoresRepository;

public class ActoresMySQLRepository implements ActoresRepository {


  protected final String url;
  protected final String user;
  protected final String password;

  public ActoresMySQLRepository() {
    
  }

  @Override
  public Actor save(Actor actor) {
    
  }

}
