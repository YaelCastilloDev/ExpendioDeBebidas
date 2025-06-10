package controladores;

import modelos.Bebida;
import modelos.Venta;
import modelos.daos.implementaciones.VentaDAOimpl;
import modelos.views.EstadisticaVentaProductos;

import java.sql.SQLException;
import java.util.List;

public class VentaControlador {
    private final VentaDAOimpl ventaDAO = new VentaDAOimpl();

    public Venta procesarPedido(int idCliente, String fecha, String estado,
                                int idBebida, int cantidad, String folioVenta)
            throws SQLException {
        return ventaDAO.procesarPedidoCompleto(idCliente, fecha, estado,
                idBebida, cantidad, folioVenta);
    }
    public List<EstadisticaVentaProductos> obtenerBebidaMasVendidaACliente(int idCliente) throws SQLException {
        return ventaDAO.bebidaMasVendidaCliente(idCliente);
    }
    public List<Bebida> obtenerBebidasNoVendidasACliente(int idCliente) throws SQLException {
        return ventaDAO.obtenerBebidasNoVendidasACliente(idCliente);
    }
}