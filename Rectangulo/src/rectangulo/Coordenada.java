package rectangulo;


public class Coordenada {
    private final double x;
    private final double y;

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int cuadrante() {
        if (x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else if (x > 0 && y < 0) {
            return 4;
        }

        return 0;
    }

    public boolean sonValoresMenoresQue(double valor) {
        return x < valor && y < valor;
    }

    public double distancia(Coordenada punto2) {
        return Math.sqrt(
                Math.pow(punto2.getX() - x, 2)
                        + Math.pow(punto2.getY() - y, 2));
    }

    public static boolean ánguloEsCuadrado(Coordenada A, Coordenada B, Coordenada C) {
        double m1 = pendiente(A, B);
        double m2 = pendiente(B, C);

        if ((Double.isInfinite(m1) && m2 == 0)
                || (m1 == 0 && Double.isInfinite(m2))
        ) {
            return true;
        }

        return m1 * m2 == -1;
    }

    public static double pendiente(Coordenada A, Coordenada B) {
        return (B.getY() - A.getY()) / (B.getX() - A.getX());
    }

}
