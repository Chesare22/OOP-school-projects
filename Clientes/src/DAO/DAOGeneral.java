package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author lbojor
 */
public abstract class DAOGeneral<T> {
    private static final String DEFAULT_HOST = "localhost:3306";
    private static final String DEFAULT_DB = "ventas";
    private static final String DEFAULT_USER = "root";
    private static final String DEFAULT_PASSWORD = "root";

    private boolean isDriverLoaded;

    public DAOGeneral() {
        loadDriver();
    }

    public void loadDriver() {
        try {
            if (!isDriverLoaded) {
                Class.forName("com.mysql.jdbc.Driver");
                isDriverLoaded = true;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public Connection getConnection(String host, String bd, String login, String password) {
        String urlConnection = "jdbc:mysql://" + host + "/" + bd +
                "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(urlConnection, login, password);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection() {
        return getConnection(
                DEFAULT_HOST,
                DEFAULT_DB,
                DEFAULT_USER,
                DEFAULT_PASSWORD
        );
    }

    public void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    public abstract int agregar(T entidad) throws SQLException;

    public abstract int eliminar(String condición) throws SQLException;

    public abstract int modificar(T entidad, String condición) throws SQLException;

    public abstract ArrayList<T> consultar(String condición) throws SQLException;
}    

