package modelos.utiles.validaciones;

import jakarta.validation.*;
import java.util.Set;
import controladores.clases.Empleado;

public class EmpleadoValidacion {
    private final Empleado empleado;

    public EmpleadoValidacion() {
        this.empleado = new Empleado();
    }

    public void validarCompleto(
            String nombre,
            String contraseña,
            String email) {
        
        empleado.setNombre(nombre);
        empleado.setContraseña(contraseña);
        empleado.setEmail(email);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Empleado>> violations = validator.validate(empleado);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    public Empleado getEmpleadoValidado() {
        return this.empleado;
    }
}
