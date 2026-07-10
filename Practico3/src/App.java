import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op;
        ArrayList<Carrera> carreras = new ArrayList<>();
        ArrayList<Materia> materias = new ArrayList<>();
        ArrayList<Profesor> profesores = new ArrayList<>();
        Carrera carrera = null;
        Carrera carreraEncontrada = null;
        Estudiante estudianteEncontrado = null;
        
        //creo la universidad
        Universidad universidad = new Universidad("UNViMe", "Juan Llerena y Garcia Lorca");

        do {
            System.out.println("M E N U");
            System.out.print("1. Agregar carrera\n2. Agregar Estudiante\n3. Agregar Materia\n4. Mostrar promedio\n5. Listas generales\n6. Buscar estudiante\n7. Agregar profesor\n8. Cargar notas a estudiantes\n0. Salir\n-> ");
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
                    //creo variables
                    String nombreEstudiante, apellidoEstudiante, documentoEstudiante, carreraEstudiante, materiaEstudiante;
                    int edadEstudiante;

                    //controlo que primero cree una carrera y una materia para poder asignarle 
                    if (carreras.isEmpty() || materias.isEmpty()){
                        System.out.println("Primero debe crear una carrera/materia.");
                        break;
                    }

                    System.out.println("===AGREGAR ESTUDIANTE===");
                    System.out.print("Nombre: ");
                    nombreEstudiante = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellidoEstudiante = sc.nextLine();
                    System.out.print("Edad: ");
                    edadEstudiante = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Dni: ");
                    documentoEstudiante = sc.nextLine();

                    if (universidad.existeDni(documentoEstudiante)) {
                        System.out.println("ERROR: Ya existe un usuario registrado con ese dni");
                        break;
                    }
                                      
                    System.out.println("--Lista de carreras--");
                    for (int i = 0; i < carreras.size(); i++) {
                        System.out.println("- " + carreras.get(i).getNombre());
                    }

                    do{ 
                        System.out.print("Carrera a la que pertenece: ");
                        carreraEstudiante = sc.nextLine();

                        carreraEncontrada = null;
                    
                        for (int i = 0; i < carreras.size(); i++) {
                            if (carreras.get(i).getNombre().equalsIgnoreCase(carreraEstudiante)){
                                carreraEncontrada = carreras.get(i);
                                break;
                            }
                        } 
                        if (carreraEncontrada == null) {
                            System.out.println("Carrera no encontrada, Ingrese nuevamente");
                        }
                    }while (carreraEncontrada == null);
                    
                    //Creo el estudiante y lo agrego a la carrera
                    Estudiante estudiante = new Estudiante(nombreEstudiante, apellidoEstudiante, edadEstudiante, documentoEstudiante, carreraEstudiante);

                    System.out.println("Materia/s a la/s que se quiera inscribir");
                    System.out.println("--Lista de materias--");
                    for (int i = 0; i < materias.size(); i++) {
                        System.out.println("* " + materias.get(i).getNombre());
                    }

                    Materia materiaEncontrada = null;
                    do{
                        System.out.print("-> ");
                        materiaEstudiante = sc.nextLine();

                        materiaEncontrada = null;
                    
                        for (int i = 0; i < materias.size(); i++) {
                            
                            if (materias.get(i).getNombre().equalsIgnoreCase(materiaEstudiante)) {
                                materiaEncontrada = materias.get(i);
                                break;
                            }
                        }
                        if(materiaEncontrada == null){
                            System.out.println("Error: Materia no encontrada, ingrese nuevamente");
                        }
                    }while(materiaEncontrada == null);

                    carreraEncontrada.agregarEstudiante(estudiante);
                    estudiante.agregarMateria(materiaEncontrada);    
                    universidad.agregarEstudiante(estudiante);
                    System.out.println("Estudiante agregado correctamente a la carrera: " + carreraEncontrada + "\nLegajo asignado: " + estudiante.getLegajo());
                    break;
                case 3:
                    System.out.println("===AGREGAR MATERIA===");
                            
                    System.out.print("Ingrese el nombre de la materia: ");
                    String nombreMateria = sc.nextLine();
                    System.out.print("Ingrese el Codigo de la materia: ");
                    String codigoMateria = sc.nextLine();
                    System.out.print("Ingrese los creditos de la materia: ");
                    int creditosMateria = sc.nextInt();
                    sc.nextLine();

                    Materia materia = new Materia(nombreMateria, codigoMateria, creditosMateria);
                    materias.add(materia);

                    break;
                case 4:
                    System.out.println("Ingrese el dni del estudiante al que le quiera calcular el promedio: ");
                    String dniEstudiante = sc.nextLine();

                    estudianteEncontrado = universidad.getEstudianteDni(dniEstudiante);
                    if (estudianteEncontrado != null) {
                        System.out.println("Promedio de " + estudianteEncontrado.getNombre() + " " + estudianteEncontrado.getApellido() + ": " + estudianteEncontrado.getPromedio());
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
                                    if (universidad.hayEstudiantes()) {
                                        System.out.println("No hay estudiantes cargados, debe cargar uno primero");
                                        break;
                                    }
                                    for (int i = 0; i < carreras.size(); i++) {
                                        carreras.get(i).listarEstudiantes();
                                    }
                                    break;
                                case 2:
                                    if (materias.isEmpty()) {
                                        System.out.println("No hay materias cargadas, debe cargar una primero");
                                        break;
                                    }
                                    for (int i = 0; i < materias.size(); i++) {
                                        System.out.println(materias.get(i).toString());
                                    }
                                    break;
                                case 3:
                                    if (profesores.isEmpty()) {
                                        System.out.println("No hay profesores cargados, debe cargar uno primero");
                                        break;
                                    }
                                    for (int i = 0; i < profesores.size(); i++) {
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

                        estudianteEncontrado = universidad.getEstudianteDni(dni);

                        if (estudianteEncontrado != null) {
                            System.out.println("Estudiante encontrado\n" + estudianteEncontrado.toString());
                        }else{
                            System.out.println("Estudiante no encontrado");
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

                case 8:
                    if(universidad.hayEstudiantes()){
                        System.out.println("No hay estudiantes creados, debe crear uno primero");
                        break;
                    }
                    System.out.println("===CARGAR NOTAS A ESTUDIANTES===");
                    System.out.print("Ingrese el dni: ");
                    String dniEst = sc.nextLine();

                    estudianteEncontrado = universidad.getEstudianteDni(dniEst);

                    if (estudianteEncontrado != null) {
                        System.out.println("__LISTA DE MATERIAS__");
                        ArrayList<Materia> materiasEstudiante = estudianteEncontrado.getListaMaterias();
                        for (int i = 0; i < materiasEstudiante.size(); i++) {
                            System.out.println("- " + materiasEstudiante.get(i).getNombre());
                        }
                        System.out.print("En que materia desea cargar notas: ");
                        String materiaNota = sc.nextLine();
                        System.out.println("Materia: " + materiaNota);

                        Materia materiaSeleccionada = null;

                        for(int i = 0; i < materiasEstudiante.size(); i++){
                            if(materiasEstudiante.get(i).getNombre().equalsIgnoreCase(materiaNota)){
                                materiaSeleccionada = materiasEstudiante.get(i);
                                break;
                            }
                        }

                        if (materiaSeleccionada != null) {
                            System.out.print("Ingrese Nota del parcial 1: ");
                            float nota1 = sc.nextFloat();
                            sc.nextLine();
                            materiaSeleccionada.setNota1(nota1);

                            System.out.print("Ingrese Nota del parcial 2: ");
                            float nota2 = sc.nextFloat();
                            sc.nextLine();
                            materiaSeleccionada.setNota1(nota2);
                        } else{
                            System.out.println("Materia no encontrada");
                            break;
                        }
                    
                    }else{
                        System.out.println("Estudiante no encontrado");
                        break;
                    }   
     
                    estudianteEncontrado.calcularPromedio();
                    break;
            }   

        } while (op != 0);
   
    }
}