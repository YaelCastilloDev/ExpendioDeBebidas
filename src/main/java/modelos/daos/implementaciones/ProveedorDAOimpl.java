package modelos.daos.implementaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Proveedor;
import modelos.conexiones.BaseDeDatosConexion;
import modelos.conexiones.UsuarioFactory;
import modelos.daos.contratos.ProveedorDAO;

public class ProveedorDAOimpl implements ProveedorDAO {

    @Override
    public boolean postRegistrar(Proveedor proveedor) throws SQLException {
        String sql = "INSERT INTO proveedor (rfc, razon_social, telefono, email, codigo_postal, colonia, ciudad, estado) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, proveedor.getRfc());
            statement.setString(2, proveedor.getRazon_social());
            statement.setString(3, proveedor.getTelefono());
            statement.setString(4, proveedor.getEmail());
            statement.setInt(5, proveedor.getCodigo_postal());
            statement.setString(6, proveedor.getColonia());
            statement.setString(7, proveedor.getCiudad());
            statement.setString(8, proveedor.getEstado());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        }
    }

    @Override
    public boolean actualizarDatos(String rfcAntiguo, Proveedor proveedor) throws SQLException {
        String update = "UPDATE proveedor SET rfc = ?, razon_social = ?, telefono = ?, "
                      + "email = ?, codigo_postal = ?, colonia = ?, ciudad = ?, estado = ? "
                      + "WHERE rfc = ?";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(update)) {

            stmt.setString(1, proveedor.getRfc());
            stmt.setString(2, proveedor.getRazon_social());
            stmt.setString(3, proveedor.getTelefono());
            stmt.setString(4, proveedor.getEmail());
            stmt.setInt(5, proveedor.getCodigo_postal());
            stmt.setString(6, proveedor.getColonia());
            stmt.setString(7, proveedor.getCiudad());
            stmt.setString(8, proveedor.getEstado());
            stmt.setString(9, rfcAntiguo);

            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public boolean eliminarProveedor(String rfc) throws SQLException {
        String delete = "DELETE FROM proveedor WHERE rfc = ?";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(delete)) {

            stmt.setString(1, rfc);
            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public Proveedor obtenerProveedor(String rfc) throws SQLException {
        String query = "SELECT rfc, razon_social, telefono, email, codigo_postal, colonia, ciudad, estado "
                     + "FROM proveedor WHERE rfc = ?";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, rfc);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    Proveedor proveedor = new Proveedor();
                    proveedor.setRfc(resultSet.getString("rfc"));
                    proveedor.setRazon_social(resultSet.getString("razon_social"));
                    proveedor.setTelefono(resultSet.getString("telefono"));
                    proveedor.setEmail(resultSet.getString("email"));
                    proveedor.setCodigo_postal(resultSet.getInt("codigo_postal"));
                    proveedor.setColonia(resultSet.getString("colonia"));
                    proveedor.setCiudad(resultSet.getString("ciudad"));
                    proveedor.setEstado(resultSet.getString("estado"));
                    return proveedor;
                }
            }
        }

        return null;
    }

    @Override
    public List<Proveedor> obtenerProveedores() throws SQLException {
        String query = "SELECT rfc, razon_social, telefono, email, codigo_postal, colonia, ciudad, estado FROM proveedor;";
        List<Proveedor> proveedores = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setRfc(resultSet.getString("rfc"));
                proveedor.setRazon_social(resultSet.getString("razon_social"));
                proveedor.setTelefono(resultSet.getString("telefono"));
                proveedor.setEmail(resultSet.getString("email"));
                proveedor.setCodigo_postal(resultSet.getInt("codigo_postal"));
                proveedor.setColonia(resultSet.getString("colonia"));
                proveedor.setCiudad(resultSet.getString("ciudad"));
                proveedor.setEstado(resultSet.getString("estado"));
                proveedores.add(proveedor);
            }
        }

        return proveedores;
    }
    
    public boolean existeEnRelaciones(String rfc) throws SQLException {
        String query = "SELECT (EXISTS (SELECT 1 FROM pedido_proveedor "
                + "WHERE rfc = ?)) AS existe;";
        Connection connection = BaseDeDatosConexion.obtenerConeccion();
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, rfc);
        ResultSet rs = stmt.executeQuery();
        
        boolean existe = false;
        if (rs.next()) {
            existe = rs.getBoolean("existe");
        }
        connection.close();
        stmt.close();
        rs.close();
        
        return existe;
    }
}
