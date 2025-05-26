package modelos;

import java.util.Date;

public class Venta {
    private int idVenta;
    private String folio;
    private Date fecha;
    private int idPedidoCliente;

    // Constructors
    public Venta() {}

    public Venta(int idVenta, String folio, Date fecha, int idPedidoCliente) {
        this.idVenta = idVenta;
        this.folio = folio;
        this.fecha = fecha;
        this.idPedidoCliente = idPedidoCliente;
    }

    // Getters and Setters
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdPedidoCliente() {
        return idPedidoCliente;
    }

    public void setIdPedidoCliente(int idPedidoCliente) {
        this.idPedidoCliente = idPedidoCliente;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", folio='" + folio + '\'' +
                ", fecha=" + fecha +
                ", idPedidoCliente=" + idPedidoCliente +
                '}';
    }
}