import java.util.ArrayList;

public class Puntajes {
    public static void main(String[] args) throws Exception {
        ArrayList<jugador> jugadores = new ArrayList<>();
        ArrayList<jugador> puntajesBajos = new ArrayList<>();
        jugador jugadorConMayorPuntaje = null;


        while (true) {
            String nombre = System.console().readLine("Ingrese el nombre del jugador (o presione 'Enter' para salir): ");
            if (nombre.isEmpty()) {
                break;
            }
            int puntaje = -1;
            while (puntaje < 0 || puntaje > 100) {
                try {
                    puntaje = Integer.parseInt(System.console().readLine("Ingrese el puntaje del jugador (0-100): "));
                } catch (NumberFormatException e) {
                    System.out.println("Puntaje inválido. Intente de nuevo.");
                }
            }
            jugador jugador = new jugador(nombre, puntaje);
            jugadores.add(jugador);
            
            if (jugadorConMayorPuntaje == null || jugador.getPuntaje() > jugadorConMayorPuntaje.getPuntaje()) {
                jugadorConMayorPuntaje = jugador;
            } else if (jugador.getPuntaje() == jugadorConMayorPuntaje.getPuntaje()) {
                System.out.println("Empate de puntaje entre " + jugador.getNombre() + " y " + jugadorConMayorPuntaje.getNombre());
            }
            
            if (puntaje < 20) {
                puntajesBajos.add(jugador);
            }
        }

        int totalPuntajes = 0;
        for (jugador jugador : jugadores) {
            totalPuntajes += jugador.getPuntaje();
        }
        double promedioPuntajes = (double) totalPuntajes / jugadores.size();
        System.out.println("El promedio de puntajes es: " + promedioPuntajes);

        System.out.println("Jugadores con puntajes menores de 20:");
        for (jugador jugador : puntajesBajos) {
            System.out.println(jugador.getNombre() + " - " + jugador.getPuntaje());
        }

        if (jugadorConMayorPuntaje != null) {
            System.out.println("El jugador con el mayor puntaje es: " + jugadorConMayorPuntaje.getNombre() + " - " + jugadorConMayorPuntaje.getPuntaje());
        }
        


    }

}
