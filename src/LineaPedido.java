public class LineaPedido {
    private Producto producto;
    private int cantidad;

    /// constructor
    public LineaPedido(Producto producto,int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }

    /// getters
    public Producto getProducto() {
        return producto;
    }
    public int getCantidad(){
        return cantidad;
    }
    public double getSubtotal(){
        return producto.getPrecio() * cantidad;
    }

    @Override
    public String toString(){
        return producto.getNombre()+" | Cantidad: "+cantidad+" | Subtotal: $"+getSubtotal();
    }
}
