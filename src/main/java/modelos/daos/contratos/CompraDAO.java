package modelos.daos.contratos;

import modelos.Compra;
import java.sql.SQLException;

public interface CompraDAO {

    Compra completarPedidoProveedor(int idBebida, int cantidadPedida, String rfcProveedor, String folioFactura) throws SQLException;
    Compra obtenerCompraPorId(int idCompra) throws SQLException;
    public Compra completarPedidoProveedor(int idPedidoProveedor, String folioFactura) throws SQLException;

    }