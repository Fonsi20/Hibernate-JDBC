package bbdd;

import java.sql.*;

/**
 *
 * @author mallo
 */
public class creacionTablas {

    public static void crearTablas(Statement sentencia, ResultSet resultado) {

        try {
            // crear tabla Libros
            sentencia.execute("CREATE TABLE IF NOT EXISTS AUTORES ( "
                    + "dniAutor CHAR(9) NOT NULL, "
                    + "nombre VARCHAR(30) NOT NULL, "
                    + "nacionalidad VARCHAR(30) NOT NULL, "
                    + "PRIMARY KEY (dniAutor));");

            sentencia.execute("CREATE TABLE IF NOT EXISTS LIBROS ( "
                    + "idLibro INT(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "titulo VARCHAR(30) NOT NULL, "
                    + "precio FLOAT UNSIGNED ZEROFILL NOT NULL, "
                    + "autor char(9) NOT NULL,"
                    + "PRIMARY KEY (idLibro),"
                    + "foreign key (autor) references autores (dniAutor) on delete cascade on update cascade,"
                    + "INDEX FK_autores(autor));");

            // crear tabla Telefonos
            sentencia.execute("CREATE TABLE IF NOT EXISTS TELEFONOS ( "
                    + "dniAutor CHAR(9) NOT NULL, "
                    + "numerotlf INT(9) UNSIGNED ZEROFILL NOT NULL, "
                    + "PRIMARY KEY (dniAutor),"
                    + "FOREIGN KEY (dniAutor) REFERENCES AUTORES(dniAutor)"
                    + "                      ON DELETE CASCADE ON UPDATE CASCADE,"
                    + "unique index (numerotlf));");

            System.out.println("Tablas creadas");

        } catch (SQLException e) {
            System.out.println("\033[31mSentencia no ejecutada");
        }
    }

}
