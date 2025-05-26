package modelos.daos.contratos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import modelos.Admin;

public interface AdminDAO {
    boolean postRegistrar(String nombre, String contrasena, String email, Connection conn) throws SQLException;
    
    boolean updateActualizarDatosPersonales(String nombre, String contrasena, String emailViejo, String emailNuevo, Connection conn) throws SQLException;
    
    boolean getLogin(String email, String contrasena, Connection conn) throws SQLException;

    boolean deleteEliminarAdmin(String email, Connection conn) throws SQLException;
    
    List<Admin> getAdministradores(Connection conn) throws SQLException;
}