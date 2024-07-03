package com.campus.modules.actores.application;

import java.util.List;

import com.campus.ConfiguracionProyecto;
import com.campus.modules.actores.adapter.out.ActorMySQLRepository;
import com.campus.modules.actores.domain.Actor;

public class ActorService {

  private ActorMySQLRepository actorMySQLRepository;

  String url = ConfiguracionProyecto.URL();
  String user = ConfiguracionProyecto.USER();
  String password = ConfiguracionProyecto.PASSWORD();

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
