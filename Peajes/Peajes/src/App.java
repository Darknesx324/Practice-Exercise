public class App {
    public static void main(String[] args) throws Exception {
   
        Vehiculo vehiculo1 = new Carro("ABC123");
    Vehiculo vehiculo2 = new Carro("DEF456");

    Persona persona1 = new Persona("Juan", 30, "12345678");
    Persona persona2 = new Persona("Maria", 25, "87654321");

        Peaje peaje = new Peaje ("La Lizama", "Santander");
        Camion camion1 = new Camion("PKI-889", 2);
        peaje.addVehiculo(camion1);
        peaje.calcularPeaje(camion1);
        Camion camion2 = new Camion("KLM-123", 3);
        peaje.addVehiculo(camion2);
        peaje.calcularPeaje(camion2);
        Camion camion3 = new Camion("PQI-234", 4);
        peaje.addVehiculo(camion3);
        peaje.calcularPeaje(camion3);
        Moto moto1 = new Moto("ABC-123");
        peaje.addVehiculo(moto1);
        peaje.calcularPeaje(moto1);
        Moto moto2 = new Moto("XYZ-000");
        peaje.addVehiculo(moto2);
        peaje.calcularPeaje(moto2);
        Carro carro1 = new Carro("WVC-389");
        peaje.addVehiculo(carro1);
        peaje.calcularPeaje(carro1);
        Carro carro2 = new Carro("QWE-543");
        peaje.addVehiculo(carro2);
        peaje.calcularPeaje(carro2);
        peaje.imprimir();
       
        persona1.setVehiculo(vehiculo1);
        persona2.setVehiculo(vehiculo2);

        System.out.println(persona1.getInfoVehiculo());
    System.out.println(persona2.getInfoVehiculo());
        
    }
}
