package GestionRelaciones;

import java.util.HashMap;
import java.util.Map;

public class AsociadorNumerosTexto {
    private Map<Integer, String> numeroATexto;

    public AsociadorNumerosTexto() {
        numeroATexto = new HashMap<>();
        // Ejemplo de inicialización
        numeroATexto.put(1, "Uno");
        numeroATexto.put(2, "Dos");
        numeroATexto.put(3, "Tres");
        // Continuar según sea necesario
    }

    public String getTexto(Integer numero) {
        return numeroATexto.get(numero);
    }
}

