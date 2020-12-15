package test;

import modelo.EstudianteGraduado;
import modelo.EstudianteNoGraduado;

public class MainEstudiante {
    public static void main(String[] args) {
        EstudianteGraduado Estudiante1 = new EstudianteGraduado();
        Estudiante1.asignaNombre("Juan Trejo");
        Estudiante1.asignaCalifExamen(1, 80);
        Estudiante1.asignaCalifExamen(2, 90);
        Estudiante1.asignaCalifExamen(3, 70);
        Estudiante1.calculaCalificacionCurso();
        System.out.println(Estudiante1.obtenNombre() + " terminó el curso con la nota: " +
                Estudiante1.obtenCalificacionCurso() + ".");
        EstudianteNoGraduado Estudiante2 = new EstudianteNoGraduado();
        Estudiante2.asignaNombre("Lupita Perez");
        Estudiante2.asignaCalifExamen(1, 80);
        Estudiante2.asignaCalifExamen(2, 90);
        Estudiante2.asignaCalifExamen(3, 70);
        Estudiante2.calculaCalificacionCurso();
        System.out.println(Estudiante2.obtenNombre() + " terminó el curso con la nota: " +
                Estudiante2.obtenCalificacionCurso() + ".");
    }
}