import java.util.ArrayList;
import java.util.Scanner;

public class Carrera {
    private String nombre;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Materia> materias;
    Scanner scanner = new Scanner(System.in);

    public Carrera(String nombre){
        setNombre(nombre);
        this.estudiantes = new ArrayList<>(); //Inicializa la lista
        this.materias = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getMaterias(){
        return materias.toString();
    }
    public void setMaterias(Materia materia){
        materias.add(materia);
    }

    public void agregarEstudiante(Estudiante est){
        estudiantes.add(est);
    }
    
    public void listarEstudiantes(){   
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println(estudiantes.get(i).toString());

        }
    }

    public void buscarEstudiante(String dni){
        boolean doc = false; //controlar que no siga la estructura
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getDocumento().equals(dni)) {
                System.out.println("Estudiante encontrado!");
                System.out.println(estudiantes.get(i).toString());
                doc = true;
                break;
            }
        }
        if(doc == false){
            System.out.println("Estudiante no encontrado");
        }
    }

    public String toString(){
        return nombre; 
    } 

}