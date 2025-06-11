package modelos.daos.implementaciones;

import modelos.conexiones.UsuarioFactory;
import modelos.daos.contratos.PromocionDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PromocionDAOimpl implements PromocionDAO{

    @Override
    public List<Integer> obtenerPromocionesPorBebida(int idBebida) throws SQLException {
        String sql = "SELECT id_promocion FROM Promocion_Bebida WHERE id_bebida = ?";
        List<Integer> promociones = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idBebida);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    promociones.add(rs.getInt("id_promocion"));
                }
            }
        }

        return promociones;
    }
    @Override
    public List<Integer> obtenerPromocionesPorCliente(int idCliente) throws SQLException {
        String sql = "SELECT id_promocion FROM Promocion_Cliente WHERE id_cliente = ?";
        List<Integer> promociones = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    promociones.add(rs.getInt("id_promocion"));
                }
            }
        }

        return promociones;
    }

    @Override
    public boolean crearPromocionCliente(int idCliente, double porcentaje, String fechaInicio, String fechaFin) throws SQLException {
        Connection conn = null;
        try {
            conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
            conn.setAutoCommit(false);

            // First create the promotion
            String sqlPromocion = "INSERT INTO promocion (porcentaje, fecha_inicio, fecha_fin) VALUES (?, ?, ?)";
            int idPromocion;

            try (PreparedStatement stmt = conn.prepareStatement(sqlPromocion, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setDouble(1, porcentaje);
                stmt.setString(2, fechaInicio);
                stmt.setString(3, fechaFin);
                stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idPromocion = rs.getInt(1);
                    } else {
                        conn.rollback();
                        return false;
                    }
                }
            }

            // Then assign to client
            String sqlCliente = "INSERT INTO promocion_cliente (id_cliente, id_promocion) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sqlCliente)) {
                stmt.setInt(1, idCliente);
                stmt.setInt(2, idPromocion);
                int affectedRows = stmt.executeUpdate();

                if (affectedRows > 0) {
                    conn.commit();
                    return true;
                } else {
                    conn.rollback();
                    return false;
                }
            }
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }

    @Override
    public boolean crearPromocionBebida(int idBebida, double porcentaje, String fechaInicio, String fechaFin) throws SQLException {
        Connection conn = null;
        try {
            conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
            conn.setAutoCommit(false);

            // First create the promotion
            String sqlPromocion = "INSERT INTO promocion (porcentaje, fecha_inicio, fecha_fin) VALUES (?, ?, ?)";
            int idPromocion;

            try (PreparedStatement stmt = conn.prepareStatement(sqlPromocion, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setDouble(1, porcentaje);
                stmt.setString(2, fechaInicio);
                stmt.setString(3, fechaFin);
                stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idPromocion = rs.getInt(1);
                    } else {
                        conn.rollback();
                        return false;
                    }
                }
            }

            // Then assign to beverage
            String sqlBebida = "INSERT INTO promocion_bebida (id_bebida, id_promocion) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sqlBebida)) {
                stmt.setInt(1, idBebida);
                stmt.setInt(2, idPromocion);
                int affectedRows = stmt.executeUpdate();

                if (affectedRows > 0) {
                    conn.commit();
                    return true;
                } else {
                    conn.rollback();
                    return false;
                }
            }
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }
}