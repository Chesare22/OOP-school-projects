package modelo;

abstract public class Estudiante {
    protected final static int NUM_DE_EXAMENES = 3;
    protected String nombre;
    protected int[] examen;
    protected String calificacionCurso;
    private int edad;
    public int sexo;

    public Estudiante() {
        nombre = "Sin nombre";
        examen = new int[NUM_DE_EXAMENES];
        edad = 25;
    }

    public Estudiante(String nombreEstudiante) {
        nombre = nombreEstudiante;
        examen = new int[NUM_DE_EXAMENES];
        calificacionCurso = "****";
    }

    public String obtenCalificacionCurso() {
        return calificacionCurso;
    }

    public String obtenNombre() {
        return nombre;
    }

    public int obtenCalifExamen(int numExamen) {
        return examen[numExamen - 1];
    }

    public void asignaNombre(String nuevoNombre) {
        nombre = nuevoNombre;
    }

    public void asignaCalifExamen(int numExamen, int califExamen) {
        examen[numExamen - 1] = califExamen;
    }

    public abstract void calculaCalificacionCurso();
}
