public class Materia {
    private String nombre;
    private String codigo;
    private int creditos;
    private float calificacion;
    private Profesor profesor;
    private float nota1;
    private float nota2;

    public Materia(String nombre, String codigo, int creditos){
        setNombre(nombre);  
        setCodigo(codigo);
        setCreditos(creditos);
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

    public void setNota1(float nota){
        if (nota < 0 || nota > 10) {
            System.out.println("Error: Nota fuera de rango (0-10)");
            return;
        }
        this.nota1 = nota;
    }
    public void setNota2(float nota){
        if (nota < 0 || nota > 10) {
            System.out.println("Error: Nota fuera de rango (0-10)");
            return;
        }
        this.nota2 = nota;
    }


    public float getCalificacion(){
        return (nota1 + nota2);
    }
    public void setCalificacion(float calificacion){
        if (calificacion < 0 || calificacion > 10) {
            System.out.println("Error: Calificacion fuera de rango (0-10)");
            return;
        }else{
            this.calificacion = calificacion;
        }
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
