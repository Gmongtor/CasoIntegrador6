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
        numeroATexto.put(4, "Cuatro");
        numeroATexto.put(5, "Cinco");
        numeroATexto.put(6, "Seis");
        numeroATexto.put(7, "Siete");
        numeroATexto.put(8, "Ocho");
        numeroATexto.put(9, "Nueve");
        numeroATexto.put(10, "Diez");
        numeroATexto.put(11, "Once");
        numeroATexto.put(12, "Doce");
        numeroATexto.put(13, "Trece");
        numeroATexto.put(14, "Catorce");
        numeroATexto.put(15, "Quince");
        numeroATexto.put(16, "Dieciséis");
        numeroATexto.put(17, "Diecisiete");
        numeroATexto.put(18, "Dieciocho");
        numeroATexto.put(19, "Diecinueve");
        numeroATexto.put(20, "Veinte");
        numeroATexto.put(21, "Veintiuno");
        numeroATexto.put(22, "Veintidós");
        numeroATexto.put(23, "Veintitrés");
        numeroATexto.put(24, "Veinticuatro");
        numeroATexto.put(25, "Veinticinco");
        numeroATexto.put(26, "Veintiséis");
        // Agregar más según sea necesario
    }

    public SortedMap<Integer, String> getTextosEnRango(Integer desde, Integer hasta) {
        return numeroATexto.subMap(desde, true, hasta, true);
    }
}
