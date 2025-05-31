package modelos.daos.contratos;

import java.sql.SQLException;
import java.util.List;
import modelos.Cliente;

public interface ClienteDAO {
    boolean registrarCliente(Cliente cliente) throws SQLException;
    
    boolean actualizarCliente(Cliente cliente, String email) throws SQLException;
    
    boolean eliminarCliente(int id) throws SQLException;
    
    Cliente obtenerCliente(String rfc) throws SQLException;
    
    List<Cliente> obtenerClientes() throws SQLException;
}
