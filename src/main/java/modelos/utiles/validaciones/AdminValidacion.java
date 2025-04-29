package modelos.utiles.validaciones;

import jakarta.validation.*;
import java.util.HashSet;
import java.util.Set;
import modelos.Admin;

public class AdminValidacion {
    private final Admin admin;
    private final Validator validator;

    public AdminValidacion() {
        this.admin = new Admin();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Valida todos los campos (para registro/actualización)
    public void validarCompleto(String nombre, String email, String contraseña) {
        admin.setNombre(nombre);
        admin.setContraseña(contraseña);
        admin.setEmail(email);

        Set<ConstraintViolation<Admin>> violations = validator.validate(admin);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    // Valida solo email y contraseña (para login)
    public void validarParaLogin(String email, String contraseña) {
        // Usamos valores dummy para el nombre ya que no es relevante para login
        admin.setEmail(email);
        admin.setContraseña(contraseña);

        // Create a mutable Set to store all violations
        Set<ConstraintViolation<Admin>> violations = new HashSet<>();
        
        // Add email violations
        violations.addAll(validator.validateProperty(admin, "email"));
        
        // Add password violations
        violations.addAll(validator.validateProperty(admin, "contraseña"));

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    public Admin getAdminValidado() {
        return this.admin;
    }
}