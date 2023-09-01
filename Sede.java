//Adrián López 231361
//Programación Orientada a Objetos

// Importamos las clases necesarias para usar una array.
import java.util.ArrayList;
import java.util.List;

// Definición de la clase Sede.
public class Sede {
    // Propiedades (atributos) privados de la clase Sede.
    private String nombre;
    private List<Estudiante> estudiantes;

    // Constructor de la clase Sede que recibe un nombre para la sede.
    public Sede(String nombre) {
        // Inicialización de la propiedad 'nombre' con el valor proporcionado en el constructor.
        this.nombre = nombre;
        // Inicialización de la lista 'estudiantes' como nueva lista de estudiantes vacía.
        this.estudiantes = new ArrayList<>();
    }

    // Método para agregar un estudiante a la sede.
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    // Método de acceso (getter) para obtener el nombre de la sede.
    public String getNombre() {
        return nombre;
    }

    // Método de acceso (getter) para obtener la lista de estudiantes en la sede.
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}