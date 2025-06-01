package modelos.daos.implementaciones;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PedidoClienteDAOimplTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private CallableStatement mockCallableStatement;

    @Mock
    private ResultSet mockResultSet;

    @InjectMocks
    private PedidoClienteDAOimpl pedidoDAO;

    @Test
    void testCrearPedidoYAgregarDetalle() throws Exception {
        // Configurar mocks para crearPedidoCliente
        when(mockConnection.prepareCall(anyString())).thenReturn(mockCallableStatement);
        when(mockCallableStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);

        // Ejecutar crearPedidoCliente
        pedidoDAO.crearPedidoCliente(1, "2023-12-15", "PENDIENTE");

        // Verificar parámetros de creación
        verify(mockCallableStatement).setInt(1, 1);
        verify(mockCallableStatement).setString(2, "2023-12-15");
        verify(mockCallableStatement).setString(3, "PENDIENTE");

        // Configurar mocks para agregarDetallePedido
        when(mockConnection.prepareCall(anyString())).thenReturn(mockCallableStatement);
        when(mockCallableStatement.execute()).thenReturn(true);
        when(mockCallableStatement.getString(4))
                .thenReturn("Detalle de pedido añadido exitosamente");

        // Ejecutar agregarDetallePedido
        boolean resultado = pedidoDAO.agregarDetallePedido(1, 5, 2);

        // Verificar éxito
        assertTrue(resultado);
    }

    @Test
    void testAgregarDetalleFallido() throws Exception {
        // Configurar mocks para simular fallo
        when(mockConnection.prepareCall(anyString())).thenReturn(mockCallableStatement);
        when(mockCallableStatement.execute()).thenReturn(true);
        when(mockCallableStatement.getString(4))
                .thenReturn("Error: Stock insuficiente");

        // Ejecutar agregarDetallePedido
        boolean resultado = pedidoDAO.agregarDetallePedido(1, 5, 10);

        // Verificar fallo
        assertFalse(resultado);
    }
}