package com.campus.modules.actores.infraestructure;

import java.util.List;

import com.campus.modules.actores.domain.Actor;

public interface ActorRepository {

  Actor save(Actor actor);

  void delete(Actor actor);

  Actor update(Actor actor);

  Actor findById(int id);

  List<Actor> findAll();

}
