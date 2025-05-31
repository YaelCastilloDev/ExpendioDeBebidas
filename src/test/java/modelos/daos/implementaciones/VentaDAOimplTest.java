package modelos.daos.implementaciones;

import modelos.Venta;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
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

    @Test
    void shouldReturnVentaWithCorrectFolioAndFecha() throws Exception {
        // Test data
        String testFolio = "TEST123";
        LocalDate testFecha = LocalDate.of(2023, 12, 15);

        // Mock the stored procedure call
        when(mockConnection.prepareCall(anyString())).thenReturn(mockCallableStatement);
        when(mockCallableStatement.execute()).thenReturn(true);
        when(mockCallableStatement.getString(7)).thenReturn("Pedido creado exitosamente");

        // Mock the venta query
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getDate("fecha")).thenReturn(Date.valueOf(testFecha));

        // Act
        Venta result = ventaDAO.procesarPedidoCompleto(
                1, "2023-12-15", "PENDIENTE", 5, 2, testFolio);

        // Assert
        assertEquals(testFolio, result.getFolio(), "Folio should match input");
        assertEquals(testFecha, result.getFecha(), "Fecha should match database value");
    }
}