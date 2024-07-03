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
import com.campus.modules.peliculaProtagonista.adapter.in.PeliculaProtagonistaConsoleAdapter;
import com.campus.modules.peliculaProtagonista.adapter.out.PeliculaProtagonistaMySQLRepository;
import com.campus.modules.peliculaProtagonista.application.PeliculaProtagonistaService;
import com.campus.modules.peliculas.adapter.in.PeliculaConsoleAdapter;
import com.campus.modules.tipoactor.adapter.in.TipoActorConsoleAdapter;
import com.campus.modules.tipoactor.adapter.out.TipoActorMySQLRepository;
import com.campus.modules.tipoactor.application.TipoActorService;
import com.campus.modules.tipoactor.infrastructure.TipoActorRepository;

public class Main {
    public static void main(String[] args) {
        String url = ConfiguracionProyecto.URL();
        String user = ConfiguracionProyecto.USER();
        String password = ConfiguracionProyecto.PASSWORD();

        System.out.println("--------------- MENU PRINCIPAL ---------------");

        while (true) {
            int choice = -1;
            System.out.println("1. Gestionar generos");
            System.out.println("2. Gestionar actores");
            System.out.println("3. Gestionar peliculas");
            System.out.println("4. Gestionar paises");
            System.out.println("5. Gestionar formatos");
            System.out.println("6. Pelicula Protagonista");
            System.out.println("7. Gestion Tipo de actor");
            System.out.println("8. ");
            System.out.println("0. Salir");
            System.out.println("");
            System.out.print("Ingrese la opcion: ");
            Scanner scanner = new Scanner(System.in);
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida, intentelo de nuevo.");
                continue;
            }
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
                    PeliculaProtagonistaMySQLRepository peliculaProtagonistaMySQLRepository = new PeliculaProtagonistaMySQLRepository(
                            url, user, password);
                    PeliculaProtagonistaService PeliculaProtagonistaService = new PeliculaProtagonistaService(
                            peliculaProtagonistaMySQLRepository);
                    PeliculaProtagonistaConsoleAdapter peliculaProtagonistaConsoleAdapter = new PeliculaProtagonistaConsoleAdapter(
                            PeliculaProtagonistaService);
                    peliculaProtagonistaConsoleAdapter.start();
                    break;
                case 7:
                    TipoActorRepository tipoActorMySQLRepository = new TipoActorMySQLRepository(url, user,
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

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}