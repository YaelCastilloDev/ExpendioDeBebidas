    package modelos.daos.implementaciones;

    import modelos.conexiones.UsuarioFactory;
    import modelos.daos.contratos.PedidoProveedorDAO;

    import java.sql.*;

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

                // Returns true if exactly one row was updated
                return rowsAffected == 1;
            }
        }
}
