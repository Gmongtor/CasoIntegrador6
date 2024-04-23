package Caso6.SistemaIndexacion;

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

    public void listarArchivos() {
        for (Map.Entry<String, String> entrada : archivoARuta.entrySet()) {
            System.out.println(entrada.getKey() + " - " + entrada.getValue());
        }
    }
}

