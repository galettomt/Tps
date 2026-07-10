public class Nodo {
    protected Object dato;
    protected Nodo izq;
    protected Nodo der; 

    public Nodo(Object valor){
        dato = valor;
        izq = der = null; 
    }

    public Nodo(Nodo ramaIzq, Object valor, Nodo ramaDer){
        this(valor);
        izq = ramaIzq;
        der = ramaDer;
    }

    public Object valorNodo(){
        return dato;
    }

    public Nodo subarbolIzq(){
        return izq;
    }

    public Nodo subarbolDer(){
        return der;
    }

    public void nuevoValor(Object d){
        dato = d;
    }

    public void ramaIzq(Nodo n){
        izq = n;
    }

    public void ramaDer(Nodo n){
        der = n;
    }

    public void visitar(){
        System.out.println(dato + " ");
    }

}