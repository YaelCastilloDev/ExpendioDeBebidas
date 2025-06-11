package modelos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Compra {
    private int idCompra;
    private String folio;
    private LocalDate fecha;
    private BigDecimal total;
    private int idPedidoProveedor;

    // Constructors
    public Compra() {}

    public Compra(String folio, LocalDate fecha, BigDecimal total, int idPedidoProveedor) {
        this.folio = folio;
        this.fecha = fecha;
        this.total = total;
        this.idPedidoProveedor = idPedidoProveedor;
    }

    // Getters and Setters
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getIdPedidoProveedor() {
        return idPedidoProveedor;
    }

    public void setIdPedidoProveedor(int idPedidoProveedor) {
        this.idPedidoProveedor = idPedidoProveedor;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "idCompra=" + idCompra +
                ", folio='" + folio + '\'' +
                ", fecha=" + fecha +
                ", total=" + total +
                ", idPedidoProveedor=" + idPedidoProveedor +
                '}';
    }
}