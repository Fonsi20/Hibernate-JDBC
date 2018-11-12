package objetos;

import java.io.Serializable;

/**
 *
 * @author mallo
 */
public class Libros implements Serializable {

    private int idLibro;
    private String titulo;
    private float precio;
    private Autores autor;

    public Libros() {
    }

    public Libros(String titulo, float precio) {
        this.titulo = titulo;
        this.precio = precio;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
