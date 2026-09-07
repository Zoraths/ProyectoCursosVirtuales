public class ProyectoFinal extends Evaluacion {
    private String tema;

    public ProyectoFinal(String tema, double ponderacion) {
        this.tema = tema;
        setPonderacion(ponderacion);       
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public void calificar(double nota) {
        setNota(nota);
    }

    @Override
    public double obtenerNotaPonderada() {
        return getNota() * getPonderacion();
    }
    
}
