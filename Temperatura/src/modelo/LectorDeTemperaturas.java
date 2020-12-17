package modelo;

import java.io.FileNotFoundException;

public interface LectorDeTemperaturas {
    Double[][] leerTemperaturasSemanalesDeLosDoceMeses() throws FileNotFoundException;

    String[] NOMBRES_DE_MESES = new String[]{
            "Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "Junio",
            "Julio",
            "Agosto",
            "Septiembre",
            "Octubre",
            "Noviembre",
            "Diciembre"
    };
    int NUMERO_DE_MESES = NOMBRES_DE_MESES.length;
    int SEMANAS_EN_UN_MES = 4;
}
