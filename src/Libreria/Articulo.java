
package Libreria;

public class Articulo {
  //  Atributos que describen las propiedades del Articulo
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    //Constructor, inicializa los atributos al crear un nuevo articulo
    public Articulo(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    // Métodos getter: permiten obtener los valores de los atributos
    public String getCodigo() { return codigo; }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    // Método que reduce el stock según la cantidad vendida
    public void reducirStock(int cantidad) { stock -= cantidad; }
    // Método toString para representar el artículo como texto 
    @Override
    public String toString() {
        return codigo + " - " + nombre + " (S/." + precio + ")";
    }
}  
