package company.expendiodebebidas;

import controladores.PedidoClienteControlador;
import java.sql.SQLException;
import java.util.List;
import modelos.Pedido_Cliente;

public class pruebapedidocliente {
    public static void main(String[] args) {
        PedidoClienteControlador controlador = new PedidoClienteControlador();
        int idClientePrueba = 1;  // Cliente con varios pedidos
        int idPedidoCancelar = 200; // Pedido PENDIENTE
        int idPedidoEntregar = 199; // Pedido PENDIENTE

        try {
            // 1. Prueba buscar pedidos pendientes
            System.out.println("=== Probando buscarPedidosPendientes ===");
            List<Pedido_Cliente> pendientes = controlador.buscarPedidosPendientes(idClientePrueba);
            System.out.println("Pedidos pendientes encontrados: " + pendientes.size());
            if (!pendientes.isEmpty()) {
                System.out.println("Primer pedido pendiente: ID " +
                        pendientes.get(0).getId_pedido_cliente());
            }

            // 2. Prueba cancelarPedido con ID 200
            System.out.println("\n=== Probando cancelarPedido ===");
            boolean resultadoCancelar = controlador.cancelarPedido(idPedidoCancelar);
            System.out.println("Pedido " + idPedidoCancelar +
                    " cancelado: " + (resultadoCancelar ? "Éxito" : "Fallo"));

            // 3. Prueba entregarPedido con ID 199
            System.out.println("\n=== Probando entregarPedido ===");
            boolean resultadoEntregar = controlador.entregarPedido(idPedidoEntregar);
            System.out.println("Pedido " + idPedidoEntregar +
                    " marcado como entregado: " + (resultadoEntregar ? "Éxito" : "Fallo"));

        } catch (SQLException e) {
            System.err.println("Error en la prueba: " + e.getMessage());
            e.printStackTrace();
        }
    }
}