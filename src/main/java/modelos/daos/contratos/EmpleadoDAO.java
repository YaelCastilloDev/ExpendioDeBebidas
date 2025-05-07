package modelos.daos.contratos;

import java.sql.SQLException;

public interface EmpleadoDAO {
    boolean postRegistrar(String nombre, String contrasena, String email) throws SQLException;

    boolean updateActualizarDatosPersonales(String email, String nuevoNombre, String nuevaContrasena) throws SQLException;
    boolean getLogin(String email, String contrasena) throws SQLException;

}
