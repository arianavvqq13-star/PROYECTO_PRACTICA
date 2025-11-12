
package Libreria;
import java.util.Scanner;
import java.util.LinkedList;

public class TablaHash {
    private LinkedList<Articulo>[] tabla;
    private int tamaño;
    // Constructor
    public TablaHash(int tamaño) {
        this.tamaño = tamaño;
        tabla = new LinkedList[tamaño];
        
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    // Función hash: convierte el código en una posición de la tabla
    private int funcionHash(String codigo) {
        return Math.abs(codigo.hashCode() % tamaño);
    }

    // Insertar un artículo en la tabla
    public void insertar(Articulo art) {
        int indice = funcionHash(art.getCodigo());
        tabla[indice].add(art);
    }

    // Buscar un artículo por código
    public Articulo buscar(String codigo) {
        int indice = funcionHash(codigo);
        for (Articulo art : tabla[indice]) {
            if (art.getCodigo().equals(codigo)) {
                return art; // encontrado
            }
        }
        return null; // no encontrado
    }

    // Eliminar un artículo por código
    public boolean eliminar(String codigo) {
        int indice = funcionHash(codigo);
        return tabla[indice].removeIf(a -> a.getCodigo().equals(codigo));
    }

    // Mostrar toda la tabla
    public void mostrar() {
        for (int i = 0; i < tamaño; i++) {
            System.out.print("Posición " + i + ": ");
            for (Articulo art : tabla[i]) {
                System.out.print(art.getCodigo() + " (" + art.getNombre() + "), ");
            }
            System.out.println();
        }
    }
}