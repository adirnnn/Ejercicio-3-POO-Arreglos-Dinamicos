import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Universidad {
    private List<Sede> sedes;

    public Universidad() {
        this.sedes = new ArrayList<>();
        // Tres sedes predefinidas
        sedes.add(new Sede("Sede del Sur"));
        sedes.add(new Sede("Sede del Norte"));
        sedes.add(new Sede("Sede Central"));
    }

    public void agregarSede(Sede sede) {
        sedes.add(sede);
    }

    public List<Sede> getSedes() {
        return sedes;
    }

    public void obtenerEstadisticasExamenes() {
        for (Sede sede : sedes) {
            System.out.println("Sede: " + sede.getNombre());
            List<Estudiante> estudiantes = sede.getEstudiantes();

            if (estudiantes.isEmpty()) {
                System.out.println("No hay estudiantes registrados en esta sede.");
                continue;
            }

            Set<String> examenes = estudiantes.get(0).getResultadosExamenes().keySet();
            for (String examen : examenes) {
                List<Double> notas = new ArrayList<>();
                for (Estudiante estudiante : estudiantes) {
                    Double nota = estudiante.getResultadosExamenes().getOrDefault(examen, 0.0);
                    notas.add(nota);
                }
                int cantidadEstudiantes = notas.size();
                double notaMinima = notas.stream().min(Double::compareTo).orElse(0.0);
                double notaMaxima = notas.stream().max(Double::compareTo).orElse(0.0);
                double promedio = notas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                double mediana = calcularMediana(notas);
                double moda = calcularModa(notas);
                double desviacionEstandar = calcularDesviacionEstandar(notas);

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

    private double calcularMediana(List<Double> notas) {
        notas.sort(Double::compareTo);
        int n = notas.size();

        if (n % 2 == 0) {
            int medio = n / 2;
            double mediana = (notas.get(medio - 1) + notas.get(medio)) / 2.0;
            return mediana;
        } else {
            return notas.get(n / 2);
        }
    }

    private double calcularModa(List<Double> notas) {
        Map<Double, Integer> frecuencia = new HashMap<>();
        double moda = notas.get(0);
        int maxFrecuencia = 1;

        for (double nota : notas) {
            frecuencia.put(nota, frecuencia.getOrDefault(nota, 0) + 1);
            if (frecuencia.get(nota) > maxFrecuencia) {
                moda = nota;
                maxFrecuencia = frecuencia.get(nota);
            }
        }

        return moda;
    }

    private double calcularDesviacionEstandar(List<Double> notas) {
        double media = notas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        double sumatoria = 0.0;

        for (double nota : notas) {
            sumatoria += Math.pow(nota - media, 2);
        }

        return Math.sqrt(sumatoria / (notas.size() - 1));
    }
}
