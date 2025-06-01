package modelos.daos.contratos;

import java.sql.SQLException;

public interface PedidoClienteDAO {
    boolean agregarDetallePedido(int idPedidoCliente, int idBebida, int cantidad) throws SQLException;
    int crearPedidoCliente(int idCliente, String fecha, String estado) throws SQLException;
}