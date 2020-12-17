package modelo;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;

public class OperadoresDeListas {

    // Un reductor es una función que "reduce" un arreglo de valores a un solo valor.
    // El operador es el criterio que usa para reducir.
    public static <T> Function<T[], T> crearReductor(BinaryOperator<T> operadorBinario) {
        return datos -> Arrays.stream(datos)
                .reduce(operadorBinario)
                .get();
    }

    public static <T, R> R[] map(Function<T, R> mapper, T[] arr, IntFunction<R[]> generator) {
        return Arrays.stream(arr)
                .map(mapper)
                .toArray(generator);
    }
}
