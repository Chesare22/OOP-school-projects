package test;

import control.ControladorCírculo;
import modelo.Circulo;
import vista.VistaCirculo;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        VistaCirculo vista = new VistaCirculo();
        JFrame frame = new JFrame("VistaCirculo");
        frame.setContentPane(vista.getPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        new ControladorCírculo(new Circulo(), vista, frame::dispose);
    }
}
