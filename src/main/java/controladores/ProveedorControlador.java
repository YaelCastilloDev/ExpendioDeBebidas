package controladores;

import modelos.daos.implementaciones.ProveedorDAOimpl;
import modelos.utiles.validaciones.ProveedorValidacion;
import java.sql.SQLException;
import jakarta.validation.ConstraintViolationException;
import java.util.List;
import modelos.Proveedor;

public class ProveedorControlador {
    private final ProveedorDAOimpl proveedorDAO = new ProveedorDAOimpl();
    private final ProveedorValidacion validacion = new ProveedorValidacion();

    public void registrarProveedor(
            String rfc,
            String razonSocial,
            String telefono,
            String email,
            Integer codigoPostal,
            String colonia,
            String ciudad,
            String estado) throws ConstraintViolationException, IllegalArgumentException, SQLException {
        
        // Validar todos los campos
        validacion.validarCompleto(rfc, razonSocial, telefono, email, codigoPostal, colonia, ciudad, estado);

        // Verificar si el proveedor ya existe
        if (existeProveedorPorRfc(rfc)) {
            throw new IllegalArgumentException("Ya existe un proveedor con el RFC: " + rfc);
        }

        // Crear objeto Proveedor con los datos validados
        Proveedor proveedor = validacion.getProveedorValidado();

        // Registrar en la base de datos
        if (!proveedorDAO.postRegistrar(proveedor)) {
            throw new SQLException("No se pudo registrar el proveedor");
        }
    }

    public void actualizarProveedor(
            String rfcAntiguo,
            String nuevoRfc,
            String nuevaRazonSocial,
            String nuevoTelefono,
            String nuevoEmail,
            Integer nuevoCodigoPostal,
            String nuevaColonia,
            String nuevaCiudad,
            String nuevoEstado) throws ConstraintViolationException, IllegalArgumentException, SQLException {
        
        // Validar que los nuevos datos sean válidos
        validacion.validarCompleto(nuevoRfc, nuevaRazonSocial, nuevoTelefono, nuevoEmail, 
                                  nuevoCodigoPostal, nuevaColonia, nuevaCiudad, nuevoEstado);

        // Crear objeto Proveedor con los datos validados
        Proveedor proveedorActualizado = validacion.getProveedorValidado();

        // Verificar que el proveedor exista antes de actualizar
        if (!existeProveedorPorRfc(rfcAntiguo)) {
            throw new IllegalArgumentException("No existe un proveedor con el RFC: " + rfcAntiguo);
        }

        // Actualizar en la base de datos
        if (!proveedorDAO.actualizarDatos(rfcAntiguo, proveedorActualizado)) {
            throw new SQLException("No se pudo actualizar los datos del proveedor");
        }
    }

    public Proveedor obtenerProveedor(String rfc) 
            throws ConstraintViolationException, IllegalArgumentException, SQLException {
        
        // Validar formato básico del RFC (tamaño mínimo)
        if (rfc == null || rfc.length() < 12 || rfc.length() > 13) {
            throw new ConstraintViolationException("RFC debe tener entre 12 y 13 caracteres", null);
        }

        Proveedor proveedor = proveedorDAO.obtenerProveedor(rfc);
        
        if (proveedor == null || proveedor.getRfc() == null) {
            throw new IllegalArgumentException("No existe un proveedor con el RFC: " + rfc);
        }
        
        return proveedor;
    }

    private boolean existeProveedorPorRfc(String rfc) throws SQLException {
        try {
            // Validación básica del RFC
            if (rfc == null || rfc.length() < 12 || rfc.length() > 13) {
                return false;
            }
            
            Proveedor proveedor = proveedorDAO.obtenerProveedor(rfc);
            return proveedor != null && proveedor.getRfc() != null;
        } catch (SQLException e) {
            throw e;
        }
    }

    public void eliminarProveedor(String rfc)
            throws ConstraintViolationException, IllegalArgumentException, SQLException {
        
        // Validación básica del RFC
        if (rfc == null || rfc.length() < 12 || rfc.length() > 13) {
            throw new ConstraintViolationException("RFC debe tener entre 12 y 13 caracteres", null);
        }

        // Verificar que el proveedor exista antes de intentar eliminarlo
        if (!existeProveedorPorRfc(rfc)) {
            throw new IllegalArgumentException("No existe un proveedor con el RFC: " + rfc);
        }

        // Ejecutar eliminación
        if (!proveedorDAO.eliminarProveedor(rfc)) {
            throw new SQLException("No se pudo eliminar el proveedor. Verifique el RFC proporcionado");
        }
    }

    public List<Proveedor> obtenerProveedores() throws SQLException {
        return proveedorDAO.obtenerProveedores();
    }
}
