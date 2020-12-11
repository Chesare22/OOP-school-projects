package modelo;

public class Perro extends Mascota{
    @Override
    public String habla() {
        return "Guau";
    }

    public String trae() {
        return "Trayendo";
    }
}
