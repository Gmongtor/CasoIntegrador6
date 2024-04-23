package Caso6.SistemaIndexacion;

import javax.swing.*;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class IndexadorDeArchivos {
    private TreeMap<String, String> archivoARuta;

    public IndexadorDeArchivos() {
        archivoARuta = new TreeMap<>();
    }

    public void indexarDirectorio(String directorio) {
        File dir = new File(directorio);
        indexarDirectorioRecursivo(dir);
    }

    private void indexarDirectorioRecursivo(File directorio) {
        File[] archivos = directorio.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    indexarDirectorioRecursivo(archivo);
                } else {
                    archivoARuta.put(archivo.getName(), archivo.getAbsolutePath());
                }
            }
        }
    }

    public Map<String, String> getArchivos() {
        return archivoARuta;
    }
    public void listarArchivos(JTextArea areaTexto) {
        for (Map.Entry<String, String> entrada : archivoARuta.entrySet()) {
            areaTexto.append(entrada.getKey() + " - " + entrada.getValue() + "\n");
        }
    }
}

