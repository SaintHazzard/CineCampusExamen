package com.campus;

import java.util.Scanner;

import com.campus.modules.actores.adapter.in.ConsoleAdapterActor;
import com.campus.modules.formatos.adapter.in.FormatoConsoleAdapter;
import com.campus.modules.generos.adapter.in.GeneroConsoleAdapter;
import com.campus.modules.generos.adapter.out.GeneroMySQLRepository;
import com.campus.modules.generos.application.GeneroService;
import com.campus.modules.paises.adapter.in.PaisConsoleAdapter;
import com.campus.modules.paises.adapter.out.PaisMySQLRepository;
import com.campus.modules.paises.application.PaisService;
import com.campus.modules.peliculaProtagonista.adapter.in.PeliculaProtagonistaConsoleAdapter;
import com.campus.modules.peliculaProtagonista.adapter.out.PeliculaProtagonistaMySQLRepository;
import com.campus.modules.peliculaProtagonista.application.PeliculaProtagonistaService;
import com.campus.modules.peliculas.adapter.in.PeliculaConsoleAdapter;
import com.campus.modules.tipoactor.adapter.in.TipoActorConsoleAdapter;
import com.campus.modules.tipoactor.adapter.out.TipoActorMySQLRepository;
import com.campus.modules.tipoactor.application.TipoActorService;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/cinecampus";
        String user = "root";
        String password = "123456";

        System.out.println("--------------- MENU PRINCIPAL ---------------");

        while (true) {
            System.out.println("1. Genero");
            System.out.println("2. Actores");
            System.out.println("3. Peliculas");
            System.out.println("4. Paises");
            System.out.println("5. Formato");
            System.out.println("6. Pelicula Protagonista");
            System.out.println("7. Tipo de actor");
            System.out.println("8. ");
            System.out.println("0. Salir");
            System.out.println("");
            System.out.print("Ingrese la opcion: ");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
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
                    PaisMySQLRepository paisMySQLRepository = new PaisMySQLRepository(url, user, password);
                    PaisService PaisService = new PaisService(paisMySQLRepository);
                    PaisConsoleAdapter PaisConsoleAdapter = new PaisConsoleAdapter(PaisService);
                    PaisConsoleAdapter.start();
                    break;
                case 5:
                    FormatoConsoleAdapter formatoConsoleAdapter = new FormatoConsoleAdapter();
                    formatoConsoleAdapter.start();
                    break;
                case 6:
                    PeliculaProtagonistaMySQLRepository peliculaProtagonistaMySQLRepository = new PeliculaProtagonistaMySQLRepository(url, user, password);
                    PeliculaProtagonistaService PeliculaProtagonistaService = new PeliculaProtagonistaService(peliculaProtagonistaMySQLRepository);
                    PeliculaProtagonistaConsoleAdapter peliculaProtagonistaConsoleAdapter = new PeliculaProtagonistaConsoleAdapter(PeliculaProtagonistaService);
                    peliculaProtagonistaConsoleAdapter.start();
                    break;
                case 7:
                    TipoActorMySQLRepository tipoActorMySQLRepository = new TipoActorMySQLRepository(url, user,
                            password);
                    TipoActorService tipoActorService = new TipoActorService(tipoActorMySQLRepository);
                    TipoActorConsoleAdapter tipoActorConsoleAdapter = new TipoActorConsoleAdapter(tipoActorService);
                    tipoActorConsoleAdapter.start();
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