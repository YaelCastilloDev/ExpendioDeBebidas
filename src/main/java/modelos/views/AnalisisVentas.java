package modelos.views;

public class AnalisisVentas {
    private int idBebida;
    private String bebida;
    private String categoria;
    private int stockActual;
    private int stockMinimo;
    private int clientesUnicos;
    private int totalVendida;
    private double ingresosTotales;
    private String estadoVenta;

    public AnalisisVentas() {
    }

    public AnalisisVentas(int idBebida, String bebida, String categoria, int stockActual, int stockMinimo, int clientesUnicos, int totalVendida, double ingresosTotales, String estadoVenta) {
        this.idBebida = idBebida;
        this.bebida = bebida;
        this.categoria = categoria;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.clientesUnicos = clientesUnicos;
        this.totalVendida = totalVendida;
        this.ingresosTotales = ingresosTotales;
        this.estadoVenta = estadoVenta;
    }

    public int getIdBebida() {
        return idBebida;
    }

    public String getBebida() {
        return bebida;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getStockActual() {
        return stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public int getClientesUnicos() {
        return clientesUnicos;
    }

    public int getTotalVendida() {
        return totalVendida;
    }

    public double getIngresosTotales() {
        return ingresosTotales;
    }

    public String getEstadoVenta() {
        return estadoVenta;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public void setClientesUnicos(int clientesUnicos) {
        this.clientesUnicos = clientesUnicos;
    }

    public void setTotalVendida(int totalVendida) {
        this.totalVendida = totalVendida;
    }

    public void setIngresosTotales(double ingresosTotales) {
        this.ingresosTotales = ingresosTotales;
    }

    public void setEstadoVenta(String estadoVenta) {
        this.estadoVenta = estadoVenta;
    }
}
