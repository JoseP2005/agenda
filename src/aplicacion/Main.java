package aplicacion;
import dominio.Libreta;
import interfaz.*;
public class Main{  
    public static void main(String[] args) {
        // Ejemplo de uso
        Libreta libreta = new Libreta("Mi Libreta");

        String[] instruccion1 = {"añadir", "Juan", "123456789"};
        Interfaz.ejecutar(instruccion1,libreta);
 
        String[] instruccion2 = {"mostrar"};
        Interfaz.ejecutar(instruccion2,libreta);
    }
} 