package modelo;

public class Ficha {
    private double precio;
    private String titulo;
    private String empresaDistribuidora;

    public Ficha(double precio, String titulo, String empresaDistribuidora) {
        this.precio = precio;
        this.titulo = titulo;
        this.empresaDistribuidora = empresaDistribuidora;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEmpresaDistribuidora() {
        return empresaDistribuidora;
    }

    public void setEmpresaDistribuidora(String empresaDistribuidora) {
        this.empresaDistribuidora = empresaDistribuidora;
    }
}
