package servicios;

import modelo.dominio.*;

public class ServicioDemo {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Modo esperado: huesped o empleado");
            return;
        }

        switch (args[0]) {
            case "huesped" -> ejecutarHuespedDemo();
            case "empleado" -> ejecutarEmpleadoDemo();
            default -> System.err.println("Modo no valido: " + args[0]);
        }
    }

    private static void ejecutarHuespedDemo() {
        HuespedServiceImpl service = new HuespedServiceImpl();
        service.registrarPersona(new Huesped(1, "Juan", "Perez", "123", "Calle 1", "Ingeniero", "Bogota", "VIP"));
        System.out.println("Listado inicial: " + service.totalPersonas());
        Persona encontrada = service.buscarPersona(1);
        System.out.println("Buscar 1: " + (encontrada != null ? ((Huesped) encontrada).getNombre() : "null"));
        service.eliminarPersona(1);
        System.out.println("Listado final: " + service.totalPersonas());
    }

    private static void ejecutarEmpleadoDemo() {
        EmpleadoServiceImpl service = new EmpleadoServiceImpl();
        service.registrarPersona(new Empleado(1, "Ana", "Gomez", "555", "Calle 2", "Recepcionista"));
        Persona encontrada = service.buscarPersona(1);
        System.out.println("Buscar 1: " + (encontrada != null ? ((Empleado) encontrada).getNombre() : "null"));
        service.actualizarPersona(new Empleado(1, "Ana", "Gomez", "555", "Calle 2", "Gerente"));
        Empleado actualizado = (Empleado) service.buscarPersona(1);
        System.out.println("Cargo actualizado: " + actualizado.getCargo());
    }
}
