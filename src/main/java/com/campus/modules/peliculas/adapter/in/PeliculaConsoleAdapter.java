package com.campus.modules.peliculas.adapter.in;

import java.util.Scanner;

import com.campus.modules.peliculas.application.PeliculaService;
import com.campus.modules.peliculas.domain.Pelicula;

public class PeliculaConsoleAdapter {

  private PeliculaService peliculaService;

  public PeliculaConsoleAdapter() {
    this.peliculaService = new PeliculaService();
  }

  public void start() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("1. Crear pelicula");
    System.out.println("2. Actualizar pelicula");
    System.out.println("3. Eliminar pelicula");
    System.out.println("4. Listar peliculas");
    System.out.println("5. Salir");
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
        return;
      default:
        System.out.println("Opcion no valida");
        break;
    }
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
