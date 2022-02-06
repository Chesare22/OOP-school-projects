package rectangulo;

public class TestRectángulo {
    public static void main(String[] args) throws ValoresMuyGrandes, NoEsRectángulo, NoEstáEnPrimerCuadrante {
        Rectángulo rectángulo = new Rectángulo(
                new Coordenada(5, 2),
                new Coordenada(5, 8),
                new Coordenada(3, 8),
                new Coordenada(3, 2));

        System.out.println("Longitud: " + rectángulo.getLongitud());
        System.out.println("Anchura: " + rectángulo.getAnchura());
        System.out.println("Área: " + rectángulo.getÁrea());
        System.out.println("Perímetro: " + rectángulo.getPerímetro());

        String esCuadrado = rectángulo.esCuadrado() ? "Sí" : "No";
        System.out.println(esCuadrado + " es cuadrado");
    }
}
