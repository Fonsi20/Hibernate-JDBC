package libreriahn;

import bbdd.comprovacionesBBDD;
import java.io.*;
import java.sql.*;

/**
 * @author mallo
 */
public class LibreriaHN {

    static Connection conexion;
    static Statement sentencia;
    static ResultSet resultado;

    public static void main(String[] args) {

        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3307?user=root&password=usbw";

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            sentencia = conexion.createStatement();

        } catch (ClassNotFoundException e) {
            System.err.println("No se encontro el driver");
            System.exit(1);
        } catch (SQLException e) {
            System.err.println("No se establecio la conexion");
            System.exit(2);
        } catch (Exception e) {
            System.err.println("Error al conectar el driver con la base de datos, "
                    + "\no cualquer otro error");
            System.exit(3);
        }
        // Crear BD o la pone en uso si ya esta creada
        comprovacionesBBDD.comprobacionBD(lee, sentencia, resultado);
        NewHibernateUtil.getSessionFactory();

        int menu = 0;

        do {
            menu = Menus.menu(lee);

            switch (menu) {
                case 1:
                    Menus.MenuAltas(lee);
                    break;
                case 2:
                    Menus.MenuBajas(lee);
                    break;
                case 3:
                    Menus.MenuModificar(lee);
                    break;
                case 4:
                    Menus.MenuConsultas(lee);
                    break;
                case 5:
                    Menus.MenuVisualizar(lee);
                    break;
                case 6: // eliminar la BD
                    comprovacionesBBDD.borrarBD(lee, sentencia);
                    break;
                case 7: // salir
                    NewHibernateUtil.getSessionFactory().close();
                    break;
            }

        } while (menu != 7);

        try {
            // Cerrar la conexion
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Sentencia no ejecutada");
        }

        // Cerrar el objeto SessionFactory
        NewHibernateUtil.getSessionFactory().close();

        System.out.println("---*************** FIN DEL PROGRAMA ***************---");
    }

}
