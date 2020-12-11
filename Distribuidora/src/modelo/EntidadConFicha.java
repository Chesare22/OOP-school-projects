package modelo;

import java.util.function.Function;

public class EntidadConFicha {
    private Ficha ficha;

    public EntidadConFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public String darFormato(Function<String, String> crearLínea) {
        return
                crearLínea.apply("Título: " + ficha.getTitulo()) +
                crearLínea.apply("Precio: " + ficha.getPrecio()) +
                crearLínea.apply("Empresa distribuidora: " + ficha.getEmpresaDistribuidora());
    }

    public Ficha getFicha() {
        return ficha;
    }
}
