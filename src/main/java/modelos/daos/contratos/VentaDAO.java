package modelos.daos.contratos;

import modelos.Bebida;
import modelos.Venta;
import modelos.views.EstadisticaVentaProductos;

import java.sql.SQLException;
import java.util.List;

public interface VentaDAO {
    Venta procesarPedidoCompleto(int idCliente, String fecha, String estado,
                                 int idBebida, int cantidad, String folioVenta)
            throws SQLException;
    List<Bebida> obtenerBebidasNoVendidasACliente(int idCliente) throws SQLException;
    List<EstadisticaVentaProductos> bebidaMasVendidaCliente(int idCliente) throws SQLException;

}