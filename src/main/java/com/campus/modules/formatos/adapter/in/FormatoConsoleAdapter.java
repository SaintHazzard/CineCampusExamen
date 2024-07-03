package com.campus.modules.formatos.adapter.in;

import java.util.List;
import java.util.Scanner;

import com.campus.modules.formatos.application.FormatoService;
import com.campus.modules.formatos.domain.Formato;

public class FormatoConsoleAdapter {

  private FormatoService formatoService;

  public FormatoConsoleAdapter() {
    this.formatoService = new FormatoService();
  }

  public void start() {
    System.out.println("--------------- FORMATOS ---------------");
    while (true) {
      System.out.println("1. Crear formato");
      System.out.println("2. Eliminar formato");
      System.out.println("3. Actualizar formato");
      System.out.println("4. Listar formatos");
      System.out.println("0. Salir");
      System.out.println("");
      System.out.print("Ingrese la opcion: ");
      Scanner scanner = new Scanner(System.in);
      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      switch (choice) {
        case 1:
          System.out.print("Ingrese la descripcion del formato: ");
          String descripcion = scanner.nextLine();
          Formato formato = new Formato(descripcion);
          formatoService.saveFormato(formato);
          break;
        case 2:
          System.out.print("Ingrese el id del formato a eliminar: ");
          int id = scanner.nextInt();
          scanner.nextLine(); // Consume newline
          Formato formato1 = formatoService.getFormatoById(id);
          formatoService.deleteFormato(formato1);
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
          break;
        case 4:
          List<Formato> formatos = formatoService.findAllFormatos();
          for (Formato form : formatos) {
            System.out.println(form);
          }
          break;
        case 0:
          return;
        default:
          System.out.println("Opcion invalida");
          break;
      }
    }
  }

}
