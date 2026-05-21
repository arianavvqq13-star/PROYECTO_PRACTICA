package Libreria;

public class ColaEnlazada {
    private Nodo frente, fin;

    public void enqueue(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public int dequeue() {
        if (frente == null) return -1;
        int valor = frente.dato;
        
        // Pauta de Seguridad: Ayudar a liberar memoria desconectando el nodo
        Nodo temporal = frente;
        frente = frente.siguiente;
        temporal.siguiente = null; 
        
        if (frente == null) fin = null;
        return valor;
    }
}