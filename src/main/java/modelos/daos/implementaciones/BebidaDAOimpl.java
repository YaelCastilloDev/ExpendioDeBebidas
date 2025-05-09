package modelos.daos.implementaciones;

import modelos.Bebida;
import modelos.daos.contratos.BebidaDAO;
import modelos.views.ResultadoBebidaMenosVendida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BebidaDAOimpl  {


    public List<ResultadoBebidaMenosVendida> obtenerBebidasMenosVendidas(Connection conexion) throws SQLException {
        String consulta = "SELECT nombre, total_vendida FROM Productos_Menos_Vendidos";
        List<ResultadoBebidaMenosVendida> resultados = new ArrayList<>();
        int primerTotalVendido = -1; // Valor inicial

        try (PreparedStatement stmt = conexion.prepareStatement(consulta);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int totalVendido = rs.getInt("total_vendida");

                // Solo capturamos el primer valor de total_vendida
                if (primerTotalVendido == -1) {
                    primerTotalVendido = totalVendido;
                }

                resultados.add(new ResultadoBebidaMenosVendida(nombre, primerTotalVendido));
            }
        }

        return resultados;
    }
}