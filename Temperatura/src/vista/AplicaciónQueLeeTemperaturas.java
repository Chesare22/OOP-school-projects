package vista;

import java.util.Objects;
import java.util.Scanner;

import static modelo.Estadisticas.*;
import static modelo.LectorDeTemperaturas.NOMBRES_DE_MESES;
import static modelo.OperadoresDeListas.map;

public class AplicaciónQueLeeTemperaturas {
    private static final Opción[] OPCIONES = {
            new LeerDatosDesdeArchivo("Leer desde un archivo", "No se encontró el archivo"),
            new LeerDatosDesdeTerminal("Leer desde la terminal", "Ocurrió un problema"),
    };
    public void correr() {
        Double[][] temperaturas = obtenerTemperaturas();

        Double[] promediosMensuales = map(calcularPromedio, temperaturas, Double[]::new);
        Double[] temperaturasMinimas = map(calcularMinimo, temperaturas, Double[]::new);
        Double[] temperaturasMaximas = map(calcularMaximo, temperaturas, Double[]::new);
        double promedioAnual = calcularPromedio.apply(promediosMensuales);

        int selección;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Calcular el promedio de un mes");
            System.out.println("2. Calcular el promedio anual");
            System.out.println("3. Calcular temperaturas máxima y mínima de un mes");
            System.out.println("4. Imprimir las temperaturas semanales de un mes");
            System.out.println("5. Salir");
            selección = scanner.nextInt();

            int númeroDelMes;
            switch (selección){
                case 1:
                    System.out.print("Ingrese el número de mes: ");
                    númeroDelMes = scanner.nextInt() - 1;
                    imprimirResultado("El promedio de las temperaturas de "
                            + NOMBRES_DE_MESES[númeroDelMes]
                            + " fue de "
                            + promediosMensuales[númeroDelMes]
                    );
                    break;
                case 2:
                    imprimirResultado("El promedio anual es de " + promedioAnual);
                    break;
                case 3:
                    System.out.print("Ingrese el número de mes: ");
                    númeroDelMes = scanner.nextInt() - 1;
                    imprimirResultado("La temperatura mínima del mes de "
                            + NOMBRES_DE_MESES[númeroDelMes]
                            + " fue de "
                            + temperaturasMinimas[númeroDelMes]
                            + ", y la máxima fue de "
                            + temperaturasMaximas[númeroDelMes]
                    );
                    break;
                case 4:
                    System.out.print("Ingrese el número de mes: ");
                    númeroDelMes = scanner.nextInt() - 1;
                    Double[] temperaturasDelMes = temperaturas[númeroDelMes];
                    String mensaje = "Las temperaturas del mes de "
                            + NOMBRES_DE_MESES[númeroDelMes]
                            + " fueron: ";
                    for (int i = 0; i < temperaturas.length; i++) {
                        mensaje += temperaturasDelMes[i];
                        if (i != temperaturas.length - 1) {
                            mensaje += ", ";
                        }
                    }
                    imprimirResultado(mensaje);
            }
        } while (selección != 5);
    }

    private static void imprimirResultado(String mensaje) {
        String separador = "+-".repeat(mensaje.length() / 2);
        if (mensaje.length() % 2 == 1) {
            separador += "+";
        }
        System.out.println(separador);
        System.out.println(mensaje);
        System.out.println(separador);
    }

    private static Double[][] obtenerTemperaturas() {
        Double[][] temperaturas = null;
        do {
            Opción opción = seleccionarOpción();
            try {
                temperaturas = opción.ejecutar();
            } catch (Exception e) {
                System.out.println(opción.mensajeDeError);
            }
        } while (Objects.isNull(temperaturas));

        return temperaturas;
    }

    private static Opción seleccionarOpción() {
        int opciónSeleccionada;
        Scanner scanner = new Scanner(System.in);
        do {
            imprimirOpciones();
            opciónSeleccionada = scanner.nextInt();
        } while (opciónSeleccionada > OPCIONES.length || opciónSeleccionada < 0);
        return OPCIONES[opciónSeleccionada - 1];
    }

    private static void imprimirOpciones() {
        System.out.println("Seleccione una de las siguientes opciones: ");
        for (int i = 0; i < OPCIONES.length; i++) {
            System.out.println((i + 1) + ".- " + OPCIONES[i].etiqueta);
        }
    }
}
