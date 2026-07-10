import TipoPila.PilaVector;

public class App {
    public static void main(String[] args) {
        try{
            ArbolBinario arbol;
            Nodo a1, a2, a;
            PilaVector pila = new PilaVector();

            // Subarbol izquierdo
            a1 = ArbolBinario.nuevoArbol(null,"Maria",null);
            a2 = ArbolBinario.nuevoArbol(null,"Rodrigo",null);
            a = ArbolBinario.nuevoArbol(a1,"Esperanza",a2);
            pila.insertar(a);

            // Subarbol derecho
            a1 = ArbolBinario.nuevoArbol(null,"Anyora",null);
            a2 = ArbolBinario.nuevoArbol(null,"Abel",null);
            a = ArbolBinario.nuevoArbol(a1,"M Jesus",a2);
            pila.insertar(a);


            a2 = (Nodo) pila.quitar();
            a1 = (Nodo) pila.quitar();

            a = ArbolBinario.nuevoArbol(a1,"Luisa",a2);
            arbol = new ArbolBinario(a);

            // Recorridos
            System.out.print("Preorden:  ");
            ArbolBinario.preorden(arbol.raizArbol());
            System.out.println();

            System.out.print("Inorden:   ");
            ArbolBinario.inorden(arbol.raizArbol());
            System.out.println();

            System.out.print("Postorden: ");
            ArbolBinario.postorden(arbol.raizArbol());
            System.out.println();
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}