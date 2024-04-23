package Caso6;

import Caso6.GestiónDatosDinamicos.ListaDinamica;
import Caso6.GestiónDatosDinamicos.Pareja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SistemaGestionYAnalisisDatos extends JFrame {
    public SistemaGestionYAnalisisDatos() {
        super("Sistema de Gestión y Análisis de Datos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton btnAbrirGestor = new JButton("Abrir Gestor Dinámico");
        btnAbrirGestor.addActionListener(this::accionAbrirGestor);
        add(btnAbrirGestor);
    }

    private void accionAbrirGestor(ActionEvent e) {
        GestorDinamico gestor = new GestorDinamico();
        gestor.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaGestionYAnalisisDatos frame = new SistemaGestionYAnalisisDatos();
            frame.setVisible(true);
        });
    }
}

class GestorDinamico extends JFrame {
    private ListaDinamica<Pareja> listaParejas;
    private JList<String> vistaParejas;
    private DefaultListModel<String> modeloLista;
    private JTextField txtPrimerElemento, txtSegundoElemento;
    private JButton btnAgregar, btnModificar, btnEliminar;

    public GestorDinamico() {
        super("Gestor Dinámico");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        listaParejas = new ListaDinamica<>();
        modeloLista = new DefaultListModel<>();
        vistaParejas = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(vistaParejas);

        JPanel panelInputs = new JPanel(new FlowLayout());
        txtPrimerElemento = new JTextField(5);
        txtSegundoElemento = new JTextField(5);
        btnAgregar = new JButton("Agregar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");

        panelInputs.add(new JLabel("Primer Elemento:"));
        panelInputs.add(txtPrimerElemento);
        panelInputs.add(new JLabel("Segundo Elemento:"));
        panelInputs.add(txtSegundoElemento);
        panelInputs.add(btnAgregar);
        panelInputs.add(btnModificar);
        panelInputs.add(btnEliminar);

        add(panelInputs, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        btnAgregar.addActionListener(this::accionAgregarPareja);
        btnModificar.addActionListener(this::accionModificarPareja);
        btnEliminar.addActionListener(this::accionEliminarPareja);

        actualizarVista();
    }

    private void accionAgregarPareja(ActionEvent e) {
        try {
            int primerElemento = Integer.parseInt(txtPrimerElemento.getText());
            int segundoElemento = Integer.parseInt(txtSegundoElemento.getText());
            listaParejas.agregar(new Pareja(primerElemento, segundoElemento));
            actualizarVista();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese números válidos.");
        }
    }

    private void accionModificarPareja(ActionEvent e) {
        int indice = vistaParejas.getSelectedIndex();
        if (indice != -1) {
            try {
                int primerElemento = Integer.parseInt(txtPrimerElemento.getText());
                int segundoElemento = Integer.parseInt(txtSegundoElemento.getText());
                listaParejas.modificar(indice, new Pareja(primerElemento, segundoElemento));
                actualizarVista();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese números válidos.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un elemento para modificar.");
        }
    }

    private void accionEliminarPareja(ActionEvent e) {
        int indice = vistaParejas.getSelectedIndex();
        if (indice != -1) {
            listaParejas.eliminar(indice);
            actualizarVista();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un elemento para eliminar.");
        }
    }

    private void actualizarVista() {
        modeloLista.clear();
        for (Pareja pareja : listaParejas.obtenerTodos()) {
            modeloLista.addElement("Pareja: " + pareja.getPrimerElemento() + ", " + pareja.getSegundoElemento());
        }
    }
}





