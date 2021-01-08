package modelo;

public class Circulo {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public Circulo() {
        this(10);
    }

    public double getPerímetro() {
        return radio * 2 * Math.PI;
    }

    public double getArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    public double getVolumen() {
        return Math.PI * Math.pow(radio, 3) * 4 / 3;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}
