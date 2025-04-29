package modelos.daos.implementaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BebidaDAOimpl {
    
    public List<String> obtenerNombresBebidasMenosVendidas(Connection conexion) throws SQLException {
        String consulta = "SELECT producto FROM Productos_Menos_Vendidos";
        List<String> nombresBebidas = new ArrayList<>();

        try (PreparedStatement stmt = conexion.prepareStatement(consulta);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                String nombre = rs.getString("producto");
                nombresBebidas.add(nombre);
            }
        }

        return nombresBebidas;
    }
}