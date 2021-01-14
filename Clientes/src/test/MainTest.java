/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controlador.ControlCliente;
import modelo.Cliente;
import vista.VistaCliente;

/**
 *
 * @author lbojor
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente modeloCliente = new Cliente();
        VistaCliente vistaCliente = new VistaCliente();
        ControlCliente controlCliente = new ControlCliente(modeloCliente, vistaCliente);
        //controlador.iniciarVista();
        vistaCliente.setVisible(true);
    }
    
}
