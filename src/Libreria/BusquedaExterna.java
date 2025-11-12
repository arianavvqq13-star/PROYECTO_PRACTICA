package Libreria;
import java.io.*;
import java.util.*;

public class BusquedaExterna {

    // Ruta del archivo de productos
    private static final String ARCHIVO_PRODUCTOS = "productos.txt";

    // Método para buscar un producto por código desde el archivo externo
    public static void buscarProductoPorCodigo(String codigoBuscado) {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_PRODUCTOS))) {
            String linea;
            boolean encontrado = false;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 4) {
                    String codigo = datos[0];
                    String nombre = datos[1];
                    double precio = Double.parseDouble(datos[2]);
                    int stock = Integer.parseInt(datos[3]);

                    if (codigo.equalsIgnoreCase(codigoBuscado)) {
                        System.out.println("\nProducto encontrado:");
                        System.out.println("Código: " + codigo);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Precio: " + precio);
                        System.out.println("Stock: " + stock);
                        encontrado = true;
                        break;
                    }
                }
            }

            if (!encontrado) {
                System.out.println("\nEl producto con código '" + codigoBuscado + "' no existe.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("❌ No se encontró el archivo: " + ARCHIVO_PRODUCTOS);
        } catch (IOException e) {
            System.out.println("⚠️ Error al leer el archivo: " + e.getMessage());
        }
    }
}