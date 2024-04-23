package Caso6;

import Caso6.GestionRelaciones.AsociadorNumerosLetras;
import Caso6.GestionRelaciones.AsociadorNumerosRango;
import Caso6.GestionRelaciones.AsociadorNumerosTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.SortedMap;

public class GestorRelaciones extends JFrame {
    private AsociadorNumerosLetras asociadorNumerosLetras;
    private AsociadorNumerosRango asociadorNumerosRango;
    private AsociadorNumerosTexto asociadorNumerosTexto;

    public GestorRelaciones() {
        super("Gestor de Relaciones");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        asociadorNumerosLetras = new AsociadorNumerosLetras();
        asociadorNumerosRango = new AsociadorNumerosRango();
        asociadorNumerosTexto = new AsociadorNumerosTexto();

        JButton btnObtenerLetra = new JButton("Obtener Letra");
        JButton btnObtenerTexto = new JButton("Obtener Texto");
        JButton btnObtenerRango = new JButton("Obtener Rango");

        JPanel panel = new JPanel();
        panel.add(btnObtenerLetra);
        panel.add(btnObtenerTexto);
        panel.add(btnObtenerRango);
        add(panel, BorderLayout.NORTH);

        btnObtenerLetra.addActionListener(e -> obtenerLetra());
        btnObtenerTexto.addActionListener(e -> obtenerTexto());
        btnObtenerRango.addActionListener(e -> obtenerRango());
    }

    private void obtenerLetra() {
        // Implementación de obtener letra asociada
        Integer numero = Integer.valueOf(JOptionPane.showInputDialog(this, "Ingrese un número:"));
        Character letra = asociadorNumerosLetras.getLetra(numero);
        JOptionPane.showMessageDialog(this, "Letra asociada: " + (letra != null ? letra : "No hay letra asociada"));
    }

    private void obtenerTexto() {
        // Implementación de obtener texto asociado
        Integer numero = Integer.valueOf(JOptionPane.showInputDialog(this, "Ingrese un número:"));
        String texto = asociadorNumerosTexto.getTexto(numero);
        JOptionPane.showMessageDialog(this, "Texto asociado: " + (texto != null ? texto : "No hay texto asociado"));
    }

    private void obtenerRango() {
        // Implementación de obtener rango
        Integer desde = Integer.valueOf(JOptionPane.showInputDialog(this, "Ingrese el número inicial:"));
        Integer hasta = Integer.valueOf(JOptionPane.showInputDialog(this, "Ingrese el número final:"));
        SortedMap<Integer, String> rango = asociadorNumerosRango.getTextosEnRango(desde, hasta);
        StringBuilder sb = new StringBuilder();
        rango.forEach((k, v) -> sb.append(k).append(": ").append(v).append("\n"));
        JOptionPane.showMessageDialog(this, "Rango de textos:\n" + sb.toString());
    }
}

