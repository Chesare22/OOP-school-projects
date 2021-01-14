package test;

import controlador.CalculadoraControlador;
import vista.CalculadoraVista;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        CalculadoraVista vista = new CalculadoraVista();

        JFrame frame = new JFrame("CalculadoraVista");
        frame.setContentPane(vista.getPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        new CalculadoraControlador(vista, frame::dispose);
    }
}
