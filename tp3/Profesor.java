public class Profesor extends Persona{
    protected String especialidad;
    protected int anosExperiencia;
    protected String materiasAsignadas;

    public Profesor(String nombre, String apellido, int edad, String documento, String materia, String especialidad, int anosExperiencia){
        super(nombre, apellido, edad, documento);
        setMateriasAsignadas(materia);
        setAnosExperiencia(anosExperiencia);
        setEspecialidad(especialidad);
    }

    public String getEspecialidad(){
        return especialidad;
    }
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }

    public int getAnosExperiencia(){
        return anosExperiencia;
    }
    public void setAnosExperiencia(int anosExperiencia){
        this.anosExperiencia = anosExperiencia;
    }

    public String getMateriasAsignadas(){
        return materiasAsignadas;
    }
    public void setMateriasAsignadas(String materiasAsignadas){
        this.materiasAsignadas = materiasAsignadas;
    }

    public void asignarMateria(Materia materia){
        this.materiasAsignadas = materia.getNombre();
    }

    public String toString(){
        return("\n--------\nNombre Completo: " + nombre + " " + apellido + "\nEdad: " + edad + "\nDocumento: " + documento + "\nEspecialidad: " + especialidad + "\nAños de Experiencia: " + anosExperiencia + "\n--------\n");
    }
    
}