package modelo;

import java.util.Scanner;

public class LeerMesesDesdeCLI implements LectorDeMeses {

    private static String pedirDatos(int numeroDeMes, int numeroDeSemana) {
        return "Ingresar temperatura de la semana "
                + (numeroDeSemana + 1)
                + " del mes de "
                + NOMBRES_DE_MESES[numeroDeMes]
                + ": ";
    }

    @Override
    public Double[][] leer() {
        Scanner scanner = new Scanner(System.in);
        Double[][] meses = new Double[NUMERO_DE_MESES][SEMANAS_EN_UN_MES];

        for (int i = 0; i < NUMERO_DE_MESES; i++) {
            for (int j = 0; j < SEMANAS_EN_UN_MES; j++) {
                System.out.print(pedirDatos(i, j));
                meses[i][j] = scanner.nextDouble();
            }
        }

        return meses;
    }
}
