import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;


public class Estudiante extends Persona{
    private String carrera;
    private float promedio;
    private ArrayList<Materia> materias;
    private String legajo;

    private static HashSet<String> legajosUsados = new HashSet<>();
    private static Random random = new Random();

    public Estudiante(String nombre, String apellido, int edad, String documento, String carrera){
        super(nombre, apellido, edad, documento);
        setCarrera(carrera);
        this.materias = new ArrayList<Materia>();
        setPromedio(0);
        this.legajo = generarLegajo();
    }

    private static String generarLegajo(){
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String legajo;
    
        do{
            StringBuilder sb = new StringBuilder(); //construye el string de a un carácter por vez, en cada iteración elige un índice aleatorio dentro de "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789" y agrega ese carácter.
            for (int i = 0; i < 4; i++) {
                int indice = random.nextInt(caracteres.length());
                sb.append(caracteres.charAt(indice));
            }
            legajo = sb.toString();
        } while(legajosUsados.contains(legajo));
    
        legajosUsados.add(legajo);
        return legajo;
    }

    public String getLegajo(){
        return legajo;
    }

    public String getCarrera(){
        return carrera;
    }
    public void setCarrera(String carrera){
        this.carrera = carrera;
    }

    public float getPromedio(){
        return promedio;
    }

    //metodos para gestionar materias
    public String getMaterias(){
        return materias.toString();
    }
    public void agregarMateria(Materia materia){
        materias.add(materia);
    }

    //calculamos el promedio
    public void calcularPromedio(){
        if (materias.isEmpty()) {
            return;
        }

        float suma = 0;

        for (int i = 0; i < materias.size(); i++) {
            suma += materias.get(i).getCalificacion();
        }

        promedio = suma / materias.size();
    }

    public void setPromedio(float promedio){
        
        if (promedio < 0 || promedio > 10) {
            System.out.println("Error: Promedio fuera de rango (0-10)");
            return;
        }

        this.promedio = promedio;
    }
    
    public ArrayList<Materia> getListaMaterias(){
        return materias;
    }

    public String toString(){
        return "Nombre Completo: " + nombre + " " + apellido + ", Edad: " + edad + ", Documento: " + documento + ", Carrera: " + carrera + ", Promedio: " + promedio;
    }
}
