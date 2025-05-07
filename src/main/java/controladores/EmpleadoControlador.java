package controladores;

import modelos.daos.implementaciones.EmpleadoDAOimpl;
import modelos.utiles.validaciones.EmpleadoValidacion;
import java.sql.SQLException;
import jakarta.validation.ConstraintViolationException;

public class EmpleadoControlador {
    private final EmpleadoDAOimpl empleadoDAO = new EmpleadoDAOimpl();
    private final EmpleadoValidacion validacion = new EmpleadoValidacion();

    public void registrarEmpleado(String nombre, String email, String contrasena) 
            throws ConstraintViolationException, IllegalArgumentException, SQLException {
        // Validar todos los campos (nombre, contraseña y email)
        validacion.validarCompleto(nombre, email, contrasena);

        // Verificar si el empleado ya existe
        if (existeEmpleadoPorEmail(email)) {
            throw new IllegalArgumentException("Ya existe un empleado con el email: " + email);
        }

        // Registrar en la base de datos
        if (!empleadoDAO.postRegistrar(nombre, contrasena, email)) {
            throw new SQLException("No se pudo registrar el empleado");
        }
    }

    public void actualizarEmpleado(String email, String nuevoNombre, String nuevaContrasena) 
            throws ConstraintViolationException, IllegalArgumentException, SQLException {
        validacion.validarCompleto(nuevoNombre, email, nuevaContrasena);

        if (!empleadoDAO.updateActualizarDatosPersonales(email, nuevoNombre, nuevaContrasena)) {
            throw new SQLException("No se pudo actualizar los datos del empleado");
        }
    }

    public void autenticarEmpleado(String nombre, String email, String contrasena) 
            throws ConstraintViolationException, IllegalArgumentException, SQLException {
        validacion.validarCompleto(nombre, email, contrasena);
        
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
}
