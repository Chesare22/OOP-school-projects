package control;

import modelo.Circulo;
import vista.VistaCirculo;

import java.awt.event.ActionListener;
import java.util.function.Supplier;

public class ControladorCírculo {
    private final Circulo circulo;
    private final VistaCirculo vistaCirculo;

    public ControladorCírculo(Circulo circulo, VistaCirculo vistaCirculo, Runnable salir) {
        this.circulo = circulo;
        this.vistaCirculo = vistaCirculo;

        vistaCirculo.getCircunferenciaButton().addActionListener(leerRadioYMostrarResultado(
                circulo::getPerímetro
        ));

        vistaCirculo.getÁreaButton().addActionListener(leerRadioYMostrarResultado(
                circulo::getArea
        ));

        vistaCirculo.getVolumenButton().addActionListener(leerRadioYMostrarResultado(
                circulo::getVolumen
        ));

        vistaCirculo.getLimpiarButton().addActionListener(
                event -> limpiarDatos()
        );

        vistaCirculo.getSalirButton().addActionListener(
                event -> salir.run()
        );
    }

    private ActionListener leerRadioYMostrarResultado(Supplier acción){
        return event -> {
            try {
                double radio = Double.parseDouble(vistaCirculo.getRadioTextField().getText());
                circulo.setRadio(radio);
                String resultado = String.valueOf(acción.get());
                vistaCirculo.getResultadoTextField().setText(resultado);
            } catch (NumberFormatException e) {
                limpiarDatos();
            }
        };
    }

    private void limpiarDatos() {
        vistaCirculo.getRadioTextField().setText("");
        vistaCirculo.getResultadoTextField().setText("");
    }
}
