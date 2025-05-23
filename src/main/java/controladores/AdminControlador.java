package controladores;

import modelos.daos.implementaciones.AdminDAOimpl;
import modelos.utiles.validaciones.AdminValidacion;
import java.sql.SQLException;
import jakarta.validation.ConstraintViolationException;
import java.util.List;
import modelos.Admin;

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

    public void actualizarAdmin(String nombre, String emailViejo, String emailNuevo, String contrasena)
            throws ConstraintViolationException, IllegalArgumentException, SQLException {
        validacion.validarCompleto(nombre, emailNuevo, contrasena);

        if (!adminDAO.updateActualizarDatosPersonales(nombre, contrasena, emailViejo, emailNuevo)) {
            throw new SQLException("No se pudo actualizar el administrador");
        }
    }

    public void autenticarAdmin(String email, String contrasena)
            throws ConstraintViolationException, IllegalArgumentException, SQLException {
        validacion.validarParaLogin(email, contrasena);

        if (!adminDAO.getLogin(email, contrasena)) {
            throw new IllegalArgumentException("Credenciales inválidas");
        }
        System.out.println("logeado");
    }

    private boolean existeAdminPorEmail(String email) throws SQLException {
        try {
            validacion.validarParaLogin(email, "passwordprueba");
            return adminDAO.existeEmail(email);
        } catch (ConstraintViolationException e) {
            return false;
        }
    }

    public void eliminarAdmin(String email)
            throws ConstraintViolationException, IllegalArgumentException, SQLException {
        // Validar que el email tenga formato correcto
        validacion.validarParaLogin(email, "contrasena123");

        // Verificar que el admin exista antes de intentar eliminarlo
        if (!existeAdminPorEmail(email)) {
            throw new IllegalArgumentException("No existe un administrador con el email: " + email);
        }

        // Ejecutar eliminación
        if (!adminDAO.deleteEliminarAdmin(email)) {
            throw new SQLException("No se pudo eliminar el administrador. Verifique el email proporcionado");
        }
    }
    
    public List<Admin> obtenerAdmins() throws SQLException {
        return adminDAO.getAdministradores();
    }
}
