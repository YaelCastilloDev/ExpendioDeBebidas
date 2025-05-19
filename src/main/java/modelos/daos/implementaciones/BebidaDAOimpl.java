package modelos.daos.implementaciones;

import modelos.Bebida;
import modelos.conexiones.BaseDeDatosConexion;
import modelos.daos.contratos.BebidaDAO;
import modelos.views.EstadisticaVentaProductos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BebidaDAOimpl implements BebidaDAO {

    @Override
    public boolean postRegistrar(Bebida bebida) throws SQLException {
        String sql = "INSERT INTO Bebida (precio_unitario, stock_minimo, stock_actual, nombre, tamaño, categoria) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Obtenemos la conexión internamente
            conn = BaseDeDatosConexion.obtenerConeccion();
            stmt = conn.prepareStatement(sql);

            stmt.setBigDecimal(1, new java.math.BigDecimal(bebida.getPrecio_unitario()));
            stmt.setInt(2, bebida.getStock_minimo());
            stmt.setInt(3, bebida.getStock_actual());
            stmt.setString(4, bebida.getNombre());
            stmt.setInt(5, bebida.getTamaño());
            stmt.setString(6, bebida.getCategoria());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } finally {
            // Cerramos recursos en orden inverso a su creación
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    @Override
    public boolean deleteEliminar(String nombreBebida) throws SQLException {
        String sql = "DELETE FROM Bebida WHERE nombre = ?";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = BaseDeDatosConexion.obtenerConeccion();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombreBebida);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    @Override
    public List<Bebida> obtenerNombresBebidasMenosVendidas(Connection conexion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public List<EstadisticaVentaProductos> obtenerBebidasMenosVendidas(Connection conexion) throws SQLException {
        String consulta = "SELECT nombre, total_vendida FROM Productos_Menos_Vendidos";
        List<EstadisticaVentaProductos> resultados = new ArrayList<>();

        try (PreparedStatement stmt = conexion.prepareStatement(consulta);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int totalVendido = rs.getInt("total_vendida");


                resultados.add(new EstadisticaVentaProductos(nombre, totalVendido));
            }
        }

        return resultados;
    }

    public List<EstadisticaVentaProductos> obtenerBebidasMasVendidas(Connection conexion) throws SQLException {
        String consulta = "SELECT nombre, total_vendida FROM Productos_Mas_Vendidos";
        List<EstadisticaVentaProductos> resultados = new ArrayList<>();

        try (PreparedStatement stmt = conexion.prepareStatement(consulta);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int totalVendido = rs.getInt("total_vendida");

                resultados.add(new EstadisticaVentaProductos(nombre, totalVendido));
            }
        }
        return resultados;
    }

    public Integer obtenerIdPorNombre(String nombreBebida) throws SQLException {
        String sql = "SELECT id_bebida FROM Bebida WHERE nombre = ?";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = BaseDeDatosConexion.obtenerConeccion();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombreBebida);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_bebida");
            } else {
                return null;
            }
        } finally {
            // Cerrar recursos en orden inverso
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    @Override
    public boolean existeEnDetallePedidoCliente(int idBebida) throws SQLException {
        String sql = "SELECT 1 FROM Detalle_Pedido_Cliente WHERE id_bebida = ? LIMIT 1";

        try (Connection conn = BaseDeDatosConexion.obtenerConeccion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idBebida);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Retorna true si hay al menos un resultado
            }
        }
    }

    @Override
    public boolean existeEnDetallePedidoProveedor(int idBebida) throws SQLException {
        String sql = "SELECT 1 FROM Detalle_Pedido_Proveedor WHERE id_bebida = ? LIMIT 1";

        try (Connection conn = BaseDeDatosConexion.obtenerConeccion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idBebida);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    @Override
    public boolean existeEnPromocionBebida(int idBebida) throws SQLException {
        String sql = "SELECT 1 FROM Promocion_Bebida WHERE id_bebida = ? LIMIT 1";

        try (Connection conn = BaseDeDatosConexion.obtenerConeccion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idBebida);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    public boolean existeEnRelaciones(int idBebida) throws SQLException {
        String sql = "SELECT (EXISTS(SELECT 1 FROM Detalle_Pedido_Cliente WHERE id_bebida = ?) OR " +
                "(EXISTS(SELECT 1 FROM Detalle_Pedido_Proveedor WHERE id_bebida = ?)) OR " +
                "(EXISTS(SELECT 1 FROM Promocion_Bebida WHERE id_bebida = ?)) AS existe";

        try (Connection conn = BaseDeDatosConexion.obtenerConeccion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idBebida);
            stmt.setInt(2, idBebida);
            stmt.setInt(3, idBebida);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getBoolean("existe");
            }
        }
    }

    public List<Bebida> getAllBebidas() throws SQLException {
        String sql = "SELECT id_bebida, precio_unitario, stock_minimo, stock_actual, nombre, tamaño, categoria FROM Bebida";
        List<Bebida> bebidas = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = BaseDeDatosConexion.obtenerConeccion();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Bebida bebida = new Bebida();
                bebida.setPrecio_unitario(rs.getDouble("precio_unitario"));
                bebida.setStock_minimo(rs.getInt("stock_minimo"));
                bebida.setStock_actual(rs.getInt("stock_actual"));
                bebida.setNombre(rs.getString("nombre"));
                bebida.setTamaño(rs.getInt("tamaño"));
                bebida.setCategoria(rs.getString("categoria"));

                bebidas.add(bebida);
            }
        } finally {
            // Cerrar recursos en orden inverso
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return bebidas;
    }
}