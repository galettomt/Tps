public class Personal extends Persona{
    protected String departamento;
    protected String puesto;
    protected String fechaIngreso;


    public Personal(String nombre, String apellido, int edad, String documento, String departamento, String puesto, String fechaIngreso){
        super(nombre, apellido, edad, documento);
        setDepartamento(departamento);
        setPuesto(puesto);
        setFechaIngreso(fechaIngreso);
    }

    public String getDepartamento(){
        return departamento;
    }
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    public String getPuesto(){
        return puesto;
    }
    public void setPuesto(String puesto){
        this.puesto = puesto;
    }

    public String getFechaIngreso(){
        return fechaIngreso;
    }
    public void setFechaIngreso(String fechaIngreso){
        this.fechaIngreso = fechaIngreso;
    }

    public String toString(){
        return "Nombre Completo: " + nombre + " " + apellido + ", Edad: " + edad + ", Documento: " + documento + ", Departamento: " + departamento + ", Puesto: " + puesto + ", Fecha de Ingreso: " + fechaIngreso;
    }
}