package modelos.utiles.validaciones;

import jakarta.validation.*;
import java.util.Set;
import modelos.Proveedor;

public class ProveedorValidacion {
    private final Proveedor proveedor;

    public ProveedorValidacion() {
        this.proveedor = new Proveedor();
    }

    public void validarCompleto(
            String rfc,
            String razon_social,
            String telefono,
            String email,
            Integer codigo_postal,
            String colonia,
            String ciudad,
            String estado) {
        
        proveedor.setRfc(rfc);
        proveedor.setRazon_social(razon_social);
        proveedor.setTelefono(telefono);
        proveedor.setEmail(email);
        proveedor.setCodigo_postal(codigo_postal);
        proveedor.setColonia(colonia);
        proveedor.setCiudad(ciudad);
        proveedor.setEstado(estado);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Proveedor>> violations = validator.validate(proveedor);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    public Proveedor getProveedorValidado() {
        return this.proveedor;
    }
}
