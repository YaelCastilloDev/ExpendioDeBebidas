package modelos.utiles.validaciones;

import jakarta.validation.*;
import java.util.Date;
import java.util.Set;
import controladores.clases.Promocion;

public class PromocionValidacion {
    private final Promocion promocion;

    public PromocionValidacion() {
        this.promocion = new Promocion();
    }

    public void validarCompleto(
            Double porcentaje,
            Date fecha_inicio,
            Date fecha_fin) {
        
        promocion.setPorcentaje(porcentaje);
        promocion.setFecha_inicio(fecha_inicio);
        promocion.setFecha_fin(fecha_fin);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Promocion>> violations = validator.validate(promocion);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    public Promocion getPromocionValidada() {
        return this.promocion;
    }
}
