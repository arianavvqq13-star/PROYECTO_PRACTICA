
package Libreria;
public class Cliente {

 // Atributos privados del cliente
    private String dni;
    private String nombres;
    private String apellidos;

    // Constructor
    public Cliente(String dni, String nombres, String apellidos) {
        StringBuilder errores=new StringBuilder();
        //Validacion del DNI, debe tener 8 digitos numericos
        if(!dni.matches("\\d{8}")){
        errores.append("\nDNI inválido.Debe tener 8 digitos.");
        }
        //Si se detectaron errores, se lanza una expecion con los mensajes acumulados
        if(errores.length()>0){
            throw new IllegalArgumentException(errores.toString());
        }
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
    // Métodos getter para obtener los valores de los atributos
    public String getDni() {return dni;}

    public String getNombres() {return nombres;}

    public String getApellidos() { return apellidos;}

    public String getNombreCompleto(){return nombres+" "+apellidos;}

  //Metodo toString para mostrar el cliente en formato: DNI - Nombre Completo
    @Override
    public String toString() {
        return dni+ "-"+getNombreCompleto();
    }
    //Metodo statico para validar el formato 
    public static boolean validarCorreo(String correo){
       return correo.matches("[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"); 
    }
    //Metodo statico para validar el formato 
    public static boolean validarCelular(String celular){
        return celular.matches("\\d{9}");
    }
}    

