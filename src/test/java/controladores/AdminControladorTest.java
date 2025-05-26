package controladores;

import modelos.Admin;
import modelos.conexiones.UsuarioFactory;
import modelos.daos.implementaciones.AdminDAOimpl;
import modelos.utiles.validaciones.AdminValidacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdminControladorTest {

    @Mock
    private AdminDAOimpl adminDAO;

    @Mock
    private AdminValidacion validacion;

    @Mock
    private Connection connection;

    @Mock
    private UsuarioFactory usuarioFactory;

    @InjectMocks
    private AdminControlador adminControlador;

    @Test
    void registrarAdminExitoso() throws Exception {
        assertDoesNotThrow(() -> adminControlador.registrarAdmin("prueba", "prueba@example.com", "12345678"));
    }

    @Test
    void registrarAdminConEmailExistente() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            adminControlador.registrarAdmin("Test", "test@example.com", "password123");
        });
        assertEquals("Ya existe un administrador con el email: test@example.com", exception.getMessage());
    }
}