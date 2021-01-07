package vista;

import modelo.Circulo;

import javax.swing.*;
import java.awt.*;

public class VistaCirculo {
    private JPanel PanelPrincipal;
    private JPanel Etiquetas;
    private JTextField Radio;
    private JTextField Resultado;
    private JPanel Inputs;
    private JPanel RadioResultado;
    private JPanel BotonesInferiores;
    private JButton circunferenciaButton;
    private JButton áreaButton;
    private JButton button3;
    private JButton button4;

    public VistaCirculo() {
        circunferenciaButton.addActionListener(event -> {
            double radio = Double.parseDouble(Radio.getText());
            Circulo circulo = new Circulo(radio);

            String circunferencia = String.valueOf(circulo.getPerímetro());
            Resultado.setText(circunferencia);
        });
    }

    public Container getPanelPrincipal() {
        return PanelPrincipal;
    }
}
