package modelos.daos.contratos;

import modelos.Bebida;
import java.sql.SQLException;
import java.util.List;

public interface BebidaDAO {
    boolean postRegistrar(Bebida bebida) throws SQLException;
    boolean deleteEliminar(String nombre) throws SQLException;
    boolean updateBebida(String nombre, Bebida bebida) throws SQLException;
    Bebida obtenerBebida(String nombre) throws SQLException;
    List<Bebida> obtenerBebidas() throws SQLException;
    List<Bebida> obtenerNombresBebidasMenosVendidas() throws SQLException;
    boolean existeEnPromocionBebida(int idBebida) throws SQLException;
    boolean existeEnDetallePedidoProveedor(int idBebida) throws SQLException;
    boolean existeEnDetallePedidoCliente(int idBebida) throws SQLException;
    boolean existeEnRelaciones(int idBebida) throws SQLException;
    Integer obtenerIdPorNombre(String nombreBebida) throws SQLException;
}