package modelo;

import java.util.Arrays;
import java.util.function.Function;

import static modelo.FuncionesDeOrdenSuperior.crearLíneaHOF;

public class Distribuidora {
    public final String nombre;
    private final Libro[] libros;
    private final Disco[] discos;
    private final int tamañoDeSangría;
    private int índiceDelSiguienteLibro = 0;
    private int índiceDelSiguienteDisco = 0;
    private final Function<String, String> crearLínea;

    public Distribuidora(String nombre, int tamañoDeArreglos, int tamañoDeSangría) {
        this.nombre = nombre;
        this.tamañoDeSangría = tamañoDeSangría;
        this.crearLínea = crearLíneaHOF(tamañoDeSangría);
        libros = new Libro[tamañoDeArreglos];
        discos = new Disco[tamañoDeArreglos];

    }


    public Distribuidora(String nombre) {
        this(nombre, 10, 4);
    }

    public void agregarLibro(Libro libro) {
        if (índiceDelSiguienteLibro < libros.length) {
            libros[++índiceDelSiguienteLibro] = libro;
        }
    }

    public void agregarDisco(Disco disco) {
        if (índiceDelSiguienteDisco < discos.length) {
            discos[++índiceDelSiguienteDisco] = disco;
        }
    }

    private String reporteDeEntidades(EntidadConFicha[] entidades, String separador) {
        // Filtrar entidades que sean nulas
        entidades
                = Arrays.stream(entidades)
                .filter(entidad -> entidad !=null)
                .toArray(EntidadConFicha[]::new);

        if (entidades.length == 0) {
            return "";
        }

        StringBuilder reporte = new StringBuilder();
        EntidadConFicha últimaEntidad = entidades[entidades.length - 1];
        for (EntidadConFicha entidad : entidades) {
            reporte
                .append(entidad.darFormato(crearLínea))
                .append(entidad.equals(últimaEntidad) ? "" : separador);
        }

        return reporte.toString();
    }

    public String generarReporte() {
        String separador = " ".repeat(tamañoDeSangría) + "-".repeat(20) + "\n";
        return "Publicaciones:\n\nLibros:\n"
                + reporteDeEntidades(libros, separador)
                + "\nDiscos:\n"
                + reporteDeEntidades(discos, separador);

    }
}
