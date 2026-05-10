import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op;
        ArrayList<Carrera> carreras = new ArrayList<>();
        ArrayList<Materia> materias = new ArrayList<>();
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        ArrayList<Profesor> profesores = new ArrayList<>();
        Carrera carrera = null;
        Carrera carreraEncontrada = null;

        do {
            System.out.println("M E N U");
            System.out.print("1. Agregar carrera\n2. Agregar Estudiante\n3. Agregar Materia\n4. Mostrar promedio\n5. Listas generales\n6. Buscar estudiante\n7. Agregar profesor\n0. Salir\n-> ");
            op = sc.nextInt();
            sc.nextLine();
            
            switch (op) {
                case 1:
                    System.out.print("Ingrese el nombre de la carrera: ");
                    String nombreCarrera = sc.nextLine();
                    carrera = new Carrera(nombreCarrera);
                    carreras.add(carrera);
                    break;
                case 2:
                    if (carrera == null){
                        System.out.println("Primero debe crear una carrera.");
                        break;
                    }
                    System.out.println("===AGREGAR ESTUDIANTE===");
                    System.out.print("Nombre: ");
                    String nombreEstudiante = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoEstudiante = sc.nextLine();
                    System.out.print("Edad: ");
                    int edadEstudiante = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Dni: ");
                    String documentoEstudiante = sc.nextLine();

                    boolean documentoExistente = false; //controlar que el dni no exista
                    for (int i = 0; i < estudiantes.size(); i++) {
                        if (estudiantes.get(i).getDocumento().equals(documentoEstudiante)){
                            documentoExistente = true;
                            break;
                        }
                    }
                    if (documentoExistente) {
                        System.out.println("Ya existe un estudiante con ese documento, No se pudo agregar al alumno");
                        break;
                    }

                    System.out.print("Carrera a la que pertenece: ");
                    String carreraEstudiante = sc.nextLine();

                    carreraEncontrada = null;
                    for (int i = 0; i < carreras.size(); i++) {
                        if (carreras.get(i).getNombre().equalsIgnoreCase(carreraEstudiante)){
                            carreraEncontrada = carreras.get(i);
                            break;
                        }
                    } 
                    if (carreraEncontrada == null) {
                        System.out.println("Carrera no encontrada, No se pudo agregar al alumno");
                        break;
                    }

                    System.out.print("Ingrese promedio general del alumno: ");
                    float promedioEstudiante = sc.nextFloat();
                    sc.nextLine();

                    //Creo el estudiante y lo agrego a la carrera
                    Estudiante estudiante = new Estudiante(nombreEstudiante, apellidoEstudiante, edadEstudiante, documentoEstudiante, carreraEstudiante, promedioEstudiante);
                    estudiante.setPromedio(promedioEstudiante); //Verifico que el promedio sea entre 0 y 10
                    carreraEncontrada.agregarEstudiante(estudiante);    
                    estudiantes.add(estudiante); //lo agrego al ArrayList de estudiantes
                    System.out.println("Estudiante agregado correctamente a la carrera: " + carreraEncontrada);
                    break;
                case 3:
                    System.out.println("===AGREGAR MATERIA===");
                    System.out.println("--Lista de materias--");
                    for (int i = 0; i < materias.size(); i++){
                        System.out.println((i + 1) + ") " + materias.get(i).toString());
                    }

                    System.out.print("Ingrese el nombre de la materia: ");
                    String nombreMateria = sc.nextLine();
                    System.out.print("Ingrese el Codigo de la materia: ");
                    String codigoMateria = sc.nextLine();
                    System.out.print("Ingrese los creditos de la materia: ");
                    int creditosMateria = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese la calificacion de la materia: ");
                    float califMateria = sc.nextFloat();
                    sc.nextLine();

                    Materia materia = new Materia(nombreMateria, codigoMateria, creditosMateria, califMateria);
                    materias.add(materia);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del estudiante al que le quiera calcular el promedio: ");
                    String nombre = sc.nextLine();

                    Estudiante estudianteEncontrado = null; //lo pongo en null para controlar que exista el alumno en la lista
                    for (int i = 0; i < estudiantes.size(); i++) {
                        if (estudiantes.get(i).getNombre().equalsIgnoreCase(nombre)) {
                            estudianteEncontrado = estudiantes.get(i); //le saco el estado de null para saber que lo encontro
                            break;
                        }
                    }

                    if (estudianteEncontrado != null) {
                        System.out.println("Promedio de " + estudianteEncontrado.getNombre() + ": " + estudianteEncontrado.getPromedio());
                    } else{
                        System.out.println("Estudiante no encontrado");
                    }
                    break;
                case 5:
                    if (carrera != null) {
                        System.out.println("===LISTAS GENERALES===");
                        System.out.println("Ingrese la opcion de la lista que desea ver");
                        int opLista;
                        do{
                            System.out.println("1) Listar Estudiantes\n2) Listar Materias\n3) Listar Profesores\n-> ");
                            opLista = sc.nextInt();

                            if (opLista < 1 || opLista > 3) {
                                System.out.println("Error: opcion invalida.");
                            }
                        }while(opLista < 1 || opLista > 3);
                        sc.nextLine();

                            switch (opLista) {
                                case 1:
                                    for (int i = 0; i < carreras.size(); i++) {
                                        carreras.get(i).listarEstudiantes();
                                    }
                                    break;
                                case 2:
                                    for (int i = 0; i < materias.size(); i++) {
                                        System.out.println(materias.get(i).toString());
                                    }
                                    break;
                                case 3:
                                    for (int i = 0; i < materias.size(); i++) {
                                        System.out.println(profesores.get(i).toString());
                                    }
                                    break;
                            }
                    }else{
                        System.out.println("No hay carreras creadas");
                    }
                    
                    break;
                case 6:
                    if (carrera != null) {
                        System.out.println("===BUSQUEDA DE ESTUDIANTES==");
                        System.out.print("Ingrese el Dni del estudiante: ");
                        String dni = sc.nextLine();

                        for (int i = 0; i < carreras.size(); i++) {
                            carreras.get(i).buscarEstudiante(dni);
                        }
                    }else{
                        System.out.println("No hay carreras creadas");
                    }
                    break;
                case 7:
                    if (materias.isEmpty()) {
                        System.out.println("No hay materias creadas, debe crear una primero");
                        break;
                    }        

                    System.out.println("===AGREGAR PROFESOR===");
                    System.out.println("A que materia desea agregar al profesor");
                    System.out.println("--Lista de materias--");
                    for (int i = 0; i < materias.size(); i++){
                        System.out.println(i + ". " + materias.get(i).toString());
                    }
                    System.out.println("-> ");
                    int opMateria = sc.nextInt();
                    sc.nextLine();
                    String mateProfe = materias.get(opMateria).getNombre(); 

                    System.out.println("--Datos a llenar del profesor--");
                    System.out.print("Nombre: ");
                    String nombreProfe = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoProfe = sc.nextLine();
                    System.out.print("Edad: ");
                    int edadProfe = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Dni: ");
                    String documentoProfe = sc.nextLine();
                    System.out.print("Especialidad: ");
                    String especialidad = sc.nextLine();
                    System.out.print("Años de experiencia: ");
                    int anosExperiencia = sc.nextInt();
                    sc.nextLine();

                    Profesor profesor = new Profesor(nombreProfe, apellidoProfe, edadProfe, documentoProfe, mateProfe, especialidad, anosExperiencia);
                    materias.get(opMateria).setProfesor(profesor);
                    System.out.println("Profesor agregado correctamente a la materia: " + mateProfe);
                    profesores.add(profesor); //agrego a la lista general
                    break;
            }

        } while (op != 0);

        
    }
}