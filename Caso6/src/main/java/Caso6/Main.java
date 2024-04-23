package Caso6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class Main extends JFrame {
    private TreeMap<String, String> archivoARuta = new TreeMap<>();
    private JList<String> listaArchivos;
    private DefaultListModel<String> modeloLista;

    public Main() {
        super("Indexador de Archivos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        JButton btnIndexar = new JButton("Seleccionar Directorio");
        modeloLista = new DefaultListModel<>();
        listaArchivos = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaArchivos);

        btnIndexar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int opcion = fileChooser.showOpenDialog(Main.this);
                if (opcion == JFileChooser.APPROVE_OPTION) {
                    File directorioSeleccionado = fileChooser.getSelectedFile();
                    indexarDirectorio(directorioSeleccionado);
                    mostrarArchivos();
                }
            }
        });

        panel.add(btnIndexar);
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void indexarDirectorio(File directorio) {
        archivoARuta.clear();
        indexarDirectorioRecursivo(directorio);
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

    private void mostrarArchivos() {
        modeloLista.clear();
        for (Map.Entry<String, String> entrada : archivoARuta.entrySet()) {
            modeloLista.addElement(entrada.getKey() + " - " + entrada.getValue());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main frame = new Main();
            frame.setVisible(true);
        });
    }
}

