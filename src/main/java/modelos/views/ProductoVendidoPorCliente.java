package modelos.views;

public class ProductoVendidoPorCliente {
    private int idBebida;
    private String nombreBebida;
    private int idCliente;
    private String nombreCliente;
    private String paterno;
    private String materno;
    private String email;

    public ProductoVendidoPorCliente() {
    }

    public ProductoVendidoPorCliente(int idBebida, String nombreBebida, int idCliente, String nombreCliente, String paterno, String materno, String email) {
        this.idBebida = idBebida;
        this.nombreBebida = nombreBebida;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.paterno = paterno;
        this.materno = materno;
        this.email = email;
    }

    public int getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }

    public String getNombreBebida() {
        return nombreBebida;
    }

    public void setNombreBebida(String nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
