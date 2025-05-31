package modelos.daos.implementaciones;

import modelos.utiles.seguridad.ContrasenaHasher;
import modelos.daos.contratos.AdminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Admin;
import modelos.conexiones.UsuarioFactory;

public class AdminDAOimpl implements AdminDAO {

    @Override
    public boolean postRegistrar(String nombre, String contrasena, String email) throws SQLException {
        String contrasenaHasheada = ContrasenaHasher.encodePassword(contrasena);
        String insertAdmin = "INSERT INTO Admin (nombre, contraseña, email) VALUES (?, ?, ?)";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(insertAdmin)) {

            stmt.setString(1, nombre);
            stmt.setString(2, contrasenaHasheada);
            stmt.setString(3, email);
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean updateActualizarDatosPersonales(String nombre, String contrasena, String emailViejo, String emailNuevo) throws SQLException {
        String contrasenaHasheada = ContrasenaHasher.encodePassword(contrasena);
        String updateAdmin = "UPDATE Admin SET nombre = ?, contraseña = ?, email = ? WHERE email = ?";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(updateAdmin)) {

            stmt.setString(1, nombre);
            stmt.setString(2, contrasenaHasheada);
            stmt.setString(3, emailNuevo);
            stmt.setString(4, emailViejo);
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean getLogin(String email, String contrasena) throws SQLException {
        String query = "SELECT contraseña FROM Admin WHERE email = ?";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(query)) {

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

    @Override
    public boolean existeEmail(String email) throws SQLException {
        String query = "SELECT 1 FROM Admin WHERE email = ?";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    @Override
    public boolean deleteEliminarAdmin(String email) throws SQLException {
        String deleteQuery = "DELETE FROM Admin WHERE email = ?";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {

            stmt.setString(1, email);
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public List<Admin> getAdministradores() throws SQLException {
        List<Admin> admins = new ArrayList<>();
        String query = "SELECT nombre, email FROM Admin";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Admin admin = new Admin();
                admin.setNombre(rs.getString("nombre"));
                admin.setEmail(rs.getString("email"));
                admin.setContraseña("");
                admins.add(admin);
            }
        }
        return admins;
    }
}
