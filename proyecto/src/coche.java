public class coche extends vehiculo {

   private int numeroPuertas;
    private String Transmision;
    private int estado;

    coche(String modelo, String marca, int año, int velocidadM, int numeroPuertas, String Transmision, int estado) {
        super(modelo, marca, año, velocidadM);

        setTTransmision(Transmision);

         setNumeroPuertas(numeroPuertas);
         setEstado(estado);


    }

    public void setTTransmision(String z){
        
     Transmision = z;

    }

    public void setNumeroPuertas(int n1){
        numeroPuertas = n1;
    }

    public void setEstado(int ab){
        estado = ab;
    }

    public String getTtransmision(){
        return Transmision;
    }

    public int getNumeroP(){
        return numeroPuertas;
    }

    public int getEstado(){
        return estado;

    }



     public void informacionCoche(){
 
        System.out.println("\n Numero de puertas del vehiculo: "+getNumeroP()+"/n Tipo de transmision: "+getTtransmision());

     }

     public void llaves(){


        if (estado ==1){

            System.out.println(" Las puertas del vehiculo estan abiertas. ");
            
        }
        
        else if(estado == 2){

            System.out.println("Las puertas del vehiculo estas cerradas. ");


        }

        else{
            System.out.println("Opcion no valida");
        }

      


     }

     





    

    


    
}
