import java.util.Scanner;

public class Main {

    static Scanner ingreso = new Scanner(System.in);

    public static void main(String[] args) {
        int opcionElegida;

        System.out.println("===================================");
        System.out.println("     BIENVENIDO A SUPERMARKET 🛒  ");
        System.out.println("      Sistema de Gestión Java      ");
        System.out.println("===================================");

        menu:
        while (true) {
            Metodos.mostrarMenu();
            opcionElegida = ingreso.nextInt();

            switch (opcionElegida) {
                case 1: Metodos.agregarProducto();
                break;
                case 2: Metodos.listarProductos();
                break;
                case 3: Metodos.buscarActualizarProducto();
                break;
                case 4: Metodos.eliminarProducto();
                break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    System.out.println("Gracias por usar SuperMarket Manager Java");
                    break menu;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
                }
        }
    }

/*
    // Opción 4: Eliminar producto
    private static void eliminarProducto() {
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = ingreso.nextInt();
        ingreso.nextLine();

        Producto producto = null;
        for (Producto p : productosDB) {
            if (p.getId() == id) {
                producto = p;
                break;
            }
        }

        if (producto != null) {
            productosDB.remove(producto);
            System.out.println("✅ Producto eliminado correctamente.");
        } else {
            System.out.println("❌ Producto no encontrado.");
        }
        pausa();
    }*/


}
