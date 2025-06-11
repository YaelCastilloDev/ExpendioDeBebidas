package modelos.daos.contratos;

import java.sql.SQLException;
import java.util.List;

public interface PromocionDAO {
    boolean crearPromocionCliente(int idCliente, double porcentaje, String fechaInicio, String fechaFin) throws SQLException;
    List<Integer> obtenerPromocionesPorBebida(int idBebida) throws SQLException;
    List<Integer> obtenerPromocionesPorCliente(int idCliente) throws SQLException;
    public boolean crearPromocionBebida(int idBebida, double porcentaje, String fechaInicio, String fechaFin) throws SQLException;
}