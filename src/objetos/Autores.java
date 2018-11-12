package objetos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mallo
 */
public class Autores implements Serializable {

    private String dniAutor;
    private String nombre;
    private String nacionalidad;
    private Telefonos numerotlf;
    Set<Libros> libro;

    public Autores() {
    }

    public Autores(String dniAutor, String nombre, String nacionalidad) {
        this.dniAutor = dniAutor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.libro = new HashSet<>();
    }

    public String getDniAutor() {
        return dniAutor;
    }

    public void setDniAutor(String dniAutor) {
        this.dniAutor = dniAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Set<Libros> getLibro() {
        return libro;
    }

    public void setLibro(Set<Libros> libro) {
        this.libro = libro;
    }

    public Telefonos getNumerotlf() {
        return numerotlf;
    }

    public void setNumerotlf(Telefonos numerotlf) {
        this.numerotlf = numerotlf;
    }

}
