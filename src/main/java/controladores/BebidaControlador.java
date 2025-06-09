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

    public void registrarBebida(Double precioUnitario, Integer stockMinimo, Integer stockActual,
                                String nombre, Integer tamaño, String categoria)
            throws ConstraintViolationException, SQLException {

        validacion.validarCompleto(precioUnitario, stockMinimo, stockActual, nombre, tamaño, categoria);
        Bebida bebida = validacion.getBebidaValidada();

        if (!bebidaDAO.postRegistrar(bebida)) {
            throw new SQLException("No se pudo registrar la bebida");
        }
    }

    public void eliminarBebida(String nombreBebida) throws SQLException, IllegalStateException {
        Integer idBebida = bebidaDAO.obtenerIdPorNombre(nombreBebida);
        if (idBebida == null) {
            throw new SQLException("No se encontró la bebida con el nombre especificado");
        }

        if (bebidaDAO.existeEnRelaciones(idBebida)) {
            throw new IllegalStateException("No se puede eliminar la bebida porque está asociada a registros");
        }

        if (!bebidaDAO.deleteEliminar(nombreBebida)) {
            throw new SQLException("No se pudo eliminar la bebida");
        }
    }

    public void actualizarBebida(String nombreAntiguo, Double precioUnitario,
                                 Integer stockMinimo, Integer stockActual, String nombre, Integer tamaño, String categoria)
            throws ConstraintViolationException, SQLException {

        validacion.validarCompleto(precioUnitario, stockMinimo, stockActual, nombre, tamaño, categoria);
        Bebida bebida = validacion.getBebidaValidada();

        Integer idBebida = bebidaDAO.obtenerIdPorNombre(nombreAntiguo);
        if (idBebida == null) {
            throw new SQLException("No se encontró la bebida con el nombre especificado");
        }

        if (bebidaDAO.existeEnRelaciones(idBebida)) {
            throw new IllegalStateException("No se puede modificar la bebida porque está asociada a registros");
        }

        if (!bebidaDAO.updateBebida(nombreAntiguo, bebida)) {
            throw new SQLException("No se pudo actualizar la bebida");
        }
    }

    public Bebida obtenerBebidaPorNombre(String nombre) throws SQLException {
        return bebidaDAO.obtenerBebida(nombre);
    }

    public List<Bebida> obtenerTodasLasBebidas() throws SQLException {
        return bebidaDAO.obtenerBebidas();
    }
}