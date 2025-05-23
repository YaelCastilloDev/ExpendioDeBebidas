package controladores;

import modelos.Bebida;
import modelos.daos.implementaciones.BebidaDAOimpl;
import modelos.utiles.validaciones.BebidaValidacion;
import jakarta.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.List;

public class BebidaControlador {
    private final BebidaDAOimpl bebidaDAO = new BebidaDAOimpl();
    private final BebidaValidacion validacion = new BebidaValidacion();

    public void registrarBebida(
            Double precioUnitario,
            Integer stockMinimo,
            Integer stockActual,
            String nombre,
            Integer tamaño,
            String categoria) throws ConstraintViolationException, SQLException {

        // Validar todos los campos
        validacion.validarCompleto(precioUnitario, stockMinimo, stockActual, nombre, tamaño, categoria);

        // Obtener la bebida validada
        Bebida bebida = validacion.getBebidaValidada();

        // Registrar en la base de datos
        if (!bebidaDAO.postRegistrar(bebida)) {
            throw new SQLException("No se pudo registrar la bebida");
        }
    }

    public void eliminarBebida(String nombreBebida) throws SQLException, IllegalStateException {
        // Obtener ID y verificar existencia
        Integer idBebida = bebidaDAO.obtenerIdPorNombre(nombreBebida);
        if (idBebida == null) {
            throw new SQLException("No se encontró la bebida con el nombre especificado");
        }

        // Verificar relaciones combinadas (más eficiente que llamadas separadas)
        if (bebidaDAO.existeEnRelaciones(idBebida)) {
            throw new IllegalStateException("No se puede eliminar la bebida porque está asociada a registros de compra, venta o promociones");
        }

        // Eliminación final
        bebidaDAO.deleteEliminar(nombreBebida);
    }
    
    public void actualizarBebida(String nombreAntiguo, Double precioUnitario,
            Integer stockMinimo, Integer stockActual, String nombre, Integer tamaño, String categoria)
            throws ConstraintViolationException, SQLException {
        Integer idBebida = bebidaDAO.obtenerIdPorNombre(nombreAntiguo);
        if (idBebida == null) {
            throw new SQLException("No se encontró la bebida con el nombre especificado");
        }
        
        if (bebidaDAO.existeEnRelaciones(idBebida)) {
            throw new IllegalStateException("No se puede eliminar la bebida porque está asociada a registros de compra, venta o promociones");
        }
        
        validacion.validarCompleto(precioUnitario, stockMinimo, stockActual, nombre, tamaño, categoria);
        Bebida bebida = validacion.getBebidaValidada();
        
        bebidaDAO.updateBebida(nombreAntiguo, bebida);
    }
    
    public Bebida obtenerBebidaPorNombre(String nombre) throws SQLException {
        return bebidaDAO.obtenerBebida(nombre);
    }
    
    public List<Bebida> obtenerTodasLasBebidas() throws SQLException {
        return bebidaDAO.obtenerBebidas();
    }
}

