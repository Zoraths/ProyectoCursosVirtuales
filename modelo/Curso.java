import java.util.ArrayList;
public class Curso {
    private String nombre;
    private ArrayList<Estudiante> estudiantes;

    public Curso(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    public float calcularPromedioFinal(Estudiante estudiante) {
        ArrayList<Parcial> parciales = estudiante.getParciales();
        ArrayList<ProyectoFinal> proyectosFinales = estudiante.getProyectosFinales();

        float sumaPonderada = 0;
        

        for (Parcial parcial : parciales) {
            sumaPonderada += parcial.obtenerNotaPonderada();
            
        }

        for (ProyectoFinal proyecto : proyectosFinales) {
            sumaPonderada += proyecto.obtenerNotaPonderada();
            
        }

        return sumaPonderada;
    }
    public Estudiante buscarEstudiante(String codigo) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigo().equals(codigo)) {
                return estudiante;
            }
        }
        return null;
    }
    public boolean determinarAprobacion(String codigo) {
        Estudiante estudiante = buscarEstudiante(codigo);
        if (estudiante != null) {
            return calcularPromedioFinal(estudiante) >= 3.0;
        }
        return false;
    }
}
