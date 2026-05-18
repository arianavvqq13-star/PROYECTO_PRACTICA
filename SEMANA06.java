
package semana06;
import Libreria.*;
import java.util.*;


public class SEMANA06 {

    public static void main(String[] args) {
    // Circular
    Libreria.ColaCircular c1 = new Libreria.ColaCircular(5);
    c1.enqueue(10);
    System.out.println("Circular sacó: " + c1.dequeue());

    // Enlazada
    Libreria.ColaEnlazada c2 = new Libreria.ColaEnlazada();
    c2.enqueue(20);
    System.out.println("Enlazada sacó: " + c2.dequeue());

    // Prueba de prioridad
    Libreria.ColaPrioridad c3 = new Libreria.ColaPrioridad();
    c3.enqueue(50);
    c3.enqueue(10); // El 10 debería salir primero por ser menor
    System.out.println("Prioridad sacó: " + c3.dequeue());
        }
    }