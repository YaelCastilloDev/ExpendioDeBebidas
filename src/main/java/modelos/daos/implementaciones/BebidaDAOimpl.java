package modelos.daos.implementaciones;

import modelos.Bebida;
import modelos.conexiones.UsuarioFactory;
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

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setDouble(1, bebida.getPrecio_unitario());
            stmt.setInt(2, bebida.getStock_minimo());
            stmt.setInt(3, bebida.getStock_actual());
            stmt.setString(4, bebida.getNombre());
            stmt.setInt(5, bebida.getTamaño());
            stmt.setString(6, bebida.getCategoria());

            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteEliminar(String nombreBebida) throws SQLException {
        String sql = "DELETE FROM Bebida WHERE nombre = ?";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nombreBebida);
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean updateBebida(String nombreAntiguo, Bebida bebida) throws SQLException {
        String sql = "UPDATE Bebida SET precio_unitario = ?, stock_minimo = ?, stock_actual = ?, " +
                   "nombre = ?, tamaño = ?, categoria = ? WHERE nombre = ?";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setDouble(1, bebida.getPrecio_unitario());
            stmt.setInt(2, bebida.getStock_minimo());
            stmt.setInt(3, bebida.getStock_actual());
            stmt.setString(4, bebida.getNombre());
            stmt.setInt(5, bebida.getTamaño());
            stmt.setString(6, bebida.getCategoria());
            stmt.setString(7, nombreAntiguo);

            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public Bebida obtenerBebida(String nombre) throws SQLException {
        String sql = "SELECT id_bebida, precio_unitario, stock_minimo, stock_actual, nombre, tamaño, categoria " +
                   "FROM Bebida WHERE nombre = ?";
        Bebida bebida = null;

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nombre);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    bebida = new Bebida();
                    bebida.setId(rs.getInt("id_bebida"));
                    bebida.setPrecio_unitario(rs.getDouble("precio_unitario"));
                    bebida.setStock_minimo(rs.getInt("stock_minimo"));
                    bebida.setStock_actual(rs.getInt("stock_actual"));
                    bebida.setNombre(rs.getString("nombre"));
                    bebida.setTamaño(rs.getInt("tamaño"));
                    bebida.setCategoria(rs.getString("categoria"));
                }
            }
        }
        return bebida;
    }

    @Override
    public List<Bebida> obtenerBebidas() throws SQLException {
        String sql = "SELECT id_bebida, precio_unitario, stock_minimo, stock_actual, nombre, tamaño, categoria FROM Bebida";
        List<Bebida> bebidas = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Bebida bebida = new Bebida();
                bebida.setId(rs.getInt("id_bebida"));
                bebida.setPrecio_unitario(rs.getDouble("precio_unitario"));
                bebida.setStock_minimo(rs.getInt("stock_minimo"));
                bebida.setStock_actual(rs.getInt("stock_actual"));
                bebida.setNombre(rs.getString("nombre"));
                bebida.setTamaño(rs.getInt("tamaño"));
                bebida.setCategoria(rs.getString("categoria"));
                bebidas.add(bebida);
            }
        }
        return bebidas;
    }

    @Override
    public Integer obtenerIdPorNombre(String nombreBebida) throws SQLException {
        String sql = "SELECT id_bebida FROM Bebida WHERE nombre = ?";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nombreBebida);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? rs.getInt("id_bebida") : null;
            }
        }
    }

    @Override
    public boolean existeEnDetallePedidoCliente(int idBebida) throws SQLException {
        String sql = "SELECT 1 FROM Detalle_Pedido_Cliente WHERE id_bebida = ? LIMIT 1";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idBebida);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    @Override
    public boolean existeEnDetallePedidoProveedor(int idBebida) throws SQLException {
        String sql = "SELECT 1 FROM Detalle_Pedido_Proveedor WHERE id_bebida = ? LIMIT 1";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
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

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idBebida);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    @Override
    public boolean existeEnRelaciones(int idBebida) throws SQLException {
        String sql = "SELECT (EXISTS(SELECT 1 FROM Detalle_Pedido_Cliente WHERE id_bebida = ?) " +
                   "OR EXISTS(SELECT 1 FROM Detalle_Pedido_Proveedor WHERE id_bebida = ?) " +
                   "OR EXISTS(SELECT 1 FROM Promocion_Bebida WHERE id_bebida = ?)) AS existe";

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idBebida);
            stmt.setInt(2, idBebida);
            stmt.setInt(3, idBebida);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getBoolean("existe");
            }
        }
    }

    @Override
    public List<EstadisticaVentaProductos> obtenerBebidasMenosVendidas() throws SQLException {
        String sql = "SELECT nombre, total_vendida FROM Productos_Menos_Vendidos";
        List<EstadisticaVentaProductos> resultados = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultados.add(new EstadisticaVentaProductos(
                        rs.getString("nombre"),
                        rs.getInt("total_vendida")
                ));
            }
        }
        return resultados;
    }

    @Override
    public List<EstadisticaVentaProductos> obtenerBebidasMasVendidas() throws SQLException {
        String sql = "SELECT nombre, total_vendida FROM Productos_Mas_Vendidos";
        List<EstadisticaVentaProductos> resultados = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultados.add(new EstadisticaVentaProductos(
                        rs.getString("nombre"),
                        rs.getInt("total_vendida")
                ));
            }
        }
        return resultados;
    }

    @Override
    public List<Bebida> obtenerNombresBebidasMenosVendidas() throws SQLException {
        String sql = "SELECT b.id_bebida, b.nombre FROM Bebida b " +
                   "JOIN Productos_Menos_Vendidos pmv ON b.nombre = pmv.nombre";
        List<Bebida> bebidas = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Bebida bebida = new Bebida();
                bebida.setId(rs.getInt("id_bebida"));
                bebida.setNombre(rs.getString("nombre"));
                bebidas.add(bebida);
            }
        }
        return bebidas;
    }
}