package com.msmartbuy.modelo;

public class Producto {
    private long id;
    private String nombre;
    private String marca;
    private String cantidad;
    private String descripcion;
    private String sku;
    private String peso;
    private double precioUnitario;
    private String estado;

    // Constructor vacío
    public Producto() {}

    // Constructor lleno
    public Producto(long id, String nombre, String marca, String cantidad, String descripcion, String sku, String peso, double precioUnitario, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.sku = sku;
        this.peso = peso;
        this.precioUnitario = precioUnitario;
        this.estado = estado;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getSku() {
    return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
    
    public String getPeso() {
    return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
