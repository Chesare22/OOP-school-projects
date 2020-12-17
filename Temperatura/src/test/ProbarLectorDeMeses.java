package test;

import modelo.LectorDeTemperaturas;
import modelo.LectorDeTemperaturasDesdeArchivo;

import java.io.FileNotFoundException;

import static modelo.Estadisticas.*;
import static modelo.LectorDeTemperaturas.*;
import static modelo.OperadoresDeListas.map;

public class ProbarLectorDeMeses {
    public static void main(String[] args) throws FileNotFoundException {
        probar(new LectorDeTemperaturasDesdeArchivo("temperaturas.txt"));
    }

    public static void probar(LectorDeTemperaturas lector) throws FileNotFoundException {
        Double[][] temperaturasSemanalesPorMes = lector.leerTemperaturas();

        Double[] promediosMensuales = map(calcularPromedio, temperaturasSemanalesPorMes, Double[]::new);
        Double[] temperaturasMinimas = map(calcularMinimo, temperaturasSemanalesPorMes, Double[]::new);
        Double[] temperaturasMaximas = map(calcularMaximo, temperaturasSemanalesPorMes, Double[]::new);


        for (int i = 0; i < NUMERO_DE_MESES; i++) {
            StringBuilder temperaturasSemanales = new StringBuilder();
            for (int j = 0; j < SEMANAS_EN_UN_MES; j++) {
                temperaturasSemanales.append(temperaturasSemanalesPorMes[i][j]).append("  ");
            }

            System.out.println("Temperaturas del mes de " + NOMBRES_DE_MESES[i] + ": " + temperaturasSemanales);
            System.out.println("Promedio del mes: " + promediosMensuales[i]);
            System.out.println("Temperatura mínima del mes: " + temperaturasMinimas[i]);
            System.out.println("Temperatura máxima del mes: " + temperaturasMaximas[i]);
            System.out.println("+-".repeat(15));
        }

        System.out.println("Promedio anual: " + calcularPromedio.apply(promediosMensuales));
        System.out.println("Temperatura mínima del año: " + calcularMinimo.apply(temperaturasMinimas));
        System.out.println("Temperatura máxima del año: " + calcularMaximo.apply(temperaturasMaximas));
    }

}
