package modelos.views;

// se usa para las views: ""
public class EstadisticaVentaProductos {
    private String nombre;
    private int totalVendido;

    // Constructor
    public EstadisticaVentaProductos(String nombre, int totalVendido) {
        this.nombre = nombre;
        this.totalVendido = totalVendido;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getTotalVendido() {
        return totalVendido;
    }
}
