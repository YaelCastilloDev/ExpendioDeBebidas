package controladores;

import java.sql.SQLException;
import java.util.List;
import modelos.Bebida;
import modelos.daos.implementaciones.ReportesDAOimpl;
import modelos.views.*;

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
    
    public List<Bebida> obtenerProductosNoVendidosPorClientes(int idCliente) throws SQLException {
        return dao.obtenerProductosNoVendidosPorCliente(idCliente);
    }
    
    public List<EstadisticaVentaProductos> obtenerProductosMasVendidosPorCliente(int idCliente) throws SQLException {
        return dao.obtenerProductosMasVendidosPorCliente(idCliente);
    }
    
    public List<Bebida> obtenerInventarioBebidasAdmin() throws SQLException {
        return dao.obtenerInventarioBebidasAdmin();
    }
    
    public List<Bebida> obtenerInventarioBebidasEmpleado() throws SQLException {
        return dao.obtenerInventarioBebidasEmpleado();
    }
    public List<StockEstado> obtenerStockBajo() throws SQLException {
        return dao.obtenerStockBajo();
    }
}
