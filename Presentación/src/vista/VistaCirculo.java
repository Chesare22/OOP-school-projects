package vista;

import modelo.Circulo;

import javax.swing.*;
import java.awt.*;

public class VistaCirculo {
    private JPanel PanelPrincipal;
    private JPanel Etiquetas;
    private JTextField RadioTextField;
    private JTextField ResultadoTextField;
    private JPanel Inputs;
    private JPanel RadioResultado;
    private JPanel BotonesInferiores;
    private JButton circunferenciaButton;
    private JButton áreaButton;
    private JButton volumenButton;
    private JButton salirButton;
    private JButton limpiarButton;

    public Container getPanelPrincipal() {
        return PanelPrincipal;
    }

    public JTextField getRadioTextField() {
        return RadioTextField;
    }

    public JTextField getResultadoTextField() {
        return ResultadoTextField;
    }

    public JButton getCircunferenciaButton() {
        return circunferenciaButton;
    }

    public JButton getÁreaButton() {
        return áreaButton;
    }

    public JButton getVolumenButton() {
        return volumenButton;
    }

    public JButton getSalirButton() {
        return salirButton;
    }

    public JButton getLimpiarButton() {
        return limpiarButton;
    }
}
