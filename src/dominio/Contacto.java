package dominio;
import java.io.Serializable;
/**
 * Clase que representa un contacto de una libreta de contactos.
 */
public class Contacto implements Serializable {
    /**
     * Nombre del contacto.
     */
    private String nombre;
    /**
     * Número de teléfono del contacto.
     */
    private String numeroDeTelefono;
    /**
     * Constructor de la clase.
     * @param nombre Nombre del contacto.
     * @param numeroDeTelefono Número de teléfono del contacto.
     */
    public Contacto(String nombre, String numeroDeTelefono) {
        this.nombre = nombre;
        this.numeroDeTelefono = numeroDeTelefono;
    }
    /**
     * Obtiene el nombre del contacto.
     * @return Nombre del contacto.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del contacto.
     * @param nombre Nombre del contacto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene el número de teléfono del contacto.
     * @return Número de teléfono del contacto.
     */
    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }
    /**
     * Establece el número de teléfono del contacto.
     * @param numeroDeTelefono Número de teléfono del contacto.
     */
    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }
    /**
     * Compara dos objetos de tipo Contacto.
     * @param obj Objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    public boolean equals (Object obj){
        Contacto c = (Contacto)obj;
        return nombre.equals(c.nombre);
    }
    /**
     * Obtiene una representación en cadena de caracteres del objeto.
     * @return Representación en cadena de caracteres del objeto.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Numero de Telefono: " + numeroDeTelefono ;
    }
}