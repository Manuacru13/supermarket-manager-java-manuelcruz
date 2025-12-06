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
                case 5: Metodos.crearPedido();
                    break;
                case 6: Metodos.listarPedidos();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    System.out.println("Gracias por usar SuperMarket Manager Java");
                    break menu;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }

}
