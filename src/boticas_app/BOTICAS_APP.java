
package boticas_app;
import Libreria.*;
import java.util.*;

public class BOTICAS_APP {

  //Declaramos el scanner y listas globales para clientes,articulos y pedidos
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Articulo> articulos = new ArrayList<>();
    static ArrayList<Pedido> pedidos = new ArrayList<>();

      // Crear tabla hash para la busqeuda interna 
   static TablaHash tablahash= new TablaHash(20);
      //Carga inicial de articulos internos
   public static void main(String[] args) {
    // Precargar algunos artículos (productos internos)
    Articulo a1 = new Articulo("A001", "Paracetamol", 2.5,100);
    Articulo a2 = new Articulo("A002", "Amoxicilina", 4.0, 50);
    Articulo a3 = new Articulo("A003", "Vitamina C", 3.5, 80);

    articulos.addAll(Arrays.asList(a1, a2, a3));
    tablahash.insertar(a1);
    tablahash.insertar(a2);
    tablahash.insertar(a3);
    // _______________________________________________
        int op;
        //MENU PRINCIPAL-bucle principal del menu
        do {
            System.out.println("\n--- BOTICAS UTP ---");
            System.out.println("1. Mantenimiento de Clientes");
            System.out.println("2. Mantenimiento de Articulos");
            System.out.println("3. Registrar Pedido");
            System.out.println("4. Imprimir Pedidos");
            System.out.println("5. Ordenamiento de Articulos , ");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            op = sc.nextInt(); sc.nextLine();//Leemos la ocpion del usuario
            
            //Redirige al sunmenu segun la opcion
            switch (op) {
                case 1: menuClientes(); break;
                case 2: menuArticulos(); break;
                case 3: registrarPedido(); break;
                case 4: imprimirPedido(); break;
                case 5: menuOrdenamientos();break;
            }
        } while (op != 0);//Mientras no eliga salir 
    }
    //--------MENU CLIENTES---------
static void menuClientes() {
    int op;
    do {
        System.out.println("\n--- MENU CLIENTES ---");
        System.out.println("1. Buscar Cliente");
        System.out.println("2. Registrar Cliente");
        System.out.println("3. Mostrar Cliente");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1://BUSCAR CLIENTE POR DNI 
                System.out.print("Ingrese DNI a buscar: ");
                String dniBuscar = sc.nextLine();
                Cliente encontrado = buscarClientePorDNI(dniBuscar);
                if (encontrado != null)
                    System.out.println("Cliente encontrado: " + encontrado);
                else
                    System.out.println("Cliente no encontrado.");
                break;

            case 2://REGISTRAR CLIENTE 
                try{
                System.out.print("DNI: "); String dni = sc.nextLine();
                System.out.print("Nombres: "); String nom = sc.nextLine();
                System.out.print("Apellidos: "); String ape = sc.nextLine();

                Cliente nuevoCliente=new Cliente(dni, nom, ape);
                clientes.add(nuevoCliente);
                    System.out.println("\nCliente registrado con exito");
                 } catch(IllegalArgumentException e){
                     System.out.println("Error al registrar cliente: "+e.getMessage());
                 }   
                break;

            case 3://MOSTRAR TODOS LOS CLIENTES 
                for (Cliente c : clientes) {
                    System.out.println(c);
                }
                break;

            case 0://Volver al menu principal
                break;

            default:
                System.out.println("Opción invalida.");
        }
    } while (op != 0);
}
//BUSCAR CLIENTE POR DNI
static Cliente buscarClientePorDNI(String dni) {
    for (Cliente c : clientes) {
        if (c.getDni().equals(dni)) {
            return c;
        }
    }
    return null;
}
//------------MENU ARTICULOS---------------
static void menuArticulos() {
    int op;
    do {
        System.out.println("\n--- MENÚ ARTÍCULOS ---");
        System.out.println("1. MOSTRAR articulo");
        System.out.println("2. BUSCAR articulo");
        System.out.println("3. AGREGAR NUEVO articulos");
         System.out.println("4. ELIMINAR articulos");
        System.out.println("0. Volver");
        System.out.print("Opcion: ");
        op = sc.nextInt(); sc.nextLine();
        sc.nextLine();
        
            switch (op) {
                case 1:
                    System.out.println("\n--- LISTA DE ARTÍCULOS (BÚSQUEDA INTERNA) ---");
                    tablahash.mostrar();
                    break;

                case 2:
                    System.out.print("\nIngrese el código del artículo a buscar: ");
                    String codigoBuscar = sc.nextLine();
                    Articulo encontrado = tablahash.buscar(codigoBuscar);
                    if (encontrado != null) {
                        System.out.println("Artículo encontrado:");
                        System.out.println(encontrado);
                    } else {
                        System.out.println("No se encontró el artículo.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- AGREGAR NUEVO ARTÍCULO ---");
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    System.out.print("Stock: ");
                    int stock = sc.nextInt();
                    Articulo nuevo = new Articulo(codigo, nombre, precio,stock);
                    tablahash.insertar(nuevo);
                    System.out.println("Artículo agregado correctamente.");
                    break;

                case 4:
                    System.out.print("\nIngrese el código del artículo a eliminar: ");
                    String codigoEliminar = sc.nextLine();
                    tablahash.eliminar(codigoEliminar);
                    System.out.println(" Artículo eliminado (si existía).");
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida, intente nuevamente.");
                    break;
            }

        } while (op != 0);
    }

    //-------Ordenamiento Interno-------
    @SuppressWarnings("empty-statement")
    static void menuOrdenamientos() {
    int op;
    do {
        System.out.println("\n--- MENU ORDENAMIENTOS ---");
        System.out.println("1. Ordenar Artículos por Precio (Burbuja)");
        System.out.println("2. Ordenar Clientes por Nombre (Inserción)");
        System.out.println("3. Ordenar Pedidos por Total (Selección)");
        System.out.println("4. Ordenacion de Productos ");
        System.out.println("5. Ordenar Por Precio (QUICK SORT) ");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1://Burbuja(precio de menor a mayor)
                OrdenamientosInterno.burbujaArticulosPorPrecio(articulos);
                System.out.println("Artículos ordenados por precio:");
                for (Articulo a : articulos) System.out.println(a);
                break;

            case 2://Insercion (ordenar por apellido alfabeticamente A-Z)
                OrdenamientosInterno.insercionClientesPorNombre(clientes);
                System.out.println("Clientes ordenados por nombre:");
                for (Cliente c : clientes) System.out.println(c);
                break;

            case 3://Seleccion(ordenar por total de menor a mayor )
                OrdenamientosInterno.seleccionPedidosPorTotal(pedidos);
                System.out.println("Pedidos ordenados por total:");
                for (Pedido p : pedidos) {
                    System.out.println(p.getNumeroPedido() + " - Total: " + p.calcularTotal());
                }
                break;
            case 4:
                //
                String rutaArchivo = "productos.txt"; 
                // Leer productos
                List<Articulo> productos = LectorArchivo.leerProductos("productos.txt");

                System.out.println("Productos cargados:");
                for (Articulo a : productos) {
                    System.out.println(a);
                }
                // Ordenar con Merge Sort por precio
                OrdenamientoExterno.mergeSort(productos);

                System.out.println("\n Productos ordenados por precio:");
                for (Articulo a : productos) {
                    System.out.println(a);
                }
                break;
            case 5:
                    OrdenamientosInterno.quickSortArticulosPorPrecio(articulos, 0, articulos.size() - 1);
                    System.out.println("Artículos ordenados por precio con Quick Sort:");
                    for (Articulo a : articulos) System.out.println(a);
                break;
                case 0: break;
                    default: System.out.println("Opción inválida.");
                }  
            } while (op != 0);
    }         
    
