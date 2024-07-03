package com.campus.modules.actores.application;

import java.util.List;

import com.campus.modules.actores.adapter.out.ActorMySQLRepository;
import com.campus.modules.actores.domain.Actor;

public class ActorService {

  private ActorMySQLRepository actorMySQLRepository;

  private String url = "jdbc:mysql://127.0.0.1:3306/CampusCine";
  private String user = "campus2023";
  private String password = "campus2023";

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
