import java.util.ArrayList;
import java.util.List;

class Cliente {
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private List<Cuenta> cuentas;

    public Cliente(String nombre, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.cuentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void addCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
}

class Cuenta {
    private String tarjeta;
    private double saldo;
    private Cliente cliente;
    private List<Pedido> pedidos;

    public Cuenta(String tarjeta, double saldo, Cliente cliente) {
        this.tarjeta = tarjeta;
        this.saldo = saldo;
        this.cliente = cliente;
        this.pedidos = new ArrayList<>();
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void cobrarPedidos() {
        double total = 0;
        List<Pedido> pedidosCobrados = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado() == EstadoPedido.PENDIENTE) {
                total += pedido.getPrecio();
                pedido.setEstado(EstadoPedido.COBRADO);
                pedidosCobrados.add(pedido);
            }
        }
        if (total > saldo) {
            for (Pedido pedido : pedidosCobrados) {
                pedido.setEstado(EstadoPedido.PENDIENTE);
            }
            throw new RuntimeException("No hay suficiente saldo en la cuenta");
        } else {
            saldo -= total;
        }
    }
}

abstract class Pedido {
    private int cantidad;
    private Producto producto;
    private Cuenta cuenta;
    private EstadoPedido estado;

    public Pedido(int cantidad, Producto producto, Cuenta cuenta) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.cuenta = cuenta;
        this.estado = EstadoPedido.PENDIENTE;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return cantidad * producto.getPrecio();
    }
}

class PedidoSimple extends Pedido {
    public PedidoSimple(int cantidad, Producto producto, Cuenta cuenta) {
        super(cantidad, producto, cuenta);
    }


}

class PedidoCompuesto extends Pedido {
    private List<Pedido> pedidos;
    public PedidoCompuesto(List<Pedido> pedidos, Cuenta cuenta) {
        super(0, null, cuenta);
        this.pedidos = pedidos;
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }
}


class Producto {
    private String nombre;
    private double precio;
    
    public Producto(String nombre, double precio, int i) {
        this.nombre = nombre;
        this.precio = 0;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return 0;
    }

    public void setCantidad(int i) {
    }

    public void disminuirStock(int cantidad) {
    }
    
    }

    class ControlPedidos {
        private static ControlPedidos instance = null;
        private List<Cliente> clientes;
        private List<Producto> productos;
        private List<Pedido> pedidosPendientes;
        private ControlPedidos() {
            clientes = new ArrayList<>();
            productos = new ArrayList<>();
            pedidosPendientes = new ArrayList<>();
        }
        
        public static ControlPedidos getInstance() {
            if (instance == null) {
                instance = new ControlPedidos();
            }
            return instance;
        }
        
        public void agregarCliente(Cliente cliente) {
            clientes.add(cliente);
        }
        
        public void agregarProducto(Producto producto) {
            productos.add(producto);
        }
        
        public Cliente buscarCliente(String nombre) {
            for (Cliente cliente : clientes) {
                if (cliente.getNombre().equals(nombre)) {
                    return cliente;
                }
            }
            return null;
        }
        
        public Producto buscarProducto(String nombre) {
            for (Producto producto : productos) {
                if (producto.getNombre().equals(nombre)) {
                    return producto;
                }
            }
            return null;
        }
        
        public void realizarPedido(Pedido pedido) {
            Cuenta cuenta = pedido.getCuenta();
            if (cuenta.getSaldo() == 0) {
                throw new RuntimeException("La cuenta no tiene saldo disponible");
            }
            if (pedido instanceof PedidoSimple) {
                PedidoSimple pedidoSimple = (PedidoSimple) pedido;
                Producto producto = pedidoSimple.getProducto();
                if (producto.getCantidad() < pedidoSimple.getCantidad()) {
                    throw new RuntimeException("No hay suficiente stock del producto");
                }
                producto.setCantidad(producto.getCantidad() - pedidoSimple.getCantidad());
                cuenta.addPedido(pedidoSimple);
            } else {
                PedidoCompuesto pedidoCompuesto = (PedidoCompuesto) pedido;
                List<Pedido> pedidos = pedidoCompuesto.getPedidos();
                double total = 0;
                for (Pedido p : pedidos) {
                    if (!(p instanceof PedidoSimple)) {
                        throw new RuntimeException("Un pedido compuesto solo puede contener pedidos simples");
                    }
                    PedidoSimple pedidoSimple = (PedidoSimple) p;
                    Producto producto = pedidoSimple.getProducto();
                    if (producto.getCantidad() < pedidoSimple.getCantidad()) {
                        throw new RuntimeException("No hay suficiente stock del producto");
                    }
                    total += pedidoSimple.getPrecio();
                }
                if (total > cuenta.getSaldo()) {
                    throw new RuntimeException("No hay suficiente saldo en la cuenta");
                }
                for (Pedido p : pedidos) {
                    PedidoSimple pedidoSimple = (PedidoSimple) p;
                    Producto producto = pedidoSimple.getProducto();
                    producto.setCantidad(producto.getCantidad() - pedidoSimple.getCantidad());
                    cuenta.addPedido(pedidoSimple);
                }
            }
            pedidosPendientes.add(pedido);
        }
        
        public void cobrarPedidos() {
            for (Cliente cliente : clientes) {
                for (Cuenta cuenta : cliente.getCuentas()) {
                    try {
                        cuenta.cobrarPedidos();
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            List<Pedido> pedidosEntregados = new ArrayList<>();
            for (Pedido pedido : pedidosPendientes) {
                if (pedido.getEstado() == EstadoPedido.COBRADO) {
                    pedido.getProducto().setCantidad(pedido.getProducto().getCantidad() - pedido.getCantidad());
                    pedidosEntregados.add(pedido);
                    pedido.setEstado(EstadoPedido.ENTREGADO);
                }
            }
            pedidosPendientes.removeAll(pedidosEntregados);
        }
        
        }

        class ProcesadorPedidos {
            private static ProcesadorPedidos instancia = new ProcesadorPedidos();
            private ProcesadorPedidos() {}
            
            public static ProcesadorPedidos getInstancia() {
                return instancia;
            }
            
            public void procesarPedidos(List<Pedido> pedidos) {
                try {
                    // Cobrar los pedidos
                    for (Pedido pedido : pedidos) {
                        Cuenta cuenta = pedido.getCuenta();
                        cuenta.cobrarPedidos();
                    }
            
                    // Distribuir los pedidos
                    for (Pedido pedido : pedidos) {
                        pedido.getProducto().disminuirStock(pedido.getCantidad());
                    }
            
                    // Confirmar los pedidos
                    for (Pedido pedido : pedidos) {
                        pedido.setEstado(EstadoPedido.CONFIRMADO);
                    }
                } catch (RuntimeException e) {
                    // Si ocurre un error, se marca el estado de los pedidos como pendiente
                    for (Pedido pedido : pedidos) {
                        pedido.setEstado(EstadoPedido.PENDIENTE);
                    }
                    throw e;
                }
            }
            
            }


    
    enum EstadoPedido {
    PENDIENTE,
    COBRADO, CONFIRMADO, ENTREGADO
    }
