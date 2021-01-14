package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CalculadoraVista {
    private JPanel PanelPrincipal;
    private JPanel BotonesDeAcción;
    private JButton sumaButton;
    private JButton restaButton;
    private JButton multiplicaciónButton;
    private JButton divisiónButton;
    private JButton limpiarDatosButton;
    private JButton salirButton;
    private JTextField resultadoField;
    private JTextField dato1Field;
    private JTextField dato2Field;

    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    public JButton getSumaButton() {
        return sumaButton;
    }

    public JButton getRestaButton() {
        return restaButton;
    }

    public JButton getMultiplicaciónButton() {
        return multiplicaciónButton;
    }

    public JButton getDivisiónButton() {
        return divisiónButton;
    }

    public JButton getLimpiarDatosButton() {
        return limpiarDatosButton;
    }

    public JButton getSalirButton() {
        return salirButton;
    }

    public JTextField getDato1Field() {
        return dato1Field;
    }

    public JTextField getDato2Field() {
        return dato2Field;
    }

    public JTextField getResultadoField() {
        return resultadoField;
    }
}
