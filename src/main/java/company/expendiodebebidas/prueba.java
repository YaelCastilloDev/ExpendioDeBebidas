package company.expendiodebebidas;

import controladores.VentaControlador;
import java.sql.SQLException;
import java.time.LocalDate;

public class prueba {
    public static void main(String[] args) {
        VentaControlador controlador = new VentaControlador();

        try {
            // Example data - replace with your actual test data
            int idCliente = 1;
            String fecha = "2023-12-15"; // Format: yyyy-MM-dd
            String estado = "PENDIENTE";
            int idBebida = 5;
            int cantidad = 2;
            String folioVenta = "FOLIO123";

            // Process the order
            var venta = controlador.procesarPedido(idCliente, fecha, estado,
                    idBebida, cantidad, folioVenta);

            // Print the Venta object
            System.out.println("Venta creada:");
            System.out.println("ID Venta: " + venta.getIdVenta());
            System.out.println("Folio: " + venta.getFolio());
            System.out.println("Fecha: " + venta.getFecha());
            System.out.println("ID Pedido Cliente: " + venta.getIdPedidoCliente());

        } catch (SQLException e) {
            System.err.println("Error al procesar el pedido:");
            e.printStackTrace();
        }
    }
}