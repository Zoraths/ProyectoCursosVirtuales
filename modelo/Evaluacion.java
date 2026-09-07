public abstract class Evaluacion {
    private double ponderacion;
    private double  nota;

    

    public double getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(double ponderacion) {
        this.ponderacion = ponderacion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public abstract void calificar(double nota);

    public abstract double obtenerNotaPonderada();


}