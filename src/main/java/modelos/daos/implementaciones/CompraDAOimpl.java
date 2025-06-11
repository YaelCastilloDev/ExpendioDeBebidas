package modelos.daos.implementaciones;

import modelos.Compra;
import modelos.conexiones.UsuarioFactory;
import modelos.daos.contratos.CompraDAO;

import java.sql.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CompraDAOimpl implements CompraDAO {

    @Override
    public Compra completarPedidoProveedor(int idBebida, int cantidadPedida, String rfcProveedor, String folioFactura) throws SQLException {
        String createOrderSql = "{CALL sp_crear_pedido_automatico(?, ?, ?)}";
        String completeOrderSql = "{CALL sp_completar_pedido_proveedor(?, ?)}";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN)) {
            // First create the supplier order
            int idPedidoProveedor;
            try (CallableStatement createStmt = conn.prepareCall(createOrderSql)) {
                createStmt.setInt(1, idBebida);
                createStmt.setInt(2, cantidadPedida);
                createStmt.setString(3, rfcProveedor);

                try (ResultSet rs = createStmt.executeQuery()) {
                    if (rs.next()) {
                        idPedidoProveedor = rs.getInt("id_pedido_proveedor");
                    } else {
                        throw new SQLException("Failed to create supplier order");
                    }
                }
            }

            // Then complete the order to create the purchase
            try (CallableStatement completeStmt = conn.prepareCall(completeOrderSql)) {
                completeStmt.setInt(1, idPedidoProveedor);
                completeStmt.setString(2, folioFactura);
                completeStmt.execute();
            }

            // Get the created purchase
            return obtenerCompraPorPedido(idPedidoProveedor);
        }
    }

    @Override
    public Compra obtenerCompraPorId(int idCompra) throws SQLException {
        String sql = "SELECT * FROM compra WHERE id_compra = ?";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCompra);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapCompraFromResultSet(rs);
                }
            }
        }
        return null;
    }

    private Compra obtenerCompraPorPedido(int idPedidoProveedor) throws SQLException {
        String sql = "SELECT * FROM compra WHERE id_pedido_proveedor = ?";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPedidoProveedor);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapCompraFromResultSet(rs);
                }
            }
        }
        return null;
    }

    private Compra mapCompraFromResultSet(ResultSet rs) throws SQLException {
        Compra compra = new Compra();
        compra.setIdCompra(rs.getInt("id_compra"));
        compra.setFolio(rs.getString("folio"));
        compra.setFecha(rs.getDate("fecha").toLocalDate());
        compra.setTotal(rs.getBigDecimal("total"));
        compra.setIdPedidoProveedor(rs.getInt("id_pedido_proveedor"));
        return compra;
    }
}