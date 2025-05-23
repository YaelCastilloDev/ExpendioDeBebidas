package modelos.daos.implementaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Proveedor;
import modelos.conexiones.BaseDeDatosConexion;
import modelos.daos.contratos.ProveedorDAO;

public class ProveedorDAOimpl implements ProveedorDAO {

    @Override
    public boolean postRegistrar(Proveedor proveedor) throws SQLException {
        String sql = "INSERT INTO proveedor (rfc, razon_social, telefono, email, codigo_postal, colonia, ciudad, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        Connection conn = BaseDeDatosConexion.obtenerConeccion();
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, proveedor.getRfc());
        statement.setString(2, proveedor.getRazon_social());
        statement.setString(3, proveedor.getTelefono());
        statement.setString(4, proveedor.getEmail());
        statement.setInt(5, proveedor.getCodigo_postal());
        statement.setString(6, proveedor.getColonia());
        statement.setString(7, proveedor.getCiudad());
        statement.setString(8, proveedor.getEstado());
        
        int filasAfectadas = statement.executeUpdate();
        
        statement.close();
        conn.close();
        return filasAfectadas > 0;
    }

    @Override
    public boolean actualizarDatos(String rfcAntiguo, Proveedor proveedor) throws SQLException {
        String update = "UPDATE proveedor SET rfc = ?, razon_social = ?, telefono = ?, "
                + "email = ?, codigo_postal = ?, colonia = ?, ciudad = ?, estado = ? "
                + "WHERE rfc = ?";
        Connection conn = BaseDeDatosConexion.obtenerConeccion();
        PreparedStatement stmt = conn.prepareStatement(update);
        
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
        conn.close();
        stmt.close();
        
        if (rows > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarProveedor(String rfc) throws SQLException {
        String delete = "DELETE FROM proveedor WHERE rfc = ?";
        Connection conn = BaseDeDatosConexion.obtenerConeccion();
        PreparedStatement stmt = conn.prepareStatement(delete);
        
        stmt.setString(1, rfc);
        int rows = stmt.executeUpdate();
        
        stmt.close();
        conn.close();
        
        return rows > 0;
    }

    @Override
    public Proveedor obtenerProveedor(String rfc) throws SQLException {
        String query = "SELECT rfc, razon_social, telefono, email, codigo_postal, colonia, ciudad, estado "
                + "FROM proveedor WHERE rfc = ?";
        Connection conn = BaseDeDatosConexion.obtenerConeccion();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, rfc);
        ResultSet resultSet = stmt.executeQuery();
        
        Proveedor proveedor = new Proveedor();
        if (resultSet.next()) {
            proveedor.setRfc(resultSet.getString("rfc"));
            proveedor.setRazon_social(resultSet.getString("razon_social"));
            proveedor.setTelefono(resultSet.getString("telefono"));
            proveedor.setEmail(resultSet.getString("email"));
            proveedor.setCodigo_postal(resultSet.getInt("codigo_postal"));
            proveedor.setColonia(resultSet.getString("colonia"));
            proveedor.setCiudad(resultSet.getString("ciudad"));
            proveedor.setEstado(resultSet.getString("estado"));
        }
        conn.close();
        stmt.close();
        resultSet.close();
        
        return proveedor;
    }

    @Override
    public List<Proveedor> obtenerProveedores() throws SQLException {
        String query = "SELECT rfc, razon_social, telefono, email, codigo_postal, colonia, ciudad, estado "
                + "FROM proveedor;";
        Connection conn = BaseDeDatosConexion.obtenerConeccion();
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet resultSet = stmt.executeQuery();
        
        List<Proveedor> proveedores = new ArrayList<>();
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
        conn.close();
        stmt.close();
        resultSet.close();
        
        return proveedores;
    }
}
