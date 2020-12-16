package test;

import modelo.LectorDeMeses;
import modelo.LeerMesesDesdeCLI;

import java.util.Arrays;

import static modelo.Estadisticas.*;
import static modelo.LectorDeMeses.*;

public class TestLeerDesdeCLI {
    public static void main(String[] args) {
        LectorDeMeses lector = new LeerMesesDesdeCLI();
        Double[][] meses = lector.leer();

        Double[] promediosMensuales = Arrays.stream(meses)
                .map(calcularPromedio)
                .toArray(Double[]::new);

        Double[] temperaturasMinimas = Arrays.stream(meses)
                .map(calcularMinimo)
                .toArray(Double[]::new);

        Double[] temperaturasMaximas = Arrays.stream(meses)
                .map(calcularMaximo)
                .toArray(Double[]::new);

        for (int i = 0; i < NUMERO_DE_MESES; i++) {
            StringBuilder temperaturasSemanales = new StringBuilder();
            for (int j = 0; j < SEMANAS_EN_UN_MES; j++) {
                temperaturasSemanales.append(meses[i][j]).append("  ");
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
