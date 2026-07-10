import java.util.ArrayList;

public class Universidad {
    private String nombre;
    private String direccion;
    private IndiceEstudiantes indice;
    private ArrayList<Estudiante> estudiantes;

    public Universidad(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.estudiantes = new ArrayList<>();
        this.indice = new IndiceEstudiantes(17, 0.7);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
        indice.insertar(e);
    }

    //metodo para buscar un dni que exista para luego traerle los datos en el App
    public Estudiante getEstudianteDni(String dni){
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getDocumento().equals(dni)) {
                return estudiantes.get(i);
            }
        }
        return null;
    }

    //metodo para saber si estudiantes esta vacio o no
    public boolean hayEstudiantes() {
        return estudiantes.isEmpty();
    }

    //metodo para que verificar que cuando cree un estudiante no se repita el dni
    public boolean existeDni(String dni) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getDocumento().equals(dni)) {
                return true;
            }
        }
        return false;
    }

}