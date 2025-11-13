import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner ingreso = new Scanner(System.in);
    static ArrayList<Producto> productosDB = new ArrayList<>();

    public static void main(String[] args) {
        int opcionElegida;

        System.out.println("===================================");
        System.out.println("     BIENVENIDO A SUPERMARKET 🛒  ");
        System.out.println("      Sistema de Gestión Java      ");
        System.out.println("===================================");

        while (true) {
            mostrarMenu();
            opcionElegida = ingreso.nextInt();
            ingreso.nextLine();

            switch (opcionElegida) {
                case 1 -> agregarProducto();
                case 2 -> listarProductos();
                case 3 -> { //todo:buscarActualizarProducto();
                }
                case 4 -> { //todo:eliminarProducto();
                }
                case 5 -> {
                    System.out.println("Saliendo del sistema...");
                    break;
                }
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú Principal:");
        System.out.println("1) Agregar producto");
        System.out.println("2) Listar productos");
        System.out.println("3) Buscar / Actualizar producto (por ID o nombre)");
        System.out.println("4) Eliminar producto");
        System.out.println("5) Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Opción 1: Agregar producto
    private static void agregarProducto() {
        System.out.println("\n--- Cargar nuevo producto ---");
        System.out.print("Ingrese el nombre: ");
        String nombre = ingreso.nextLine();
        System.out.print("Ingrese el precio: ");
        double precio = ingreso.nextDouble();
        System.out.print("Ingrese la cantidad en stock: ");
        int cantidad = ingreso.nextInt();
        ingreso.nextLine();

        Producto nuevoProducto = new Producto(nombre, precio, cantidad);
        productosDB.add(nuevoProducto);

        System.out.println("✅ Producto creado correctamente!");
        pausa();
    }

    // Opción 2: Listar productos
    private static void listarProductos() {
        System.out.println("\n--- Lista de Productos ---");
        if (productosDB.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto producto : productosDB) {
                System.out.println(producto);
            }
        }
        pausa();
    }

    // Opción 3: Buscar y actualizar producto por ID o nombre
    /*private static void buscarActualizarProducto() {
        System.out.print("Desea buscar por ID o Nombre? (id/nombre): ");
        String opcion = ingreso.nextLine();

        Producto producto = null;

        if (opcion.equalsIgnoreCase("id")) {
            System.out.print("Ingrese el ID del producto: ");
            int id = ingreso.nextInt();
            ingreso.nextLine();

            for (Producto p : productosDB) {
                if (p.getId() == id) {
                    producto = p;
                    break;
                }
            }

        } else if (opcion.equalsIgnoreCase("nombre")) {
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = ingreso.nextLine();

            ArrayList<Producto> encontrados = new ArrayList<>();
            for (Producto p : productosDB) {
                if (p.getNombre().equalsIgnoreCase(nombre)) {
                    encontrados.add(p);
                }
            }

            if (encontrados.isEmpty()) {
                System.out.println("❌ No se encontraron productos con ese nombre.");
                pausa();
                return;
            } else if (encontrados.size() == 1) {
                producto = encontrados.get(0);
            } else {
                System.out.println("Se encontraron varios productos:");
                for (Producto p : encontrados) {
                    System.out.println(p);
                }
                System.out.print("Ingrese el ID del producto que desea actualizar: ");
                int idElegido = ingreso.nextInt();
                ingreso.nextLine();

                for (Producto p : encontrados) {
                    if (p.getId() == idElegido) {
                        producto = p;
                        break;
                    }
                }
            }
        } else {
            System.out.println("Opción inválida.");
            return;
        }

        if (producto != null) {
            System.out.println("Producto seleccionado: " + producto);
            System.out.print("Desea actualizar precio y stock? (s/n): ");
            String respuesta = ingreso.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                System.out.print("Nuevo precio: ");
                double precio = ingreso.nextDouble();
                System.out.print("Nuevo stock: ");
                int stock = ingreso.nextInt();
                ingreso.nextLine();
                producto.setPrecio(precio);
                producto.setStock(stock);
                System.out.println("✅ Producto actualizado!");
            }
        } else {
            System.out.println("❌ Producto no encontrado.");
        }
        pausa();
    }

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

    private static void pausa() {
        System.out.println("\nPulsa ENTER para continuar...");
        ingreso.nextLine();
    }
}
