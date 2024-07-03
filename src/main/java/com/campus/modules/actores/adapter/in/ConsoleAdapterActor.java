package com.campus.modules.actores.adapter.in;

import java.util.Scanner;

import com.campus.modules.actores.application.ActorService;

public class ConsoleAdapterActor {
  private ActorService actorService;
  private GeneroService generoService;

  public ConsoleAdapterActor(ActorService actorService, GeneroService generoService) {
    this.actorService = actorService;
    this.generoService = generoService;
  }

  Scanner scanner = new Scanner(System.in);

  public void saveActor() {
    System.out.println("Nombre del actor: ");
    String nombre = scanner.nextLine();
    System.out.println("Edad del actor: ");
    int edad = scanner.nextInt();
    System.out.println("Genero del actor: ");
    int idGenero = scanner.nextInt();
    System.out.println("Nacionalidad del actor: ");
    int idNacionalidad = scanner.nextInt();
  }
}
