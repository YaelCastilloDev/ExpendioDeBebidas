package modelos.views;


public class ResultadoBebidaMenosVendida {
    private String nombre;
    private int totalVendido;

    // Constructor
    public ResultadoBebidaMenosVendida(String nombre, int totalVendido) {
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
