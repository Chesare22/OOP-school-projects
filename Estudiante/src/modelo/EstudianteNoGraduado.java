package modelo;

public class EstudianteNoGraduado extends Estudiante {
    public EstudianteNoGraduado(String nombre) {
        super(nombre);
    }

    public EstudianteNoGraduado() {
        super();
    }

    public void calculaCalificacionCurso() {
        int total = 0;
        for (int i = 0; i < NUM_DE_EXAMENES; i++) {
            total += examen[i];
        }
        if (total / NUM_DE_EXAMENES >= 70) {
            calificacionCurso = "Aprobado";
        } else {
            calificacionCurso = "No Aprobado";
        }
    }

}
