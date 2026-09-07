import java.util.ArrayList;
public class Docente {
    private String nombre;
    private String identificacion;
    private ArrayList<Curso> cursos;

    public Docente(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.cursos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }   

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public Curso buscarCurso(String nombre) {
        for (Curso curso : cursos) {
            if (curso.getNombre().equals(nombre)) {
                return curso;
            }
        }
        return null;
    }

    public void verCursos() {
        System.out.println("Cursos del docente " + nombre + ":");
        for (Curso curso : cursos) {
            System.out.println("- " + curso.getNombre());
            System.out.println("  Estudiantes:"+curso.getEstudiantes().size());
        }
    }

    public Estudiante buscarEstudiante(String codigo) {
        for (Curso curso : cursos) {
            Estudiante estudiante = curso.buscarEstudiante(codigo);
            if (estudiante != null) {
                return estudiante;
            }
        }
        return null;
    }
    
}