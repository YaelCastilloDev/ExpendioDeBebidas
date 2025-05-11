package modelos.daos.implementaciones;

import modelos.views.EstadisticaVentaProductos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BebidaDAOimpl  {


    public List<EstadisticaVentaProductos> obtenerBebidasMenosVendidas(Connection conexion) throws SQLException {
        String consulta = "SELECT nombre, total_vendida FROM Productos_Menos_Vendidos";
        List<EstadisticaVentaProductos> resultados = new ArrayList<>();

        try (PreparedStatement stmt = conexion.prepareStatement(consulta);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int totalVendido = rs.getInt("total_vendida");


                resultados.add(new EstadisticaVentaProductos(nombre, totalVendido));
            }
        }

        return resultados;
    }

    public List<EstadisticaVentaProductos> obtenerBebidasMasVendidas(Connection conexion) throws SQLException {
        String consulta = "SELECT nombre, total_vendida FROM Productos_Mas_Vendidos";
        List<EstadisticaVentaProductos> resultados = new ArrayList<>();

        try (PreparedStatement stmt = conexion.prepareStatement(consulta);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int totalVendido = rs.getInt("total_vendida");

                resultados.add(new EstadisticaVentaProductos(nombre, totalVendido));
            }
        }

        return resultados;
    }
}