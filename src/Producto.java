public class Producto {
    //TODO:atributos
    private static int contador = 1;
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;

    //TODO:constructor
    public Producto(String nombre, double precio, int cantidad){
        this.id = contador++;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    //TODO:Getters para acceder a los datos desde afuera de la clase
    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }


    public int getCantidad(){
        return cantidad;
    }

    //TODO:Setters para modificar los datos
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    @Override
    public String toString(){
        return "ID: "+ id + "| Producto: " + nombre + "| Precio: $" + precio+"| Stock: "+cantidad;
    }
}
