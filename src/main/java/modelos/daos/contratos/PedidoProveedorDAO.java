package modelos.daos.contratos;

import java.sql.SQLException;
import java.util.List;
import modelos.PedidoProveedor;

public interface PedidoProveedorDAO {
    public boolean añadirDetallePedidoProveedor(int idPedidoProveedor, int idBebida, int cantidad) throws SQLException;
    public int crearPedidoAutomatico(int idBebida, int cantidadPedida, String rfcProveedor) throws SQLException;
    boolean cancelarPedidoProveedor(int idPedidoProveedor) throws SQLException;
    List<PedidoProveedor> obtenerPedidosPendientes(String rfc) throws SQLException;
}
