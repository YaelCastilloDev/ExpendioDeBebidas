package controladores;

import modelos.Compra;
import modelos.daos.contratos.CompraDAO;
import modelos.daos.implementaciones.CompraDAOimpl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Random;

public class CompraControlador {
    private final CompraDAO compraDAO;

    public CompraControlador() {
        this.compraDAO = new CompraDAOimpl();
    }

    public Compra completarPedidoProveedor(int idPedidoProveedor, String folioFactura)
            throws SQLException, IllegalArgumentException {
        // Input validation
        if (idPedidoProveedor <= 0) {
            throw new IllegalArgumentException("ID de pedido a proveedor inválido");
        }
        if (folioFactura == null || folioFactura.trim().isEmpty()) {
            throw new IllegalArgumentException("El folio de factura no puede estar vacío");
        }

        return compraDAO.completarPedidoProveedor(idPedidoProveedor, folioFactura.trim());
    }

    public Compra crearYCompletarCompra(int idBebida, int cantidadPedida, String rfcProveedor)
            throws SQLException, IllegalArgumentException {
        // Input validation
        if (idBebida <= 0) {
            throw new IllegalArgumentException("ID de bebida inválido");
        }
        if (cantidadPedida <= 0) {
            throw new IllegalArgumentException("La cantidad pedida debe ser mayor a cero");
        }

        String folio = "C" + String.format("%010d", new Random().nextInt(1_000_000_000));

        return compraDAO.completarPedidoProveedor(idBebida, cantidadPedida, rfcProveedor, folio);
    }


    public Compra obtenerCompraPorId(String folio) throws SQLException, IllegalArgumentException {
        if (folio == null || folio.isEmpty()) {
            throw new IllegalArgumentException("ID de compra inválido");
        }
        return compraDAO.obtenerCompraPorId(folio);
    }


}