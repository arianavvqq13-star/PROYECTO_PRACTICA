

package Libreria;
import java.util.*;
public class Pedido {
   //Atributos del Pedido
    private String numeroPedido;
    private Date fecha;
    private Cliente cliente;
    private ArrayList<DetallePedido> detalles;//Lista de productos (detalles)del pedido
    
    //Constructor que inicializa el pedido con su número, fecha y cliente
    public Pedido(String numeroPedido, Date fecha, Cliente cliente) {
        this.numeroPedido = numeroPedido;
        this.fecha = fecha;
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
    }
     // Método para agregar un producto (detalle) al pedido
    public void agregarDetalle(DetallePedido detalle) {
        detalles.add(detalle);
    }
    // Método para calcular el total del pedido sumando los subtotales de cada detalle
    public double calcularTotal() {
        double total = 0;
        for (DetallePedido d : detalles) {
            total += d.calcularSubtotal();// Llama al método calcularSubtotal de cada producto
        }
        return total;
    }
    
    // Getters para obtener los datos del pedido
    public String getNumeroPedido() { return numeroPedido; }
    public Date getFecha() { return fecha; }
    public Cliente getCliente() { return cliente; }
    
    // Método para imprimir el detalle del pedido por consola
    public void imprimirDetalle() {
        System.out.println("Pedido: " + numeroPedido);
        System.out.println("Cliente: " + cliente.getNombreCompleto());
        for (DetallePedido d : detalles) {
            System.out.println("  " + d);// Imprime cada detalle del pedido
        }
        System.out.println("Total: S/." + calcularTotal());// Muestra el total calculado
    }
    // Método toString para mostrar un resumen del pedido
    @Override
    public String toString() {
        return cliente.getDni() + "\t" + cliente.getNombreCompleto() + "\t" + numeroPedido + "\t" + fecha + "\tS/." + calcularTotal();
    }

}  
