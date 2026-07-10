import java.util.ArrayList;

public class ListaDeTareas {
    private ArrayList<Tarea> tareas;

    public ListaDeTareas(){
        this.tareas = new ArrayList<Tarea>();
    }

    public void agregarTarea(Tarea t){
        tareas.add(t);
    }

    public void marcarComoCompletada(int indice){
        if (indice >= 0 && indice < tareas.size()) {
            if (tareas.get(indice).getcompletada() == true) {
                tareas.get(indice).setCompletada(false);
                System.out.println("Tarea desmarcada con exito");
                return;
            }else{
                tareas.get(indice).setCompletada(true);
                System.out.println("Tarea marcada con exito");
            }
        } else{
            System.out.println("Indice  invalido: " + indice);
        }
    }

    public void mostrarTodas(){
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas en la lista");
            return;
        }

        for (int i = 0; i < tareas.size(); i++) {
            System.out.println("Tarea #" + (i+1));
            tareas.get(i).mostrar();
            System.out.println();
        }
    }

    public int buscarPorTitulo(String texto){
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getTitulo().toLowerCase().contains(texto.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    public void eliminarTarea(int indice){
        if (indice < 0 || indice >= tareas.size()) {
            System.out.println("Indice invalido: " + indice);
            return;
        }
        tareas.remove(indice);
    }

}
