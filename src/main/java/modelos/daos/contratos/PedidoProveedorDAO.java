package modelos.daos.contratos;

import java.sql.SQLException;

public interface PedidoProveedorDAO {
    public boolean añadirDetallePedidoProveedor(int idPedidoProveedor, int idBebida, int cantidad) throws SQLException;
    boolean crearPedidoAutomatico(int idBebida, int cantidadPedida, String rfcProveedor) throws SQLException;
    boolean cancelarPedidoProveedor(int idPedidoProveedor) throws SQLException;

}
