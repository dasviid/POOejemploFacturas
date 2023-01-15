package org.davidbarre.appfacturas.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Facturas {
    //constantes
    public static final int MAX_ITEMS = 10;
    private static int ultimoFolio;
    // atributos de la clase
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFacturas[] items;
    private int indiceItems;

    //constructor


    public Facturas(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFacturas[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    // get and set
    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFacturas[] getItems() {
        return items;
    }

    // metodos de la clase
    public void addItemFacturas(ItemFacturas item) {
        if (indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (int i = 0; i < indiceItems; i++) {
            total += this.items[i].calculaImporte();
        }
        return total;
    }

    public String generarDetalle() {
        SimpleDateFormat df = new SimpleDateFormat("dd MMMM yyyy");
        StringBuilder sb = new StringBuilder("Factura N:" + folio);
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\nDescripcion: ")
                .append(this.descripcion)
                .append("\n")
                .append("Fecha emision: ").append(df.format(this.fecha))
                .append("\n")
                .append("\n#\t\t\tNombre\t\t\t$\t\t\tCant.\t\t\tTotal\n");

        sb.append("\n");

        for (int i = 0; i < indiceItems; i++) {
            sb.append(this.items[i].toString()).append("\n");

        }
        sb.append("\nGran total: ")
                .append(calcularTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
