public class IndiceEstudiantes {
    private Estudiante[] tabla;
    private int tamaño;
    private double factorCargaMax;
    private int cantidadActual;

    public IndiceEstudiantes(int tamaño, double factorCargaMax) {
        this.tamaño = tamaño;
        this.factorCargaMax = factorCargaMax;
        this.cantidadActual = 0;

        tabla = new Estudiante[tamaño];
    }

    private int hash(String clave) {
        int suma = 0;

        for (int i = 0; i < clave.length(); i++) {
            suma += (int) clave.charAt(i); // convierte cada char a su valor ASCII y suma
        }

        return suma % tamaño; // módulo para que el índice entre en la tabla
    }

    public void insertar(Estudiante e) {
        //verifico factor de carga antes de insertar
        if (cantidadActual >= tamaño * factorCargaMax) {
            System.out.println("Error: factor de carga excedido.");
            return;
        }

        int indiceBase = hash(e.getLegajo());

        for (int i = 0; i < tamaño; i++){
            int indice = (indiceBase + i * i) % tamaño; //exploracion cuadratica

            //buscar posicion libre para insertar
            if (tabla[indice] == null) {
                tabla[indice] = e;
                cantidadActual++;
                System.out.println("Insertado en indice " + indice + " (intento " + i + ")");
                return;
            }
        }

        System.out.println("Error: Tabla llena.");
    }

    public Estudiante buscar(String legajo) {
        int indiceBase = hash(legajo);

        for (int i = 0; i < tamaño; i++) {
            int indice = (indiceBase + i * i) % tamaño; 
            
            if(tabla[indice] == null){
                return null;
            }

            if (tabla[indice].getLegajo().equals(legajo)) {
                return tabla[indice];
            }
        }

        return null; //no encontrado
    }
}
