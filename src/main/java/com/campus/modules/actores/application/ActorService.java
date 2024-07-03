package com.campus.modules.actores.application;

import com.campus.modules.actores.adapter.out.ActorMySQLRepository;

public class ActorService {

  private ActorMySQLRepository actorMySQLRepository;

  public ActorService(ActorMySQLRepository actorMySQLRepository) {
    this.actorMySQLRepository = new ActorMySQLRepository(null, null, null);
  }

}
