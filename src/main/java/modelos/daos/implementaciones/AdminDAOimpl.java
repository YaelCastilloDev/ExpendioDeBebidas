
package modelos.daos.implementaciones;

import modelos.conecciones.BaseDeDatosConeccion;
import modelos.utiles.seguridad.ContrasenaHasher;
import modelos.daos.contratos.AdminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOimpl implements AdminDAO {

    @Override
    public boolean postRegistrar(String nombre, String contrasena, String email) throws SQLException {
        String contrasenaHasheada = ContrasenaHasher.encodePassword(contrasena);
        String insertAdmin = "INSERT INTO Admin (nombre, contraseña, email) VALUES (?, ?, ?)";

        Connection conn = BaseDeDatosConeccion.obtenerConeccion();
        PreparedStatement stmt = conn.prepareStatement(insertAdmin);

        stmt.setString(1, nombre);
        stmt.setString(2, contrasenaHasheada);
        stmt.setString(3, email);

        int rows = stmt.executeUpdate();
        stmt.close();
        conn.close();

        if (rows > 0) {
            return true;
        }

        return false;
    }

    @Override
    public boolean updateActualizarDatosPersonales(String nombre, String contrasena, String emailViejo, String emailNuevo) throws SQLException {
        String contrasenaHasheada = ContrasenaHasher.encodePassword(contrasena);
        String updateAdmin = "UPDATE Admin SET nombre = ?, contraseña = ?, email = ? WHERE email = ?";

        Connection conn = BaseDeDatosConeccion.obtenerConeccion();
        PreparedStatement stmt = conn.prepareStatement(updateAdmin);

        try {
            stmt.setString(1, nombre);
            stmt.setString(2, contrasenaHasheada);
            stmt.setString(3, emailNuevo);
            stmt.setString(4, emailViejo);

            int rows = stmt.executeUpdate();

            return rows > 0;
        } finally {
            // Asegurarse de cerrar recursos en el bloque finally
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }

    @Override
    public boolean getLogin(String email, String contrasena) throws SQLException {
        String query = "SELECT contraseña FROM Admin WHERE email = ?";

        Connection conn = BaseDeDatosConeccion.obtenerConeccion();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, email);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String contrasenaEncriptada = rs.getString("contraseña");
            rs.close();
            stmt.close();
            conn.close();

            if (ContrasenaHasher.matches(contrasena, contrasenaEncriptada)) {
                return true;
            }
        } else {
            rs.close();
            stmt.close();
            conn.close();
        }

        System.out.println("Datos inválidos");
        return false;
    }


    public boolean existeEmail(String email) throws SQLException {
        String query = "SELECT 1 FROM Admin WHERE email = ?";

        try (Connection conn = BaseDeDatosConeccion.obtenerConeccion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Retorna true si encontró un registro con ese email
            }
        }
    }

    @Override
    public boolean deleteEliminarAdmin(String email) throws SQLException {
        String deleteQuery = "DELETE FROM Admin WHERE email = ?";

        try (Connection conn = BaseDeDatosConeccion.obtenerConeccion();
             PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {

            stmt.setString(1, email);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        }
    }
}