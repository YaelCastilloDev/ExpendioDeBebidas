package modelos.daos.implementaciones;

import modelos.daos.contratos.PedidoClienteDAO;
import modelos.conexiones.UsuarioFactory;
import java.sql.*;

public class PedidoClienteDAOimpl implements PedidoClienteDAO {

    @Override
    public boolean agregarDetallePedido(int idPedidoCliente, int idBebida, int cantidad)
            throws SQLException {

        String sql = "{CALL sp_agregar_detalle_pedido(?, ?, ?, ?)}";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
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

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
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
}