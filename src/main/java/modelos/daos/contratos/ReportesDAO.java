package modelos.daos.contratos;

import java.sql.SQLException;
import java.util.List;
import modelos.Bebida;
import modelos.views.*;

public interface ReportesDAO {
    List<VentasAnuales> obtenerVentasAnuales() throws SQLException;
    List<VentasMensuales> obtenerVentasMensuales() throws SQLException;
    List<VentasSemanales> obtenerVentasSemanales() throws SQLException;
    List<EstadisticaVentaProductos> obtenerBebidasMenosVendidas() throws SQLException;
    List<EstadisticaVentaProductos> obtenerBebidasMasVendidas() throws SQLException;
    List<EstadisticaVentaProductos> obtenerVentasPorProducto() throws SQLException;
    List<StockProductos> obtenerBebidasStockMinimo() throws SQLException;
    List<AnalisisVentas> obtenerAnalisisVentas() throws SQLException;
    List<Bebida> obtenerProductosNoVendidosPorCliente(int idCliente) throws SQLException;
    List<EstadisticaVentaProductos> obtenerProductosMasVendidosPorCliente(int idCliente) throws SQLException;
    List<Bebida> obtenerInventarioBebidasEmpleado() throws SQLException;
    List<Bebida> obtenerInventarioBebidasAdmin() throws SQLException;
    List<StockEstado> obtenerStockBajo() throws SQLException;

}
