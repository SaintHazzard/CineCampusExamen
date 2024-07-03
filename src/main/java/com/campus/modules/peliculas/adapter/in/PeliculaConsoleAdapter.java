package com.campus.modules.peliculas.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.campus.modules.actores.application.ActorService;
import com.campus.modules.formatos.application.FormatoService;
import com.campus.modules.formatos.domain.Formato;
import com.campus.modules.peliculaformato.application.PeliculaFormatoService;
import com.campus.modules.peliculaformato.domain.PeliculaFormato;
import com.campus.modules.peliculas.application.PeliculaService;
import com.campus.modules.peliculas.domain.Pelicula;

public class PeliculaConsoleAdapter {

  private PeliculaService peliculaService;
  private ActorService actorService;
  private FormatoService formatoService;
  private PeliculaFormatoService peliculaFormatoService;

  public PeliculaConsoleAdapter() {
    this.peliculaService = new PeliculaService();
    this.actorService = new ActorService();
    this.formatoService = new FormatoService();
    this.peliculaFormatoService = new PeliculaFormatoService();
  }

  public void start() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("1. Crear pelicula");
    System.out.println("2. Actualizar pelicula");
    System.out.println("3. Eliminar pelicula");
    System.out.println("4. Listar peliculas");
    System.out.println("5. Agregar actor a pelicula");
    System.out.println("6. Agregar formato a pelicula");
    System.out.println("0. Salir");
    System.out.println("Opcion: ");
    int opcion = scanner.nextInt();
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
      case 0:
        return;
      default:
        System.out.println("Opcion no valida");
        break;
    }
  }

  private void agregarFormatoAPelicula(Scanner scanner) {
    List<Formato> formatos = formatoService.findAllFormatos();
    List<Pelicula> peliculas = peliculaService.findAllPeliculas();
    for (Pelicula peli : peliculas) {
      System.out.println(peli);
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

  }

  private void agregarActorAPelicula(Scanner scanner) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'agregarActorAPelicula'");
  }

  private void findAllPeliculas(Scanner scanner) {
    for (Pelicula peli : peliculaService.findAllPeliculas()) {
      System.out.println(peli);
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
    int codInterno = scanner.nextInt();
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
    System.out.println("Codigo interno de la pelicula: ");
    int codInterno = scanner.nextInt();
    scanner.nextLine();
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
