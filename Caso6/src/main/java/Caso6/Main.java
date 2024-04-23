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
    public class SistemaIntegral extends JFrame {
        private JList<String> listaArchivos;
        private DefaultListModel<String> modeloLista;
        private Map<Integer, Character> numeroALetra;
        private Map<Integer, String> numeroATexto;

        public SistemaIntegral() {
            super("Sistema Integral de Gestión de Datos y Archivos");
            setSize(800, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            // Panel para las funciones
            JPanel panelFunciones = new JPanel();
            JButton btnIndexar = new JButton("Indexar Directorio");
            JButton btnAsociarNumeros = new JButton("Asociar Números");
            modeloLista = new DefaultListModel<>();
            listaArchivos = new JList<>(modeloLista);
            JScrollPane scrollPane = new JScrollPane(listaArchivos);

            // Agregar acciones a los botones
            btnIndexar.addActionListener(e -> seleccionarDirectorio());
            btnAsociarNumeros.addActionListener(e -> mostrarAsociaciones());

            panelFunciones.add(btnIndexar);
            panelFunciones.add(btnAsociarNumeros);
            add(panelFunciones, BorderLayout.NORTH);
            add(scrollPane, BorderLayout.CENTER);

            // Inicialización de mapas
            inicializarMapas();
        }

        private void seleccionarDirectorio() {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int opcion = fileChooser.showOpenDialog(this);
            if (opcion == JFileChooser.APPROVE_OPTION) {
                File directorioSeleccionado = fileChooser.getSelectedFile();
                indexarDirectorioRecursivo(directorioSeleccionado);
                listarArchivos();
            }
        }

        private void indexarDirectorioRecursivo(File directorio) {
            TreeMap<String, String> archivoARuta = new TreeMap<>();
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
            modeloLista.clear();
            archivoARuta.forEach((nombre, ruta) -> modeloLista.addElement(nombre + " - " + ruta));
        }

        private void listarArchivos() {
            modeloLista.clear();
            numeroATexto.forEach((numero, texto) -> modeloLista.addElement(numero + " - " + texto));
        }

        private void mostrarAsociaciones() {
            JOptionPane.showMessageDialog(this, "Número 1 asociado a " + numeroALetra.get(1) +
                    " y a " + numeroATexto.get(1), "Asociaciones de Números", JOptionPane.INFORMATION_MESSAGE);
        }

        private void inicializarMapas() {
            numeroALetra = new TreeMap<>();
            numeroATexto = new TreeMap<>();

            // Asociaciones de ejemplo
            numeroALetra.put(1, 'A');
            numeroALetra.put(2, 'B');
            numeroATexto.put(1, "Uno");
            numeroATexto.put(2, "Dos");
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                SistemaIntegral frame = new SistemaIntegral();
                frame.setVisible(true);
            });
        }
}

