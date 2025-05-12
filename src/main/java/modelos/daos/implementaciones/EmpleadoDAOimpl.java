package modelos.daos.implementaciones;

import modelos.daos.contratos.EmpleadoDAO;
import modelos.conexiones.BaseDeDatosConexion;
import modelos.utiles.seguridad.ContrasenaHasher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAOimpl implements EmpleadoDAO {

    @Override
    public boolean postRegistrar(String nombre, String contrasena, String email) {
        String contrasenaHasheada = ContrasenaHasher.encodePassword(contrasena);
        String insertEmpleado = "INSERT INTO Empleado (nombre, contraseña, email) VALUES (?, ?, ?)";

        try (Connection conn = BaseDeDatosConexion.obtenerConeccion();
             PreparedStatement stmt = conn.prepareStatement(insertEmpleado)) {

            stmt.setString(1, nombre);
            stmt.setString(2, contrasenaHasheada);
            stmt.setString(3, email);
            stmt.executeUpdate();

            System.out.println("Empleado registrado exitosamente.");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

 @Override
public boolean updateActualizarDatosPersonales(String emailViejo, String nuevoNombre, String nuevoEmail, String nuevaContrasena) 
    throws SQLException {
    
    String contrasenaHasheada = ContrasenaHasher.encodePassword(nuevaContrasena);
    String update = "UPDATE Empleado SET nombre = ?, email = ?, contraseña = ? WHERE email = ?";

    try (Connection conn = BaseDeDatosConexion.obtenerConeccion();
         PreparedStatement stmt = conn.prepareStatement(update)) {

        stmt.setString(1, nuevoNombre);
        stmt.setString(2, nuevoEmail);
        stmt.setString(3, contrasenaHasheada);
        stmt.setString(4, emailViejo);
        
        int rows = stmt.executeUpdate();

        if (rows > 0) {
            System.out.println("Datos del empleado actualizados exitosamente.");
            return true;
        }
        
        System.out.println("No se encontró un empleado con el email: " + emailViejo);
        return false;
    }
}

    @Override
    public boolean getLogin(String email, String contrasena) {
        String query = "SELECT contraseña FROM Empleado WHERE email = ?";

        try (Connection conn = BaseDeDatosConexion.obtenerConeccion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String contrasenaAlmacenada = rs.getString("contraseña");
                boolean coincide = ContrasenaHasher.matches(contrasena, contrasenaAlmacenada);
                if (coincide) {
                    System.out.println("Login exitoso.");
                    return true;
                } else {
                    System.out.println("Contraseña incorrecta.");
                }
            } else {
                System.out.println("Empleado no encontrado con ese email.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public boolean existeEmail(String email) throws SQLException {
    String query = "SELECT 1 FROM Empleado WHERE email = ?";

    try (Connection conn = BaseDeDatosConexion.obtenerConeccion();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, email);

        try (ResultSet rs = stmt.executeQuery()) {
            return rs.next(); // Retorna true si encontró un registro con ese email
        }
    }
}

    @Override
    public boolean deleteEliminarEmpleado(String email) throws SQLException {
        String deleteQuery = "DELETE FROM Empleado WHERE email = ?";

        try (Connection conn = BaseDeDatosConexion.obtenerConeccion();
             PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {

            stmt.setString(1, email);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        }
    }
}
