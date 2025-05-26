package controladores;

import modelos.Bebida;
import modelos.conexiones.UsuarioFactory;
import modelos.daos.implementaciones.BebidaDAOimpl;
import modelos.utiles.validaciones.BebidaValidacion;
import jakarta.validation.ConstraintViolationException;
import modelos.views.EstadisticaVentaProductos;

import java.sql.Connection;
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

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN)) {
            if (!bebidaDAO.postRegistrar(bebida, conn)) {
                throw new SQLException("No se pudo registrar la bebida");
            }
        }
    }

    public void eliminarBebida(String nombreBebida) throws SQLException, IllegalStateException {
        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN)) {
            Integer idBebida = bebidaDAO.obtenerIdPorNombre(nombreBebida, conn);
            if (idBebida == null) {
                throw new SQLException("No se encontró la bebida con el nombre especificado");
            }

            if (bebidaDAO.existeEnRelaciones(idBebida, conn)) {
                throw new IllegalStateException("No se puede eliminar la bebida porque está asociada a registros");
            }

            if (!bebidaDAO.deleteEliminar(nombreBebida, conn)) {
                throw new SQLException("No se pudo eliminar la bebida");
            }
        }
    }

    public void actualizarBebida(String nombreAntiguo, Double precioUnitario,
                                 Integer stockMinimo, Integer stockActual, String nombre, Integer tamaño, String categoria)
            throws ConstraintViolationException, SQLException {

        validacion.validarCompleto(precioUnitario, stockMinimo, stockActual, nombre, tamaño, categoria);
        Bebida bebida = validacion.getBebidaValidada();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN)) {
            Integer idBebida = bebidaDAO.obtenerIdPorNombre(nombreAntiguo, conn);
            if (idBebida == null) {
                throw new SQLException("No se encontró la bebida con el nombre especificado");
            }

            if (bebidaDAO.existeEnRelaciones(idBebida, conn)) {
                throw new IllegalStateException("No se puede modificar la bebida porque está asociada a registros");
            }

            if (!bebidaDAO.updateBebida(nombreAntiguo, bebida, conn)) {
                throw new SQLException("No se pudo actualizar la bebida");
            }
        }
    }

    public Bebida obtenerBebidaPorNombre(String nombre) throws SQLException {
        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN)) {
            return bebidaDAO.obtenerBebida(nombre, conn);
        }
    }

    public List<Bebida> obtenerTodasLasBebidas() throws SQLException {
        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN)) {
            return bebidaDAO.obtenerBebidas(conn);
        }
    }

    public List<EstadisticaVentaProductos> obtenerBebidasMenosVendidas() throws SQLException {
        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN)) {
            return bebidaDAO.obtenerBebidasMenosVendidas(conn);
        }
    }

    public List<EstadisticaVentaProductos> obtenerBebidasMasVendidas() throws SQLException {
        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN)) {
            return bebidaDAO.obtenerBebidasMasVendidas(conn);
        }
    }
}
