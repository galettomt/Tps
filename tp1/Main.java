import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDeTareas lista = new ListaDeTareas();
        int op; //opcion del menu1
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("=== MENU ===");
            System.out.print("1.Agregar tarea\n2.Ver lista de tareas\n3.Marcar tarea\n4.Buscar tarea\n5.Eliminar tarea\n0.Salir\n-> ");
            op = scanner.nextInt();
            if (op < 0 || op > 5) {
                System.out.println("Error: OPCION INVALIDA");
            }
            scanner.nextLine();
            

            switch (op) {
                case 1:{
                    System.out.println("---AGREGAR TAREA");
                    System.out.print("Ingrese Titulo: ");
                    String tar = scanner.nextLine();

                    System.out.print("Ingrese descripcion: ");
                    String desc = scanner.nextLine();
                    Tarea t = new Tarea(tar, desc);

                    lista.agregarTarea(t);
                    break;
                }
                case 2:{
                    System.out.println("---LISTA DE TAREAS");
                    lista.mostrarTodas();
                    break;
                }
                case 3:{
                    System.out.println("---MARCAR/DESMARCAR TAREA");
                    System.out.print("Ingrese el indice de la tarea: ");
                    int completa = scanner.nextInt();
                    lista.marcarComoCompletada(completa);
                    break;
                }
                case 4:{
                    System.out.println("---BUSCADOR DE TAREAS");
                    System.out.print("Ingrese el TITULO de la tarea a buscar: ");
                    String titulo = scanner.nextLine();
                    int indice = lista.buscarPorTitulo(titulo);
                    if (indice != -1) {
                        System.out.println("Tarea encontrada en el Indice #" + indice);
                    } else{
                        System.out.println("No se encontro ninguna tarea con ese nombre");
                    }
                    break;
                }
                case 5:{
                    System.out.println("---ELIMINAR TAREA");
                    System.out.print("Ingrese el indice de la tarea a eliminar: ");
                    int eliminar = scanner.nextInt();
                    lista.eliminarTarea(eliminar);
                    System.out.println("Tarea eliminada con exito");
                    break;
                }
            
            }
        } while (op != 0);   

    }
}
