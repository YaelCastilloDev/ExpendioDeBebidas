package modelos.daos.implementaciones;

import modelos.Venta;
import modelos.daos.contratos.VentaDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.*;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class VentaDAOimplTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private CallableStatement mockCallableStatement;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    @InjectMocks
    private VentaDAOimpl ventaDAO;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        when(mockConnection.prepareCall(anyString())).thenReturn(mockCallableStatement);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
    }

    @Test
    void procesarPedidoCompleto_ExitosoConVenta() throws SQLException {
        // Arrange
        when(mockCallableStatement.execute()).thenReturn(true);
        when(mockCallableStatement.getString(7)).thenReturn("Pedido creado exitosamente. ID: 123");
        when(mockCallableStatement.getInt(8)).thenReturn(123);

        // Mock sale retrieval
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("id_venta")).thenReturn(456);
        when(mockResultSet.getString("folio")).thenReturn("FOLIO123");
        when(mockResultSet.getDate("fecha")).thenReturn(new java.sql.Date(new Date().getTime()));

        // Act
        Venta resultado = ventaDAO.procesarPedidoCompleto(
                3, "2023-11-15", "ENTREGADO", 21, 3, "FOLIO123", mockConnection);

        // Assert
        assertNotNull(resultado);
        assertEquals(456, resultado.getIdVenta());
        assertEquals("FOLIO123", resultado.getFolio());
        assertEquals(123, resultado.getIdPedidoCliente());
    }

    @Test
    void procesarPedidoCompleto_ExitosoSinVenta() throws SQLException {
        // Arrange
        when(mockCallableStatement.execute()).thenReturn(true);
        when(mockCallableStatement.getString(7)).thenReturn("Pedido creado exitosamente. ID: 123");
        when(mockCallableStatement.getInt(8)).thenReturn(123);

        // Act (status is not "ENTREGADO" so it won't try to get sale info)
        Venta resultado = ventaDAO.procesarPedidoCompleto(
                3, "2023-11-15", "PENDIENTE", 21, 3, "", mockConnection);

        // Assert
        assertNotNull(resultado);
        assertEquals(123, resultado.getIdPedidoCliente());
        assertNull(resultado.getFolio()); // No sale created for PENDIENTE status
    }

    @Test
    void procesarPedidoCompleto_Fallido() throws SQLException {
        // Arrange
        when(mockCallableStatement.execute()).thenReturn(true);
        when(mockCallableStatement.getString(7)).thenReturn("Error: No se pudo crear el pedido");

        // Act & Assert
        assertThrows(SQLException.class, () -> {
            ventaDAO.procesarPedidoCompleto(
                    3, "2023-11-15", "ENTREGADO", 21, 3, "", mockConnection);
        });
    }
}