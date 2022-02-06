package rectangulo;

public class ValoresMuyGrandes extends Throwable {
    public ValoresMuyGrandes(double maxCoordenada) {
        super("Alguna coordenada es mayor que " + maxCoordenada);
    }
}
