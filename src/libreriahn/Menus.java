package libreriahn;

import funciones.Altas;
import funciones.Bajas;
import funciones.Modificar;
import funciones.Visualizaciones;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author mallo
 */
public class Menus {

    public static int menu(BufferedReader lee) {

        int menu = 0;

        do {
            try {
                System.out.println("---**************** MENU PRINCIPAL ****************---"
                        + "\n   1.- Altas"
                        + "\n   2.- Bajas"
                        + "\n   3.- Modificaciones"
                        + "\n   4.- Consultas"
                        + "\n   5.- Visualizar"
                        + "\n   6.- Borrar BD"
                        + "\n------------------------------------------------------"
                        + "\n   7.- Salir"
                        + "\n---************************************************---");
                menu = Integer.parseInt(lee.readLine());

                if (menu < 0 || menu > 7) {
                    System.out.println("'Error', elija una opción porfavor");
                }

            } catch (NumberFormatException e) {
                System.out.println("'Error', introduzca numeros no letras porfavor");
            } catch (IOException e) {
            }

        } while (menu < 0 || menu > 7);

        return menu;
    }

    public static char confirmacion(BufferedReader lee, String mensaje) {

        char menu = 'a';

        do {
            try {
                System.out.println(mensaje
                        + "\nS - Si"
                        + "\nN - No");
                menu = lee.readLine().toUpperCase().charAt(0);

            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("'Error', solo puede introducir una letra");
            } catch (IOException e) {
            }

        } while (menu != 'S' && menu != 'N');

        return menu;
    }

    static void MenuAltas(BufferedReader lee) {

        int menu = 0;

        do {
            try {
                System.out.println("---**************** MENU INSERTAR ****************---"
                        + "\n   1.- Insertar Autor"
                        + "\n   2.- Insertar Libro"
                        + "\n   3.- Insertar Teléfono"
                        + "\n------------------------------------------------------"
                        + "\n   4.- Salir"
                        + "\n---************************************************---");
                menu = Integer.parseInt(lee.readLine());

                if (menu < 0 || menu > 4) {
                    System.out.println("'Error', elija una opción porfavor");
                }

            } catch (NumberFormatException e) {
                System.out.println("'Error', introduzca numeros no letras porfavor");
            } catch (IOException e) {
            }

        } while (menu < 0 || menu > 4);

        Altas.escogerInsertar(menu);
    }

    static void MenuBajas(BufferedReader lee) {

        int menu = 0;

        do {
            try {
                System.out.println("---**************** MENU BAJAS ****************---"
                        + "\n   1.- Borrar Libro"
                        + "\n   2.- Borrar Autor"
                        + "\n   3.- Borrar Teléfono"
                        + "\n------------------------------------------------------"
                        + "\n   4.- Salir"
                        + "\n---************************************************---");
                menu = Integer.parseInt(lee.readLine());

                if (menu < 0 || menu > 4) {
                    System.out.println("'Error', elija una opción porfavor");
                }

            } catch (NumberFormatException e) {
                System.out.println("'Error', introduzca numeros no letras porfavor");
            } catch (IOException e) {
            }

        } while (menu < 0 || menu > 4);

        Bajas.escogerBaja(menu);
    }

    static void MenuModificar(BufferedReader lee) {

        int menu = 0;

        do {
            try {
                System.out.println("---**************** MENU MODIFICACIONES ****************---"
                        + "\n   1.- Modificar precio de un libro"
                        + "\n   2.- Cambiar el teléfono de un Autor"
                        + "\n------------------------------------------------------"
                        + "\n   3.- Salir"
                        + "\n---************************************************---");
                menu = Integer.parseInt(lee.readLine());

                if (menu < 0 || menu > 3) {
                    System.out.println("'Error', elija una opción porfavor");
                }

            } catch (NumberFormatException e) {
                System.out.println("'Error', introduzca numeros no letras porfavor");
            } catch (IOException e) {
            }

        } while (menu < 0 || menu > 3);

        Modificar.escogerModificaciones(menu);

    }

    static void MenuConsultas(BufferedReader lee) {
        
        int menu = 0;

        do {
            try {
                System.out.println("---**************** MENU CONSULTAS ****************---"
                        + "\n   1.- Introduce el nombre de un libro y visualice información del autor"
                        + "\n   2.- Información de un autor y sus libros"
                        + "\n------------------------------------------------------"
                        + "\n   3.- Salir"
                        + "\n---************************************************---");
                menu = Integer.parseInt(lee.readLine());

                if (menu < 0 || menu > 3) {
                    System.out.println("'Error', elija una opción porfavor");
                }

            } catch (NumberFormatException e) {
                System.out.println("'Error', introduzca numeros no letras porfavor");
            } catch (IOException e) {
            }

        } while (menu < 0 || menu > 3);

        Visualizaciones.escogerConsulta(menu);
    }

    static void MenuVisualizar(BufferedReader lee) {

        int menu = 0;

        do {
            try {
                System.out.println("---**************** MENU VISUALIZACIONES ****************---"
                        + "\n   1.- Visualizar todos los libros"
                        + "\n   2.- Visualizar todos los autores con sus libros"
                        + "\n------------------------------------------------------"
                        + "\n   3.- Salir"
                        + "\n---************************************************---");
                menu = Integer.parseInt(lee.readLine());

                if (menu < 0 || menu > 3) {
                    System.out.println("'Error', elija una opción porfavor");
                }

            } catch (NumberFormatException e) {
                System.out.println("'Error', introduzca numeros no letras porfavor");
            } catch (IOException e) {
            }

        } while (menu < 0 || menu > 3);

        Visualizaciones.escogerVisualizacion(menu);

    }

}
