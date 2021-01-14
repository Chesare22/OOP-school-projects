package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Cliente;

/**
 * @author lbojor
 */
public class DAOCliente extends DAOGeneral<Cliente> {
    public DAOCliente() {
    }

    public int agregar(Cliente cliente) throws SQLException {
        Connection connection = getConnection();
        Statement sentencia = connection.createStatement();

        String sqlQuery = "INSERT INTO clientes (id_clientes, nombre, fechaIngreso, activo)" +
                "VALUES (" + cliente.getClaveCliente() + ",'" + cliente.getNombre() + "','" +
                cliente.getFechaIngreso().toString() + "'," + cliente.isActivo() + ")";
        int numFilas = sentencia.executeUpdate(sqlQuery);

        sentencia.close();
        closeConnection(connection);
        return numFilas;
    }

    public int eliminar(String condición) throws SQLException {
        Connection connection = getConnection();
        Statement sentencia = connection.createStatement();

        String sqlQuery = "DELETE FROM clientes WHERE " + condición;
        int numFilas = sentencia.executeUpdate(sqlQuery);

        sentencia.close();
        closeConnection(connection);
        return numFilas;
    }

    public int modificar(Cliente cliente, String condición) throws SQLException {
        Connection connection = getConnection();
        Statement sentencia = connection.createStatement();

        String sqlQuery = "UPDATE clientes SET " +
                " nombre='" + cliente.getNombre() + "'," +
                "fechaIngreso " + cliente.getFechaIngreso().toString() + "'," +
                " activo = " + cliente.isActivo() +
                " WHERE " + condición;
        int numFilas = sentencia.executeUpdate(sqlQuery);

        sentencia.close();
        closeConnection(connection);
        return numFilas;
    }

    public ArrayList<Cliente> consultar(String condición) throws SQLException {
        Connection connection = getConnection();
        Statement sentencia = connection.createStatement();

        ArrayList<Cliente> clientes = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Clientes " +
                (isEmpty(condición) ? "" : "WHERE " + condición);
        ResultSet rs = sentencia.executeQuery(sqlQuery);
        while (rs.next()) {
            clientes.add(new Cliente(
                    rs.getInt("id_clientes"),
                    rs.getString("nombre"),
                    rs.getDate("fechaIngreso"),
                    rs.getBoolean("activo")
            ));
        }

        sentencia.close();
        closeConnection(connection);
        return clientes;
    }

    private static boolean isEmpty(String str) {
        return  str == null || str.isEmpty();
    }
}
