package company.expendiodebebidas;

import modelos.daos.implementaciones.PedidoClienteDAOimpl;
import java.sql.SQLException;

public class prueba {
    public static void main(String[] args) {
        PedidoClienteDAOimpl pedidoDAO = new PedidoClienteDAOimpl();

        try {
            // 1. Crear un nuevo pedido
            int idPedido = pedidoDAO.crearPedidoCliente(
                    1,                      // ID del cliente
                    "2023-12-15",           // Fecha del pedido
                    "PENDIENTE"             // Estado del pedido
            );
            System.out.println("Pedido creado con ID: " + idPedido);

            // 2. Añadir primer detalle al pedido
            boolean detalle1 = pedidoDAO.agregarDetallePedido(
                    idPedido,               // ID del pedido recién creado
                    1,                      // ID de la primera bebida
                    2                       // Cantidad de la primera bebida
            );
            System.out.println("Primer detalle añadido: " + (detalle1 ? "Éxito" : "Fallo"));

            // 3. Añadir segundo detalle al pedido
            boolean detalle2 = pedidoDAO.agregarDetallePedido(
                    idPedido,               // Mismo ID de pedido
                    8,                      // ID de la segunda bebida
                    3                       // Cantidad de la segunda bebida
            );
            System.out.println("Segundo detalle añadido: " + (detalle2 ? "Éxito" : "Fallo"));

        } catch (SQLException e) {
            System.err.println("Error al procesar el pedido:");
            e.printStackTrace();
        }
    }
}