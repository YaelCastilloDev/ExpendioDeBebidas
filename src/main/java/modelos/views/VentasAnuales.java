package modelos.views;

import java.math.BigDecimal;

public class VentasAnuales {
    private Integer año;
    private BigDecimal totalAnual;
    private Long cantidadVentas;

    // Constructor
    public VentasAnuales() {
    }

    public VentasAnuales(Integer año, BigDecimal totalAnual, Long cantidadVentas) {
        this.año = año;
        this.totalAnual = totalAnual;
        this.cantidadVentas = cantidadVentas;
    }

    // Getters y Setters
    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public BigDecimal getTotalAnual() {
        return totalAnual;
    }

    public void setTotalAnual(BigDecimal totalAnual) {
        this.totalAnual = totalAnual;
    }

    public Long getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(Long cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    @Override
    public String toString() {
        return "VentasAnuales{" +
                "año=" + año +
                ", totalAnual=" + totalAnual +
                ", cantidadVentas=" + cantidadVentas +
                '}';
    }
}