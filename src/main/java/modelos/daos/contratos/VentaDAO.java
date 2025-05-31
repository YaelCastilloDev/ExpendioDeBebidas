package modelos.daos.contratos;

import modelos.Venta;
import java.sql.SQLException;

public interface VentaDAO {
    Venta procesarPedidoCompleto(int idCliente, String fecha, String estado,
                                 int idBebida, int cantidad, String folioVenta)
            throws SQLException;
}