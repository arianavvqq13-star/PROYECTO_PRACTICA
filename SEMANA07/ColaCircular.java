package Libreria;

public class ColaCircular {
    private int[] arreglo;
    private int frente, fin, capacidad, tamanoActual;

    public ColaCircular(int capacidad) {
        this.capacidad = capacidad;
        this.arreglo = new int[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.tamanoActual = 0;
    }

    public void enqueue(int elemento) {
        if (tamanoActual == capacidad) {
            System.out.println("Cola Circular Llena");
            return;
        }
        // Pauta de Seguridad: Verificar índices válidos usando módulo
        fin = (fin + 1) % capacidad;
        arreglo[fin] = elemento;
        tamanoActual++;
    }

    public int dequeue() {
        if (tamanoActual == 0) return -1;
        int valor = arreglo[frente];
        frente = (frente + 1) % capacidad;
        tamanoActual--;
        return valor;
    }
}