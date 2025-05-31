package controladores;

import jakarta.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.List;
import modelos.Cliente;
import modelos.daos.implementaciones.ClienteDAOimpl;
import modelos.utiles.validaciones.ClienteValidacion;

public class ClienteControlador {
    private final ClienteDAOimpl clienteDAO = new ClienteDAOimpl();
    private final ClienteValidacion validador = new ClienteValidacion();
    
    public void registrarCliente(
            String nombre,
            String paterno,
            String materno,
            String email,
            String telefono,
            String rfc,
            Integer codigo_postal,
            String colonia,
            String ciudad,
            String estado) throws SQLException, ConstraintViolationException, IllegalArgumentException {
        validador.validarCompleto(nombre, paterno, materno, email, telefono, rfc, codigo_postal, colonia, ciudad, estado);
        
        if (existeClientePorEmail(email)) {
            throw new IllegalArgumentException("Ya existe un cliente con el email: " + email);
        }
        Cliente clienteValidado = validador.getClienteValidado();
        
        if (!clienteDAO.registrarCliente(clienteValidado)) {
            throw new SQLException("No se pudo registrar el cliente");
        }
    }
    
    public void actualizarCliente(
            String nombre,
            String paterno,
            String materno,
            String email,
            String emailAntiguo,
            String telefono,
            String rfc,
            Integer codigo_postal,
            String colonia,
            String ciudad,
            String estado) throws ConstraintViolationException, IllegalArgumentException, IllegalStateException, SQLException {
        
        validador.validarCompleto(nombre, paterno, materno, email, telefono, rfc, codigo_postal, colonia, ciudad, estado);
        Cliente clienteValidado = validador.getClienteValidado();
        
        if (!existeClientePorEmail(emailAntiguo)) {
            throw new IllegalArgumentException("No existe un cliente con el email: " + emailAntiguo);
        }
        
        if (!clienteDAO.actualizarCliente(clienteValidado, clienteValidado.getEmail())) {
            throw new SQLException("No se pudo actualizar los datos del cliente.");
        }
    }
    
    public void eliminarCliente(Cliente cliente) throws ConstraintViolationException, IllegalArgumentException, IllegalStateException, SQLException {
        if (!existeClientePorEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("No existe un cliente con el email: " + cliente.getEmail());
        }
        
        if (clienteDAO.existeEnRelaciones(cliente.getId())) {
            throw new IllegalStateException("No se puede eliminar el cliente porque está asociada a registros");
        }
        
        if (!clienteDAO.eliminarCliente(cliente.getId())) {
            throw new SQLException("No se pudo eliminar el cliente.");
        }
    }
    
    private boolean existeClientePorEmail(String email) throws SQLException {
        if (email == null || email.length() < 15 || email.length() > 30) {
            return false;
        }
        Cliente cliente = clienteDAO.obtenerCliente(email);
        return cliente != null && cliente.getEmail() != null;
    }
    
    public List<Cliente> obtenerClientes() throws SQLException {
        return clienteDAO.obtenerClientes();
    }
    
    public Cliente obtenerCliente(String email) throws ConstraintViolationException,
            IllegalArgumentException, SQLException {
        if (email == null || email.length() < 15 || email.length() > 30) {
            throw new ConstraintViolationException("El email debe tener máximo 30 caracteres.", null);
        }
        Cliente cliente = clienteDAO.obtenerCliente(email);
        
        if (cliente == null || cliente.getEmail() == null) {
            throw new IllegalArgumentException("No existe un cliente con el email: " + email);
        }
        return cliente;
    }
}
