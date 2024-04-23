package Caso6;

import Caso6.GestorDinamico;
import Caso6.GestorRelaciones;
import Caso6.Ventas;

import javax.swing.*;
import java.awt.*;

public class SistemaGestionYAnalisisDatos extends JFrame {
    public SistemaGestionYAnalisisDatos() {
        super("Análisis de Datos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton btnGestorDinamico = new JButton("Gestor Dinámico");
        JButton btnVentas = new JButton("Ventas");
        JButton btnGestorRelaciones = new JButton("Gestor de Relaciones");

        btnGestorDinamico.addActionListener(e -> new GestorDinamico().setVisible(true));
        btnVentas.addActionListener(e -> new Ventas().setVisible(true));
        btnGestorRelaciones.addActionListener(e -> new GestorRelaciones().setVisible(true));

        add(btnGestorDinamico);
        add(btnVentas);
        add(btnGestorRelaciones);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SistemaGestionYAnalisisDatos().setVisible(true));
    }
}







