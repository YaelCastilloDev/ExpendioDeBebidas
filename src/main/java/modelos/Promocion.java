package modelos;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

public class Promocion  {
    
    private int id; 

    @NotNull(message = "Porcentaje no puede ser nulo")
    @DecimalMin(value = "0.0", message = "Porcentaje no puede ser negativo")
    @DecimalMax(value = "100.0", message = "Porcentaje no puede ser mayor a 100")
    private Double porcentaje;

    @NotNull(message = "Fecha inicio no puede ser nula")
    @Future(message = "La fecha de inicio debe ser una fecha futura")
    private Date fecha_inicio;

    @Future(message = "La fecha de fin debe ser una fecha futura")
    private Date fecha_fin;

    public Promocion() {}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    // Getters y Setters
    public Double getPorcentaje() { return porcentaje; }
    public void setPorcentaje(Double porcentaje) { this.porcentaje = porcentaje; }

    public Date getFecha_inicio() { return fecha_inicio; }
    public void setFecha_inicio(Date fecha_inicio) { this.fecha_inicio = fecha_inicio; }

    public Date getFecha_fin() { return fecha_fin; }
    public void setFecha_fin(Date fecha_fin) { this.fecha_fin = fecha_fin; }

    @Override
    public String toString() {
        return "Promocion{" +
                "porcentaje=" + porcentaje +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                '}';
    }
}
