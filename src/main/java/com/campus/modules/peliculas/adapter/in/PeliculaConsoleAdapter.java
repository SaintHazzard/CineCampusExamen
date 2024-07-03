package com.campus.modules.peliculas.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.campus.modules.actores.application.ActorService;
import com.campus.modules.actores.domain.Actor;
import com.campus.modules.formatos.application.FormatoService;
import com.campus.modules.formatos.domain.Formato;
import com.campus.modules.peliculaProtagonista.application.PeliculaProtagonistaService;
import com.campus.modules.peliculaProtagonista.domain.PeliculaProtagonista;
import com.campus.modules.peliculaformato.application.PeliculaFormatoService;
import com.campus.modules.peliculaformato.domain.PeliculaFormato;
import com.campus.modules.peliculas.application.PeliculaService;
import com.campus.modules.peliculas.domain.Pelicula;
import com.campus.modules.tipoactor.application.TipoActorService;
import com.campus.modules.tipoactor.domain.Tipoactor;

public class PeliculaConsoleAdapter {

  private PeliculaService peliculaService;
  private ActorService actorService;
  private FormatoService formatoService;
  private PeliculaFormatoService peliculaFormatoService;
  private TipoActorService tipoActorService;
  private PeliculaProtagonistaService peliculaProtagonistaService;

  public PeliculaConsoleAdapter() {
    this.peliculaService = new PeliculaService();
    this.actorService = new ActorService();
    this.formatoService = new FormatoService();
    this.peliculaFormatoService = new PeliculaFormatoService();
    this.tipoActorService = new TipoActorService();
    this.peliculaProtagonistaService = new PeliculaProtagonistaService();
  }

