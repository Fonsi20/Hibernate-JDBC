package funciones;

import bbdd.comprovacionesBBDD;
import java.util.Scanner;
import objetos.Autores;
import objetos.Libros;
import objetos.Telefonos;

/**
 *
 * @author mallo
 */
public class Modificar {

    public static void escogerModificaciones(int menu) {

        switch (menu) {
            case 1:
                modificarPrecioLibro();
                break;
            case 2:
                cambiarTlfAutor();
                break;
        }
    }

    private static void modificarPrecioLibro() {

        int existe = Visualizaciones.visualizarLibros();
        int cod;
        float precio;
        char conf;
        Libros l = null;
        Scanner scan = new Scanner(System.in);
        if (existe == 1) {
            System.out.println("Introduce el codigo del libro a modificar.");
            System.out.print(" > ");
            cod = scan.nextInt();
            scan.nextLine();
            l = comprovacionesBBDD.comprobarLibro(cod);
            if (l != null) {
                System.out.println("Precio actual del libro: " + l.getPrecio());
                System.out.println("Introduzca el precio nuevo.");
                System.out.print(" > ");
                precio = scan.nextFloat();
                scan.nextLine();
                System.out.println("Esta seguro de querer modificar el libro?[S/N]");
                System.out.print(" > ");
                conf = scan.nextLine().toLowerCase().charAt(0);
                if (conf == 's') {
                    l.setPrecio(precio);
                    Altas.guardarModificar(l);
                    System.out.println("Libro modificado.");
                } else {
                    System.out.println("No se ha modificado el libro");
                }
            } else {
                System.out.println("El libro no existe");
            }
        } else {
            System.out.println("No hay ningun libro.");
        }

    }

    private static void cambiarTlfAutor() {

        int existe = Visualizaciones.visualizarAutores();
        String dni;
        int telf;
        char conf;
        Autores a = null;
        Telefonos t = null;
        Scanner scan = new Scanner(System.in);
        if (existe == 1) {
            System.out.println("Introduce el dni del autor al cual quieres modificar el telefono.");
            System.out.print(" > ");
            dni = scan.nextLine();
            a = comprovacionesBBDD.comprobarAutor(dni);
            if (a != null) {
                t = (Telefonos) comprovacionesBBDD.busqueda1Variable1Objeto(Telefonos.class.getName(), "dniAutor", dni);
                if (t != null) {
                    System.out.println("El telefono actual es: " + t.getNumerotlf());
                    System.out.println("Introduce el nuevo telefono.");
                    System.out.print(" > ");
                    telf = Integer.parseInt(scan.nextLine());
                    System.out.println("Esta seguro de querer modificar el telefono[S/N]?");
                    System.out.print(" > ");
                    conf = scan.nextLine().toLowerCase().charAt(0);
                    if (conf == 's') {
                        t.setNumerotlf(telf);
                        Altas.guardarModificar(t);
                        System.out.println("Telefono modificado.");
                    } else {
                        System.out.println("No se ha modificado.");
                    }
                } else {
                    System.out.println("No hay telefonos de ese autor.");
                }
            } else {
                System.out.println("El autor introducido no existe.");
            }
        } else {
            System.out.println("No hay autores.");
        }

    }

}
