package controladores;

import modelos.daos.implementaciones.PedidoClienteDAOimpl;
import java.sql.SQLException;

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

        if (!estado.equals("PENDIENTE") && !estado.equals("ENTREGADO") && !estado.equals("CANCELADO")) {
            throw new IllegalArgumentException("Estado inválido. Debe ser PENDIENTE, ENTREGADO o CANCELADO");
        }

        return pedidoDAO.crearPedidoCliente(idCliente, fecha, estado);
    }

    public boolean agregarDetalle(int idPedido, int idBebida, int cantidad)
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
            return agregarDetalle(idPedido, idBebida, cantidad);
        } catch (IllegalArgumentException e) {
            throw new SQLException("Datos inválidos: " + e.getMessage());
        }
    }
}