import java.util.ArrayList;
import java.util.Scanner;


public class Metodos {
    static ArrayList<Producto> productosDB = new ArrayList<>();
    static Scanner ingreso = new Scanner(System.in);

    public static void mostrarMenu() {
        System.out.println("\nMenú Principal:");
        System.out.println("1) Agregar producto");
        System.out.println("2) Listar productos");
        System.out.println("3) Buscar / Actualizar producto (por ID o nombre)");
        System.out.println("4) Eliminar producto");
        System.out.println("5) Salir");
        System.out.print("Seleccione una opción: ");

    }

    public static void pausa() {
        System.out.println("\nPulsa ENTER para continuar...");
        ingreso.nextLine();
    }

    // Opción 1: Agregar producto
    public static void agregarProducto() {
        System.out.println("\n--- Cargar nuevo producto ---");
        System.out.print("Ingrese el nombre: ");
        String nombre = ingreso.nextLine();
        System.out.print("Ingrese el precio: ");
        double precio = ingreso.nextDouble();
        System.out.print("Ingrese la cantidad en stock: ");
        int cantidad = ingreso.nextInt();

        Producto nuevoProducto = new Producto(nombre, precio, cantidad);
        productosDB.add(nuevoProducto);

        System.out.println("\n✅ Producto creado correctamente!");
        pausa();
    }

    // Opción 2: Listar productos
    public static void listarProductos() {
        System.out.println("\n--- Lista de Productos ---");
        if (productosDB.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto producto : productosDB) {
                System.out.println("ID: "+producto.getId()+" | Nombre: "+producto.getNombre()+
                        " | Precio: "+producto.getPrecio()+" | Stock: "+producto.getCantidad());
            }
            pausa();
        }


    }

    // Opción 3: Buscar y actualizar producto por ID o nombre
    public static void buscarActualizarProducto() {
        System.out.print("Desea buscar por ID o Nombre? (Ingrese 1 para id o 2 para nombre): ");
        int opcion = ingreso.nextInt();
        ingreso.nextLine();

        Producto pEncontrado = null;

        if (opcion == 1) {
            System.out.print("Ingrese el ID del producto: ");
            int id = ingreso.nextInt();
            ingreso.nextLine();

            for (Producto p : productosDB) {
                if (p.getId() == id) {
                    pEncontrado = p;
                    break;
                }
            }

        } else if (opcion == 2) {
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
                return;
            } else if (encontrados.size() == 1) {
                pEncontrado = encontrados.get(0);
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
                        pEncontrado = p;
                        break;
                    }
                }
            }
        } else {
            System.out.println("Opción inválida.");
            return;
        }

        if (pEncontrado != null) {
            System.out.println("Producto seleccionado: " + pEncontrado
            );
            System.out.print("Desea actualizar precio y stock? (s/n): ");
            String respuesta = ingreso.nextLine();
            int nuevostock = 0;
            double nuevoPrecio = 0;
            do {
                if (respuesta.equalsIgnoreCase("s")) {
                    System.out.print("Nuevo precio: ");
                    nuevoPrecio = ingreso.nextDouble();
                    if (nuevoPrecio < 0){
                        System.out.println("El precio no puede ser negativo!");
                        pausa();
                        break;
                    }
                    System.out.print("Nuevo stock: ");
                    nuevostock = ingreso.nextInt();
                    if (nuevostock < 0) {
                        System.out.println("El numero no puede ser negativo!");
                        ingreso.nextLine();
                        pausa();
                        break;
                    }
                    ingreso.nextLine();
                    pEncontrado.setPrecio(nuevoPrecio);
                    pEncontrado.setCantidad(nuevostock);
                    System.out.println("✅ Producto actualizado!");
                }
            }while( nuevostock < 0 || nuevoPrecio < 0);
        } else {
            System.out.println("❌ Producto no encontrado.");
            pausa();
        }
    }

    // Opción 4: Eliminar producto
    public static void eliminarProducto() {
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
            System.out.println("✅ Producto: "+producto.getNombre()+" | id: "+producto.getId()+" | Precio: "+producto.getPrecio()+
                    " | Stock: "+producto.getCantidad()+"--- Eliminado correctamente.");
        } else {
            System.out.println("❌ Producto no encontrado.");
        }
        pausa();
    }

}
