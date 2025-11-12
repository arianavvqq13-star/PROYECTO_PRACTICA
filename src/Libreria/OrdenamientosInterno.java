
package Libreria;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenamientosInterno {
    public static void burbujaArticulosPorPrecio(List<Articulo> articulos) {
        
    // ORDENAMIENTO BURBUJA
    // ===============================   
        int n = articulos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (articulos.get(j).getPrecio() > articulos.get(j + 1).getPrecio()) {
                    // intercambio
                    Articulo temp = articulos.get(j);
                    articulos.set(j, articulos.get(j + 1));
                    articulos.set(j + 1, temp);
            }
         }
    }         
 }
    // ORDENAMIENTO INSERCIÓN
    // ===============================
    public static void insercionClientesPorNombre(List<Cliente> clientes) {
        int n = clientes.size();
        for (int i = 1; i < n; i++) {
            Cliente key = clientes.get(i);
            int j = i - 1;
            // mover los mayores una posición adelante
            while (j >= 0 && clientes.get(j).getNombres().compareTo(key.getNombres()) > 0) {
                clientes.set(j + 1, clientes.get(j));
                j = j - 1;
            }
            clientes.set(j + 1, key);
        }
    }
    
    // ORDENAMIENTO SELECCIÓN
    // ===============================
    public static void seleccionPedidosPorTotal(List<Pedido> pedidos) {
        int n = pedidos.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (pedidos.get(j).calcularTotal() < pedidos.get(minIndex).calcularTotal()) {
                    minIndex = j;
                }
            }
            // intercambio
            Pedido temp = pedidos.get(minIndex);
            pedidos.set(minIndex, pedidos.get(i));
            pedidos.set(i, temp);
        }
    }  
public static void quickSortArticulosPorPrecio(List<Articulo> articulos, int inicio, int fin) {
    if (inicio < fin) {
        int indiceParticion = particionar(articulos, inicio, fin);
        quickSortArticulosPorPrecio(articulos, inicio, indiceParticion - 1);
        quickSortArticulosPorPrecio(articulos, indiceParticion + 1, fin);
    }
}

private static int particionar(List<Articulo> articulos, int inicio, int fin) {
    double pivote = articulos.get(fin).getPrecio();
    int i = inicio - 1;
    for (int j = inicio; j < fin; j++) { 
        if (articulos.get(j).getPrecio() <= pivote) {
            i++;
            Collections.swap(articulos, i, j);
        }
    }
    Collections.swap(articulos, i + 1, fin);
    return i + 1;
    }
}
