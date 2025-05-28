package modelos.daos.implementaciones;

import modelos.Empleado;
import modelos.conexiones.UsuarioFactory;
import modelos.daos.contratos.EmpleadoDAO;
import modelos.utiles.seguridad.ContrasenaHasher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOimpl implements EmpleadoDAO {

    @Override
    public boolean postRegistrar(String nombre, String contrasena, String email) throws SQLException {
        String contrasenaHasheada = ContrasenaHasher.encodePassword(contrasena);
        String sql = "INSERT INTO Empleado (nombre, contraseña, email) VALUES (?, ?, ?)";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nombre);
            stmt.setString(2, contrasenaHasheada);
            stmt.setString(3, email);

            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean updateActualizarDatosPersonales(String emailViejo, String nuevoNombre, 
                                                  String nuevoEmail, String nuevaContrasena) throws SQLException {
        String contrasenaHasheada = ContrasenaHasher.encodePassword(nuevaContrasena);
        String sql = "UPDATE Empleado SET nombre = ?, email = ?, contraseña = ? WHERE email = ?";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nuevoNombre);
            stmt.setString(2, nuevoEmail);
            stmt.setString(3, contrasenaHasheada);
            stmt.setString(4, emailViejo);

            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean getLogin(String email, String contrasena) throws SQLException {
        String sql = "SELECT contraseña FROM Empleado WHERE email = ?";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.EMPLEADO);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String contrasenaAlmacenada = rs.getString("contraseña");
                    return ContrasenaHasher.matches(contrasena, contrasenaAlmacenada);
                }
                return false;
            }
        }
    }

    public boolean existeEmail(String email) throws SQLException {
        String sql = "SELECT 1 FROM Empleado WHERE email = ? LIMIT 1";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    @Override
    public boolean deleteEliminarEmpleado(String email) throws SQLException {
        String sql = "DELETE FROM Empleado WHERE email = ?";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);
            return stmt.executeUpdate() > 0;
        }
    }

     
    public List<Empleado> obtenerEmpleados() throws SQLException {
        String sql = "SELECT nombre, email FROM Empleado";
        List<Empleado> empleados = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setNombre(rs.getString("nombre"));
                empleado.setEmail(rs.getString("email"));
                empleado.setContraseña(""); // No devolvemos la contraseña por seguridad
                empleados.add(empleado);
            }
        }
        return empleados;
    }
}