package modelos;

import jakarta.validation.constraints.*;
import java.io.Serializable;

public class Empleado {
    
        private int id; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @NotBlank(message = "Nombre no puede estar vacío")
    @Size(max = 45, message = "El nombre no debe exceder los 45 caracteres")
    private String nombre;
    
    @NotBlank(message = "Contraseña no puede estar vacía")
    @Size(min = 6, max = 25, message = "La contraseña debe tener entre 6 y 25 caracteres")
    private String contraseña;
    
    @NotBlank(message = "Email no puede estar vacío")
    @Email(message = "Formato de email inválido")
    @Size(max = 30, message = "El email no debe exceder los 30 caracteres")
    private String email;

    public Empleado() {}

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}