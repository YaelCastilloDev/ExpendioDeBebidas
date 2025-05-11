package modelos.views;

import java.math.BigDecimal;

// se usa para las views: "Ventas_Por_Producto"
public class VentaPorProducto {
    private String producto;
    private int cantidadVendida;  // Cambiado a int
    private BigDecimal totalVentas;

    public VentaPorProducto() {
    }

    public VentaPorProducto(String producto, int cantidadVendida, BigDecimal totalVentas) {
        this.producto = producto;
        this.cantidadVendida = cantidadVendida;
        this.totalVentas = totalVentas;
    }

    // Getters y Setters
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public BigDecimal getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(BigDecimal totalVentas) {
        this.totalVentas = totalVentas;
    }

    @Override
    public String toString() {
        return "VentaPorProducto{" +
                "producto='" + producto + '\'' +
                ", cantidadVendida=" + cantidadVendida +
                ", totalVentas=" + totalVentas +
                '}';
    }
}