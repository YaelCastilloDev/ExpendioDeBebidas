package modelos;

import jakarta.validation.constraints.*;
import java.io.Serializable;

public class Proveedor implements Serializable{
    @NotBlank(message = "RFC no puede estar vacío")
    @Size(min = 12, max = 13, message = "RFC debe tener entre 12 y 13 caracteres")
    private String rfc;
    
    @NotBlank(message = "Razón social no puede estar vacía")
    @Size(max = 25, message = "Razón social no debe exceder 25 caracteres")
    private String razon_social;
    
    @NotBlank(message = "Teléfono no puede estar vacío")
    @Size(min = 10, max = 10, message = "Teléfono debe tener 10 caracteres")
    private String telefono;
    
    @NotBlank(message = "Email no puede estar vacío")
    @Email(message = "Formato de email inválido")
    @Size(max = 30, message = "El email no debe exceder los 30 caracteres")
    private String email;
    
    @NotNull(message = "Código postal no puede ser nulo")
    @Digits(integer = 5, fraction = 0, message = "Código postal debe tener 5 dígitos")
    private Integer codigo_postal;
    
    @NotBlank(message = "Colonia no puede estar vacía")
    @Size(max = 30, message = "Colonia no debe exceder 30 caracteres")
    private String colonia;
    
    @NotBlank(message = "Ciudad no puede estar vacía")
    @Size(max = 25, message = "Ciudad no debe exceder 25 caracteres")
    private String ciudad;
    
    @NotBlank(message = "Estado no puede estar vacío")
    @Size(max = 20, message = "Estado no debe exceder 20 caracteres")
    private String estado;

    public Proveedor() {}

    // Getters y Setters
    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }
    public String getRazon_social() { return razon_social; }
    public void setRazon_social(String razon_social) { this.razon_social = razon_social; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Integer getCodigo_postal() { return codigo_postal; }
    public void setCodigo_postal(Integer codigo_postal) { this.codigo_postal = codigo_postal; }
    public String getColonia() { return colonia; }
    public void setColonia(String colonia) { this.colonia = colonia; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Proveedor{" +
                "rfc='" + rfc + '\'' +
                ", razon_social='" + razon_social + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}