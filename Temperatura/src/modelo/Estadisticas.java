package modelo;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;

public class Estadisticas {

    public static final Function<double[], Double>
            calcularPromedio = datos -> Arrays.stream(datos)
                .average()
                .getAsDouble();

    public static Function<double[], Double> reducir(DoubleBinaryOperator operator) {
        return datos -> Arrays.stream(datos)
                .reduce(operator)
                .getAsDouble();
    }

    public static final Function<double[], Double>
            calcularMinimo = reducir(Math::min);

    public static final Function<double[], Double>
            calcularMaximo = reducir(Math::max);
}
