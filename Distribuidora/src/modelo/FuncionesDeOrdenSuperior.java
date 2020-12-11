package modelo;

import java.util.function.Function;

public class FuncionesDeOrdenSuperior {
    public static Function<String, String> crearLíneaHOF(int tamañoDeSangría) {
        String sangría = " ".repeat(tamañoDeSangría);
        return texto -> new StringBuilder().append(sangría).append(texto).append("\n").toString();
    }
}
