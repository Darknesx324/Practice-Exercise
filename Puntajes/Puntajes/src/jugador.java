import java.time.LocalDateTime;

public class jugador {


    private String nombre;
    private LocalDateTime fechaRegistro;
    private int puntaje;


    public jugador(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.fechaRegistro = LocalDateTime.now();
    }
    public String getNombre() {
        return nombre;
    }
    
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    
    public int getPuntaje() {
        return puntaje;
    }
    
    
}
