package modelos.daos.implementaciones;

import modelos.Pedido_Cliente;
import modelos.daos.contratos.PedidoClienteDAO;
import modelos.conexiones.UsuarioFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoClienteDAOimpl implements PedidoClienteDAO {
    @Override
    public boolean cancelarPedido(int idPedidoCliente) throws SQLException {
        String sql = "{CALL cancelar_pedido(?)}";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.EMPLEADO);
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idPedidoCliente);
            stmt.execute();
            return true; // Si no lanza excepción, se canceló correctamente
        }
    }

    @Override
    public boolean agregarDetallePedido(int idPedidoCliente, int idBebida, int cantidad)
            throws SQLException {

        String sql = "{CALL sp_agregar_detalle_pedido(?, ?, ?, ?)}";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.EMPLEADO);
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idPedidoCliente);
            stmt.setInt(2, idBebida);
            stmt.setInt(3, cantidad);
            stmt.registerOutParameter(4, Types.VARCHAR);

            stmt.execute();

            String resultado = stmt.getString(4);
            return resultado != null && resultado.contains("Detalle de pedido añadido exitosamente");
        }
    }

    @Override
    public int crearPedidoCliente(int idCliente, String fecha, String estado)
            throws SQLException {

        String sql = "{CALL sp_crear_pedido_cliente(?, ?, ?)}";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.EMPLEADO); // no está en el script //////////
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idCliente);
            stmt.setString(2, fecha);
            stmt.setString(3, estado);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1); // Retorna el ID del pedido creado
                }
            }

            throw new SQLException("No se pudo obtener el ID del pedido creado");
        }
    }



    @Override
    public boolean entregarPedido(int idPedidoCliente) throws SQLException {
        String sql = "UPDATE pedido_cliente SET estado = 'ENTREGADO' " +
                "WHERE id_pedido_cliente = ?";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.EMPLEADO); // no está en el script ///////////
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPedidoCliente);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    @Override
    public List<Pedido_Cliente> buscarPedidosPendientes(int idCliente) throws SQLException {
        String sql = "SELECT id_pedido_cliente, fecha, total, estado, id_cliente " +
                "FROM pedido_cliente " +
                "WHERE estado = 'PENDIENTE' AND id_cliente = ?";

        List<Pedido_Cliente> resultados = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.EMPLEADO);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Pedido_Cliente pedido = new Pedido_Cliente();
                    pedido.setId_pedido_cliente(rs.getInt("id_pedido_cliente"));
                    pedido.setFecha(rs.getDate("fecha").toLocalDate());
                    pedido.setTotal(rs.getBigDecimal("total"));
                    pedido.setEstado(rs.getString("estado"));
                    pedido.setId_cliente(rs.getInt("id_cliente"));

                    resultados.add(pedido);
                }
            }
        }
        return resultados;
    }
}