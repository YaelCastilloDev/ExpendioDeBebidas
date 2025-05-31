/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author yael
 */
public class AdminConexion {
        private static Connection connection;

    public static void inicializarConnecion() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String user = "expendioAdmin";
            String password = "123456";
            String url = "jdbc:mysql://localhost:3306/expendio_bebidas";

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection established.");
        }
    }

public static Connection obtenerConeccion() throws SQLException {
    if (connection == null || connection.isClosed()) {
        inicializarConnecion();
    }
    return connection;
}

    public static void CerrarConneciones() throws SQLException {
        if (connection != null) {
                connection.close();
                System.out.println("Database connection closed.");

        }
    }

    public static void tryConneccion() throws SQLException {
            BaseDeDatosConexion.inicializarConnecion();
    }
}
