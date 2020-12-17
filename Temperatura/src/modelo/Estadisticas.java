package modelo;

import java.util.function.Function;

import static modelo.OperadoresDeListas.crearReductor;

public class Estadisticas {

    public static final Function<Double[], Double>
            sumarTodosLosDatos = crearReductor(Double::sum);

    public static final Function<Double[], Double>
            calcularPromedio = datos -> sumarTodosLosDatos.apply(datos) / datos.length;

    public static final Function<Double[], Double>
            calcularMinimo = crearReductor(Math::min);

    public static final Function<Double[], Double>
            calcularMaximo = crearReductor(Math::max);
}
