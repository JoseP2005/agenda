package dominio;
import java.util.ArrayList;
import java.util.List;
public class Libreta {
    private String nombre;
    private List<Contacto> contactos;

    public Libreta(String nombre) {
        this.nombre = nombre;
        contactos = new ArrayList<>();
    }
   
    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void borrar(Contacto contacto){
        contactos.remove(contacto);
    }


    public int contarContactos() {
        return contactos.size(); 
    }

    public List<Contacto> getContactos() {
        return contactos;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Libreta: " + nombre + " Contactos: "+ contactos + ", Total Contactos: " + contarContactos();
    }
}
