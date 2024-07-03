package com.campus;

import java.util.Scanner;

import com.campus.modules.actores.adapter.in.ConsoleAdapterActor;
import com.campus.modules.formatos.adapter.in.FormatoConsoleAdapter;
import com.campus.modules.generos.adapter.in.GeneroConsoleAdapter;
import com.campus.modules.generos.adapter.out.GeneroMySQLRepository;
import com.campus.modules.generos.application.GeneroService;
import com.campus.modules.peliculas.adapter.in.PeliculaConsoleAdapter;

public class Main {
    public static void main(String[] args) {
        String url = "";
        String user = "";
        String password = "";

        System.out.println("--------------- MENU PRINCIPAL ---------------");

        while (true) {
            System.out.println("1. Genero");
            System.out.println("2. ");
            System.out.println("3. Peliculas");
            System.out.println("4. ");
            System.out.println("5. Formato");
            System.out.println("6. ");
            System.out.println("7. ");
            System.out.println("8. ");
            System.out.println("0. Salir");
            System.out.println("");
            System.out.print("Ingrese la opcion: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    GeneroMySQLRepository generoMySQLRepository = new GeneroMySQLRepository(url, user, password);
                    GeneroService generoService = new GeneroService(generoMySQLRepository);
                    GeneroConsoleAdapter generoConsoleAdapter = new GeneroConsoleAdapter(generoService);
                    generoConsoleAdapter.start();
                    break;
                case 2:
                    ConsoleAdapterActor consoleAdapterActor = new ConsoleAdapterActor();
                    consoleAdapterActor.start();
                    break;
                case 3:
                    PeliculaConsoleAdapter peliculaConsoleAdapter = new PeliculaConsoleAdapter();
                    peliculaConsoleAdapter.start();
                    break;
                case 4:

                    break;
                case 5:
                    FormatoConsoleAdapter formatoConsoleAdapter = new FormatoConsoleAdapter();
                    formatoConsoleAdapter.start();
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");

            }
        }
    }
}