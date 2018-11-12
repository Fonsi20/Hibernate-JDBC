package bbdd;

import java.io.BufferedReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import libreriahn.Menus;
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
public class comprovacionesBBDD {

    static ResultSet resultado2;

    public static void comprobacionBD(BufferedReader lee, Statement sentencia, ResultSet resultado) {

        try {
            // crear BD
            sentencia.execute("CREATE DATABASE IF NOT EXISTS libreriafon_hn;");
            // poner en uso la BD recien creada
            sentencia.execute("USE libreriafon_hn;");
            // crear las tablas de la base de datos
            creacionTablas.crearTablas(sentencia, resultado);

        } catch (SQLException e) {
            System.out.println("Sentencia no ejecutada");
        } catch (Exception e) {
        }
    }

    public static void borrarBD(BufferedReader lee, Statement sentencia) {

        char op = Menus.confirmacion(lee, "Esta seguro de que desea borrar la BD?");
        if (op == 'S') {
            try {
                sentencia.execute("DROP DATABASE libreriafon_hn;");
                comprovacionesBBDD.comprobacionBD(lee, sentencia, resultado2);
                System.out.println("---*************** BASE DE DATOS RESTAURADA ***************---");
            } catch (SQLException e) {
                System.out.println("\033[31mSentencia no ejecutada");
            }
        }

    }

    public static Autores comprobarAutor(String dni) {

        Session sesion;
        Autores a = null;
        try {
            sesion = NewHibernateUtil.getSession();
            a = (Autores) sesion.get(Autores.class, dni);
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return a;
    }

    public static Libros comprobarLibro(int cod) {

        Session sesion;
        Libros l = null;
        try {
            sesion = NewHibernateUtil.getSession();
            l = (Libros) sesion.get(Libros.class, cod);
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return l;

    }

    public static Telefonos comprobarTlf(String dni) {
        Session s;
        Telefonos t = null;
        try {
            s = NewHibernateUtil.getSession();
            t = (Telefonos) s.get(Telefonos.class, dni);
            s.close();
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return t;
    }

    public static Object busqueda1Variable1Objeto(String objeto, String columna, String variable) {

        Session sesion;
        int c = 0;
        Object obj = null;
        try {
            sesion = NewHibernateUtil.getSession();
            obj = sesion.createQuery("FROM " + objeto + " WHERE " + columna + " = '" + variable + "'").uniqueResult();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

        return obj;
    }

}
