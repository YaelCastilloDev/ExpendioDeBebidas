package modelos.daos.contratos;

import java.sql.SQLException;
import java.util.List;
import modelos.Proveedor;

public interface ProveedorDAO {
    public boolean postRegistrar(Proveedor proveedor) throws SQLException;
    
    public boolean actualizarDatos(String rfcAntiguo, Proveedor proveedor) throws SQLException;
    
    public boolean eliminarProveedor(String rfc) throws SQLException;
    
    public Proveedor obtenerProveedor(String rfc) throws SQLException;
    
    public List<Proveedor> obtenerProveedores() throws SQLException;
    
}
