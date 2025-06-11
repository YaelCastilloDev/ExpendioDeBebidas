package modelos.daos.implementaciones;

import modelos.conexiones.UsuarioFactory;
import modelos.daos.contratos.PromocionDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelos.Promocion;

public class PromocionDAOimpl implements PromocionDAO{

    @Override
    public List<Promocion> obtenerPromocionesPorBebida(int idBebida) throws SQLException {
        String sql = "SELECT pb.id_promocion, p.porcentaje, p.fecha_inicio, p.fecha_fin "
                + "FROM Promocion_Bebida pb JOIN promocion p ON  pb.id_promocion = p.id_promocion "
                + "WHERE pb.id_bebida = ?";
        List<Promocion> promociones = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idBebida);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Promocion promocion = new Promocion();
                    promocion.setId(rs.getInt("id_promocion"));
                    promocion.setPorcentaje(rs.getDouble("porcentaje"));
                    promocion.setFecha_inicio(rs.getDate("fecha_inicio"));
                    promocion.setFecha_fin(rs.getDate("fecha_fin"));
                    promociones.add(promocion);
                }
            }
        }
        return promociones;
    }
    
    @Override
    public List<Promocion> obtenerPromocionesPorCliente(int idCliente) throws SQLException {
        String sql = "SELECT pc.id_promocion, p.porcentaje, p.fecha_inicio, p.fecha_fin "
                + "FROM Promocion_Cliente pc JOIN promocion p ON pc.id_promocion = p.id_promocion "
                + "WHERE pc.id_cliente = ?";
        List<Promocion> promociones = new ArrayList<>();

        try (Connection conn = UsuarioFactory.obtenerConexion(UsuarioFactory.TipoUsuario.ADMIN);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Promocion promocion = new Promocion();
                    promocion.setId(rs.getInt("id_promocion"));
                    promocion.setPorcentaje(rs.getDouble("porcentaje"));
                    promocion.setFecha_inicio(rs.getDate("fecha_inicio"));
                    promocion.setFecha_fin(rs.getDate("fecha_fin"));
                    promociones.add(promocion);
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