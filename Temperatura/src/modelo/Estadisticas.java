package modelo;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Estadisticas {

    public static Function<Double[], Double> reducir(BinaryOperator<Double> operator) {
        return datos -> Arrays.stream(datos)
                .reduce(operator)
                .get();
    }

    public static final Function<Double[], Double>
            sumarTodosLosDatos = reducir(Double::sum);

    public static final Function<Double[], Double>
        calcularPromedio = datos -> sumarTodosLosDatos.apply(datos) / datos.length;

    public static final Function<Double[], Double>
            calcularMinimo = reducir(Math::min);

    public static final Function<Double[], Double>
            calcularMaximo = reducir(Math::max);
}
