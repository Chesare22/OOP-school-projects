package modelo;

import java.util.function.Function;

public class Libro extends EntidadConFicha {
    private final int añoDePublicación;
    private final int númeroDePáginas;

    public Libro(Ficha ficha, int añoDePublicación, int númeroDePáginas) {
        super(ficha);
        this.añoDePublicación = añoDePublicación;
        this.númeroDePáginas = númeroDePáginas;
    }

    @Override
    public String darFormato(Function<String, String> crearLínea) {
        return
                super.darFormato(crearLínea) +
                crearLínea.apply("Año de publicación: " + añoDePublicación) +
                crearLínea.apply("Número de páginas: " + númeroDePáginas);
    }

}
