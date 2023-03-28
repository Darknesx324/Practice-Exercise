import org.junit.Test;
import static org.junit.Assert.*;

public class PeajeTest {

    @Test
    public void testValorPeajeCarro() {
        Carro carro = new Carro("ABC123");
        int valorEsperado = 10000;
        int valorObtenido = carro.getValorPeaje();
        assertEquals(valorEsperado, valorObtenido);
    }
    
    @Test
    public void testValorPeajeMoto() {
        Moto moto = new Moto("DEF456");
        int valorEsperado = 5000;
        int valorObtenido = moto.getValorPeaje();
        assertEquals(valorEsperado, valorObtenido);
    }
    
    @Test
    public void testValorPeajeCamion() {
        Camion camion = new Camion("GHI789", 5);
        int valorEsperado = 25000;
        int valorObtenido = camion.getValorPeajeEje() * camion.numeroEjes;
        assertEquals(valorEsperado, valorObtenido);
    }
    @Test
    public void testConstructor() {
        Camion camion = new Camion("GHI789", 3);
        assertEquals("GHI789", camion.getPlaca());
        assertEquals(3, camion.numeroEjes);
    }
    
    @Test
    public void testValorPeajeEje() {
        Camion camion = new Camion("GHI789", 3);
        assertEquals(5000, camion.getValorPeajeEje());
        Camion.setValorPeajeEje(6000);
        assertEquals(6000, camion.getValorPeajeEje());
    }
    
    @Test
    public void testImprimir() {
        Camion camion = new Camion("GHI789", 3);
        camion.imprimit(); // Debe imprimir "Placa = GHI789\nNúmero de ejes = 3\nValor del peaje = 5000"
    }
}
