import java.util.ArrayList;

public class Universidad {
    private String nombre;
    private String direccion;
    private ArrayList<Estudiante> estudiantes;

    public Universidad(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.estudiantes = new ArrayList<>();
    }
}