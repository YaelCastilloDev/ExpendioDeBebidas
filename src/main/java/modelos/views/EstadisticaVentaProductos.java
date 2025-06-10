package modelos.views;

// se usa para las views: ""
public class EstadisticaVentaProductos {
    private int idBebida;
    private String nombreBebida;
    private int totalVendido;
    private int cantidadVendida;

    public EstadisticaVentaProductos(String nombreBebida, int totalVendido) {
        this.nombreBebida = nombreBebida;
        this.totalVendido = totalVendido;
    }

    public EstadisticaVentaProductos(){

    }

    // Constructor
    public EstadisticaVentaProductos(int idBebida, String nombreBebida, int totalVendido, int cantidadVendida) {
        this.idBebida = idBebida;
        this.nombreBebida = nombreBebida;
        this.totalVendido = totalVendido;
        this.cantidadVendida = cantidadVendida;
    }

    // Getters
    public String getNombreBebida() {
        return nombreBebida;
    }

    public int getTotalVendido() {
        return totalVendido;
    }

    public int getIdBebida() {
        return idBebida;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }

    public void setNombreBebida(String nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    public void setTotalVendido(int totalVendido) {
        this.totalVendido = totalVendido;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }
}
