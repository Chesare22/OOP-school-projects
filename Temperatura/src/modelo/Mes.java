package modelo;

public class Mes {
    private final Double[] temperaturasDeLaSemana;

    public Mes(Double[] temperaturasDeLaSemana) {
        this.temperaturasDeLaSemana = temperaturasDeLaSemana.clone();
    }

    public Double[] getTemperaturasDeLaSemana() {
        return temperaturasDeLaSemana.clone();
    }
}
