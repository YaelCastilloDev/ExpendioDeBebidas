package modelos.views;

import java.math.BigDecimal;

public class VentasMensuales {
    private Integer año;
    private Integer mes;
    private BigDecimal totalMensual;
    private long cantidadVentas;  // long (no Long) para evitar null y forzar positivo

    public VentasMensuales() {
    }
    
    // Constructor
    public VentasMensuales(Integer año, Integer mes, BigDecimal totalMensual, long cantidadVentas) {
        setAño(año);
        setMes(mes);
        setTotalMensual(totalMensual);
        setCantidadVentas(cantidadVentas);  // Valida que sea positivo
    }

    // Getters
    public Integer getAño() {
        return año;
    }

    public Integer getMes() {
        return mes;
    }

    public BigDecimal getTotalMensual() {
        return totalMensual;
    }

    public long getCantidadVentas() {
        return cantidadVentas;
    }

    // Setters con validaciones
    public void setAño(Integer año) {
        this.año = año;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public void setTotalMensual(BigDecimal totalMensual) {
        this.totalMensual = totalMensual;
    }


    public void setCantidadVentas(long cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }
}