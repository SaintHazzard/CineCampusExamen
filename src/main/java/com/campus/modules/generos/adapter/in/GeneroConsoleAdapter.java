package com.campus.modules.generos.adapter.in;

import java.util.Optional;
import java.util.Scanner;

import com.campus.modules.generos.application.GeneroService;
import com.campus.modules.generos.domain.Genero;
public class GeneroConsoleAdapter {

    private GeneroService generoService;

    public GeneroConsoleAdapter(GeneroService generoService) {
        this.generoService = generoService;
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            int choice = menu(scanner);

            switch (choice) {
                case 1:

                    System.out.print("Ingrese la descripcion del genero: ");
                    String descripcion = scanner.nextLine();
                    Genero genero = new Genero(descripcion);
                    generoService.saveGenero(genero);
                    break;

                case 2:
                    System.out.print("Ingrese  ID del genero a actualizar: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    Optional<Genero> generoEncontrado = generoService.findByIdGenero(updateId);
                    generoEncontrado.ifPresentOrElse(p -> {
                        System.out.println("Ingrese la descripcion del genero nueva");
                        String newDescription = scanner.nextLine();
                        p.setDescripcion(newDescription);
                        generoService.updateGenero(p);
                    }, () -> System.out.println("genero con el id " + updateId + "no encontrado"));
                    break;

                case 3:
                    System.out.print("Ingrese el Id del Genero a buscar: ");
                    int findId = Integer.parseInt(scanner.nextLine());
                    Optional<Genero> genero1 = generoService.findByIdGenero(findId);
                    genero1.ifPresentOrElse(
                        p -> System.out.println(p.toString()),
                        () -> System.out.println("Genero no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el Id del genero a borrar: ");
                    int deleteId = Integer.parseInt( scanner.nextLine());
                    generoService.deleteGenero(deleteId);
                    break;

                case 5:
                    generoService.findAllGenero().forEach(p -> {
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
        System.out.println("1. Save genero");
        System.out.println("2. Update genero");
        System.out.println("3. Find By ID Genero");
        System.out.println("4. Delete Genero");
        System.out.println("5. Find All Generos");
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
