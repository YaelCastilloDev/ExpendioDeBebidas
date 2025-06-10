package controladores;

import modelos.Pedido_Cliente;
import modelos.daos.implementaciones.PedidoClienteDAOimpl;
import java.sql.SQLException;
import java.util.List;

public class PedidoClienteControlador {
    private final PedidoClienteDAOimpl pedidoDAO = new PedidoClienteDAOimpl();

    public int crearPedido(int idCliente, String fecha, String estado)
            throws SQLException, IllegalArgumentException {

        if (idCliente <= 0) {
            throw new IllegalArgumentException("ID de cliente inválido");
        }

        if (fecha == null || fecha.isEmpty()) {
            throw new IllegalArgumentException("Fecha no puede estar vacía");
        }



        return pedidoDAO.crearPedidoCliente(idCliente, fecha, estado);
    }

    public boolean agregarDetallePedido(int idPedido, int idBebida, int cantidad)
            throws SQLException, IllegalArgumentException {

        if (idPedido <= 0) {
            throw new IllegalArgumentException("ID de pedido inválido");
        }

        if (idBebida <= 0) {
            throw new IllegalArgumentException("ID de bebida inválido");
        }

        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }

        return pedidoDAO.agregarDetallePedido(idPedido, idBebida, cantidad);
    }

    public boolean procesarPedidoCompleto(int idCliente, String fecha, String estado,
                                          int idBebida, int cantidad) throws SQLException {
        try {
            int idPedido = crearPedido(idCliente, fecha, estado);
            return agregarDetallePedido(idPedido, idBebida, cantidad);
        } catch (IllegalArgumentException e) {
            throw new SQLException("Datos inválidos: " + e.getMessage());
        }
    }

    public boolean entregarPedido(int idPedidoCliente) throws SQLException {
        return pedidoDAO.entregarPedido(idPedidoCliente);
    }

    public List<Pedido_Cliente> buscarPedidosPendientes(int idCliente) throws SQLException {
        return pedidoDAO.buscarPedidosPendientes(idCliente);
    }

    public boolean cancelarPedido(int idPedidoCliente) throws SQLException {
        return pedidoDAO.cancelarPedido(idPedidoCliente);
    }
}