//-----------REGISTRO DE PEDIDOS-----------------
    static void registrarPedido(){
        System.out.print("DNI del cliente: ");
        String dni = sc.nextLine();
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) {
                cliente = c; break;
            }
        }
        if (cliente == null) {
            System.out.println("Cliente no encontrado."); return;
        }
        //Generacion automatica de numero de pedido
        String numPedido = "P" + (pedidos.size() + 1);
        Pedido pedido = new Pedido(numPedido, new Date(), cliente);

        while (true) {
            System.out.print("Codigo de artículo (ENTER para terminar): ");
            String cod = sc.nextLine();
            if (cod.isEmpty()) break;
            Articulo art = null;
            for (Articulo a : articulos) {
                if (a.getCodigo().equals(cod)) {
                    art = a; break;
                }
            }
            if (art == null) {
                System.out.println("Articulo no encontrado."); continue;
            }    
        System.out.println("Cantidad");
        int cant=sc.nextInt();sc.nextLine();
        if(cant<=0){
            System.out.println("La cantidad debe ser mayor que cero.");
            continue;
        }        
        if (cant>art.getStock()){
            System.out.println("Stock insuficiente.Solo hay "+art.getStock()+"unidades disponibles.");
        continue;
        //Se agrega el pedido y se actualiza el stock
        }
        pedido.agregarDetalle(new DetallePedido(art,cant));
        art.reducirStock(cant);
            System.out.println("Articulo agregado al pedido.");
        }
        pedidos.add(pedido);
        pedido.imprimirDetalle();//Mostrar resumen del pedido
        }
    static void imprimirPedido(){//MOSTRAR TODOS LOS PEDIDOS CON SUS TOTALESSystem.out.println("\n===============================================================");
    System.out.println("|                  REPORTE DE PEDIDOS                        |");
    System.out.println("===============================================================");
    System.out.printf("| %-12s | %-15s | %-13s | %-12s | %-10s |\n",
            "Cod.Cliente", "Cliente", "N° Pedido", "Fecha", "Total (S/.)");
    System.out.println("---------------------------------------------------------------");

    for (Pedido p : pedidos) {
        System.out.printf("| %-12s | %-15s | %-13s | %-12s | %10.2f |\n",
                p.getCliente().getDni(),
                p.getCliente().getNombreCompleto(),
                p.getNumeroPedido(),
                p.getFecha(),
                p.calcularTotal());
    }

    System.out.println("===============================================================");
    }
}

