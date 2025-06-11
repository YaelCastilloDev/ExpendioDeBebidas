package modelos.views;

import java.math.BigDecimal;

public class StockEstado {
    private int idBebida;
    private String nombre;
    private String categoria;
    private int tamaño;
    private int stockActual;
    private int stockMinimo;
    private BigDecimal precioUnitario;
    private int deficitStock;
    private String estadoStock;

    // Constructor
    public StockEstado(int idBebida, String nombre, String categoria, int tamaño,
                       int stockActual, int stockMinimo, BigDecimal precioUnitario,
                       int deficitStock, String estadoStock) {
        this.idBebida = idBebida;
        this.nombre = nombre;
        this.categoria = categoria;
        this.tamaño = tamaño;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.precioUnitario = precioUnitario;
        this.deficitStock = deficitStock;
        this.estadoStock = estadoStock;
    }

    // Getters
    public int getIdBebida() {
        return idBebida;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getTamaño() {
        return tamaño;
    }

    public int getStockActual() {
        return stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public int getDeficitStock() {
        return deficitStock;
    }

    public String getEstadoStock() {
        return estadoStock;
    }

    @Override
    public String toString() {
        return "StockEstado{" +
                "idBebida=" + idBebida +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", tamaño=" + tamaño +
                ", stockActual=" + stockActual +
                ", stockMinimo=" + stockMinimo +
                ", precioUnitario=" + precioUnitario +
                ", deficitStock=" + deficitStock +
                ", estadoStock='" + estadoStock + '\'' +
                '}';
    }
}