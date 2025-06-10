package modelos.daos.implementaciones;

import modelos.Bebida;
import modelos.Venta;
import modelos.daos.contratos.VentaDAO;
import modelos.conexiones.UsuarioFactory;
import modelos.views.EstadisticaVentaProductos;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VentaDAOimpl implements VentaDAO {

    @Override
    public Venta procesarPedidoCompleto(int idCliente, String fecha, String estado,
                                        int idBebida, int cantidad, String folioVenta)
            throws SQLException {

        String sql = "{CALL sp_transaccion_pedido_completo(?, ?, ?, ?, ?, ?, ?, ?)}";
        Venta venta = new Venta();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
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

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
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

    @Override
    public List<Bebida> obtenerBebidasNoVendidasACliente(int idCliente) throws SQLException {
        String sql = "SELECT b.id_bebida, b.nombre, b.precio_unitario, b.stock_minimo, " +
                "b.stock_actual, b.tamaño, b.categoria " +
                "FROM bebida b " +
                "WHERE NOT EXISTS (" +
                "    SELECT 1 " +
                "    FROM detalle_pedido_cliente dpc " +
                "    JOIN pedido_cliente pc ON dpc.id_pedido_cliente = pc.id_pedido_cliente " +
                "    WHERE dpc.id_bebida = b.id_bebida " +
                "    AND pc.id_cliente = ?" +
                ")";

        List<Bebida> bebidas = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Bebida bebida = new Bebida();
                    bebida.setId(rs.getInt("id_bebida"));
                    bebida.setNombre(rs.getString("nombre"));
                    bebida.setPrecio_unitario(rs.getDouble("precio_unitario"));
                    bebida.setStock_minimo(rs.getInt("stock_minimo"));
                    bebida.setStock_actual(rs.getInt("stock_actual"));
                    bebida.setTamaño(rs.getInt("tamaño"));
                    bebida.setCategoria(rs.getString("categoria"));
                    bebidas.add(bebida);
                }
            }
        }
        return bebidas;
    }
    @Override
    public List<EstadisticaVentaProductos> bebidaMasVendidaCliente(int idCliente) throws SQLException {
        String callProcedure = "{CALL bebida_mas_vendida_a_cliente(?, ?, ?)}";
        String selectResult = "SELECT @bebida_nombre AS bebida_mas_vendida, @ventas_contar AS ventas_contar";
        List<EstadisticaVentaProductos> result = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             CallableStatement callStmt = conn.prepareCall(callProcedure);
             Statement selectStmt = conn.createStatement()) {

            // Set parameters for the stored procedure call
            callStmt.setInt(1, idCliente);
            callStmt.registerOutParameter(2, Types.VARCHAR);
            callStmt.registerOutParameter(3, Types.INTEGER);

            // Execute the stored procedure
            callStmt.execute();

            // Get the results from the output parameters
            try (ResultSet rs = selectStmt.executeQuery(selectResult)) {
                if (rs.next()) {
                    String nombreBebida = rs.getString("bebida_mas_vendida");
                    int totalVendido = rs.getInt("ventas_contar");

                    // Create and add the statistics object
                    result.add(new EstadisticaVentaProductos(nombreBebida, totalVendido));
                }
            }
        }
        return result;
    }
}