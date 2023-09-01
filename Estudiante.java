//Adrián López 231361
//Programación Orientada a Objetos

// Se importan las clases necesarias.
import java.util.Map;
import java.util.HashMap;

public class Estudiante { // Definición de la clase Estudiante.
    private String nombre; // Propiedades (atributos) privados de la clase Estudiante.
    private String apellido;
    private String codigo;
    private String fechaNacimiento;
    private String correo;
    private Map<String, Double> resultadosExamenes;

    // Constructor de la clase Estudiante que recibe los datos iniciales.
    public Estudiante(String nombre, String apellido, String codigo, String fechaNacimiento, String correo) {
        this.nombre = nombre; // Inicialización de las propiedades con los valores proporcionados en el constructor.
        this.apellido = apellido;
        this.codigo = codigo;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.resultadosExamenes = new HashMap<>();
    }

    // Método para agregar el resultado de un examen para este estudiante.
    public void agregarResultadoExamen(String asignatura, double nota) {
        resultadosExamenes.put(asignatura, nota);
    }

    // Métodos de acceso (getters) para obtener los valores de las propiedades.
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    // Método para obtener el mapa de resultados de exámenes.
    public Map<String, Double> getResultadosExamenes() {
        return resultadosExamenes;
    }
}