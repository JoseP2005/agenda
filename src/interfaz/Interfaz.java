package interfaz;

import dominio.Contacto;
import dominio.Libreta;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa la interfaz de usuario de la aplicación.
 */
public class Interfaz{
    /**
     * Libreta de contactos.
     */
    private Libreta libreta;
    /**
     * Scanner para leer datos desde la consola.
     */
    private Scanner scanner;
    /**
     * Constructor de la clase.
     */
    public Interfaz() {
        scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la libreta: ");
        String nombre = scanner.nextLine();

        libreta = new Libreta(nombre);
    }
    /**
     * Ejecuta la interfaz de usuario.
     */
    public void ejecutar() {
        cargarDatosCSV();
        boolean salir = false;
        while (!salir) {
            System.out.println("Ingrese una instrucción (mostrar, añadir, salir): ");
            String instruccion = scanner.nextLine();

            switch (instruccion.toLowerCase()) {
                case "mostrar":
                    mostrarLibreta();
                    break;
                case "añadir":
                    agregarContacto();
                    break;
                case "salir":
                    salir = true;
                    guardarDatosCSV();  // También podrías cambiar esto a guardarDatosCSV
                    System.out.println("Programa terminado.");
                    break;
                default:
                    System.out.println("Error en la instrucción.");
                    break;
            }
        }
    }
    /**
     * Muestra los contactos de la libreta.
     */
    private void mostrarLibreta() {
        List<Contacto> contactos = libreta.getContactos();

        for (Contacto contacto : contactos) {
            System.out.println("Nombre: " + contacto.getNombre() + ", Número de Teléfono: " + contacto.getNumeroDeTelefono());
        }
        System.out.println("El número total de contactos es: " + libreta.contarContactos());
    }
    /**
     * Agrega un contacto a la libreta.
     */
    private void agregarContacto() {
        System.out.print("Ingrese el nombre del contacto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el número de teléfono del contacto: ");
        String numeroDeTelefono = scanner.nextLine();

        Contacto nuevoContacto = new Contacto(nombre, numeroDeTelefono);
        libreta.agregarContacto(nuevoContacto);
        System.out.println("Contacto añadido correctamente.");
    }

    /**
     * guarda los datos de la libreta en formato CSV.
     */
    private void guardarDatosCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("libreta.csv"))) {
            writer.println("Nombre,Numero de Telefono");
            List<Contacto> contactos = libreta.getContactos();
            for (Contacto contacto : contactos) {
                writer.println(contacto.getNombre() + "," + contacto.getNumeroDeTelefono());
            }
            System.out.println("Datos guardados exitosamente en formato CSV.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los datos en formato CSV.");
        }
    }
    /**
     * Carga los datos de la libreta desde formato CSV.
     */
    private void cargarDatosCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader("libreta.csv"))) {
            // Saltamos la primera línea que contiene los encabezados
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String nombre = parts[0];
                    String numeroDeTelefono = parts[1];
                    Contacto nuevoContacto = new Contacto(nombre, numeroDeTelefono);
                    libreta.agregarContacto(nuevoContacto);
                }
            }
            System.out.println("Datos cargados exitosamente desde formato CSV.");
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Error al cargar los datos desde formato CSV.");
        }
    }

}
