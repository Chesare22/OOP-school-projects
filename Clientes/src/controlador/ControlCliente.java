package controlador;

import DAO.DAOCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import modelo.Cliente;
import vista.VistaCliente;
import static util.RunnableWithException.defaultTryCatch;

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

            defaultTryCatch(() -> {
                daoCliente.agregar(modeloCliente);
            });
        }

        //Eliminar Cliente
        if (vistaCliente.getEliminarButton() == evento.getSource()) {
            DAOCliente daoCliente = new DAOCliente();

            defaultTryCatch(() -> {
                daoCliente.eliminar(" id_clientes = " + getClaveCliente());
            });
        }

        //Modificar Cliente
        if (vistaCliente.getModificarButton() == evento.getSource()) {
            actualizarModelo();
            DAOCliente daoCliente = new DAOCliente();

            defaultTryCatch(() -> {
                daoCliente.modificar(modeloCliente, " id_clientes = " + getClaveCliente());
            });
        }

        //Consultar Cliente
        if (vistaCliente.getConsultarButton() == evento.getSource()) {
            DAOCliente daoCliente = new DAOCliente();
            AtomicReference<ArrayList<Cliente>> clientes = new AtomicReference<>(new ArrayList<>());

            defaultTryCatch(()-> {
                clientes.set(daoCliente.consultar(" id_clientes = " + getClaveCliente()));
            });

            Cliente cliente = clientes.get().get(0);
            vistaCliente.getNombreField().setText(cliente.getNombre());
            vistaCliente.getFechaTextField().setText(String.valueOf(cliente.getFechaIngreso()));
            vistaCliente.isActiveCheckbox().setSelected(cliente.isActivo());
        }

    }

    private void actualizarModelo() {
        modeloCliente.setClaveCliente(getClaveCliente());
        modeloCliente.setNombre(getNombreCliente());
        modeloCliente.setFechaIngreso(new Date(1 - 10 - 2018));
        modeloCliente.setActivo(true);
    }

    private String getNombreCliente() {
        return vistaCliente.getNombreField().getText();
    }

    private int getClaveCliente() {
        return Integer.parseInt(vistaCliente.getClaveField().getText());
    }
}
