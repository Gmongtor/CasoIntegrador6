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
        numeroALetra.put(4, 'D');
        numeroALetra.put(5, 'E');
        numeroALetra.put(6, 'F');
        numeroALetra.put(7, 'G');
        numeroALetra.put(8, 'H');
        numeroALetra.put(9, 'I');
        numeroALetra.put(10, 'J');
        numeroALetra.put(11, 'K');
        numeroALetra.put(12, 'L');
        numeroALetra.put(13, 'M');
        numeroALetra.put(14, 'N');
        numeroALetra.put(15, 'O');
        numeroALetra.put(16, 'P');
        numeroALetra.put(17, 'Q');
        numeroALetra.put(18, 'R');
        numeroALetra.put(19, 'S');
        numeroALetra.put(20, 'T');
        numeroALetra.put(21, 'U');
        numeroALetra.put(22, 'V');
        numeroALetra.put(23, 'W');
        numeroALetra.put(24, 'X');
        numeroALetra.put(25, 'Y');
        numeroALetra.put(26, 'Z');
        // Agregar más asociaciones según sea necesario
    }

    public Character getLetra(Integer numero) {
        return numeroALetra.get(numero);
    }
}

