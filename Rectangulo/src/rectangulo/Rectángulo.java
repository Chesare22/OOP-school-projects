package rectangulo;

public class Rectángulo {
    private Coordenada inferiorDerecha;
    private Coordenada superiorDerecha;
    private Coordenada superiorIzquierda;
    private Coordenada inferiorIzquierda;

    private static final double MAX_COORDENADA = 20;

    public Rectángulo(
            Coordenada inferiorDerecha,
            Coordenada superiorDerecha,
            Coordenada superiorIzquierda,
            Coordenada inferiorIzquierda
    ) throws ValoresMuyGrandes, NoEstáEnPrimerCuadrante, NoEsRectángulo {
        setCoordenadas(inferiorDerecha,
                superiorDerecha,
                superiorIzquierda,
                inferiorIzquierda);
    }

    public final void setCoordenadas(
            Coordenada inferiorDerecha,
            Coordenada superiorDerecha,
            Coordenada superiorIzquierda,
            Coordenada inferiorIzquierda
    ) throws ValoresMuyGrandes, NoEstáEnPrimerCuadrante, NoEsRectángulo {
        validar(inferiorDerecha, superiorDerecha, superiorIzquierda, inferiorIzquierda);
        this.inferiorDerecha = inferiorDerecha;
        this.superiorDerecha = superiorDerecha;
        this.superiorIzquierda = superiorIzquierda;
        this.inferiorIzquierda = inferiorIzquierda;
    }

    public final void validar(
            Coordenada inferiorDerecha,
            Coordenada superiorDerecha,
            Coordenada superiorIzquierda,
            Coordenada inferiorIzquierda

    ) throws NoEstáEnPrimerCuadrante, ValoresMuyGrandes, NoEsRectángulo {

        if (!(inferiorDerecha.cuadrante() == 1
                && superiorDerecha.cuadrante() == 1
                && superiorIzquierda.cuadrante() == 1
                && inferiorIzquierda.cuadrante() == 1)) {
            throw new NoEstáEnPrimerCuadrante();
        }

        if (!(inferiorDerecha.sonValoresMenoresQue(MAX_COORDENADA)
                && superiorDerecha.sonValoresMenoresQue(MAX_COORDENADA)
                && superiorIzquierda.sonValoresMenoresQue(MAX_COORDENADA)
                && inferiorIzquierda.sonValoresMenoresQue(MAX_COORDENADA))){
           throw new ValoresMuyGrandes(MAX_COORDENADA);
        }

        if(!(inferiorIzquierda.distancia(superiorIzquierda) == inferiorDerecha.distancia(superiorDerecha)
            && superiorIzquierda.distancia(superiorDerecha) == inferiorIzquierda.distancia(inferiorDerecha)
            && Coordenada.ánguloEsCuadrado(superiorIzquierda, inferiorIzquierda, inferiorDerecha)
            && Coordenada.ánguloEsCuadrado(superiorIzquierda, superiorDerecha, inferiorDerecha))){
            throw new NoEsRectángulo();
        }

    }

    private double getHorizontal() {
        return inferiorDerecha.distancia(inferiorIzquierda);
    }

    private double getVertical() {
        return superiorDerecha.distancia(inferiorDerecha);
    }

    public double getLongitud() {
        return Math.max(getVertical(), getHorizontal());
    }

    public double getAnchura() {
        return Math.min(getVertical(), getHorizontal());
    }

    public double getPerímetro() {
        return (getVertical() + getHorizontal()) * 2;
    }

    public double getÁrea() {
        return getVertical() * getHorizontal();
    }

    public boolean esCuadrado() {
        return getVertical() == getHorizontal();
    }
}
