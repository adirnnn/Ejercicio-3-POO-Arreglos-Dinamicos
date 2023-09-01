import java.util.ArrayList;
import java.util.List;

public class Sede {
    private String nombre;
    private List<Estudiante> estudiantes;

    public Sede(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}