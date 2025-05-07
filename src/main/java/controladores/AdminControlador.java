package controladores;

import modelos.daos.implementaciones.AdminDAOimpl;
import modelos.utiles.validaciones.AdminValidacion;
import java.sql.SQLException;
import jakarta.validation.ConstraintViolationException;

public class AdminControlador {
    private final AdminDAOimpl adminDAO = new AdminDAOimpl();
    private final AdminValidacion validacion = new AdminValidacion();

    public void registrarAdmin(String nombre, String email, String contrasena) 
            throws ConstraintViolationException, IllegalArgumentException, SQLException {
        // Validar todos los campos (nombre, contraseña y email)
        validacion.validarCompleto(nombre, email, contrasena);

        // Verificar si el admin ya existe
        if (existeAdminPorEmail(email)) {
            throw new IllegalArgumentException("Ya existe un administrador con el email: " + email);
        }

        // Registrar en la base de datos
        if (!adminDAO.postRegistrar(nombre, contrasena, email)) {
            throw new SQLException("No se pudo registrar el administrador");
        }
    }

    public void actualizarAdmin(String nombre, String email, String contrasena) 
            throws ConstraintViolationException, IllegalArgumentException, SQLException {
        validacion.validarCompleto(nombre, email, contrasena);

        if (!adminDAO.updateActualizarDatosPersonales(nombre, contrasena, email)) {
            throw new SQLException("No se pudo actualizar el administrador");
        }
    }

    public void autenticarAdmin(String email, String contrasena) 
            throws ConstraintViolationException, IllegalArgumentException, SQLException {
        validacion.validarParaLogin(email, contrasena);
        
        if (!adminDAO.getLogin(email, contrasena)) {
            throw new IllegalArgumentException("Credenciales inválidas");
        }
    }

    private boolean existeAdminPorEmail(String email) throws SQLException {
        try {
            validacion.validarParaLogin(email, "passwordprueba");
            return adminDAO.existeEmail(email);
        } catch (ConstraintViolationException e) {
            return false;
        }
    }
}
