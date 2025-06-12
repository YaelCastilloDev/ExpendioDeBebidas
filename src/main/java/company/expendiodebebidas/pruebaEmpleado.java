package company.expendiodebebidas;

import modelos.daos.implementaciones.PedidoClienteDAOimpl;
import java.sql.SQLException;
import java.util.List;
import modelos.Pedido_Cliente;

public class pruebaEmpleado {
    public static void main(String[] args) {
        PedidoClienteDAOimpl pedidoDAO = new PedidoClienteDAOimpl();

        try {
            // 1. Crear un nuevo pedido
            int idNuevoPedido = pedidoDAO.crearPedidoCliente(7, "2023-11-15", "PENDIENTE");
            System.out.println("Nuevo pedido creado con ID: " + idNuevoPedido);

            // 2. Agregar detalle al pedido (usando el ID 189 como especificaste)
            boolean detalleAgregado = pedidoDAO.agregarDetallePedido(idNuevoPedido, 3, 2); // Cantidad 2 como ejemplo
            System.out.println("Detalle agregado: " + (detalleAgregado ? "Éxito" : "Fallo"));

            // 3. Buscar pedidos pendientes del cliente 7
            List<Pedido_Cliente> pedidosPendientes = pedidoDAO.buscarPedidosPendientes(7);
            System.out.println("Pedidos pendientes:");
            for (Pedido_Cliente pedido : pedidosPendientes) {
                System.out.println("ID: " + pedido.getId_pedido_cliente() +
                        ", Fecha: " + pedido.getFecha() +
                        ", Estado: " + pedido.getEstado());
            }

            // 4. Entregar pedido (usando ID 189)
            boolean entregado = pedidoDAO.entregarPedido(idNuevoPedido);
            System.out.println("Pedido entregado: " + (entregado ? "Éxito" : "Fallo"));

            // 5. Cancelar pedido (usando ID 189)
            boolean cancelado = pedidoDAO.cancelarPedido(189);
            System.out.println("Pedido cancelado: " + (cancelado ? "Éxito" : "Fallo"));

        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}