package modelos.daos.contratos;

import modelos.Bebida;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import modelos.views.EstadisticaVentaProductos;

public interface BebidaDAO {
    boolean postRegistrar(Bebida bebida, Connection conexion) throws SQLException;
    boolean deleteEliminar(String nombre, Connection conexion) throws SQLException;
    boolean updateBebida(String nombre, Bebida bebida, Connection conexion) throws SQLException;
    Bebida obtenerBebida(String nombre, Connection conexion) throws SQLException;
    List<Bebida> obtenerBebidas(Connection conexion) throws SQLException;
    List<Bebida> obtenerNombresBebidasMenosVendidas(Connection conexion) throws SQLException;
    boolean existeEnPromocionBebida(int idBebida, Connection conexion) throws SQLException;
    boolean existeEnDetallePedidoProveedor(int idBebida, Connection conexion) throws SQLException;
    boolean existeEnDetallePedidoCliente(int idBebida, Connection conexion) throws SQLException;
    boolean existeEnRelaciones(int idBebida, Connection conexion) throws SQLException;
    Integer obtenerIdPorNombre(String nombreBebida, Connection conexion) throws SQLException;
    List<EstadisticaVentaProductos> obtenerBebidasMenosVendidas(Connection conexion) throws SQLException;
    List<EstadisticaVentaProductos> obtenerBebidasMasVendidas(Connection conexion) throws SQLException;
}