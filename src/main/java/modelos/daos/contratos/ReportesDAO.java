package modelos.daos.contratos;

import java.sql.SQLException;
import java.util.List;
import modelos.views.AnalisisVentas;
import modelos.views.EstadisticaVentaProductos;
import modelos.views.ProductoVendidoPorCliente;
import modelos.views.StockProductos;
import modelos.views.VentasAnuales;
import modelos.views.VentasMensuales;
import modelos.views.VentasSemanales;

public interface ReportesDAO {
    List<VentasAnuales> obtenerVentasAnuales() throws SQLException;
    List<VentasMensuales> obtenerVentasMensuales() throws SQLException;
    List<VentasSemanales> obtenerVentasSemanales() throws SQLException;
    List<EstadisticaVentaProductos> obtenerBebidasMenosVendidas() throws SQLException;
    List<EstadisticaVentaProductos> obtenerBebidasMasVendidas() throws SQLException;
    List<EstadisticaVentaProductos> obtenerVentasPorProducto() throws SQLException;
    List<StockProductos> obtenerBebidasStockMinimo() throws SQLException;
    List<AnalisisVentas> obtenerAnalisisVentas() throws SQLException;
    List<ProductoVendidoPorCliente> obtenerProductosNoVendidosPorCliente() throws SQLException;
    List<ProductoVendidoPorCliente> obtenerProductosMasVendidosPorCliente() throws SQLException;
}
