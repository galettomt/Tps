public class ArbolBinario {
    protected Nodo raiz;

    public static Nodo nuevoArbol(Nodo ramaIzq, Object dato, Nodo ramaDer){
        return new Nodo(ramaIzq, dato, ramaDer);
    }

    public ArbolBinario(){
        raiz = null;
    }

    public ArbolBinario(Nodo raiz){
        this.raiz = raiz;
    }

    public Nodo raizArbol(){
        return raiz;
    }

    boolean esVacio(){
        return raiz == null;
    }

    // Recorrido de un arbol binario en preorden
    public static void preorden(Nodo r){
        if (r != null){
            r.visitar();
            preorden (r.subarbolIzq());
            preorden (r.subarbolDer());
        }
    } 
    
    // Recorrido de un arbol binario en inorden
    public static void inorden(Nodo r){
        if (r != null){
            inorden (r.subarbolIzq());
            r.visitar();
            inorden (r.subarbolDer());
        }
    } 
    
    // Recorrido de un arbol binario en postorden
    public static void postorden(Nodo r){
        if (r != null){
            postorden (r.subarbolIzq());
            postorden (r.subarbolDer());
            r.visitar();
        }
    }
}