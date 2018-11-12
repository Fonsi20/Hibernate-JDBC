package funciones;

import java.util.Scanner;
import libreriahn.NewHibernateUtil;
import objetos.Autores;
import objetos.Libros;
import objetos.Telefonos;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author mallo
 */
public class Altas {

    public static void escogerInsertar(int menu) {

        switch (menu) {
            case 1:
                InsertarAutor();
                break;
            case 2:
                InsertarLibro();
                break;
            case 3:
                InsertarTlf();
                break;
        }

    }

    private static void InsertarAutor() {

        byte restriccion = 0;
        String dni = null, nombre, nacionalidad;
        char conf;
        Scanner scan = new Scanner(System.in);

        try {
            while (restriccion == 0) {
                System.out.println("Introduce el dni del autor.");
                System.out.print(" > ");
                dni = scan.nextLine().toUpperCase();
                restriccion = Restricciones.compruebaDni(dni);
            }

            System.out.println("Introduce el nombre del autor.");
            System.out.print(" > ");
            nombre = scan.nextLine();

            System.out.println("Introduce la nacionalidad del autor.");
            System.out.print(" > ");
            nacionalidad = scan.nextLine();

            Autores a = new Autores(dni, nombre, nacionalidad);
            guardarModificar(a);
            System.out.println("Desea introducir un libro para ese autor?[s/n]");
            System.out.print(" > ");
            conf = scan.nextLine().toLowerCase().charAt(0);
            if (conf == 's') {
                do {
                    Libros l = crearLibro(a);
                    a.getLibro().add(l);
                    guardarModificar(l);
                    System.out.println("Desea introducir otro libro para ese autor?[s/n]");
                    System.out.print(" > ");
                    conf = scan.nextLine().toLowerCase().charAt(0);
                } while (conf == 's');
            }
            guardarModificar(a);
            System.out.println("Autor introducido.");
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Problema insertando Autor - Error:" + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }

    private static void InsertarLibro() {

        Scanner scan = new Scanner(System.in);
        String titulo;
        float precio;
        char conf;
        String dni;

        try {
            System.out.println("Introduce el titulo del libro.");
            System.out.print(" > ");
            titulo = scan.nextLine();
            System.out.println("Introduce el precio del libro.");
            System.out.print(" > ");
            precio = scan.nextFloat();
            scan.nextLine();
            Libros l = new Libros(titulo, precio);
            Autores a = null;
            do {
                int c;
                c = Visualizaciones.visualizarAutores();
                if (c == 1) {
                    a = buscarAutor();
                    if (a == null) {
                        System.out.println("El autor introducido no existe, desea crearlo?[s/n].");
                        conf = scan.nextLine().toLowerCase().charAt(0);
                        if (conf == 's') {
                            a = crearAutor(l);
                        }
                    }
                } else {
                    a = crearAutor(l);
                }
            } while (a == null);

            l.setAutor(a);
            guardarModificar(l);
            System.out.println("Libro introducido.");
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Problema insertando Libro - Error:" + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }

    private static Autores crearAutor(Libros l) {
        try {
            String dni, nombre, nacionalidad;
            Scanner scan = new Scanner(System.in);
            System.out.println("Introduce el dni del autor.");
            System.out.print(" > ");
            dni = scan.nextLine();
            System.out.println("Introduce el nombre del autor.");
            System.out.print(" > ");
            nombre = scan.nextLine();
            System.out.println("Introduce la nacionalidad del autor.");
            System.out.print(" > ");
            nacionalidad = scan.nextLine();
            Autores a = new Autores(dni, nombre, nacionalidad);
            a.getLibro().add(l);
            guardarModificar(a);
            return a;
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Problema creando a un Autor - Error:" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static Libros crearLibro(Autores a) {
        try {
            Scanner scan = new Scanner(System.in);
            String titulo;
            float precio;
            String dni;
            System.out.println("Introduce el titulo del libro.");
            System.out.print(" > ");
            titulo = scan.nextLine();
            System.out.println("Introduce el precio del libro.");
            System.out.print(" > ");
            precio = scan.nextFloat();
            scan.nextLine();

            Libros l = new Libros(titulo, precio);
            l.setAutor(a);
            return l;
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Problema creando un Libro - Error:" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static void InsertarTlf() {
        Scanner scan = new Scanner(System.in);
        int telf;
        String dni;

        try {
            System.out.println("Introduce el telefono del autor.");
            System.out.print(" > ");
            telf = Integer.parseInt(scan.nextLine());
            Autores a = null;
            do {
                Visualizaciones.visualizarAutores();
                a = buscarAutor();
                if (a == null) {
                    System.out.println("El autor introducido no existe.");
                }
            } while (a == null);
            Telefonos t = new Telefonos(telf);
            t.setAutor(a);
            t.setDniAutor(a.getDniAutor());
            guardarModificar(t);
            System.out.println("Telefono introducido.");
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Problema insertando Telefono - Error:" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static Autores buscarAutor() {
        Scanner scan = new Scanner(System.in);
        Autores a = null;
        Session s;
        String dni;

        System.out.println("Introduce el DNI del autor.");
        System.out.print(" > ");
        dni = scan.nextLine();
        try {
            s = NewHibernateUtil.getSession();
            a = (Autores) s.get(Autores.class, dni);
            s.close();

        } catch (HibernateException e) {
            System.out.println(e);
        }
        return a;
    }

    public static void guardarModificar(Object objeto) {

        Session sesion;
        try {
            sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.saveOrUpdate(objeto);
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

}
