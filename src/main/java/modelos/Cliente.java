package modelos;

import jakarta.validation.constraints.*;

public class Cliente {
    
    private int id; 

    @NotBlank(message = "Nombre no puede estar vacío")
    @Size(max = 25, message = "El nombre no debe exceder los 25 caracteres")
    private String nombre;
    
    @NotBlank(message = "Apellido paterno no puede estar vacío")
    @Size(max = 15, message = "El apellido paterno no debe exceder los 15 caracteres")
    private String paterno;
    
    @Size(max = 15, message = "El apellido materno no debe exceder los 15 caracteres")
    private String materno;
    
    @Email(message = "Formato de email inválido")
    @Size(max = 30, message = "El email no debe exceder los 30 caracteres")
    private String email;
    
    @NotBlank(message = "Teléfono no puede estar vacío")
    @Size(min = 10, max = 10, message = "Teléfono debe tener 10 caracteres")
    private String telefono;
    
    // @Size(min = 12, max = 13, message = "RFC debe tener entre 12 y 13 caracteres")
    private String rfc;
    
    @Digits(integer = 5, fraction = 0, message = "Código postal debe tener 5 dígitos")
    private Integer codigo_postal;
    
    @Size(max = 30, message = "Colonia no debe exceder 30 caracteres")
    private String colonia;
    
    @Size(max = 25, message = "Ciudad no debe exceder 25 caracteres")
    private String ciudad;
    
    @Size(max = 20, message = "Estado no debe exceder 20 caracteres")
    private String estado;

    public Cliente() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getPaterno() { return paterno; }
    public void setPaterno(String paterno) { this.paterno = paterno; }
    public String getMaterno() { return materno; }
    public void setMaterno(String materno) { this.materno = materno; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }
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
        return String.format("%s %s %s", nombre, paterno, materno);
    }
}