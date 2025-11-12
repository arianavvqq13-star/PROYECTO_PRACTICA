
package Libreria;
import java.util.*;
public class OrdenamientoExterno {

    // Merge Sort por precio
    public static void mergeSort(List<Articulo> lista) {
        if (lista.size() <= 1) return;

        int mitad = lista.size() / 2;
        List<Articulo> izquierda = new ArrayList<>(lista.subList(0, mitad));
        List<Articulo> derecha = new ArrayList<>(lista.subList(mitad, lista.size()));

        mergeSort(izquierda);
        mergeSort(derecha);

        merge(lista, izquierda, derecha);
    }

    private static void merge(List<Articulo> lista, List<Articulo> izquierda, List<Articulo> derecha) {
        int i = 0, j = 0, k = 0;

        while (i < izquierda.size() && j < derecha.size()) {
            if (izquierda.get(i).getPrecio() <= derecha.get(j).getPrecio()) {
                lista.set(k++, izquierda.get(i++));
            } else {
                lista.set(k++, derecha.get(j++));
            }
        }

        while (i < izquierda.size()) {
            lista.set(k++, izquierda.get(i++));
        }

        while (j < derecha.size()) {
            lista.set(k++, derecha.get(j++));
        }
    }
}
