import java.util.Map;
import java.util.HashMap;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String codigo;
    private String fechaNacimiento;
    private String correo;
    private Map<String, Double> resultadosExamenes;

    public Estudiante(String nombre, String apellido, String codigo, String fechaNacimiento, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.resultadosExamenes = new HashMap<>();
    }

    public void agregarResultadoExamen(String asignatura, double nota) {
        resultadosExamenes.put(asignatura, nota);
    }

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

    public Map<String, Double> getResultadosExamenes() {
        return resultadosExamenes;
    }
}