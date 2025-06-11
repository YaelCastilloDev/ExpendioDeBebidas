package controladores;

import modelos.daos.implementaciones.PedidoProveedorDAOimpl;

import java.sql.SQLException;

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

    public int crearPedidoAutomatico(int idBebida, int cantidadPedida, String rfcProveedor) {
        try {
            return pedidoProveedorDAO.crearPedidoAutomatico(idBebida, cantidadPedida, rfcProveedor);
        } catch (SQLException e) {
            return -1; // Retorna -1 si hay algún fallo
        }
    }

    public boolean cancelarPedidoProveedor(int idPedidoProveedor) throws SQLException, IllegalArgumentException {
        // Input validation
        if (idPedidoProveedor <= 0) {
            throw new IllegalArgumentException("ID de pedido a proveedor inválido");
        }

        return pedidoProveedorDAO.cancelarPedidoProveedor(idPedidoProveedor);
    }
}
