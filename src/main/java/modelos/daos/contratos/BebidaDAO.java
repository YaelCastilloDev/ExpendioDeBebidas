package modelos.daos.contratos;

import modelos.Bebida;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BebidaDAO {

    public boolean postRegistrar(Bebida bebida) throws SQLException;

    public boolean deleteEliminar(String nombre) throws SQLException;
    
    public boolean updateBebida(String nombre, Bebida bebida) throws SQLException;
    
    public Bebida obtenerBebida(String nombre) throws SQLException;
    
    public List<Bebida> obtenerBebidas() throws SQLException;

    public List<Bebida> obtenerNombresBebidasMenosVendidas(Connection conexion) throws SQLException;

    public boolean existeEnPromocionBebida(int idBebida) throws SQLException;

    public boolean existeEnDetallePedidoProveedor(int idBebida) throws SQLException;

    public boolean existeEnDetallePedidoCliente(int idBebida) throws SQLException;
}
