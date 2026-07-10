public class Materia {
    private String nombre;
    private String codigo;
    private int creditos;
    private float calificacion;
    private Profesor profesor;

    public Materia(String nombre, String codigo, int creditos, float calificacion){
        setNombre(nombre);  
        setCodigo(codigo);
        setCreditos(creditos);
        setCalificacion(calificacion);
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public int getCreditos(){
        return creditos;
    }
    public void setCreditos(int creditos){
        this.creditos = creditos;
    }

    public float getCalificacion(){
        return calificacion;
    }
    public void setCalificacion(float calificacion){
        this.calificacion = calificacion;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public String toString(){
        String nombreProfesor = (profesor != null) ? profesor.getNombre() : "(Sin profesor asignado)";
        return "Nombre Materia: " + nombre + ", Profesor: " + nombreProfesor + ", Codigo: " + codigo + ", Creditos: " + creditos + ", Calificacion: " + calificacion;
    }

    public boolean equals(Materia materia2){
        return this.nombre.equals(materia2.nombre);
    }

    public int hashCode(){
        return nombre.hashCode();
    }
    
}
