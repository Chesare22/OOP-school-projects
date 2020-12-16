package test;


import static modelo.Estadisticas.calcularMaximo;
import static modelo.Estadisticas.calcularMinimo;
import static modelo.Estadisticas.calcularPromedio;

public class TestEstadisticas {
    public static void main(String[] args) {
        double[] numeros = new double[] { 1.0, 3.0, 2.0, 4.0, 5.0 };

        double promedio = calcularPromedio.apply(numeros);
        double minimo = calcularMaximo.apply(numeros);
        double maximo = calcularMinimo.apply(numeros);

        System.out.println(promedio);
        System.out.println(minimo);
        System.out.println(maximo);
    }
}
