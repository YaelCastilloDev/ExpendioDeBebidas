package controladores;

import modelos.Venta;
import modelos.daos.implementaciones.VentaDAOimpl;

import java.sql.SQLException;

public class VentaControlador {
    private final VentaDAOimpl ventaDAO = new VentaDAOimpl();

    public Venta procesarPedido(int idCliente, String fecha, String estado,
                                int idBebida, int cantidad, String folioVenta)
            throws SQLException {
        return ventaDAO.procesarPedidoCompleto(idCliente, fecha, estado,
                idBebida, cantidad, folioVenta);
    }
}