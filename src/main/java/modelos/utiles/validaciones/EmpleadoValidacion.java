package modelos.utiles.validaciones;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.HashSet;
import java.util.Set;
import modelos.Empleado;

public class EmpleadoValidacion {
    private final Empleado empleado;
    private final Validator validator;  // Declaración del validator


    public EmpleadoValidacion() {
        this.empleado = new Empleado();
        // Inicialización del validator
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();    }

    public void validarCompleto(
            String nombre,
            String email,
            String contraseña) {

        empleado.setNombre(nombre);
        empleado.setContraseña(contraseña);
        empleado.setEmail(email);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Empleado>> violations = validator.validate(empleado);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    public void validarParaLogin(String email, String contraseña) {
        // Validación individual de propiedades
        Set<ConstraintViolation<Empleado>> violations = new HashSet<>();

        // Validar email
        empleado.setEmail(email);
        violations.addAll(validator.validateProperty(empleado, "email"));

        // Validar contraseña
        empleado.setContraseña(contraseña);
        violations.addAll(validator.validateProperty(empleado, "contraseña"));

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
    }


