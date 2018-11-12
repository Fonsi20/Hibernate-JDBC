package funciones;

import bbdd.comprovacionesBBDD;
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
public class Bajas {

    public static void escogerBaja(int menu) {

        switch (menu) {
            case 1:
                bajasLibro();
                break;
            case 2:
                bajasAutor();
                break;
            case 3:
                bajasTlf();
                break;
        }

    }

    private static void bajasLibro() {

        int existe = Visualizaciones.visualizarLibros();
        int cod;
        char conf;
        Libros l = null;
        Scanner scan = new Scanner(System.in);
        if (existe == 1) {
            System.out.println("Introduce el codigo del libro a borrar.");
            System.out.print(" > ");
            cod = scan.nextInt();
            scan.nextLine();
            l = comprovacionesBBDD.comprobarLibro(cod);
            if (l != null) {
                System.out.println("Esta seguro de querer borrar el libro?[S/N]");
                System.out.print(" > ");
                conf = scan.nextLine().toLowerCase().charAt(0);
                if (conf == 's') {
                    eliminar(l);
                    System.out.println("EXITO Libro borrado.");
                } else {
                    System.out.println("No se ha borrado el libro");
                }
            } else {
                System.out.println("El libro no existe");
            }
        } else {
            System.out.println("No hay ningun libro.");
        }

    }

    private static void bajasTlf() {

        int existe = Visualizaciones.visualizarTelf();
        String telf;
        char conf;
        Telefonos t = null;
        Scanner scan = new Scanner(System.in);
        if (existe == 1) {
            System.out.println("Introduce el dni asociado al telefono a borrar.");
            System.out.print(" > ");
            telf = scan.nextLine();
            t = comprovacionesBBDD.comprobarTlf(telf);
            if (t != null) {
                System.out.println("Esta seguro de querer borrar el telefono?[S/N]");
                System.out.print(" > ");
                conf = scan.nextLine().toLowerCase().charAt(0);
                if (conf == 's') {
                    eliminar(t);
                    System.out.println("Telefono borrado.");
                } else {
                    System.out.println("No se ha borrado el telefono.");
                }
            } else {
                System.out.println("El telefono introducido no existe.");
            }
        } else {
            System.out.println("No hay telefonos.");
        }

    }

    private static void bajasAutor() {

        int existe = Visualizaciones.visualizarAutores();
        String dni;
        char conf;
        Autores a = null;
        Scanner scan = new Scanner(System.in);
        if (existe == 1) {
            System.out.println("Introduce el dni del autor a borrar.");
            System.out.print(" > ");
            dni = scan.nextLine();
            a = comprovacionesBBDD.comprobarAutor(dni);
            if (a != null) {
                System.out.println("Esta seguro de querer borrar el autor?[S/N]");
                System.out.print(" > ");
                conf = scan.nextLine().toLowerCase().charAt(0);
                if (conf == 's') {
                    System.out.println("AUTOR ELIMINADO");
                    eliminar(a);
                } else {
                    System.out.println("No se ha borrado al autor");
                }
            } else {
                System.out.println("El autor no existe");
            }
        } else {
            System.out.println("No hay ningun autor.");
        }

    }

    private static void eliminar(Object objeto) {

        Session sesion;
        try {
            sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.delete(objeto);
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

}
