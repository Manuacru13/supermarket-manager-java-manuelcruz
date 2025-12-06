public class Producto {
    //TODO:atributos
    private static int contador = 1;
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    //TODO:constructor
    public Producto(String nombre, double precio, int stock){
        this.id = contador++;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
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


    public int getStock(){
        return stock;
    }

    //TODO:Setters para modificar los datos
    public void setPrecio(double precio){
        this.precio = precio;
    }

    public void setStock(int cantidad){
        this.stock = stock;
    }

    ///metodo para restar stock
    public boolean disminuirStock(int cantidad){
        if (cantidad <= stock){
            this.stock -= stock;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return "ID: "+ id + "| Producto: " + nombre + "| Precio: $" + precio+"| Stock: "+stock;
    }
}
