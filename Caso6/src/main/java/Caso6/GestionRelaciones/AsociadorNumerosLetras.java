package Caso6.GestionRelaciones;
import java.util.HashMap;
import java.util.Map;

public class AsociadorNumerosLetras {
    private Map<Integer, Character> numeroALetra;

    public AsociadorNumerosLetras() {
        numeroALetra = new HashMap<>();
        // Ejemplo de inicialización
        numeroALetra.put(1, 'A');
        numeroALetra.put(2, 'B');
        numeroALetra.put(3, 'C');
        // Agregar más asociaciones según sea necesario
    }

    public Character getLetra(Integer numero) {
        return numeroALetra.get(numero);
    }
}

