package controlador;

import DAO.DAOCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import modelo.Cliente;
import vista.VistaCliente;

/**
 * @author lbojor
 */
public class ControlCliente implements ActionListener {
    private final Cliente modeloCliente;
    private final VistaCliente vistaCliente;

    public ControlCliente(Cliente modeloCliente, VistaCliente vistaCliente) {
        this.modeloCliente = modeloCliente;
        this.vistaCliente = vistaCliente;

        this.vistaCliente.getInsertarButton().addActionListener(this);
        this.vistaCliente.getEliminarButton().addActionListener(this);
        this.vistaCliente.getConsultarButton().addActionListener(this);
        this.vistaCliente.getModificarButton().addActionListener(this);
    }

    public void actionPerformed(ActionEvent evento) {
        //Insertar Cliente
        if (vistaCliente.getInsertarButton() == evento.getSource()) {
            actualizarModelo();
            DAOCliente daoCliente = new DAOCliente();
            try {
                daoCliente.agregar(modeloCliente);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Eliminar Cliente
        if (vistaCliente.getEliminarButton() == evento.getSource()) {
            DAOCliente daoCliente = new DAOCliente();
            try {
                daoCliente.eliminar(" id_clientes = " + getClaveCliente());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Modificar Cliente
        if (vistaCliente.getModificarButton() == evento.getSource()) {
            actualizarModelo();
            DAOCliente daoCliente = new DAOCliente();
            try {
                daoCliente.modificar(modeloCliente, " id_clientes = " + getClaveCliente());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Consultar Cliente
        if (vistaCliente.getConsultarButton() == evento.getSource()) {
            DAOCliente daoCliente = new DAOCliente();
            ArrayList<Cliente> clientes = new ArrayList<>();
            try {
                clientes = daoCliente.consultar(" id_clientes = " + getClaveCliente());
            } catch (Exception e) {
                e.printStackTrace();
            }

            Cliente cliente = clientes.get(0);
            vistaCliente.getNombreField().setText(cliente.getNombre());
            vistaCliente.getjFormattedTextField1().setText(String.valueOf(cliente.getFechaIngreso()));
            vistaCliente.getjCheckBox1().setSelected(cliente.isActivo());
        }

    }

    private void actualizarModelo() {
        modeloCliente.setClaveCliente(getClaveCliente());
        modeloCliente.setNombre(getNombreCliente());
        modeloCliente.setFechaIngreso(new Date(01 - 10 - 2018));
        modeloCliente.setActivo(true);
    }

    private String getNombreCliente() {
        return vistaCliente.getNombreField().getText();
    }

    private int getClaveCliente() {
        return Integer.parseInt(vistaCliente.getClaveField().getText());
    }
}
