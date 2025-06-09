package controladores;

import java.sql.SQLException;
import java.util.List;
import modelos.daos.implementaciones.ReportesDAOimpl;
import modelos.views.AnalisisVentas;
import modelos.views.EstadisticaVentaProductos;
import modelos.views.ProductoVendidoPorCliente;
import modelos.views.StockProductos;
import modelos.views.VentasAnuales;
import modelos.views.VentasMensuales;
import modelos.views.VentasSemanales;

public class ReporteControlador {
    private final ReportesDAOimpl dao = new ReportesDAOimpl();
    
    public List<VentasAnuales> obtenerVentasAnuales() throws SQLException {
        return dao.obtenerVentasAnuales();
    }
    
    public List<VentasMensuales> obtenerVentasMensuales() throws SQLException {
        return dao.obtenerVentasMensuales();
    }
    
    public List<VentasSemanales> obtenerVentasSemanales() throws SQLException {
        return dao.obtenerVentasSemanales();
    }
    
    public List<EstadisticaVentaProductos> obtenerBebidasMasVendidas() throws SQLException {
        return dao.obtenerBebidasMasVendidas();
    }
    
    public List<EstadisticaVentaProductos> obtenerBebidasMenosVendidas() throws SQLException {
        return dao.obtenerBebidasMenosVendidas();
    }
    
    public List<EstadisticaVentaProductos> obtenerVentasPorProducto() throws SQLException {
        return dao.obtenerVentasPorProducto();
    }
    
    public List<StockProductos> obtenerBebidasStockMinimo() throws SQLException {
        return dao.obtenerBebidasStockMinimo();
    }
    
    public List<AnalisisVentas> obtenerAnalisisVentas() throws SQLException {
        return dao.obtenerAnalisisVentas();
    }
    
    public List<ProductoVendidoPorCliente> obtenerProductosNoVendidosPorClientes() throws SQLException {
        return dao.obtenerProductosNoVendidosPorCliente();
    }
    
    public List<ProductoVendidoPorCliente> obtenerProductosMasVendidosPorCliente() throws SQLException {
        return dao.obtenerProductosMasVendidosPorCliente();
    }
}
