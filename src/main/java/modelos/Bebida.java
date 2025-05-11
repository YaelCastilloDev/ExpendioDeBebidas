package modelos;

import jakarta.validation.constraints.*;
import java.io.Serializable;

public class Bebida {
    @NotNull(message = "Precio no puede ser nulo")
    @Positive(message = "Precio debe ser positivo")
    private Double precio_unitario;
    
    @NotNull(message = "Stock mínimo no puede ser nulo")
    @Min(value = 0, message = "Stock mínimo no puede ser negativo")
    private Integer stock_minimo;
    
    @NotNull(message = "Stock actual no puede ser nulo")
    @Min(value = 0, message = "Stock actual no puede ser negativo")
    private Integer stock_actual;
    
    @NotBlank(message = "Nombre no puede estar vacío")
    @Size(max = 20, message = "El nombre no debe exceder los 20 caracteres")
    private String nombre;
    
    @NotNull(message = "Tamaño no puede ser nulo")
    @Positive(message = "Tamaño debe ser positivo")
    private Integer tamaño;
    
    @NotBlank(message = "Categoría no puede estar vacía")
    private String categoria;

    public Bebida() {}

    public Double getPrecio_unitario() { return precio_unitario; }
    public void setPrecio_unitario(Double precio_unitario) { this.precio_unitario = precio_unitario; }
    public Integer getStock_minimo() { return stock_minimo; }
    public void setStock_minimo(Integer stock_minimo) { this.stock_minimo = stock_minimo; }
    public Integer getStock_actual() { return stock_actual; }
    public void setStock_actual(Integer stock_actual) { this.stock_actual = stock_actual; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getTamaño() { return tamaño; }
    public void setTamaño(Integer tamaño) { this.tamaño = tamaño; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return "Bebida{" +
                "nombre='" + nombre + '\'' +
                ", precio_unitario=" + precio_unitario +
                ", stock_actual=" + stock_actual +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}