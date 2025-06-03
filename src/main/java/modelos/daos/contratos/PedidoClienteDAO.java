package modelos.daos.contratos;

import modelos.Pedido_Cliente;

import java.sql.SQLException;
import java.util.List;

public interface PedidoClienteDAO {
    boolean agregarDetallePedido(int idPedidoCliente, int idBebida, int cantidad) throws SQLException;
    int crearPedidoCliente(int idCliente, String fecha, String estado) throws SQLException;
    boolean cancelarPedido(int idPedidoCliente) throws SQLException;
    boolean entregarPedido(int idPedidoCliente) throws SQLException;
    public List<Pedido_Cliente> buscarPedidosPendientes(int idCliente) throws SQLException;
}