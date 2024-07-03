package com.campus.modules.actores.adapter.in;

import java.util.Scanner;
import com.campus.modules.actores.application.ActorService;
import com.campus.modules.actores.domain.Actor;

public class ConsoleAdapterActor {
  private ActorService actorService;

  public ConsoleAdapterActor() {
    this.actorService = new ActorService();
  }

  Scanner scanner = new Scanner(System.in);

  public void start() {
    System.out.println("1. Crear actor");
    System.out.println("2. Actualizar actor");
    System.out.println("3. Eliminar actor");
    System.out.println("4. Listar actores");
    System.out.println("5. Salir");
    System.out.println("Opcion: ");
    int opcion = scanner.nextInt();
    switch (opcion) {
      case 1:
        saveActor();
        break;
      case 2:
        updateActor();
        break;
      case 3:
        deleteActor();
        break;
      case 4:
        findAllActors();
        break;
      case 5:
        return;
      default:
        System.out.println("Opcion no valida");
        break;
    }
  }

  private void findAllActors() {
    actorService.findAllActors().forEach(actor -> {
      System.out.println("Id: " + actor.getId());
      System.out.println("Nombre: " + actor.getNombre());
      System.out.println("Edad: " + actor.getEdad());
      System.out.println("Genero: " + actor.getIdGenero());
      System.out.println("Nacionalidad: " + actor.getIdNacionalidad());
    });
  }

  private void saveActor() {
    scanner.nextLine();
    System.out.println("Nombre del actor: ");
    String nombre = scanner.nextLine();
    System.out.println("Edad del actor: ");
    int edad = scanner.nextInt();
    System.out.println("Id genero del actor: ");
    int idGenero = scanner.nextInt();
    System.out.println("Nacionalidad del actor: ");
    int idNacionalidad = scanner.nextInt();
    Actor actor = new Actor(nombre, edad, idGenero, idNacionalidad);
    actorService.saveActor(actor);
  }

  private void updateActor() {
    System.out.println("Id del actor: ");
    int id = scanner.nextInt();
    Actor actor = actorService.getActorById(id);
    System.out.println("Nombre del actor: ");
    String nombre = scanner.nextLine();
    System.out.println("Edad del actor: ");
    int edad = scanner.nextInt();
    System.out.println("Genero del actor: ");
    int idGenero = scanner.nextInt();
    System.out.println("Nacionalidad del actor: ");
    int idNacionalidad = scanner.nextInt();
    actor.setNombre(nombre);
    actor.setEdad(edad);
    actor.setIdGenero(idGenero);
    actor.setIdNacionalidad(idNacionalidad);
    actorService.updateActor(actor);
  }

  private void deleteActor() {
    System.out.println("Id del actor: ");
    int id = scanner.nextInt();
    Actor actor = actorService.getActorById(id);
    if (actor != null) {
      actorService.deleteActor(actor);
      System.out.println("El actor ha sido eliminado");
    } else {
      System.out.println("El actor no existe");
    }
  }
}
