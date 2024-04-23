package Caso6;

import Caso6.GestorDinamico;
import Caso6.GestorRelaciones;
import Caso6.Ventas;
import Caso6.VentanaIndexador;  // Importar la clase VentanaIndexador

import javax.swing.*;
import java.awt.*;

public class VENTANA extends JFrame {
    public VENTANA() {
        super("Análisis de Datos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton btnGestorDinamico = new JButton("Gestor Dinámico");
        JButton btnVentas = new JButton("Ventas");
        JButton btnGestorRelaciones = new JButton("Gestor de Relaciones");
        JButton btnIndexadorArchivos = new JButton("Indexador de Archivos"); // Botón para la ventana de indexación

        btnGestorDinamico.addActionListener(e -> new GestorDinamico().setVisible(true));
        btnVentas.addActionListener(e -> new Ventas().setVisible(true));
        btnGestorRelaciones.addActionListener(e -> new GestorRelaciones().setVisible(true));
        btnIndexadorArchivos.addActionListener(e -> new VentanaIndexador().setVisible(true));  // Acción para mostrar la ventana de indexación

        add(btnGestorDinamico);
        add(btnVentas);
        add(btnGestorRelaciones);
        add(btnIndexadorArchivos);  // Agregar el botón al layout
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VENTANA().setVisible(true));
    }
}







