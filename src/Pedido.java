import java.util.ArrayList;

public class Pedido {
    private static int contador = 1;

    private int idPedido;
    private static ArrayList<LineaPedido>lineas;

    /// constructor
    public Pedido(){
        this.idPedido = contador++;
        this.lineas = new ArrayList<>();
    }

    public int getIdPedido(){
        return idPedido;
    }

    public static void agregarLinea(Producto p, int cantidad){
        lineas.add(new LineaPedido(p,cantidad));
    }

    public double getTotal(){
        double total = 0;
        for (LineaPedido lp : lineas ){
            total += lp.getSubtotal();
        }
        return total;
    }

    @Override
    public String toString(){
        String texto = "\n--- Pedido #"+idPedido+" ---\n";
        for (LineaPedido lp : lineas){
            texto+=lp.toString()+"\n";
        }
        texto += "TOTAl: $"+getTotal()+"\n";
        return texto;
    }
}
