import java.util.ArrayList;
public class Estudiante {
    private String nombre;
    private String codigo;
    private ArrayList<Parcial> parciales = new ArrayList<>();
    private ArrayList<ProyectoFinal> proyectosFinales = new ArrayList<>();
    private ArrayList<Curso> cursos = new ArrayList<>();

    public Estudiante(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;       
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Parcial> getParciales() {
        return parciales;
    }
    
    public void setParciales(ArrayList<Parcial> parciales) {
        this.parciales = parciales;
    }
    
    public ArrayList<ProyectoFinal> getProyectosFinales() {
        return proyectosFinales;
    }

    public void setProyectosFinales(ArrayList<ProyectoFinal> proyectosFinales) {
        this.proyectosFinales = proyectosFinales;
    }

    public void agregarProyectoFinal(ProyectoFinal proyectoFinal) {
        
        proyectosFinales.add(proyectoFinal);
        
    }

    public void agregarParcial(Parcial parcial) {        
        parciales.add(parcial);
    }

    public void agregarCurso(String nombre) {
        Curso cursoss = new Curso(nombre);
        cursos.add(cursoss);
    }
    public void verCursos(){
        System.out.println("Cursos del estudiante " + nombre + ":");
        for (Curso curso : cursos) {
            System.out.println("- " + curso.getNombre());
        }
    }
}
