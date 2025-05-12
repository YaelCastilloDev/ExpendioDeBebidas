package modelos.utiles.validaciones;

import modelos.Bebida;
import org.junit.jupiter.api.Test;
import jakarta.validation.ConstraintViolationException;
import static org.junit.jupiter.api.Assertions.*;

class BebidaValidacionTest {

    @Test
    void testValidacionCorrecta() {
        BebidaValidacion validador = new BebidaValidacion();

        // Prueba con datos válidos
        assertDoesNotThrow(() -> {
            validador.validarCompleto(
                    15.99,   // precio válido
                    10,      // stock mínimo válido
                    20,     // stock actual válido
                    "Agua Mineral", // nombre válido
                    1000,    // tamaño válido
                    "Agua"   // categoría válida
            );
        });
    }

    @Test
    void testValidacionFallida() {
        BebidaValidacion validador = new BebidaValidacion();

        // Prueba con datos inválidos (precio negativo)
        Exception exception = assertThrows(ConstraintViolationException.class, () -> {
            validador.validarCompleto(
                    -5.0,   // precio inválido (negativo)
                    10,      // stock mínimo válido
                    20,      // stock actual válido
                    "Jugo de Naranja", // nombre válido
                    500,     // tamaño válido
                    "Jugos"  // categoría válida
            );
        });

        // Verifica que el mensaje de error contenga la validación fallida
        assertTrue(exception.getMessage().contains("Precio debe ser positivo"));
    }
}