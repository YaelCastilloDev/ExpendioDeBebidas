package modelos.utiles.validaciones;

import jakarta.validation.*;
import java.util.Set;
import modelos.Cliente;

public class ClienteValidacion {
    private final Cliente cliente;

    public ClienteValidacion() {
        this.cliente = new Cliente();
    }

    public void validarCompleto(
            String nombre,
            String paterno,
            String materno,
            String email,
            String telefono,
            String rfc,
            Integer codigo_postal,
            String colonia,
            String ciudad,
            String estado) {
        
        cliente.setNombre(nombre);
        cliente.setPaterno(paterno);
        cliente.setMaterno(materno);
        cliente.setEmail(email);
        cliente.setTelefono(telefono);
        cliente.setRfc(rfc);
        cliente.setCodigo_postal(codigo_postal);
        cliente.setColonia(colonia);
        cliente.setCiudad(ciudad);
        cliente.setEstado(estado);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Cliente>> violations = validator.validate(cliente);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    public Cliente getClienteValidado() {
        return this.cliente;
    }
}
