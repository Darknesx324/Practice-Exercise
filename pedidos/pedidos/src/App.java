import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        
Producto producto1 = new Producto("Producto 1", 10, 100);
Producto producto2 = new Producto("Producto 2", 20, 50);
Producto producto3 = new Producto("Producto 3", 15, 75);

    // Crear clientes
    Cliente cliente1 = new Cliente("Cliente 1", "Dirección 1", "111111111", "cliente1@correo.com");
    Cliente cliente2 = new Cliente("Cliente 2", "Dirección 2", "222222222", "cliente2@correo.com");

    // Crear cuentas
    Cuenta cuenta1 = new Cuenta("Tarjeta 1", 500, cliente1);
    Cuenta cuenta2 = new Cuenta("Tarjeta 2", 1000, cliente1);
    Cuenta cuenta3 = new Cuenta("Tarjeta 3", 1500, cliente2);

    // Asociar cuentas a clientes
    cliente1.addCuenta(cuenta1);
    cliente1.addCuenta(cuenta2);
    cliente2.addCuenta(cuenta3);

    // Realizar pedidos
    PedidoSimple pedido1 = new PedidoSimple(5, producto1, cuenta1);
    PedidoSimple pedido2 = new PedidoSimple(2, producto2, cuenta2);
    PedidoSimple pedido3 = new PedidoSimple(3, producto3, cuenta3);

    List<Pedido> pedidos = new ArrayList<>();
    pedidos.add(pedido1);
    pedidos.add(pedido2);
    pedidos.add(pedido3);

    // Procesar pedidos
    ProcesadorPedidos procesador = ProcesadorPedidos.getInstancia();
    procesador.procesarPedidos(pedidos);

    // Imprimir estado de los pedidos
    for (Pedido pedido : pedidos) {
        System.out.println("Pedido de " + pedido.getProducto().getNombre() + " - Estado: " + pedido.getEstado());
    }
}

}
       
    
        

    

