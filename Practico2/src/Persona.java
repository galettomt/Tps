public class Persona {
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String documento;

    public Persona(String nombre, String apellido, int edad, String documento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }

    public String getDocumento(){
        return documento;
    }
    public void setDocumento(String documento){
        this.documento = documento;
    }

    public String toString(){
        return "Nombre completo:" + nombre + " " + apellido + ", Edad: " + edad + ", Documento: " + documento;
    }

    public boolean equals(Persona persona2){
        return this.documento.equals(persona2.documento);
    }

    public int hashCode(){
        return documento.hashCode();
    }

}