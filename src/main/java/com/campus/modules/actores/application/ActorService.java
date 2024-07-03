package com.campus.modules.actores.application;

import java.util.List;

import com.campus.modules.actores.adapter.out.ActorMySQLRepository;
import com.campus.modules.actores.domain.Actor;

public class ActorService {

  private ActorMySQLRepository actorMySQLRepository;

  public ActorService(ActorMySQLRepository actorMySQLRepository) {
    this.actorMySQLRepository = new ActorMySQLRepository(null, null, null);
  }

  public void saveActor(Actor actor) {
    actorMySQLRepository.save(actor);
  }

  public void deleteActor(Actor actor) {
    actorMySQLRepository.delete(actor);
  }

  public void updateActor(Actor actor) {
    actorMySQLRepository.update(actor);
  }

  public Actor findActorById(int id) {
    return actorMySQLRepository.findById(id);
  }

  public List<Actor> findAllActors() {
    return actorMySQLRepository.findAll();
  }

}
