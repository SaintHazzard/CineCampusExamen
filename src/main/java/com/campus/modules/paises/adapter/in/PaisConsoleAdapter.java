package com.campus.modules.paises.adapter.in;

import java.util.Optional;
import java.util.Scanner;

import com.campus.modules.paises.application.PaisService;
import com.campus.modules.paises.domain.Pais;

public class PaisConsoleAdapter {
    private PaisService paisService;

    public PaisConsoleAdapter(PaisService paisService) {
        this.paisService = paisService;
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            int choice = menu(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la descripcion del pais: ");
                    String descripcion = scanner.nextLine();
                    Pais pais = new Pais(descripcion);
                    paisService.savePais(pais);
                    break;

                case 2:
                    System.out.print("Ingrese  ID del pais a actualizar: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    Optional<Pais> paisEncontrado = paisService.findByIdPais(updateId);
                    paisEncontrado.ifPresentOrElse(p -> {
                        System.out.println("Ingrese la descripcion del pais nueva");
                        String newDescription = scanner.nextLine();
                        p.setDescripcion(newDescription);
                        paisService.updatePais(p);
                    }, () -> System.out.println("pais con el id " + updateId + "no encontrado"));
                    break;

                case 3:
                    System.out.print("Ingrese el Id del Pais a buscar: ");
                    int findId = Integer.parseInt(scanner.nextLine());
                    Optional<Pais> pais1 = paisService.findByIdPais(findId);
                    pais1.ifPresentOrElse(
                        p -> System.out.println(p.toString()),
                        () -> System.out.println("Pais no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el Id del pais a borrar: ");
                    int deleteId = Integer.parseInt( scanner.nextLine());
                    paisService.deletePais(deleteId);
                    break;

                case 5:
                    paisService.findAllPais().forEach(p -> {
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
        System.out.println("1. Save pais");
        System.out.println("2. Update pais");
        System.out.println("3. Find By ID Pais");
        System.out.println("4. Delete Pais");
        System.out.println("5. Find All Paiss");
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
