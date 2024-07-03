package com.campus.modules.actores.application;

import java.util.List;

import com.campus.modules.actores.adapter.out.ActorMySQLRepository;
import com.campus.modules.actores.domain.Actor;

public class ActorService {

  private ActorMySQLRepository actorMySQLRepository;

  String url = "jdbc:mysql://localhost:3306/cinecampus";
  String user = "root";
  String password = "123456";

  public ActorService() {
    this.actorMySQLRepository = new ActorMySQLRepository(url, user, password);
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

  public Actor getActorById(int id) {
    return actorMySQLRepository.findById(id);
  }

  public List<Actor> findAllActors() {
    return actorMySQLRepository.findAll();
  }

}
