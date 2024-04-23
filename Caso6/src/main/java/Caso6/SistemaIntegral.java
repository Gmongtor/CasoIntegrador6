package Caso6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class SistemaIntegral extends JFrame {
    private TreeMap<String, String> archivoARuta = new TreeMap<>();
    private TreeMap<Integer, Character> numeroALetra = new TreeMap<>();
    private TreeMap<Integer, String> numeroATexto = new TreeMap<>();
    private JList<String> listaArchivos;
    private DefaultListModel<String> modeloLista;

    public SistemaIntegral() {
        super("Sistema Integral de Gestión de Datos y Archivos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para botones
        JPanel panelBotones = new JPanel();
        JButton btnIndexarDirectorio = new JButton("Indexar Directorio");
        JButton btnAsociarNumeros = new JButton("Asociar Números");
        JButton btnMostrarAsociaciones = new JButton("Mostrar Asociaciones");
        modeloLista = new DefaultListModel<>();
        listaArchivos = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaArchivos);

        btnIndexarDirectorio.addActionListener(this::accionIndexar);
        btnAsociarNumeros.addActionListener(this::accionAsociarNumeros);
        btnMostrarAsociaciones.addActionListener(this::accionMostrarAsociaciones);

        panelBotones.add(btnIndexarDirectorio);
        panelBotones.add(btnAsociarNumeros);
        panelBotones.add(btnMostrarAsociaciones);
        add(panelBotones, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        inicializarAsociaciones();
    }

    private void accionIndexar(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int opcion = fileChooser.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File directorioSeleccionado = fileChooser.getSelectedFile();
            indexarDirectorioRecursivo(directorioSeleccionado);
            mostrarArchivos();
        }
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
        archivoARuta.forEach((nombre, ruta) -> modeloLista.addElement(nombre + " - " + ruta));
    }

    private void accionAsociarNumeros(ActionEvent e) {
        modeloLista.clear();
        numeroALetra.forEach((numero, letra) -> modeloLista.addElement(numero + " -> " + letra));
        numeroATexto.forEach((numero, texto) -> modeloLista.addElement(numero + " -> " + texto));
    }

    private void accionMostrarAsociaciones(ActionEvent e) {
        modeloLista.clear();
        numeroALetra.forEach((numero, letra) -> modeloLista.addElement("Número: " + numero + ", Letra: " + letra));
        numeroATexto.forEach((numero, texto) -> modeloLista.addElement("Número: " + numero + ", Texto: " + texto));
    }

    private void inicializarAsociaciones() {
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


