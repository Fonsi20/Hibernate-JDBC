package objetos;

import java.io.Serializable;

/**
 * @author mallo
 */
public class Telefonos implements Serializable {

    private int numerotlf;
    private String dniAutor;
    private Autores autor;

    public Telefonos() {
    }

    public Telefonos(int numerotlf) {
        this.numerotlf = numerotlf;
    }

    public int getNumerotlf() {
        return numerotlf;
    }

    public void setNumerotlf(int numerotlf) {
        this.numerotlf = numerotlf;
    }

    public String getDniAutor() {
        return dniAutor;
    }

    public void setDniAutor(String dniAutor) {
        this.dniAutor = dniAutor;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }
}
