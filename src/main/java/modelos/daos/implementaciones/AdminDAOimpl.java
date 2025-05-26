
package modelos.daos.implementaciones;

import modelos.conexiones.BaseDeDatosConexion;
import modelos.utiles.seguridad.ContrasenaHasher;
import modelos.daos.contratos.AdminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Admin;

public class AdminDAOimpl implements AdminDAO {

    @Override
    public boolean postRegistrar(String nombre, String contrasena, String email, Connection conn) throws SQLException {
        String contrasenaHasheada = ContrasenaHasher.encodePassword(contrasena);
        String insertAdmin = "INSERT INTO Admin (nombre, contraseña, email) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(insertAdmin)) {
            stmt.setString(1, nombre);
            stmt.setString(2, contrasenaHasheada);
            stmt.setString(3, email);

            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public boolean updateActualizarDatosPersonales(String nombre, String contrasena, String emailViejo, String emailNuevo, Connection conn) throws SQLException {
        String contrasenaHasheada = ContrasenaHasher.encodePassword(contrasena);
        String updateAdmin = "UPDATE Admin SET nombre = ?, contraseña = ?, email = ? WHERE email = ?";

        try (PreparedStatement stmt = conn.prepareStatement(updateAdmin)) {
            stmt.setString(1, nombre);
            stmt.setString(2, contrasenaHasheada);
            stmt.setString(3, emailNuevo);
            stmt.setString(4, emailViejo);

            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean getLogin(String email, String contrasena, Connection conn) throws SQLException {
        String query = "SELECT contraseña FROM Admin WHERE email = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String contrasenaEncriptada = rs.getString("contraseña");
                    return ContrasenaHasher.matches(contrasena, contrasenaEncriptada);
                }
                return false;
            }
        }
    }

    public boolean existeEmail(String email, Connection conn) throws SQLException {
        String query = "SELECT 1 FROM Admin WHERE email = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    @Override
    public boolean deleteEliminarAdmin(String email, Connection conn) throws SQLException {
        String deleteQuery = "DELETE FROM Admin WHERE email = ?";

        try (PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
            stmt.setString(1, email);
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public List<Admin> getAdministradores(Connection conn) throws SQLException {
        List<Admin> admins = new ArrayList<>();
        String query = "SELECT nombre, email FROM admin";

        try (PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Admin admin = new Admin();
                admin.setNombre(resultSet.getString("nombre"));
                admin.setEmail(resultSet.getString("email"));
                admin.setContraseña("");
                admins.add(admin);
            }
        }
        return admins;
    }
}