package modelos.views;

public class StockProductos {
    private int idBebida;
    private String nombreBebida;
    private int stockMinimo;
    private int stockActual;

    public StockProductos() {
    }

    public StockProductos(int idBebida, String nombreBebida, int stockMinimo, int stockActual) {
        this.idBebida = idBebida;
        this.nombreBebida = nombreBebida;
        this.stockMinimo = stockMinimo;
        this.stockActual = stockActual;
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

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }
}
