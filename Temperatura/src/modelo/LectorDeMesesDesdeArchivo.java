package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LectorDeMesesDesdeArchivo implements LectorDeMeses {
    private final String nombreDeArchivo;

    public LectorDeMesesDesdeArchivo(String nombreDeArchivo) {
        this.nombreDeArchivo = nombreDeArchivo;
    }

    @Override
    public Double[][] leer() throws FileNotFoundException {
        Scanner reader = new Scanner(new File(nombreDeArchivo));
        Double[][] temperaturas = new Double[NUMERO_DE_MESES][SEMANAS_EN_UN_MES];

        for (int i = 0; i < NUMERO_DE_MESES; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.nextLine());
            for (int j = 0; j < SEMANAS_EN_UN_MES; j++) {
                temperaturas[i][j] = Double.valueOf(tokenizer.nextToken());
            }
        }

        return temperaturas;
    }
}
