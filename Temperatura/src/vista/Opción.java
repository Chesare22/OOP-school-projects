package vista;

public abstract class Opción {
    public final String etiqueta;
    public final String mensajeDeError;

    public Opción(String etiqueta, String mensajeDeError) {
        this.etiqueta = etiqueta;
        this.mensajeDeError = mensajeDeError;
    }

    public abstract Double[][] ejecutar() throws Exception;
}
