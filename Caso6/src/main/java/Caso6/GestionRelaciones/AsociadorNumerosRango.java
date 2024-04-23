package Caso6.GestionRelaciones;
import java.util.SortedMap;
import java.util.TreeMap;

public class AsociadorNumerosRango {
    private TreeMap<Integer, String> numeroATexto;

    public AsociadorNumerosRango() {
        numeroATexto = new TreeMap<>();
        // Ejemplo de inicialización
        numeroATexto.put(1, "Uno");
        numeroATexto.put(2, "Dos");
        numeroATexto.put(3, "Tres");
        // Agregar más según sea necesario
    }

    public SortedMap<Integer, String> getTextosEnRango(Integer desde, Integer hasta) {
        return numeroATexto.subMap(desde, true, hasta, true);
    }
}
