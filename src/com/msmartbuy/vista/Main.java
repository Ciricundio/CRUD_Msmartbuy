package com.msmartbuy.vista;

import com.msmartbuy.dao.ProductoDAO;
import com.msmartbuy.modelo.Producto;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductoDAO productoDAO = new ProductoDAO();
        int opcion;

        do {
            System.out.println("Menú de Gestión de Productos");
            System.out.println("1. Insertar Producto");
            System.out.println("2. Listar Productos");
            System.out.println("3. Actualizar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Insertar Producto
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Cantidad: ");
                    String cantidad = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("SKU: ");
                    String sku = scanner.nextLine();
                    System.out.print("peso: ");
                    String peso = scanner.nextLine();
                    System.out.print("Precio Unitario: ");
                    double precioUnitario = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Estado: ");
                    String estado = scanner.nextLine();


                    Producto nuevoProducto = new Producto(0, nombre, marca, cantidad, descripcion, sku, peso, precioUnitario, estado);
                    productoDAO.insertarProducto(nuevoProducto);
                    System.out.println("Producto insertado con éxito.");
                    break;

                case 2:
                    // Listar Productos
                    List<Producto> productos = productoDAO.listarProductos();
                    for (Producto producto : productos) {
                        System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Marca: " + producto.getMarca() + ", Precio: " + producto.getPrecioUnitario());
                    }
                    break;

                case 3:
                    // Actualizar Producto
                    System.out.print("ID del Producto a actualizar: ");
                    long idActualizar = scanner.nextLong();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Nuevo Nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nueva Marca: ");
                    String nuevaMarca = scanner.nextLine();
                    System.out.print("Nueva Cantidad: ");
                    String nuevaCantidad = scanner.nextLine();
                    System.out.print("Nueva Descripción: ");
                    String nuevaDescripcion = scanner.nextLine();
                    System.out.print("Nueva Sku: ");
                    String nuevaSku = scanner.nextLine();
                    System.out.print("Nuevo peso: ");
                    String nuevoPeso = scanner.nextLine();
                    System.out.print("Nuevo Precio Unitario: ");
                    double nuevoPrecioUnitario = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Nuevo Estado: ");
                    String nuevoEstado = scanner.nextLine();

                    Producto productoActualizar = new Producto(idActualizar, nuevoNombre, nuevaMarca, nuevaCantidad, nuevaDescripcion, nuevaSku, nuevoPeso, nuevoPrecioUnitario, nuevoEstado);
                    productoDAO.actualizarProducto(productoActualizar);
                    System.out.println("Producto actualizado con éxito.");
                    break;

                case 4:
                    // Eliminar Producto
                    System.out.print("ID del Producto a eliminar: ");
                    long idEliminar = scanner.nextLong();
                    productoDAO.eliminarProducto(idEliminar);
                    System.out.println("Producto eliminado con éxito.");
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
