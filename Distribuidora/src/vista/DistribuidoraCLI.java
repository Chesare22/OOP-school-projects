package vista;

import modelo.Disco;
import modelo.Distribuidora;
import modelo.Ficha;
import modelo.Libro;

import java.util.Scanner;

public class DistribuidoraCLI {
    private static final String MENÚ = crearMenú();
    private static String crearMenú() {
        String[] opciones = {
                "Agregar disco",
                "Agregar libro",
                "Imprimir reporte actual",
                "Salir"
        };

        StringBuilder menú = new StringBuilder("Seleccione una de las siguientes opciones:\n");
        for (int i = 0; i < opciones.length; i++) {
            menú
                    .append(i + 1)
                    .append(".- ")
                    .append(opciones[i])
                    .append("\n");
        }
        return menú.toString();
    }

    private final Scanner scanner;
    private final Distribuidora distribuidora;

    public DistribuidoraCLI(Distribuidora distribuidora) {
        scanner = new Scanner(System.in);
        this.distribuidora = distribuidora;
    }

    public String correr() {
        int selección;

        do {
            selección = leerInt(MENÚ);
            switch (selección) {
                case 1:
                    distribuidora.agregarDisco(leerDisco());
                    System.out.println("Disco agregado con éxito\n");
                    break;
                case 2:
                    distribuidora.agregarLibro(leerLibro());
                    System.out.println("Libro agregado con éxito\n");
                    break;
                case 3:
                    System.out.println(distribuidora.generarReporte());
            }
        } while (selección != 4);

        return distribuidora.generarReporte();
    }

    private Libro leerLibro() {
        String título = leerLínea("Ingresar título del libro: ");
        double precio = leerDouble("Ingresar precio: ");
        int añoDePublicación = leerInt("Ingresar año de publicación: ");
        int númeroDePáginas = leerInt("Ingresar número de páginas: ");

        return new Libro(new Ficha(precio, título, distribuidora.nombre), añoDePublicación, númeroDePáginas);
    }

    private Disco leerDisco() {
        String título = leerLínea("Ingresar título del disco: ");
        double precio = leerDouble("Ingresar precio: ");
        double duración = leerDouble("Ingresar duración en minutos: ");

        return new Disco(new Ficha(precio, título, distribuidora.nombre), duración);
    }

    private String leerLínea(String mensaje) {
        System.out.print(mensaje);
        scanner.nextLine();
        return scanner.nextLine();
    }

    private double leerDouble(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    private int leerInt(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }
}
