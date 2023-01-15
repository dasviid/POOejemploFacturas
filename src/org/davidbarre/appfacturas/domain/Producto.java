package org.davidbarre.appfacturas.domain;

public class Producto {

    private Integer codigo;
    private String nombre;
    private Double precio;
    private static int ultimoCodigo;

    public Producto() {
        this.codigo = ++ultimoCodigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return codigo +
                "\t" + nombre +
                "\t" + precio;
    }
}