  public void start() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("1. Crear pelicula");
      System.out.println("2. Actualizar pelicula");
      System.out.println("3. Eliminar pelicula");
      System.out.println("4. Listar peliculas");
      System.out.println("5. Agregar actor a pelicula");
      System.out.println("6. Agregar formato a pelicula");
      System.out.println("7. Consultar Información Detallada de una Película por ID");
      System.out.println("8. Listar actores de una pelicula");
      System.out.println("0. Salir");
      System.out.print("Ingrese opcion: ");
      int opcion = scanner.nextInt();
      try {
        opcion = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Opcion invalida, intentelo de nuevo.");
        continue;
      }
      switch (opcion) {
        case 1:
          savePelicula(scanner);
          break;
        case 2:
          updatePelicula(scanner);
          break;
        case 3:
          deletePelicula(scanner);
          break;
        case 4:
          findAllPeliculas(scanner);
          break;
        case 5:
          agregarActorAPelicula(scanner);
          break;
        case 6:
          agregarFormatoAPelicula(scanner);
          break;
        case 7:
          detailPelicula(scanner);
          break;
        case 8:
          listActoresPelicula(scanner);
          break;
        case 0:
          System.out.println("Saliendo...");
          return;
        default:
          System.out.println("Opcion no valida");
          break;
      }
    }
  }

  private void listActoresPelicula(Scanner scanner) {
    int i = 0;
    List<Pelicula> peliculas = peliculaService.findAllPeliculas();
    List<PeliculaProtagonista> peliculaProtagonistas = peliculaProtagonistaService.findAllPeliculaprotagonista();
    for (Pelicula peli : peliculas) {
      System.out.println(peli);
    }
    System.out.println("Indique ID de la pelicula que desea ver: ");
    int idPelicula = scanner.nextInt();
    System.out.println("Actores de la pelicula: ");
    System.out.println("");
    for (PeliculaProtagonista peliProtagonista : peliculaProtagonistas) {

      if (peliProtagonista.getIdPelicula() == idPelicula) {
        i++;
        System.out.println(actorService.getActorById(peliProtagonista.getIdProtagonista()).getNombre() + " "
            + tipoActorService.getByTipoActorId(peliProtagonista.getIdTipoActor()).orElse(null).getDescripcion());
      }
    }
    if (i == 0) {
      System.out.println("No hay actores para mostrar");
    }
  }

  private void detailPelicula(Scanner scanner) {
    int i = 0;
    int j = 0;
    List<Pelicula> peliculas = peliculaService.findAllPeliculas();
    List<PeliculaProtagonista> peliculaProtagonistas = peliculaProtagonistaService.findAllPeliculaprotagonista();
    for (Pelicula peli : peliculas) {
      System.out.println(peli);
    }
    System.out.println("Indique ID de la pelicula que desea ver: ");
    int idPelicula = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Actores de la pelicula: ");
    for (PeliculaProtagonista peliProtagonista : peliculaProtagonistas) {
      if (peliProtagonista.getIdPelicula() == idPelicula) {
        i++;
        System.out.println(actorService.getActorById(peliProtagonista.getIdProtagonista()).getNombre() + " "
            + tipoActorService.getByTipoActorId(peliProtagonista.getIdTipoActor()).orElse(null).getDescripcion());
      }
    }
    if (i == 0) {
      System.out.println("No hay actores para mostrar");
    }
    System.out.println("Formatos disponibles: ");
    for (PeliculaFormato peliFormato : peliculaFormatoService.findAllPeliculaFormatos()) {
      if (peliFormato.getIdPelicula() == idPelicula) {
        j++;
        System.out.println(formatoService.getFormatoById(peliFormato.getIdFormato()) + " "
            + peliFormato.getCantidad() + " - copias");
      }
    }
    if (j == 0) {
      System.out.println("No hay formatos para mostrar");
    }
  }

  private void agregarFormatoAPelicula(Scanner scanner) {
    System.out.println("");
    List<Formato> formatos = formatoService.findAllFormatos();
    List<Pelicula> peliculas = peliculaService.findAllPeliculas();
    for (Pelicula peli : peliculas) {
      System.out.println(peli);
      System.out.println("");
    }
    System.out.println("Indique ID de la pelicula a la que desea agregar un formato: ");
    int idPelicula = scanner.nextInt();
    for (Formato format : formatos) {
      System.out.println(format);
    }
    System.out.println("Indique ID del formato que desea agregar: ");
    int idFormato = scanner.nextInt();
    System.out.println("Indique cantidad de copias: ");
    int cantidad = scanner.nextInt();
    PeliculaFormato peliculaFormato = new PeliculaFormato();
    peliculaFormato.setIdPelicula(idPelicula);
    peliculaFormato.setIdFormato(idFormato);
    peliculaFormato.setCantidad(cantidad);
    peliculaFormatoService.savePeliculaFormato(peliculaFormato);
    if (peliculaFormatoService.getPeliculaFormatoById(idPelicula, idFormato) != null) {
      System.out.println("Formato agregado a pelicula exitosamente");
    } else {
      System.out.println("Formato no agregado a pelicula");
    }
  }

  private void agregarActorAPelicula(Scanner scanner) {
    List<Pelicula> peliculas = peliculaService.findAllPeliculas();
    if (peliculas.isEmpty()) {
      System.out.println("No hay peliculas para agregar actores");
    }
    for (Pelicula peli : peliculas) {
      System.out.println(peli);
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
    if (peliculaProtagonistaService.getPeliculaProtagonistaById(idPelicula, idActor) != null) {
      System.out.println("Actor agregado a pelicula exitosamente");
    } else {
      System.out.println("Actor no agregado a pelicula");
    }
  }

  private void findAllPeliculas(Scanner scanner) {
    for (Pelicula peli : peliculaService.findAllPeliculas()) {
      System.out.println(peli);
      System.out.println("");
    }
  }

  private void deletePelicula(Scanner scanner) {
    System.out.println("Indique ID de la pelicula que desea eliminar: ");
    int idPelicula = scanner.nextInt();
    Pelicula pelicula = peliculaService.getPeliculaById(idPelicula);
    peliculaService.deletePelicula(pelicula);
  }

  private void updatePelicula(Scanner scanner) {
    System.out.println("Que pelicula desea actualizar?");
    int idPelicula = scanner.nextInt();
    peliculaService.getPeliculaById(idPelicula);
    System.out.println();
    System.out.println("Codigo interno de la pelicula: ");
    String codInterno = scanner.nextLine();
    System.out.println("Nombre de la pelicula: ");
    String nombre = scanner.nextLine();
    System.out.println("Duracion de la pelicula: ");
    String duracion = scanner.nextLine();
    System.out.println("Sinopsis de la pelicula: ");
    String sinopsis = scanner.nextLine();
    Pelicula pelicula = new Pelicula();
    pelicula.setCodInterno(codInterno);
    pelicula.setNombre(nombre);
    pelicula.setDuracion(duracion);
    pelicula.setSinopsis(sinopsis);
    peliculaService.updatePelicula(pelicula);
  }

  private void savePelicula(Scanner scanner) {
    scanner.nextLine();
    System.out.println("Codigo interno de la pelicula: ");
    String codInterno = scanner.nextLine();
    System.out.println("Nombre de la pelicula: ");
    String nombre = scanner.nextLine();
    System.out.println("Duracion de la pelicula: ");
    String duracion = scanner.nextLine();
    System.out.println("Sinopsis de la pelicula: ");
    String sinopsis = scanner.nextLine();
    Pelicula pelicula = new Pelicula();
    pelicula.setCodInterno(codInterno);
    pelicula.setNombre(nombre);
    pelicula.setDuracion(duracion);
    pelicula.setSinopsis(sinopsis);
    peliculaService.savePelicula(pelicula);
  }

}
