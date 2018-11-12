package funciones;

import bbdd.comprovacionesBBDD;
import java.util.List;
import java.util.Scanner;
import libreriahn.NewHibernateUtil;
import objetos.Autores;
import objetos.Libros;
import objetos.Telefonos;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author mallo
 */
public class Visualizaciones {

    public static void escogerConsulta(int menu) {
        switch (menu) {
            case 1:
                consultaLibroAutor();
                break;
            case 2:
                consultaAutorLibros();
                break;
        }
    }

    public static void escogerVisualizacion(int menu) {
        switch (menu) {
            case 1:
                visualizarLibros();
                break;
            case 2:
                visualizarAutores();
                break;
        }
    }

    public static int visualizarLibros() {

        try {
            Session s;
            s = NewHibernateUtil.getSession();
            List<Object> libros = s.createCriteria(Libros.class).list();
            s.close();
            if (!libros.isEmpty()) {
                System.out.print("\u250c");
                for (int i = 0; i < 35; i++) {
                    System.out.print("\u2500");
                }
                System.out.print("\u2510");
                System.out.println("\n\u2502                          LIBROS                            \u2502");
                System.out.print("\u251c");
                for (int i = 0; i < 35; i++) {
                    System.out.print("\u2500");
                }
                System.out.println("\u2524");
                System.out.println("\u2502 Cod                      Titulo                     Precio \u2502");
                System.out.print("\u251c");
                for (int i = 0; i < 35; i++) {
                    System.out.print("\u2500");
                }
                System.out.println("\u2524");

                for (Object o : libros) {
                    System.out.println("\u2502 " + String.format("%1$-24s %2$-26s %3$-6.2f %4$s", ((Libros) o).getIdLibro(), ((Libros) o).getTitulo(), ((Libros) o).getPrecio(), "\u2502"));
                }
                System.out.print("\u2514");
                for (int i = 0; i < 35; i++) {
                    System.out.print("\u2500");
                }
                System.out.println("\u2518");
                return 1;
            } else {
                System.out.println("No hay libros.");
                return 0;
            }
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return 1;

    }

    static int visualizarAutores() {

        try {
            Session s;
            s = NewHibernateUtil.getSession();
            List<Object> autores = s.createCriteria(Autores.class).list();
            s.close();
            if (!autores.isEmpty()) {
                System.out.print("\u250c");
                for (int i = 0; i < 35; i++) {
                    System.out.print("\u2500");
                }
                System.out.print("\u2510");
                System.out.println("\n\u2502                          AUTORES                           \u2502");
                System.out.print("\u251c");
                for (int i = 0; i < 35; i++) {
                    System.out.print("\u2500");
                }
                System.out.println("\u2524");
                System.out.println("\u2502 DNI                      Nombre               Nacionalidad \u2502");
                System.out.print("\u251c");
                for (int i = 0; i < 35; i++) {
                    System.out.print("\u2500");
                }
                System.out.println("\u2524");

                for (Object o : autores) {
                    System.out.println("\u2502 " + String.format("%1$-24s %2$-20s %3$-12s %4$s", ((Autores) o).getDniAutor(), ((Autores) o).getNombre(), ((Autores) o).getNacionalidad(), "\u2502"));
                }
                System.out.print("\u2514");
                for (int i = 0; i < 35; i++) {
                    System.out.print("\u2500");
                }
                System.out.println("\u2518");
                return 1;
            } else {
                System.out.println("No hay autores.");
                return 0;
            }
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return 1;

    }

    public static int visualizarTelf() {

        try {
            Session s;
            s = NewHibernateUtil.getSession();
            List<Object> telefonos = s.createCriteria(Telefonos.class).list();
            s.close();
            if (!telefonos.isEmpty()) {
                System.out.print("\u250c");
                for (int i = 0; i < 35; i++) {
                    System.out.print("\u2500");
                }
                System.out.print("\u2510");
                System.out.println("\n\u2502                         TELEFONOS                          \u2502");
                System.out.print("\u251c");
                for (int i = 0; i < 35; i++) {
                    System.out.print("\u2500");
                }
                System.out.println("\u2524");
                System.out.println("\u2502  DNI                                             Telefono  \u2502");
                for (Object o : telefonos) {
                    System.out.println("\u2502  " + String.format("%1$-47s %2$-9s %3$s", ((Telefonos) o).getDniAutor(), ((Telefonos) o).getNumerotlf(), "\u2502"));
                }
                System.out.print("\u2514");
                for (int i = 0; i < 35; i++) {
                    System.out.print("\u2500");
                }
                System.out.println("\u2518");
                return 1;
            } else {
                System.out.println("No hay Telefonos.");
                return 0;
            }
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return 1;
    }

    private static void consultaLibroAutor() {

        Scanner scan = new Scanner(System.in);
        int existe = visualizarLibros();
        int cod;
        if (existe == 1) {
            System.out.println("Introduce el codigo del libro a visualizar");
            System.out.print(" > ");
            cod = scan.nextInt();
            scan.nextLine();
            Libros l = null;
            l = comprovacionesBBDD.comprobarLibro(cod);

            if (l != null) {
                Autores a = comprovacionesBBDD.comprobarAutor(l.getAutor().getDniAutor());
                Telefonos t = comprovacionesBBDD.comprobarTlf(l.getAutor().getDniAutor());
                System.out.print("Titulo: " + l.getTitulo() + "\tPrecio: " + l.getPrecio()
                        + "\tAutor: " + l.getAutor().getDniAutor() + "\tNacionalidad: " + a.getNacionalidad());
                if (t != null) {
                    System.out.println("\tTelefono: " + t.getNumerotlf());
                } else {
                    System.out.println();
                }
                System.out.println();
            }
        } else {
            System.out.println("No hay libros.");
        }

    }

    private static void consultaAutorLibros() {

        Scanner scan = new Scanner(System.in);
        int existe = visualizarAutores();
        Session s;
        String dni;
        List<Object> libros;
        if (existe == 1) {
            System.out.println("Introduce el dni del autor a buscar.");
            System.out.print(" > ");
            dni = scan.nextLine();
            Autores a = null;
            a = comprovacionesBBDD.comprobarAutor(dni);
            s = NewHibernateUtil.getSession();
            libros = s.createQuery("FROM " + Libros.class.getName() + " WHERE autor='" + a.getDniAutor() + "'").list();
            s.close();
            if (a != null) {
                System.out.println("Lista de libros de: " + a.getNombre());
                System.out.println(String.format("%1$-22s %2$s", "Titulo: ", "Precio: "));
                for (Object l : libros) {
                    System.out.println(String.format("%1$-22s %2$.2f€", ((Libros) l).getTitulo(), ((Libros) l).getPrecio()));
                }
                System.out.println();
            }

        } else {
            System.out.println("No hay autores.");
        }

    }

}
