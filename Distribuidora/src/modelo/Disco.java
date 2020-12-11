package modelo;

import java.util.function.Function;

public class Disco extends EntidadConFicha{
    private final double duraciónEnMinutos;

    public Disco(Ficha ficha, double duraciónEnMinutos) {
        super(ficha);
        this.duraciónEnMinutos = duraciónEnMinutos;
    }

    @Override
    public String darFormato(Function<String, String> crearLínea) {
        return
                super.darFormato(crearLínea) +
                crearLínea.apply("Duración en minutos: " + duraciónEnMinutos);
    }
}
