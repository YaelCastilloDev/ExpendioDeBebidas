package controladores;

import modelos.daos.implementaciones.EmpleadoDAOimpl;
import modelos.utiles.validaciones.EmpleadoValidacion;
import java.sql.SQLException;
import jakarta.validation.ConstraintViolationException;
import java.util.List;
import modelos.Empleado;

public class EmpleadoControlador {
    private final EmpleadoDAOimpl empleadoDAO = new EmpleadoDAOimpl();
    private final EmpleadoValidacion validacion = new EmpleadoValidacion();

    public void registrarEmpleado(String nombre, String email, String contrasena)
            throws ConstraintViolationException, IllegalArgumentException, SQLException {
        // Validar todos los campos (nombre, contraseña y email)
        validacion.validarCompleto(nombre, email, contrasena);

        if (existeEmpleadoPorEmail(email)) {
            throw new IllegalArgumentException("Ya existe un empleado con el email: " + email);
        }

        if (!empleadoDAO.postRegistrar(nombre, contrasena, email)) {
            throw new SQLException("No se pudo registrar el empleado");
        }
    }

    public void actualizarEmpleado(String emailViejo, String nuevoNombre, String nuevoEmail, String nuevaContrasena)
            throws ConstraintViolationException, IllegalArgumentException, SQLException {

        validacion.validarCompleto(nuevoNombre, nuevoEmail, nuevaContrasena);

        if (!empleadoDAO.updateActualizarDatosPersonales(emailViejo, nuevoNombre, nuevoEmail, nuevaContrasena)) {
            throw new SQLException("No se pudo actualizar los datos del empleado");
        }
    }

    public void autenticarEmpleado( String email, String contrasena)
            throws ConstraintViolationException, IllegalArgumentException, SQLException {
        validacion.validarParaLogin(email, contrasena);

        if (!empleadoDAO.getLogin(email, contrasena)) {
            throw new IllegalArgumentException("Credenciales inválidas");
        }
    }

    private boolean existeEmpleadoPorEmail(String email) throws SQLException {
        try {
            validacion.validarParaLogin(email, "passwordprueba");
            return empleadoDAO.existeEmail(email);
        } catch (ConstraintViolationException e) {
            return false;
        }
    }

    public void eliminarEmpleado(String email)
            throws ConstraintViolationException, IllegalArgumentException, SQLException {
        validacion.validarParaLogin(email, "contrasena12");

        // Verifica que el empleado exista antes de intentar eliminarlo
        if (!existeEmpleadoPorEmail(email)) {
            throw new IllegalArgumentException("No existe un empleado con el email: " + email);
        }

        // Ejecuta la eliminación
        if (!empleadoDAO.deleteEliminarEmpleado(email)) {
            throw new SQLException("No se pudo eliminar el empleado. Verifique el email proporcionado");
        }
    }

    public List<Empleado> obtenerEmpleados() throws SQLException {
        return empleadoDAO.obtenerEmpleados();
    }
}