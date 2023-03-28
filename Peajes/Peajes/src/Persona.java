public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private Vehiculo vehiculo;

    // Constructor
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    // Getter y Setter para vehiculo
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    // Método para obtener la información del vehículo asignado
    public String getInfoVehiculo() {
        if (vehiculo != null) {
            return "El vehículo asignado a " + nombre + " es un " + vehiculo.getMarca() + " " + vehiculo.getModelo() + " con matrícula " + vehiculo.getPlaca() + ".";
        } else {
            return "A " + nombre + " no se le ha asignado ningún vehículo.";
        }
    }
}