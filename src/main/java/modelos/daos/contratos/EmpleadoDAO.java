package modelos.daos.contratos;

import java.sql.SQLException;

public interface EmpleadoDAO {
    boolean postRegistrar(String nombre, String contrasena, String email) throws SQLException;

    public boolean updateActualizarDatosPersonales(String emailViejo, String nuevoNombre, String nuevoEmail, String nuevaContrasena) 
    throws SQLException;

    boolean getLogin(String email, String contrasena) throws SQLException;

    boolean deleteEliminarEmpleado(String email) throws SQLException;
}
