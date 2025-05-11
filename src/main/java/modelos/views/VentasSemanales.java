package modelos.views;

import java.math.BigDecimal;

public class VentasSemanales {
    private Integer año;
    private Integer semana;
    private BigDecimal totalSemanal;
    private Long cantidadVentas;

    // Constructor
    public VentasSemanales() {
    }

    public VentasSemanales(Integer año, Integer semana, BigDecimal totalSemanal, Long cantidadVentas) {
        this.año = año;
        this.semana = semana;
        this.totalSemanal = totalSemanal;
        this.cantidadVentas = cantidadVentas;
    }

    // Getters y Setters
    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public Integer getSemana() {
        return semana;
    }

    public void setSemana(Integer semana) {
        this.semana = semana;
    }

    public BigDecimal getTotalSemanal() {
        return totalSemanal;
    }

    public void setTotalSemanal(BigDecimal totalSemanal) {
        this.totalSemanal = totalSemanal;
    }

    public Long getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(Long cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    @Override
    public String toString() {
        return "VentasSemanales{" +
                "año=" + año +
                ", semana=" + semana +
                ", totalSemanal=" + totalSemanal +
                ", cantidadVentas=" + cantidadVentas +
                '}';
    }
}