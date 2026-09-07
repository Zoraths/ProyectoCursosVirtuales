public  class Parcial extends Evaluacion {
    private String nombreDelParcial;

    public Parcial(String nombreDelParcial, double ponderacion) {
        this.nombreDelParcial = nombreDelParcial;
        setPonderacion(ponderacion);
        
        
    }

    public String getNombreDelParcial() {
        return nombreDelParcial;
    }

    public void setNombreDelParcial(String nombreDelParcial) {
        this.nombreDelParcial = nombreDelParcial;
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
