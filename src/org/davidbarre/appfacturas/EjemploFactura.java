package org.davidbarre.appfacturas;

import org.davidbarre.appfacturas.domain.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNif("555-5");
        cliente.setNombre("David");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una descripcion de la factura: ");
        Facturas factura = new Facturas(scanner.nextLine(), cliente);

        Producto producto;
       /* String nombre;
        Double precio;
        int cantidad;*/

        System.out.println();
        for (int i = 0; i < 2; i++) {
            producto = new Producto();
            System.out.print("Ingrese producto n " + producto.getCodigo() + ": ");
            //  nombre = scanner.nextLine();
            producto.setNombre(scanner.nextLine());

            System.out.print("Ingrese el precio: ");
            //precio = scanner.nextDouble();
            producto.setPrecio(scanner.nextDouble());

            System.out.print("Ingrese la cantidad: ");
            factura.addItemFacturas(new ItemFacturas(scanner.nextInt(), producto));

            System.out.println();
            scanner.nextLine();
        }

        System.out.println(factura);
    }
}
