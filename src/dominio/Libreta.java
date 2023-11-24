package dominio;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa una libreta de contactos.
 */
public class Libreta {
    /**
     * Nombre de la libreta.
     */
    private String nombre;
    /**
     * Lista de contactos de la libreta.
     */
    private List<Contacto> contactos;
   /**
     * Constructor de la clase.
     * @param nombre Nombre de la libreta.
     */
    public Libreta(String nombre) {
        this.nombre = nombre;
        contactos = new ArrayList<>();
    }

    /**
     * Obtiene los datos de la libreta en formato CSV.
     * @return Datos de la libreta en formato CSV.
     */
    public String obtenerDatosCSV() {
        StringBuilder csvData = new StringBuilder();
        for (Contacto contacto : contactos) {
            csvData.append(contacto.getNombre()).append(",").append(contacto.getNumeroDeTelefono()).append("\n");
        }
        return csvData.toString();
    }
    /**
     * Agrega un contacto a la libreta.
     * @param contacto Contacto a agregar.
     */
    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    /**
     * Cuenta el número de contactos de la libreta.
     * @return Número de contactos de la libreta.
     */
    public int contarContactos() {
        return contactos.size();
    }

    /**
     * Obtiene los contactos de la libreta.
     * @return Contactos de la libreta.
     */
    public List<Contacto> getContactos() {
        return contactos;
    }

    /**
     * Establece los contactos de la libreta.
     * @return Libreta de contactos y cantidad de contactos.
     */
    @Override
    public String toString() {
        return "Libreta: " + nombre + " Contactos: "+ contactos + ", Total Contactos: " + contarContactos();
    }
}
