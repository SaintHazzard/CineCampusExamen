package com.campus.modules.tipoactor.adapter.in;

import java.util.Optional;
import java.util.Scanner;

import com.campus.modules.tipoactor.application.TipoActorService;
import com.campus.modules.tipoactor.domain.Tipoactor;

public class TipoActorConsoleAdapter {
    private TipoActorService tipoactorService;

    public TipoActorConsoleAdapter(TipoActorService tipoactorService) {
        this.tipoactorService = tipoactorService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            int choice = menu(scanner);

            switch (choice) {
                case 1:

                    System.out.print("Ingrese la descripcion del tipoactor: ");
                    String descripcion = scanner.nextLine();
                    Tipoactor tipoactor = new Tipoactor(descripcion);
                    tipoactorService.saveTipoactor(tipoactor);
                    break;

                case 2:
                    System.out.print("Ingrese  ID del tipo de actor a actualizar: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    Optional<Tipoactor> tipoactorEncontrado = tipoactorService.getByTipoActorId(updateId);
                    tipoactorEncontrado.ifPresentOrElse(p -> {
                        System.out.println("Ingrese la descripcion del tipo de actor nueva");
                        String newDescription = scanner.nextLine();
                        p.setDescripcion(newDescription);
                        tipoactorService.updateTipoactor(p);
                    }, () -> System.out.println("tipo de actor con el id " + updateId + "no encontrado"));
                    break;

                case 3:
                    System.out.print("Ingrese el Id del Tipoactor a buscar: ");
                    int findId = Integer.parseInt(scanner.nextLine());
                    Optional<Tipoactor> tipoactor1 = tipoactorService.getByTipoActorId(findId);
                    tipoactor1.ifPresentOrElse(
                            p -> System.out.println(p.toString()),
                            () -> System.out.println("Tipo de actor no encontrado"));
                    break;

                case 4:
                    System.out.print("Ingrese el Id del tipo de actor a borrar: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    if (tipoactorService.getByTipoActorId(deleteId).isEmpty()) {
                        System.out.println("Tipoactor no encontrado");
                        break;
                    }
                    tipoactorService.deleteTipoactor(deleteId);
                    System.out.println("Tipo de actor eliminado");
                    break;

                case 5:
                    tipoactorService.findAllTipoactor().forEach(p -> {
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

    private int menu(Scanner scanner) {
        System.out.println("1. Guardar nuevo tipo de actor");
        System.out.println("2. Actualizar Tipoactor");
        System.out.println("3. Buscar tipo de actor por ID");
        System.out.println("4. Eliminar Tipo de actor");
        System.out.println("5. Listar todos los tipos de actores");
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
