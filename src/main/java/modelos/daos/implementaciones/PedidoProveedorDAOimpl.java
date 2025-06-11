    package modelos.daos.implementaciones;

    import modelos.conexiones.UsuarioFactory;
    import modelos.daos.contratos.PedidoProveedorDAO;

    import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelos.PedidoProveedor;

    public class PedidoProveedorDAOimpl implements PedidoProveedorDAO {
    @Override
    public boolean añadirDetallePedidoProveedor(int idPedidoProveedor, int idBebida, int cantidad) throws SQLException {
        String sql = "{CALL añadir_detalle_pedido_proveedor(?, ?, ?)}";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idPedidoProveedor);
            stmt.setInt(2, idBebida);
            stmt.setInt(3, cantidad);

            stmt.execute();
            return true;
        } catch (SQLException e) {
            // Log the error if needed
            throw e;
        }
    }
    @Override
    public boolean crearPedidoAutomatico(int idBebida, int cantidadPedida, String rfcProveedor) throws SQLException {
        String sql = "{CALL sp_crear_pedido_automatico(?, ?, ?)}";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idBebida);
            stmt.setInt(2, cantidadPedida);

            if (rfcProveedor == null || rfcProveedor.isEmpty()) {
                stmt.setNull(3, Types.VARCHAR);
            } else {
                stmt.setString(3, rfcProveedor);
            }

            stmt.execute();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

        @Override
        public boolean cancelarPedidoProveedor(int idPedidoProveedor) throws SQLException {
            String sql = "UPDATE pedido_proveedor SET estado = 'CANCELADO' WHERE id_pedido_proveedor = ? AND estado = 'PENDIENTE'";

            try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, idPedidoProveedor);
                int rowsAffected = stmt.executeUpdate();

                // Retorna verdadero si el pedido se cambió a CANCELADO
                return rowsAffected == 1;
            }
        }
        
    @Override
    public List<PedidoProveedor> obtenerPedidosPendientes(String rfc) throws SQLException {
        String sql = "SELECT id_pedido_proveedor, fecha, total, estado, rfc " +
                     "FROM pedido_proveedor " +
                     "WHERE estado = 'PENDIENTE' AND rfc = ?";

        List<PedidoProveedor> resultados = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, rfc);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PedidoProveedor pedido = new PedidoProveedor();
                    pedido.setId(rs.getInt("id_pedido_proveedor"));
                    pedido.setFecha(rs.getDate("fecha").toLocalDate());
                    pedido.setTotal(rs.getBigDecimal("total"));
                    pedido.setEstado(rs.getString("estado"));
                    pedido.setRfc(rs.getString("rfc"));

                    resultados.add(pedido);
                }
            }
        }

        return resultados;
    }
}
