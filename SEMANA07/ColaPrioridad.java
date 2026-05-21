package Libreria;

public class ColaPrioridad {
    private Nodo frente;

    public void enqueue(int dato) {
        Nodo nuevo = new Nodo(dato);
        // Si está vacía o el dato tiene más prioridad (es menor) que el primero
        if (frente == null || dato < frente.dato) {
            nuevo.siguiente = frente;
            frente = nuevo;
        } else {
            Nodo actual = frente;
            while (actual.siguiente != null && actual.siguiente.dato <= dato) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }
    }

    public int dequeue() {
        if (frente == null) return -1;
        int valor = frente.dato;
        frente = frente.siguiente;
        return valor;
    }
}