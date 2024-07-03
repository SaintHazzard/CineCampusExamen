package com.campus.modules.formatos.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.campus.modules.formatos.application.FormatoService;
import com.campus.modules.formatos.domain.Formato;
import com.campus.modules.peliculaformato.application.PeliculaFormatoService;
import com.campus.modules.peliculaformato.domain.PeliculaFormato;
import com.campus.modules.peliculas.application.PeliculaService;
import com.campus.modules.peliculas.domain.Pelicula;

public class FormatoConsoleAdapter {

  private FormatoService formatoService;
  private PeliculaService peliculaService;
  private PeliculaFormatoService peliculaFormatoService;

  public FormatoConsoleAdapter() {
    this.formatoService = new FormatoService();
    this.peliculaService = new PeliculaService();
    this.peliculaFormatoService = new PeliculaFormatoService();
  }

  @SuppressWarnings("resource")
  public void start() {
    System.out.println("--------------- FORMATOS ---------------");
    while (true) {
      int opcion = -1;
      System.out.println("1. Crear formato");
      System.out.println("2. Eliminar formato");
      System.out.println("3. Actualizar formato");
      System.out.println("4. Listar formatos");
      System.out.println("5. Agregar formato a pelicula");
      System.out.println("0. Salir");
      System.out.print("Ingrese la opcion: ");
      Scanner scanner = new Scanner(System.in);
      try {
        opcion = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Opcion invalida, intentelo de nuevo.");
        continue;
      }
      switch (opcion) {
        case 1:
          System.out.print("Ingrese la descripcion del formato: ");
          String descripcion = scanner.nextLine();
          Formato formato = new Formato(descripcion);
          formatoService.saveFormato(formato);
          if (formatoService.getFormatoById(formato.getId()) != null) {
            System.out.println("Formato creado exitosamente");
          } else {
            System.out.println("Formato no creado");
          }
          break;
        case 2:
          System.out.print("Ingrese el id del formato a eliminar: ");
          int id = scanner.nextInt();
          scanner.nextLine(); // Consume newline
          Formato formato1 = formatoService.getFormatoById(id);
          formatoService.deleteFormato(formato1);
          if (formatoService.getFormatoById(id) == null) {
            System.out.println("Formato eliminado exitosamente");
          } else {
            System.out.println("Formato no eliminado");
          }
          break;
        case 3:
          System.out.print("Ingrese el id del formato a actualizar: ");
          int id1 = scanner.nextInt();
          scanner.nextLine(); // Consume newline
          Formato formato2 = formatoService.getFormatoById(id1);
          System.out.print("Ingrese la nueva descripcion del formato: ");
          String descripcion2 = scanner.nextLine();
          formato2.setDescripcion(descripcion2);
          formatoService.updateFormato(formato2);
          System.out.println("Formato actualizado exitosamente");
          break;
        case 4:
          System.out.println("Formatos disponibles:");
          List<Formato> formatos = formatoService.findAllFormatos();
          for (Formato form : formatos) {
            System.out.println(form);
          }
          break;
        case 5:
          agregarFormatoAPelicula(scanner);
          break;
        case 0:
          return;
        default:
          System.out.println("Opcion invalida");
          break;
      }
    }
  }

  private void agregarFormatoAPelicula(Scanner scanner) {
    System.out.println("");
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
    System.out.println("Formato agregado a pelicula exitosamente");
  }

}
