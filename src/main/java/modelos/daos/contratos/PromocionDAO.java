package modelos.daos.contratos;

import java.sql.SQLException;
import java.util.List;
import modelos.Promocion;

public interface PromocionDAO {
    boolean crearPromocionCliente(int idCliente, double porcentaje, String fechaInicio, String fechaFin) throws SQLException;
    List<Promocion> obtenerPromocionesPorBebida(int idBebida) throws SQLException;
    List<Promocion> obtenerPromocionesPorCliente(int idCliente) throws SQLException;
    public boolean crearPromocionBebida(int idBebida, double porcentaje, String fechaInicio, String fechaFin) throws SQLException;
}