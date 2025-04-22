package modelos.utiles.validaciones;

import jakarta.validation.*;
import java.util.Set;
import modelos.Bebida;

public class BebidaValidacion {
    private final Bebida bebida;

    public BebidaValidacion() {
        this.bebida = new Bebida();
    }

    public void validarCompleto(
            Double precio_unitario,
            Integer stock_minimo,
            Integer stock_actual,
            String nombre,
            Integer tamaño,
            String categoria) {
        
        bebida.setPrecio_unitario(precio_unitario);
        bebida.setStock_minimo(stock_minimo);
        bebida.setStock_actual(stock_actual);
        bebida.setNombre(nombre);
        bebida.setTamaño(tamaño);
        bebida.setCategoria(categoria);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Bebida>> violations = validator.validate(bebida);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    public Bebida getBebidaValidada() {
        return this.bebida;
    }
}
