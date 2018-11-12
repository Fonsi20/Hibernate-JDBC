package funciones;

/**
 * @author a16alfonsofa
 */
public class Restricciones {

    static byte compruebaDni(String dni) {
        byte con = 0;

        if (dni.length() == 9) {
            if (dni.substring(0, 7).matches("[0-9]*")) {
                if (dni.substring(8).matches("[A-Za-z]*")) {
                    con = 1;
                } else {
                    System.err.println("El ultimo caracter tiene que ser una letra.");
                    con = 0;
                }
            } else {
                System.err.println("Los 8 primeros caracteres tiene que ser números.");
                con = 0;
            }
        } else {
            System.err.println("El tamaño del DNI tiene que ser de 9 Caracteres. El ultimo una Letra");
            con = 0;
        }
        return con;
    }
}
