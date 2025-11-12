
package Libreria;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LectorArchivo {
    
    public static List<Articulo> leerProductos(String rutaArchivo){
        List<Articulo> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                
                if(datos.length==4){
                String codigo = datos[0];
                String nombre = datos[1];
                double precio = Double.parseDouble(datos[2]);
                int stock = Integer.parseInt(datos[3]);

                lista.add(new Articulo(codigo, nombre, precio, stock));
                }
            }
            System.out.println(lista.size() + " productos cargados correctamente desde " + rutaArchivo);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return lista;
    }
}

