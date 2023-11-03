package interfaz;
import java.util.List;
import dominio.Contacto;
import dominio.Libreta;
public class Interfaz{
    public static void ejecutar(String[] instruccion, Libreta libreta) {
        if (instruccion[0].equalsIgnoreCase("mostrar") && instruccion.length == 1) {
            mostrarLibreta(libreta);
        } else if (instruccion[0].equalsIgnoreCase("añadir") && instruccion.length == 3) {
            Contacto nuevoContacto = new Contacto(instruccion[1], Integer.parseInt(instruccion[2]));
            libreta.agregarContacto(nuevoContacto);
            System.out.println("Contacto añadido correctamente");
            
        } //else if (instruccion[0].equalsIgnoreCase("borrar") && instruccion.length == 1){
           // libreta.borrar(new Contacto());
        //}
        else {
            System.out.println("Error en la instrucción");
        }
    }

    private static void mostrarLibreta(Libreta libreta) {
        List<Contacto> contactos = libreta.getContactos();

        for (Contacto contacto : contactos) {
            System.out.println("Nombre: " + contacto.getNombre() + ", Numero de Teléfono: " + contacto.getNumeroDeTelefono());
        }
        System.out.println("El número total de contactos es: " + libreta.contarContactos());
    }
    
}

 
/*public class Interfaz {
    public static boolean ejecutar(String[] instruccion) {
        Libreta libreta = new Contacto(); // Create a new instance of Libreta

        if (instruccion[0].equalsIgnoreCase("mostrar") && instruccion.length == 1) {
            mostrarLibreta(libreta);
        } else if (instruccion[0].equalsIgnoreCase("añadir") && instruccion.length == 4) {
            libreta.agregarContacto(new Contacto(instruccion[1], instruccion[2], instruccion[3]));
            System.out.println("Contacto añadido correctamente");
        } else {
            System.out.println("Error en la instrucción");
        }
        return true;
    }

    private static void mostrarLibreta(Libreta libreta) {
        ArrayList<Contacto> contactos = libreta.getContactos(); // Use the correct variable name

        for (Contacto contacto : contactos) { 
            System.out.println(contacto.getNombre() + " " + contacto.getNumeroDeTelefono());
        }
        System.out.println("El número total de contactos es: " + libreta.contarContactos());
    }
}*/
