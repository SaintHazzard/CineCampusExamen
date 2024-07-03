package com.campus.modules.actores.adapter.in;

import java.util.List;
import java.util.Scanner;
import com.campus.modules.actores.application.ActorService;
import com.campus.modules.actores.domain.Actor;
import com.campus.modules.generos.application.GeneroService;
import com.campus.modules.generos.domain.Genero;
import com.campus.modules.paises.application.PaisService;
import com.campus.modules.paises.domain.Pais;
import com.campus.modules.peliculaProtagonista.application.PeliculaProtagonistaService;
import com.campus.modules.peliculaProtagonista.domain.PeliculaProtagonista;
import com.campus.modules.peliculas.application.PeliculaService;
import com.campus.modules.peliculas.domain.Pelicula;
import com.campus.modules.tipoactor.application.TipoActorService;
import com.campus.modules.tipoactor.domain.Tipoactor;

public class ConsoleAdapterActor {
  private ActorService actorService;
  private GeneroService generoService;
  private PaisService paisService;
  private PeliculaService peliculaService;
  private TipoActorService tipoActorService;
  private PeliculaProtagonistaService peliculaProtagonistaService;

  public ConsoleAdapterActor() {
    this.actorService = new ActorService();
    this.generoService = new GeneroService();
    this.paisService = new PaisService();
    this.peliculaService = new PeliculaService();
    this.tipoActorService = new TipoActorService();
    this.peliculaProtagonistaService = new PeliculaProtagonistaService();
  }

  Scanner scanner = new Scanner(System.in);

  public void start() {
    int choice = -1;
    while (true) {
      System.out.println("1. Crear actor");
      System.out.println("2. Actualizar actor");
      System.out.println("3. Eliminar actor");
      System.out.println("4. Listar actores");
      System.out.println("5. Agregar actor a pelicula");
      System.out.println("0. Salir");
      System.out.print("Ingrese la opcion: ");
      try {
        choice = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Opcion invalida, intentelo de nuevo.");
        continue;
      }
      switch (choice) {
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
          agregarActorAPelicula();
          break;
        case 0:
          return;
        default:
          System.out.println("Opcion no valida");
          break;
      }
    }

  }

  private void agregarActorAPelicula() {
    List<Pelicula> peliculas = peliculaService.findAllPeliculas();
    if (peliculas.isEmpty()) {
      System.out.println("No hay peliculas para agregar actores");
    }
    for (Pelicula peli : peliculas) {
      System.out.println(peli);
      System.out.println("");
    }
    System.out.println("Indique ID de la pelicula a la que desea agregar un actor: ");
    int idPelicula = scanner.nextInt();
    List<Actor> actores = actorService.findAllActors();
    if (actores.isEmpty()) {
      System.out.println("No hay actores para agregar a la pelicula");
    }
    for (Actor actor : actores) {
      System.out.println(actor);
    }
    System.out.println("Indique ID del actor que desea agregar: ");
    int idActor = scanner.nextInt();
    List<Tipoactor> tipoActores = tipoActorService.findAllTipoactor();
    if (tipoActores.isEmpty()) {
      System.out.println("No hay tipos de actores para agregar a la pelicula");
    }
    for (Tipoactor tipoActor : tipoActores) {
      System.out.println(tipoActor);
    }
    System.out.println("Indique ID del tipo de actor: ");
    int idTipoActor = scanner.nextInt();
    PeliculaProtagonista peliculaProtagonista = new PeliculaProtagonista();
    peliculaProtagonista.setIdPelicula(idPelicula);
    peliculaProtagonista.setIdProtagonista(idActor);
    peliculaProtagonista.setIdTipoActor(idTipoActor);
    peliculaProtagonistaService.savePeliculaprotagonista(peliculaProtagonista);
    if (peliculaProtagonistaService.findByIdPeliculaprotagonista(idPelicula, idTipoActor) != null) {
      System.out.println("El actor ha sido agregado a la pelicula");
    } else {
      System.out.println("El actor no ha sido agregado a la pelicula");
    }
  }

  private void findAllActors() {
    System.out.println("Lista de actores: ");
    if (actorService.findAllActors().isEmpty()) {
      System.out.println("No hay actores");
    }
    actorService.findAllActors().forEach(actor -> {
      System.out.println("Id: " + actor.getId());
      System.out.println("Nombre: " + actor.getNombre());
      System.out.println("Edad: " + actor.getEdad());
      System.out.println("Genero: " + actor.getIdGenero());
      System.out.println("Nacionalidad: " + actor.getIdNacionalidad());
    });
    System.out.println("");
  }

  private void saveActor() {
    scanner.nextLine();
    System.out.println("Nombre del actor: ");
    String nombre = scanner.nextLine();
    System.out.println("Edad del actor: ");
    int edad = scanner.nextInt();
    List<Genero> generos = generoService.findAllGenero();
    if (generos.isEmpty()) {
      System.out.println("No hay generos registre al menos uno");
      return;
    }
    for (Genero genero : generos) {
      System.out.println("Id: " + genero.getId() + " Descripcion: " + genero.getDescripcion());
    }
    System.out.print("Id genero del actor: ");
    int idGenero = scanner.nextInt();
    List<Pais> paises = paisService.findAllPais();
    if (paises.isEmpty()) {
      System.out.println("No hay paises registre al menos uno");
      return;
    }
    for (Pais pais : paises) {
      System.out.println("Id: " + pais.getId() + " Nombre: " + pais.getDescripcion());
    }
    System.out.println("Id nacionalidad del actor: ");
    int idNacionalidad = scanner.nextInt();
    Actor actor = new Actor(nombre, edad, idGenero, idNacionalidad);
    actorService.saveActor(actor);
    System.out.println("El actor ha sido registrado");
  }

  private void updateActor() {
    List<Actor> actores = actorService.findAllActors();
    if (actores.isEmpty()) {
      System.out.println("No hay actores registrados");
      return;
    }
    for (Actor actor : actores) {
      System.out.println("Id: " + actor.getId());
      System.out.println("Nombre: " + actor.getNombre());
      System.out.println("Edad: " + actor.getEdad());
      System.out.println("Genero: " + actor.getIdGenero());
      System.out.println("Nacionalidad: " + actor.getIdNacionalidad());
    }
    System.out.println("Cual es el id del actor que desea actualizar?");
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
    System.out.println("El actor ha sido actualizado");
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
