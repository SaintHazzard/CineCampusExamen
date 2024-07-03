package com.campus.modules.peliculaProtagonista.adapter.in;

import java.util.Optional;
import java.util.Scanner;

import com.campus.modules.peliculaProtagonista.application.PeliculaProtagonistaService;
import com.campus.modules.peliculaProtagonista.domain.PeliculaProtagonista;



public class PeliculaProtagonistaConsoleAdapter {
    private PeliculaProtagonistaService peliculaprotagonistaService;

    public PeliculaProtagonistaConsoleAdapter(PeliculaProtagonistaService peliculaprotagonistaService) {
        this.peliculaprotagonistaService = peliculaprotagonistaService;
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            int choice = menu(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el id de la Pelicula: ");
                    int idPelicula = Integer.parseInt(scanner.nextLine());

                    System.out.print("Ingrese el id del actor protagonista: ");
                    int idProtagonista = Integer.parseInt(scanner.nextLine());

                    System.out.print("Ingrese el id del Tipo Actor: ");
                    int idTipoActor = Integer.parseInt(scanner.nextLine());

                    PeliculaProtagonista peliculaprotagonista = new PeliculaProtagonista(idPelicula, idProtagonista, idTipoActor);
                    peliculaprotagonistaService.savePeliculaprotagonista(peliculaprotagonista);
                    break;

                case 2:
                    System.out.print("Ingrese idPelicula de la peliculaprotagonista a actualizar: ");
                    int updateId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Ingrese idProtagonista de la peliculaprotagonista a actualizar: ");
                    int updateId2 = Integer.parseInt(scanner.nextLine());

                    Optional<PeliculaProtagonista> peliculaprotagonistaEncontrado = peliculaprotagonistaService.findByIdPeliculaprotagonista(updateId, updateId2);
                    peliculaprotagonistaEncontrado.ifPresentOrElse(p -> {

                        System.out.println("Ingrese el idPelicula de la peliculaprotagonista nueva");
                        int newIdPelicula = Integer.parseInt(scanner.nextLine());

                        System.out.println("Ingrese el idProtagonista de la peliculaprotagonista nueva");
                        int newIdProtagonista = Integer.parseInt(scanner.nextLine());

                        System.out.println("Ingrese el idTipoActor de la peliculaprotagonista nueva");
                        int newIdTipoActor = Integer.parseInt(scanner.nextLine());
                        
                        p.setIdPelicula(newIdPelicula);
                        p.setIdProtagonista(newIdProtagonista);
                        p.setIdTipoActor(newIdTipoActor);
                        peliculaprotagonistaService.updatePeliculaprotagonista(p);
                    }, () -> System.out.println("peliculaprotagonista con el id " + updateId + "no encontrado"));
                    break;

                case 3:
                System.out.print("Ingrese idPelicula de la peliculaprotagonista a buscar: ");
                int buscarid = Integer.parseInt(scanner.nextLine());

                System.out.print("Ingrese idProtagonista de la peliculaprotagonista a buscar: ");
                int buscarid2 = Integer.parseInt(scanner.nextLine());

                Optional<PeliculaProtagonista> peliculaprotagonista1 = peliculaprotagonistaService.findByIdPeliculaprotagonista(buscarid, buscarid2);
                peliculaprotagonista1.ifPresentOrElse(
                    p -> System.out.println(p.toString()),
                    () -> System.out.println("Peliculaprotagonista no encontrado")
                );
                break;

                case 4:
                    System.out.print("Ingrese idPelicula de la peliculaprotagonista a buscar: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Ingrese idProtagonista de la peliculaprotagonista a buscar: ");
                    int deleteId1 = Integer.parseInt(scanner.nextLine());
                    peliculaprotagonistaService.deletePeliculaprotagonista(deleteId, deleteId1);
                    break;

                case 5:
                    peliculaprotagonistaService.findAllPeliculaprotagonista().forEach(p -> {
                        System.out.println(p.toString());
                    });
                    break;

                case 0:
                    flag = false;
                    break;

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        }
    }

    private int menu(Scanner scanner){
        System.out.println("1. Save peliculaprotagonista");
        System.out.println("2. Update peliculaprotagonista");
        System.out.println("3. Find By ID Peliculaprotagonista");
        System.out.println("4. Delete Peliculaprotagonista");
        System.out.println("5. Find All Peliculaprotagonistas");
        System.out.println("0. Salir");
        System.out.println("");
        System.out.print("Ingrese la opcion: ");
        int choice = -1;

        while (choice < 0 || choice > 6) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 6) {                    
                    System.out.println("Ingrese una opcion valida (0 - 5).");
                }
            } catch (Exception e) {
                System.out.println("Ingrese una opcion valida (0 - 5).");
            }
        }
        return choice;
    }

    
}
