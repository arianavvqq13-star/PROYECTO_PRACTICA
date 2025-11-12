
package Libreria;

public class DetallePedido {    
    //Atributos 
    private Articulo articulo;
    private int cantidad;

    //Constructor de la clase,recibe articulo y cantidad
    public DetallePedido(Articulo articulo, int cantidad) {
        this.articulo = articulo;
        this.cantidad = cantidad;
    }
    // Método que calcula el subtotal del detalle 
    public double calcularSubtotal() {
        return cantidad * articulo.getPrecio();
    }
    // Método que devuelve una representación en texto del detalle del pedido
    public String toString() {
        return articulo.getNombre() + " x" + cantidad + " - S/." + calcularSubtotal();
    }
}  
