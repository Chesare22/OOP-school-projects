package modelo;

public class Mes {
    private final float[] temperaturasDeLaSemana;

    public Mes(float[] temperaturasDeLaSemana) {
        this.temperaturasDeLaSemana = temperaturasDeLaSemana.clone();
    }

    public float[] getTemperaturasDeLaSemana() {
        return temperaturasDeLaSemana.clone();
    }
}
