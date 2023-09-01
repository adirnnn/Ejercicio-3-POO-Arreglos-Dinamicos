//Adrián López 231361
//Programación Orientada a Objetos

// Se importan las clases necesarias.
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

// Definición de la clase Universidad.
public class Universidad {
    private List<Sede> sedes;  // Propiedad privada que almacena una lista de sedes de la universidad.

    public Universidad() { // Constructor de la clase Universidad.
        this.sedes = new ArrayList<>();  // Inicialización de la lista de sedes como una nueva lista vacía.
        // Tres sedes predefinidas
        sedes.add(new Sede("Sede del Sur"));
        sedes.add(new Sede("Sede del Norte"));
        sedes.add(new Sede("Sede Central"));
    }

    public void agregarSede(Sede sede) { // Método para agregar una sede a la lista de sedes.
        sedes.add(sede);
    }

    public List<Sede> getSedes() { // Método de acceso (getter) para obtener la lista de sedes.
        return sedes;
    }

    public void obtenerEstadisticasExamenes() { // Método para obtener estadísticas de los exámenes para todas las sedes y estudiantes.
        for (Sede sede : sedes) { // Se itera a través de todas las sedes.
            System.out.println("Sede: " + sede.getNombre());
            List<Estudiante> estudiantes = sede.getEstudiantes();

            if (estudiantes.isEmpty()) { // Se verifica si no hay estudiantes registrados en la sede.
                System.out.println("No hay estudiantes registrados en esta sede.");
                continue;
            }

            Set<String> examenes = estudiantes.get(0).getResultadosExamenes().keySet(); // Se obtiene el conjunto de nombres de exámenes a partir del primer estudiante.
            for (String examen : examenes) {  // Se itera a través de los exámenes.
                List<Double> notas = new ArrayList<>();
                for (Estudiante estudiante : estudiantes) { // Se obtiene la nota del estudiante para el examen actual.
                    Double nota = estudiante.getResultadosExamenes().getOrDefault(examen, 0.0);
                    notas.add(nota);
                }

                // Estadísticas

                int cantidadEstudiantes = notas.size();
                double notaMinima = notas.stream().min(Double::compareTo).orElse(0.0);
                double notaMaxima = notas.stream().max(Double::compareTo).orElse(0.0);
                double promedio = notas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                double mediana = calcularMediana(notas);
                double moda = calcularModa(notas);
                double desviacionEstandar = calcularDesviacionEstandar(notas);

                // Se imprimen las estadísticas del examen actual.

                System.out.println("Examen: " + examen);
                System.out.println("Cantidad de estudiantes: " + cantidadEstudiantes);
                System.out.println("Nota Mínima: " + notaMinima);
                System.out.println("Nota Máxima: " + notaMaxima);
                System.out.println("Promedio: " + promedio);
                System.out.println("Mediana: " + mediana);
                System.out.println("Moda: " + moda);
                System.out.println("Desviación Estándar: " + desviacionEstandar + "\n");
            }
        }
    }

    private double calcularMediana(List<Double> notas) {  // Método privado para calcular la mediana del conjunto de notas.
        notas.sort(Double::compareTo); // Para ordenar la lista de notas.
        int n = notas.size();

        if (n % 2 == 0) { // Si hay un número par de elementos, calculamos el promedio de los dos valores del medio.
            int medio = n / 2; 
            double mediana = (notas.get(medio - 1) + notas.get(medio)) / 2.0;
            return mediana;
        } else { // Si hay un número impar de elementos, la mediana es el valor del medio.
            return notas.get(n / 2);
        }
    }

    private double calcularModa(List<Double> notas) { // Método privado para calcular la moda de un conjunto de notas.
        Map<Double, Integer> frecuencia = new HashMap<>();
        double moda = notas.get(0);
        int maxFrecuencia = 1;

        for (double nota : notas) { // Contamos la frecuencia de cada nota y encontramos la moda.
            frecuencia.put(nota, frecuencia.getOrDefault(nota, 0) + 1);
            if (frecuencia.get(nota) > maxFrecuencia) {
                moda = nota;
                maxFrecuencia = frecuencia.get(nota);
            }
        }

        return moda;
    }

    private double calcularDesviacionEstandar(List<Double> notas) { // Método privado para calcular la desviación estándar de un conjunto de notas.
        double media = notas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        double sumatoria = 0.0;

        for (double nota : notas) {
            sumatoria += Math.pow(nota - media, 2);
        }

        return Math.sqrt(sumatoria / (notas.size() - 1));
    }
}