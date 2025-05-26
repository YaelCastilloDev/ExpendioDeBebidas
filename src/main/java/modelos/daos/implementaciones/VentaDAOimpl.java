package modelos.daos.implementaciones;

import modelos.Venta;
import modelos.daos.contratos.VentaDAO;
import java.sql.*;

public class VentaDAOimpl implements VentaDAO {

    @Override
    public Venta procesarPedidoCompleto(int idCliente, String fecha, String estado,
                                        int idBebida, int cantidad, String folioVenta,
                                        Connection conn) throws SQLException {
        String sql = "{CALL sp_transaccion_pedido_completo(?, ?, ?, ?, ?, ?, ?, ?)}";
        Venta venta = new Venta();

        try (CallableStatement stmt = conn.prepareCall(sql)) {
            // Set input parameters
            stmt.setInt(1, idCliente);
            stmt.setString(2, fecha);
            stmt.setString(3, estado);
            stmt.setInt(4, idBebida);
            stmt.setInt(5, cantidad);
            stmt.setString(6, folioVenta);

            // Register output parameters
            stmt.registerOutParameter(7, Types.VARCHAR); // resultado
            stmt.registerOutParameter(8, Types.INTEGER); // id_pedido_generado

            stmt.execute();

            // Get the output values
            String resultado = stmt.getString(7);
            int idPedidoGenerado = stmt.getInt(8);

            if (resultado != null && resultado.contains("exitosamente")) {
                // If successful, get the created sale information
                if (estado.equals("ENTREGADO")) {
                    venta = obtenerVentaPorPedido(idPedidoGenerado, conn);
                }
                venta.setIdPedidoCliente(idPedidoGenerado);
                return venta;
            } else {
                throw new SQLException(resultado != null ? resultado : "Error desconocido al procesar el pedido");
            }
        }
    }

    private Venta obtenerVentaPorPedido(int idPedido, Connection conn) throws SQLException {
        String sql = "SELECT id_venta, folio, fecha FROM Venta WHERE id_pedido_cliente = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPedido);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Venta venta = new Venta();
                    venta.setIdVenta(rs.getInt("id_venta"));
                    venta.setFolio(rs.getString("folio"));
                    venta.setFecha(rs.getDate("fecha"));
                    return venta;
                }
            }
        }
        return new Venta(); // Return empty sale if not found (shouldn't happen for ENTREGADO status)
    }
}