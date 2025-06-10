package modelos.daos.implementaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Bebida;
import modelos.conexiones.UsuarioFactory;
import modelos.daos.contratos.ReportesDAO;
import modelos.views.AnalisisVentas;
import modelos.views.EstadisticaVentaProductos;
import modelos.views.ProductoVendidoPorCliente;
import modelos.views.StockProductos;
import modelos.views.VentasAnuales;
import modelos.views.VentasMensuales;
import modelos.views.VentasSemanales;

public class ReportesDAOimpl implements ReportesDAO {

    @Override
    public List<VentasAnuales> obtenerVentasAnuales() throws SQLException {
        String sql = "SELECT año, total_anual, cantidad_ventas FROM vw_ventas_anuales";
        List<VentasAnuales> resultados = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                VentasAnuales ventas = new VentasAnuales();
                ventas.setAño(rs.getInt("año"));
                ventas.setTotalAnual(rs.getBigDecimal("total_anual"));
                ventas.setCantidadVentas(rs.getLong("cantidad_ventas"));
                resultados.add(ventas);
            }
        }
        return resultados;
    }

    @Override
    public List<VentasMensuales> obtenerVentasMensuales() throws SQLException {
        String sql = "SELECT año, mes, total_mensual, cantidad_ventas FROM vw_ventas_mensuales";
        List<VentasMensuales> resultados = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                VentasMensuales ventas = new VentasMensuales();
                ventas.setAño(rs.getInt("año"));
                ventas.setCantidadVentas(rs.getLong("cantidad_ventas"));
                ventas.setMes(rs.getInt("mes"));
                ventas.setTotalMensual(rs.getBigDecimal("total_mensual"));
                resultados.add(ventas);
            }
        }
        return resultados;
    }

    @Override
    public List<VentasSemanales> obtenerVentasSemanales() throws SQLException {
        String sql = "SELECT año, semana, total_semanal, cantidad_ventas FROM vw_ventas_semanales";
        List<VentasSemanales> resultados = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                VentasSemanales ventas = new VentasSemanales();
                ventas.setAño(rs.getInt("año"));
                ventas.setCantidadVentas(rs.getLong("cantidad_ventas"));
                ventas.setSemana(rs.getInt("semana"));
                ventas.setTotalSemanal(rs.getBigDecimal("total_semanal"));
                resultados.add(ventas);
            }
        }
        return resultados;
    }

    @Override
    public List<EstadisticaVentaProductos> obtenerBebidasMenosVendidas() throws SQLException {
        String sql = "SELECT id_bebida, nombre, total_vendida FROM Productos_Menos_Vendidos";
        List<EstadisticaVentaProductos> resultados = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                EstadisticaVentaProductos estadisticas = new EstadisticaVentaProductos();
                estadisticas.setIdBebida(rs.getInt("id_bebida"));
                estadisticas.setNombreBebida(rs.getString("nombre"));
                estadisticas.setTotalVendido(rs.getInt("total_vendida"));
                resultados.add(estadisticas);
            }
        }
        return resultados;
    }

    @Override
    public List<EstadisticaVentaProductos> obtenerBebidasMasVendidas() throws SQLException {
        String sql = "SELECT id_bebida, nombre, total_vendida FROM Productos_Mas_Vendidos";
        List<EstadisticaVentaProductos> resultados = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                EstadisticaVentaProductos estadisticas = new EstadisticaVentaProductos();
                estadisticas.setIdBebida(rs.getInt("id_bebida"));
                estadisticas.setNombreBebida(rs.getString("nombre"));
                estadisticas.setTotalVendido(rs.getInt("total_vendida"));
                resultados.add(estadisticas);
            }
        }
        return resultados;
    }

    @Override
    public List<EstadisticaVentaProductos> obtenerVentasPorProducto() throws SQLException {
        String sql = "SELECT id_bebida, producto, cantidad_vendida, total_ventas FROM Ventas_Por_Producto";
        List<EstadisticaVentaProductos> resultados = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                EstadisticaVentaProductos estadisticas = new EstadisticaVentaProductos();
                estadisticas.setIdBebida(rs.getInt("id_bebida"));
                estadisticas.setNombreBebida(rs.getString("producto"));
                estadisticas.setTotalVendido(rs.getInt("total_ventas"));
                estadisticas.setCantidadVendida(rs.getInt("cantidad_vendida"));
                resultados.add(estadisticas);
            }
        }
        return resultados;
    }

    @Override
    public List<StockProductos> obtenerBebidasStockMinimo() throws SQLException {
        String sql = "SELECT id_bebida, nombre, stock_minimo, stock_actual FROM Productos_Stock_Bajo";
        List<StockProductos> resultados = new ArrayList<>();
        
        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                StockProductos productos = new StockProductos();
                productos.setIdBebida(rs.getInt("id_bebida"));
                productos.setNombreBebida(rs.getString("nombre"));
                productos.setStockMinimo(rs.getInt("stock_minimo"));
                productos.setStockActual(rs.getInt("stock_actual"));
                resultados.add(productos);
            }
        }
        return resultados;
    }

    @Override
    public List<AnalisisVentas> obtenerAnalisisVentas() throws SQLException {
        String sql = "SELECT id_bebida, producto, categoria, stock_actual, " +
                    "stock_minimo, clientes_unicos, ingresos_totales, " +
                    "cantidad_total_vendida, estado_venta " +
                    "FROM analisis_ventas;";
        List<AnalisisVentas> resultados = new ArrayList<>();
        
        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                AnalisisVentas analisis = new AnalisisVentas();
                analisis.setIdBebida(rs.getInt("id_bebida"));
                analisis.setBebida(rs.getString("producto"));
                analisis.setCategoria(rs.getString("categoria"));
                analisis.setStockActual(rs.getInt("stock_actual"));
                analisis.setStockMinimo(rs.getInt("stock_minimo"));
                analisis.setClientesUnicos(rs.getInt("clientes_unicos"));
                analisis.setIngresosTotales(rs.getDouble("ingresos_totales"));
                analisis.setTotalVendida(rs.getInt("cantidad_total_vendida"));
                analisis.setEstadoVenta(rs.getString("estado_venta"));
                resultados.add(analisis);
            }
        }
        return resultados;
    }

    @Override
    public List<ProductoVendidoPorCliente> obtenerProductosNoVendidosPorCliente() throws SQLException {
        String sql = "";
        List<ProductoVendidoPorCliente> resultados = new ArrayList<>();
        
        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                ProductoVendidoPorCliente producto = new ProductoVendidoPorCliente();
                resultados.add(producto);
            }
        }
        return resultados;
    }

    @Override
    public List<ProductoVendidoPorCliente> obtenerProductosMasVendidosPorCliente() throws SQLException {
        String sql = "";
        List<ProductoVendidoPorCliente> resultados = new ArrayList<>();
        
        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                ProductoVendidoPorCliente producto = new ProductoVendidoPorCliente();
                resultados.add(producto);
            }
        }
        return resultados;
    }

    @Override
    public List<Bebida> obtenerInventarioBebidasEmpleado() throws SQLException {
        String sql = "SELECT id_bebida, nombre, tamaño, categoria, precio_unitario, stock_actual " +
                     "FROM bebida;";
        List<Bebida> resultados = new ArrayList<>();
        
        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.EMPLEADO);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Bebida bebida = new Bebida();
                bebida.setId(rs.getInt("id_bebida"));
                bebida.setNombre(rs.getString("nombre"));
                bebida.setTamaño(rs.getInt("tamaño"));
                bebida.setCategoria(rs.getString("categoria"));
                bebida.setPrecio_unitario(rs.getDouble("precio_unitario"));
                bebida.setStock_actual(rs.getInt("stock_actual"));
                resultados.add(bebida);
            }
        }
        return resultados;
    }
    
    @Override
    public List<Bebida> obtenerInventarioBebidasAdmin() throws SQLException {
        String sql = "SELECT id_bebida, nombre, tamaño, categoria, precio_unitario, stock_actual, stock_minimo " +
                     "FROM bebida;";
        List<Bebida> resultados = new ArrayList<>();
        
        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.EMPLEADO);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Bebida bebida = new Bebida();
                bebida.setId(rs.getInt("id_bebida"));
                bebida.setNombre(rs.getString("nombre"));
                bebida.setTamaño(rs.getInt("tamaño"));
                bebida.setCategoria(rs.getString("categoria"));
                bebida.setPrecio_unitario(rs.getDouble("precio_unitario"));
                bebida.setStock_actual(rs.getInt("stock_actual"));
                bebida.setStock_minimo(rs.getInt("stock_minimo"));
                resultados.add(bebida);
            }
        }
        return resultados;
    }
}
