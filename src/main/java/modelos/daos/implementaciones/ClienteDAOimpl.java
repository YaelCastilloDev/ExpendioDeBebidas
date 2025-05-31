package modelos.daos.implementaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Cliente;
import modelos.conexiones.BaseDeDatosConexion;
import modelos.daos.contratos.ClienteDAO;

public class ClienteDAOimpl implements ClienteDAO {

    @Override
    public boolean registrarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nombre, paterno, materno, email, "
                + "telefono, rfc, codigo_postal, colonia, ciudad, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = BaseDeDatosConexion.obtenerConeccion();
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, cliente.getNombre());
        statement.setString(2, cliente.getPaterno());
        statement.setString(3, cliente.getMaterno());
        statement.setString(4, cliente.getEmail());
        statement.setString(5, cliente.getTelefono());
        statement.setString(6, cliente.getRfc());
        statement.setInt(7, cliente.getCodigo_postal());
        statement.setString(8, cliente.getColonia());
        statement.setString(9, cliente.getCiudad());
        statement.setString(10, cliente.getEstado());
        
        int filasAfectadas = statement.executeUpdate();
        
        statement.close();
        conn.close();
        return filasAfectadas > 0;
    }

    @Override
    public boolean actualizarCliente(Cliente cliente, String email) throws SQLException {
        String update = "UPDATE cliente SET nombre = ?, paterno = ?, materno = ?, email = ?, "
                + "telefono = ?, rfc = ?, codigo_postal = ?, colonia = ?, ciudad = ?, estado = ? "
                + "WHERE email = ?;";
        Connection conn = BaseDeDatosConexion.obtenerConeccion();
        PreparedStatement statement = conn.prepareStatement(update);
        
        statement.setString(1, cliente.getNombre());
        statement.setString(2, cliente.getPaterno());
        statement.setString(3, cliente.getMaterno());
        statement.setString(4, cliente.getEmail());
        statement.setString(5, cliente.getTelefono());
        statement.setString(6, cliente.getRfc());
        statement.setInt(7, cliente.getCodigo_postal());
        statement.setString(8, cliente.getColonia());
        statement.setString(9, cliente.getCiudad());
        statement.setString(10, cliente.getEstado());
        statement.setString(11, email);
        
        int filasAfectadas = statement.executeUpdate();
        conn.close();
        statement.close();
        return filasAfectadas > 0;
    }

    @Override
    public boolean eliminarCliente(int id) throws SQLException {
        String delete = "DELETE FROM cliente WHERE id_cliente = ?";
        Connection conn = BaseDeDatosConexion.obtenerConeccion();
        PreparedStatement statement = conn.prepareStatement(delete);
        
        statement.setInt(1, id);
        int filasAfectadas = statement.executeUpdate();
        
        statement.close();
        conn.close();
        
        return filasAfectadas > 0;
    }
    
    
    @Override
    public Cliente obtenerCliente(String email) throws SQLException {
        String query = "SELECT id_cliente, nombre, paterno, materno, email, "
                + "telefono, rfc, codigo_postal, colonia, ciudad, estado "
                + "FROM cliente WHERE email = ?";
        Connection conn = BaseDeDatosConexion.obtenerConeccion();
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();
        
        Cliente cliente = new Cliente();
        if (resultSet.next()) {
            cliente.setId(resultSet.getInt("id_cliente"));
            cliente.setNombre(resultSet.getString("nombre"));
            cliente.setPaterno(resultSet.getString("paterno"));
            cliente.setMaterno(resultSet.getString("materno"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setTelefono(resultSet.getString("telefono"));
            cliente.setRfc(resultSet.getString("rfc"));
            cliente.setCodigo_postal(resultSet.getInt("codigo_postal"));
            cliente.setColonia(resultSet.getString("colonia"));
            cliente.setCiudad(resultSet.getString("ciudad"));
            cliente.setEstado(resultSet.getString("estado"));
        }
        conn.close();
        statement.close();
        resultSet.close();
        
        return cliente;
    }

    @Override
    public List<Cliente> obtenerClientes() throws SQLException {
        String query = "SELECT id_cliente, nombre, paterno, materno, email, "
                + "telefono, rfc, codigo_postal, colonia, ciudad, estado "
                + "FROM cliente";
        Connection conn = BaseDeDatosConexion.obtenerConeccion();
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        
        List<Cliente> clientes = new ArrayList<>();
        while (resultSet.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(resultSet.getInt("id_cliente"));
            cliente.setNombre(resultSet.getString("nombre"));
            cliente.setPaterno(resultSet.getString("paterno"));
            cliente.setMaterno(resultSet.getString("materno"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setTelefono(resultSet.getString("telefono"));
            cliente.setRfc(resultSet.getString("rfc"));
            cliente.setCodigo_postal(resultSet.getInt("codigo_postal"));
            cliente.setColonia(resultSet.getString("colonia"));
            cliente.setCiudad(resultSet.getString("ciudad"));
            cliente.setEstado(resultSet.getString("estado"));
            clientes.add(cliente);
        }
        conn.close();
        statement.close();
        resultSet.close();
        
        return clientes;
    }

    public boolean existeEnRelaciones(int idCliente) throws SQLException {
        String sql = "SELECT (EXISTS (SELECT 1 FROM Pedido_Cliente WHERE id_cliente = ?) "
                + "OR EXISTS (SELECT 1 FROM Promocion_Cliente WHERE id_cliente = ?)) AS existe";
        
        Connection connection = BaseDeDatosConexion.obtenerConeccion();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, idCliente);
        stmt.setInt(2, idCliente);
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
