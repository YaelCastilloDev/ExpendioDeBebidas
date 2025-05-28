package modelos.daos.implementaciones;

import modelos.conexiones.UsuarioFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromocionDAOimpl {

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
}