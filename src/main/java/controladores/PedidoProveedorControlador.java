package controladores;

import modelos.daos.implementaciones.PedidoProveedorDAOimpl;

import java.sql.SQLException;
import java.util.List;
import modelos.PedidoProveedor;

public class PedidoProveedorControlador {
    PedidoProveedorDAOimpl pedidoProveedorDAO = new PedidoProveedorDAOimpl();

    public boolean agregarDetalleAPedido(int idPedidoProveedor, int idBebida, int cantidad) {
        try {
            return pedidoProveedorDAO.añadirDetallePedidoProveedor(idPedidoProveedor, idBebida, cantidad);
        } catch (SQLException e) {
            // Log the error or handle it appropriately
            return false;
        }
    }

    public int crearPedidoAutomatico(int idBebida, int cantidadPedida, String rfcProveedor) throws SQLException {
            return pedidoProveedorDAO.crearPedidoAutomatico(idBebida, cantidadPedida, rfcProveedor);

    }

    public boolean cancelarPedidoProveedor(int idPedidoProveedor) throws SQLException, IllegalArgumentException {
        // Input validation
        if (idPedidoProveedor <= 0) {
            throw new IllegalArgumentException("ID de pedido a proveedor inválido");
        }

        return pedidoProveedorDAO.cancelarPedidoProveedor(idPedidoProveedor);
    }
    
    public List<PedidoProveedor> obtenerPedidosPendientes(String rfc) throws SQLException {
        return pedidoProveedorDAO.obtenerPedidosPendientes(rfc);
    }
}
