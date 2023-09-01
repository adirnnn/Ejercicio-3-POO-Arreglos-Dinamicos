import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Universidad universidad = new Universidad();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Ingresar Resultados de Exámenes");
            System.out.println("3. Mostrar Estadísticas de Exámenes");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarEstudiante(universidad);
                    break;
                case 2:
                    ingresarResultados(universidad);
                    break;
                case 3:
                    mostrarEstadisticas(universidad);
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static void registrarEstudiante(Universidad universidad) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del estudiante:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Código único: ");
        String codigo = scanner.nextLine();
        System.out.print("Fecha de nacimiento: ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correo = scanner.nextLine();

        Estudiante estudiante = new Estudiante(nombre, apellido, codigo, fechaNacimiento, correo);
        Sede sede = seleccionarSede(universidad);

        if (sede != null) {
            sede.agregarEstudiante(estudiante);
            System.out.println("Estudiante registrado en la sede: " + sede.getNombre());
        } else {
            System.out.println("No se pudo registrar al estudiante. La sede seleccionada no existe.");
        }
    }

    private static void ingresarResultados(Universidad universidad) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el código único del estudiante: ");
        String codigoEstudiante = scanner.nextLine();

        for (Sede sede : universidad.getSedes()) {
            for (Estudiante estudiante : sede.getEstudiantes()) {
                if (estudiante.getCodigo().equals(codigoEstudiante)) {
                    System.out.println("Ingrese los resultados de exámenes para " + estudiante.getNombre() + " " + estudiante.getApellido() + ":");
                    for (String examen : estudiante.getResultadosExamenes().keySet()) {
                        System.out.print("Nota para " + examen + ": ");
                        double nota = scanner.nextDouble();
                        estudiante.agregarResultadoExamen(examen, nota);
                    }
                    System.out.println("Resultados de exámenes ingresados para el estudiante.");
                    return;
                }
            }
        }

        System.out.println("Estudiante no encontrado.");
    }

    private static void mostrarEstadisticas(Universidad universidad) {
        universidad.obtenerEstadisticasExamenes();
    }

    private static Sede seleccionarSede(Universidad universidad) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sedes disponibles:");

        for (int i = 0; i < universidad.getSedes().size(); i++) {
            System.out.println(i + ". " + universidad.getSedes().get(i).getNombre());
        }

        System.out.print("Seleccione el índice de la sede: ");
        int indiceSede = scanner.nextInt();

        if (indiceSede >= 0 && indiceSede < universidad.getSedes().size()) {
            return universidad.getSedes().get(indiceSede);
        } else {
            return null;
        }
    }
}