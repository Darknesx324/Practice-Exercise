import java.util.Scanner;

class vehiculo {

    private String modelo,marca;
    private int año,velocidadM;
    


    vehiculo(String modelo, String marca, int año, int velocidadM){

        setModelo(modelo);
        setMarca(marca);
        setAño(año);
        setVelocidadM(velocidadM);
    }
    

    public void setModelo(String n){modelo = n;}
    public void setMarca(String a){marca = a;}

    public void setAño(int b) {año = b;}
    public void setVelocidadM(int c){velocidadM = c;}


    public String getModelo(){return modelo;}
    public String getMarca(){return marca;}
    public int getAño(){return año;}
    public int getVelocidadM(){return velocidadM;}


    public void informacionVehiculo(){

        System.out.print("\n Modelo: "+getModelo()+"\n Marca: "+getMarca()+"\n Año: "+getAño()+"\n velocidad Maxima: "+getVelocidadM()+"\n");



    }

    public void AcelelarVehiculo(){

        if(velocidadM > 0){

            velocidadM = velocidadM*10;

            System.out.println("\n El vehiculo esta acelerando a una velocidad de: "+getVelocidadM());


        }

        else if(velocidadM < 0){

            

            System.out.println("\n El vehiculo esta desacelerando."+getVelocidadM());
        }

        else{
            System.out.print("\n El vehiculo esta estatico");
        }



    }

}




public class Garage {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        String modelo, marca, Transmision;
        int año, velocidadM,numeroPuertas,estado;
        

   



       


        System.out.println("\n Por favor ingrese el modelo del vehiculo:");
        modelo = entrada.nextLine();

        System.out.println("\n Ingrese la marca del vehiculo");
        marca = entrada.nextLine();

        System.out.println("\n Que tipo de transmision usa el vehiculo: ");
        Transmision = entrada.nextLine();

        System.out.println("\n Ingrese el numero de puertas del vehiculo: ");
        numeroPuertas = entrada.nextInt();

        

        System.out.print("\n Ingrese el año del vehiculo:");
        año = entrada.nextInt();

        System.out.print("\n Ingrese la velocidad del vehiculo:");
        velocidadM = entrada.nextInt();

        System.out.println("Oprima el seguro del vehiculo: ");
        estado = entrada.nextInt();

        
        
        //coche b;
       // b = new coche(modelo, marca, año, velocidadM, numeroPuertas, Transmision, numeroPuertas);

       // b.informacionCoche();

     

    

        vehiculo e;

        e = new vehiculo(modelo, marca, año, velocidadM);
        e.informacionVehiculo();
        e.AcelelarVehiculo();

        

        
        


    }
}
