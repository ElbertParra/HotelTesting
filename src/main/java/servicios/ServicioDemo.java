package servicios;

import modelo.dominio.*;
import java.util.Scanner;

/**
 * Entrada principal de la aplicación. Proporciona un menú interactivo
 * para gestionar huéspedes y empleados del hotel.
 */
public class ServicioDemo {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menuA();
    }

    /**
     * Muestra el menú principal de la aplicación.
     */
    public static void menuA() {
        int opcion;
        do {
            System.out.println("Bienvenido al sistema de gestión del hotel");
            System.out.println("1. Gestionar huéspedes");
            System.out.println("2. Gestionar empleados");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            String input = scanner.nextLine();
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> gestionarHuespedes();
                case 2 -> System.out.println("Funcionalidad de empleados aún no implementada");
                case 3 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no correcta");
            }
        } while (opcion != 3);
    }

    /**
     * Submenú para realizar operaciones CRUD sobre los huéspedes.
     */
    private static void gestionarHuespedes() {
        HuespedServiceImpl service = new HuespedServiceImpl();
        int opcion;
        do {
            System.out.println("\nGestión de huéspedes");
            System.out.println("1. Registrar");
            System.out.println("2. Buscar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("6. Volver");
            System.out.print("Seleccione una opción: ");

            String input = scanner.nextLine();
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> {
                    Huesped h = leerHuesped();
                    service.registrarPersona(h);
                }
                case 2 -> {
                    System.out.print("ID a buscar: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Persona p = service.buscarPersona(id);
                    System.out.println(p != null ? p : "No encontrado");
                }
                case 3 -> {
                    Huesped h = leerHuesped();
                    service.actualizarPersona(h);
                }
                case 4 -> {
                    System.out.print("ID a eliminar: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    service.eliminarPersona(id);
                }
                case 5 -> service.listarPersonas();
                case 6 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no correcta");
            }
        } while (opcion != 6);
    }

    /**
     * Solicita por consola los datos de un huésped.
     *
     * @return instancia de {@link Huesped} con los datos ingresados.
     */
    private static Huesped leerHuesped() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ocupación: ");
        String ocupacion = scanner.nextLine();
        System.out.print("Origen: ");
        String origen = scanner.nextLine();
        System.out.print("Tipo de huésped: ");
        String tipo = scanner.nextLine();
        return new Huesped(id, nombre, apellido, telefono, direccion, ocupacion, origen, tipo);
    }
}

