package controlador;

import modelo.Calculadora;
import vista.CalculadoraVista;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

public class CalculadoraControlador {
    private final CalculadoraVista vista;

    public CalculadoraControlador(CalculadoraVista vista, Runnable salir) {
        this.vista = vista;

        vista.getSumaButton().addActionListener(leerDatosYMostrarResultado(
                Calculadora::sumar
        ));
        vista.getRestaButton().addActionListener(leerDatosYMostrarResultado(
                Calculadora::restar
        ));
        vista.getMultiplicaciónButton().addActionListener(leerDatosYMostrarResultado(
                Calculadora::multiplicar
        ));
        vista.getDivisiónButton().addActionListener(leerDatosYMostrarResultado(
                Calculadora::dividir
        ));

        vista.getLimpiarDatosButton().addActionListener(
                event -> limpiarDatos()
        );
        vista.getSalirButton().addActionListener(
                event -> salir.run()
        );
    }

    private ActionListener leerDatosYMostrarResultado(BinaryOperator<Double> acción) {
        return event -> {
            try {
                double dato1 = Double.parseDouble(vista.getDato1Field().getText());
                double dato2 = Double.parseDouble(vista.getDato2Field().getText());
                String resultado = String.valueOf(acción.apply(dato1, dato2));
                vista.getResultadoField().setText(resultado);
            } catch (NumberFormatException e) {
                limpiarDatos();
            }
        };
    }

    private void limpiarDatos() {
        vista.getDato1Field().setText("");
        vista.getDato2Field().setText("");
        vista.getResultadoField().setText("");
    }
}
