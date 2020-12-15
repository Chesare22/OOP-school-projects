package test;

import modelo.Estudiante;
import modelo.EstudianteGraduado;
import modelo.EstudianteNoGraduado;

public class TestEstudiantePolimorfismo {

    public static void main(String[] args) {

        Estudiante[] lista = new Estudiante[] {
                new EstudianteGraduado("Pánfilo"),
                new EstudianteGraduado("Yayita"),
                new EstudianteNoGraduado("Balalaica"),
                new EstudianteGraduado("Pintatucha"),
        };

        lista[0].asignaCalifExamen(1, 90);
        lista[0].asignaCalifExamen(2, 90);
        lista[0].asignaCalifExamen(3, 90);
        lista[1].asignaCalifExamen(1, 60);
        lista[1].asignaCalifExamen(2, 90);
        lista[1].asignaCalifExamen(3, 70);
        lista[2].asignaCalifExamen(1, 90);
        lista[2].asignaCalifExamen(2, 90);
        lista[2].asignaCalifExamen(3, 90);
        lista[3].asignaCalifExamen(1, 100);
        lista[3].asignaCalifExamen(2, 100);
        lista[3].asignaCalifExamen(3, 90);

        for (Estudiante estudiante : lista) {
            if (estudiante instanceof EstudianteGraduado) {
                estudiante.calculaCalificacionCurso();
                System.out.println(estudiante.obtenNombre() +
                        " Estudiante graduado terminó el curso con la nota: " +
                        estudiante.obtenCalificacionCurso() + ".");
            } else {
                estudiante.calculaCalificacionCurso();
                System.out.println(estudiante.obtenNombre() +
                        " Estudiante No graduado terminó el curso con la nota: " +
                        estudiante.obtenCalificacionCurso() + ".");
            }
        }
    }
}
