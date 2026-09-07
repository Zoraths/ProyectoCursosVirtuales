import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        Docente docente = new Docente("Juan Perez", "123456789");
        Estudiante estudiante1 = new Estudiante("Maria Gomez", "A001");
        do{
            System.out.println("Bienvenido al sistema de gestión académica");
            System.out.println("Usted es 1.estudiante o 2. docente?");
            System.out.println("Ingrese 3 para salir");
            opcion = scanner.nextInt();
            
            if (opcion == 1 ){
                int opcionEstudiante;
                do {

                System.out.println("Menu de opciones para estudiantes:");
                System.out.println("1. Ver cursos");
                System.out.println("2. Ver promedio final");
                System.out.println("3. Ver si aprobo el curso");
                System.out.println("4. Salir");
                opcionEstudiante = scanner.nextInt();
                switch (opcionEstudiante) {
                    case 1:
                        scanner.nextLine();
                        System.out.println("Ingrese el código del estudiante:");
                        String codigoEstudiante1 = scanner.nextLine();
                        Estudiante estudiante = docente.buscarEstudiante(codigoEstudiante1);
                        if (estudiante != null) {
                            estudiante.verCursos();
                        } else {
                            System.out.println("Estudiante no encontrado.");
                        }
                        break;
                    case 2:
                        scanner.nextLine();
                        System.out.println("Ingrese el código del estudiante:");
                        String codigoEstudiante2 = scanner.nextLine();
                        Estudiante estudiante2 = docente.buscarEstudiante(codigoEstudiante2);
                        if (estudiante2 != null) {
                            float promedioFinal = 0;
                            for (Curso curso : docente.getCursos()) {
                                if (curso.buscarEstudiante(codigoEstudiante2) != null) {
                                    promedioFinal = curso.calcularPromedioFinal(estudiante2);
                                    break;
                                }
                            }
                            System.out.println("El promedio final del estudiante " + estudiante2.getNombre() + " es: " + promedioFinal);
                        } else {
                            System.out.println("Estudiante no encontrado.");
                        }
                        break;
                    case 3:
                        scanner.nextLine();
                        System.out.println("Ingrese el código del estudiante:");
                        String codigoEstudiante3 = scanner.nextLine();
                        boolean aprobo = false;
                        for (Curso curso : docente.getCursos()) {
                            if (curso.buscarEstudiante(codigoEstudiante3) != null) {
                                aprobo = curso.determinarAprobacion(codigoEstudiante3);
                                break;
                            }
                        }
                        if (aprobo) {
                            System.out.println("El estudiante " + codigoEstudiante3 + " aprobó el curso.");
                        } else {
                            System.out.println("El estudiante " + codigoEstudiante3 + " no aprobó el curso o no se encontró.");
                        }
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    }
                }while (opcionEstudiante != 4);    
            }
            if (opcion == 2 ){
                int opciones;
                do {
                    
                    System.out.println("Menu de opciones para docentes:");
                    System.out.println("1. Registrar curso");
                    System.out.println("2. Ver cursos");
                    System.out.println("3. Agregar estudiante a un curso");
                    System.out.println("4. Agregar proyecto y parcial al estudiante");
                    System.out.println("5. Salir");
                    
                    opciones = scanner.nextInt();
                    
                    switch (opciones) {
                        case 1:
                            scanner.nextLine();
                            System.out.println("Ingrese el nombre del curso:");
                            String nombre= scanner.nextLine();
                            docente.agregarCurso(new Curso(nombre));
                    
                            break;  
                        case 2:
                            docente.verCursos();
                            break;
                    case 3:
                        scanner.nextLine();
                        System.out.println("Ingrese el nombre del curso al que desea agregar un estudiante:");
                        String nombreCursosString = scanner.nextLine();
                        
                        System.out.println("Ingrese el nombre del estudiante:");
                        String nombreEstudiante = scanner.nextLine();
                        
                        System.out.println("Ingrese el código del estudiante:");
                        String codigoEstudiante = scanner.nextLine();
                        Curso curso = docente.buscarCurso(nombreCursosString);
                        if (curso != null) {
                            Estudiante estudiante = new Estudiante(nombreEstudiante, codigoEstudiante);
                            curso.agregarEstudiante(estudiante);
                            estudiante.agregarCurso(nombreCursosString);
                            System.out.println("Estudiante agregado al curso " + nombreCursosString);
                        } else {
                            System.out.println("Curso no encontrado.");
                        }
                            break;
                    case 4:
                            scanner.nextLine();
                            System.out.println("Ingrese el código del estudiante:");
                            String codigoES = scanner.nextLine();
                            Estudiante estudiante = docente.buscarEstudiante(codigoES);
                            System.out.println("Ingrese el nombre del Parcial, Ponderacion");
                            String parcialNonbre = scanner.nextLine();
                            
                            double ponderacion = scanner.nextDouble();
                            Parcial parcial = new Parcial(parcialNonbre,ponderacion);
                            System.out.println("Ingrese la Nota:");
                            double nota = scanner.nextDouble();
                            parcial.calificar(nota);
                            estudiante.agregarParcial(parcial);
                            scanner.nextLine();
                            System.out.println("Ingrese el nombre del Proyecto Final, Ponderacion");
                            String proyectoNombre = scanner.nextLine();
                            double proyectoPonderacion = scanner.nextDouble();
                            ProyectoFinal proyectoFinal = new ProyectoFinal(proyectoNombre,proyectoPonderacion);
                            System.out.println("Ingrese la Nota:");
                            double proyectoNota = scanner.nextDouble();
                            proyectoFinal.calificar(proyectoNota);
                            estudiante.agregarProyectoFinal(proyectoFinal);
                            break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                            break;
                
                    }
                
            } while (opciones != 5);
            

        }}while (opcion != 3);
        
            

        


    }
}
