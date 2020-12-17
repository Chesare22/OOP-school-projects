package modelo;

import java.util.Scanner;

public class LectorDeTemperaturasDesdeCLI implements LectorDeTemperaturas {

    private static String pedirDatos(int numeroDeMes, int numeroDeSemana) {
        return "Ingresar temperatura de la semana "
                + (numeroDeSemana + 1)
                + " del mes de "
                + NOMBRES_DE_MESES[numeroDeMes]
                + ": ";
    }

    @Override
    public Double[][] leerTemperaturasSemanalesDeLosDoceMeses() {
        Scanner scanner = new Scanner(System.in);
        Double[][] temperaturasSemanalesPorMes = new Double[NUMERO_DE_MESES][SEMANAS_EN_UN_MES];

        for (int i = 0; i < NUMERO_DE_MESES; i++) {
            for (int j = 0; j < SEMANAS_EN_UN_MES; j++) {
                System.out.print(pedirDatos(i, j));
                temperaturasSemanalesPorMes[i][j] = scanner.nextDouble();
            }
        }

        return temperaturasSemanalesPorMes;
    }
}
