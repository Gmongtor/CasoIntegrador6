package Caso6;
import Caso6.SistemaIndexacion.IndexadorDeArchivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class VentanaIndexador extends JFrame {
    private IndexadorDeArchivos indexador;
    private JTextArea areaTexto;
    private JButton botonIndexar;
    private JFileChooser fileChooser;

    public VentanaIndexador() {
        super("Indexador de Archivos");
        indexador = new IndexadorDeArchivos();
        inicializarComponentes();
        configurarVentana();
    }

    private void inicializarComponentes() {
        areaTexto = new JTextArea(20, 50);
        areaTexto.setEditable(false);

        botonIndexar = new JButton("Indexar Directorio");
        botonIndexar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int retorno = fileChooser.showOpenDialog(VentanaIndexador.this);

                if (retorno == JFileChooser.APPROVE_OPTION) {
                    File directorio = fileChooser.getSelectedFile();
                    indexador.indexarDirectorio(directorio.getAbsolutePath());
                    areaTexto.setText(""); // Limpiar el área de texto antes de mostrar nuevos resultados
                    indexador.listarArchivos(areaTexto);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(areaTexto);
        this.add(botonIndexar, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    private void configurarVentana() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null); // Centrar la ventana
        this.setVisible(true);
    }
}

