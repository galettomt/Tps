import java.util.ArrayList;

public class Estudiante extends Persona{
    private String carrera;
    private float promedio;
    private ArrayList<Materia> materias;

    public Estudiante(String nombre, String apellido, int edad, String documento, String carrera, float promedio){
        super(nombre, apellido, edad, documento);
        setCarrera(carrera);
        setPromedio(promedio);
        this.materias = new ArrayList<Materia>();
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
    public void setPromedio(float promedio){
        if (promedio < 0 || promedio > 10) {
            System.out.println("Error: Promedio fuera de rango (0-10)");
            return;
        }else{
            this.promedio = promedio;
        }   
    }

    //metodos para gestionar materias
    public void agregarMateria(Materia materia){
        materias.add(materia);
    }

    public void calcularPromedio(){
        float suma = 0;

        for (int i = 0; i < materias.size(); i++) {
            suma += materias.get(i).getCalificacion();
        }

        promedio = suma / materias.size();
    }

    public String toString(){
        return "Nombre Completo: " + nombre + " " + apellido + ", Edad: " + edad + ", Documento: " + documento + ", Carrera: " + carrera + ", Promedio: " + promedio;
    }
}
