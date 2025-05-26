package modelos.conexiones;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author yael
 */
public class UsuarioFactory {

    public enum TipoUsuario {
        ADMIN,
        EMPLEADO
    }

    public static Connection obtenerConexion(TipoUsuario tipo) throws SQLException {
        switch(tipo) {
            case ADMIN:
                return AdminConexion.obtenerConeccion();
            case EMPLEADO:
                return EmpleadoConexion.obtenerConeccion();
            default:
                throw new IllegalArgumentException("Tipo de usuario no soportado");
        }
    }

    public static void inicializarConexion(TipoUsuario tipo) throws SQLException {
        switch(tipo) {
            case ADMIN:
                AdminConexion.inicializarConnecion();
                break;
            case EMPLEADO:
                EmpleadoConexion.inicializarConnecion();
                break;
            default:
                throw new IllegalArgumentException("Tipo de usuario no soportado");
        }
    }

    public static void cerrarConexion(TipoUsuario tipo) throws SQLException {
        switch(tipo) {
            case ADMIN:
                AdminConexion.CerrarConneciones();
                break;
            case EMPLEADO:
                EmpleadoConexion.CerrarConneciones();
                break;
            default:
                throw new IllegalArgumentException("Tipo de usuario no soportado");
        }
    }

    public static void probarConexion(TipoUsuario tipo) throws SQLException {
        switch(tipo) {
            case ADMIN:
                AdminConexion.tryConneccion();
                break;
            case EMPLEADO:
                EmpleadoConexion.tryConneccion();
                break;
            default:
                throw new IllegalArgumentException("Tipo de usuario no soportado");
        }
    }
}