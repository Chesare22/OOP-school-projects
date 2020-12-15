package modelo;

public class EstudianteGraduado extends Estudiante {
    public EstudianteGraduado(String nombre) {
        super(nombre);
    }

    public EstudianteGraduado() {
        super();
    }

    public void calculaCalificacionCurso() {
        int total = 0;
        for (int i = 0; i < NUM_DE_EXAMENES; i++) {
            total += examen[i];
        }
        if (total / NUM_DE_EXAMENES >= 80) {
            calificacionCurso = "Aprobado";
        } else {
            calificacionCurso = "No Aprobado";
        }
    }
}
