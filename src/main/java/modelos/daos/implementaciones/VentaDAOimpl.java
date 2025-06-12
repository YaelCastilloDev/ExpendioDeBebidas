package modelos.daos.implementaciones;

import modelos.Venta;
import modelos.daos.contratos.VentaDAO;
import modelos.conexiones.UsuarioFactory;

import java.sql.*;

public class VentaDAOimpl implements VentaDAO {

    @Override
    public Venta procesarPedidoCompleto(int idCliente, String fecha, String estado,
                                        int idBebida, int cantidad, String folioVenta)
            throws SQLException {

        String sql = "{CALL sp_transaccion_pedido_completo(?, ?, ?, ?, ?, ?, ?, ?)}";
        Venta venta = new Venta();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);////////////////////
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idCliente);
            stmt.setString(2, fecha);
            stmt.setString(3, estado);
            stmt.setInt(4, idBebida);
            stmt.setInt(5, cantidad);
            stmt.setString(6, folioVenta);
            stmt.registerOutParameter(7, Types.VARCHAR);
            stmt.registerOutParameter(8, Types.INTEGER);

            stmt.execute();

            String resultado = stmt.getString(7);
            int idPedidoGenerado = stmt.getInt(8);

            if (resultado != null && idPedidoGenerado > 0) {
                venta = obtenerVentaPorPedido(idPedidoGenerado);
                venta.setIdPedidoCliente(idPedidoGenerado);
                venta.setFolio(folioVenta);
                return venta;
            } else {
                throw new SQLException(resultado != null ? resultado : "Error desconocido al procesar el pedido");
            }
        }
    }

    private Venta obtenerVentaPorPedido(int idPedido) throws SQLException {
        String sql = "SELECT id_venta, fecha FROM venta WHERE id_pedido_cliente = ?";
        Venta venta = new Venta();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.EMPLEADO);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPedido);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    venta.setIdVenta(rs.getInt("id_venta"));
                    venta.setFecha(rs.getDate("fecha").toLocalDate());                }
            }
        }
        return venta;
    }
}