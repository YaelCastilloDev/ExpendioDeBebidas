package modelos;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido_Cliente {
    private int id_pedido_cliente;

    @NotNull(message = "La fecha no puede ser nula")
    private LocalDate fecha;

    @DecimalMin(value = "0.00", message = "El total no puede ser negativo")
    @Digits(integer = 10, fraction = 2, message = "El total debe tener máximo 2 decimales")
    private BigDecimal total;

    @NotBlank(message = "El estado no puede estar vacío")
    private String estado;

    private int id_cliente;

    // Constructor vacío
    public Pedido_Cliente() {}

    // Constructor con parámetros
    public Pedido_Cliente(int id_pedido_cliente, LocalDate fecha, BigDecimal total,
                          String estado, int id_cliente) {
        this.id_pedido_cliente = id_pedido_cliente;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
        this.id_cliente = id_cliente;
    }

    // Getters y Setters
    public int getId_pedido_cliente() {
        return id_pedido_cliente;
    }

    public void setId_pedido_cliente(int id_pedido_cliente) {
        this.id_pedido_cliente = id_pedido_cliente;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "Pedido_Cliente{" +
                "id_pedido_cliente=" + id_pedido_cliente +
                ", fecha=" + fecha +
                ", total=" + total +
                ", estado='" + estado + '\'' +
                ", id_cliente=" + id_cliente +
                '}';
    }
}