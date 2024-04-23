package Caso6;

import Caso6.GestiónDatosDinamicos.ListaDinamica;
import Caso6.GestiónDatosDinamicos.Pareja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class GestorDinamico extends JFrame {
    private ListaDinamica<Pareja> listaParejas;
    private DefaultListModel<String> modeloLista;
    private JList<String> vistaParejas;
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

        JPanel panelInputs = new JPanel(new GridLayout(0, 2));
        txtPrimerElemento = new JTextField();
        txtSegundoElemento = new JTextField();
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

        btnAgregar.addActionListener(e -> accionAgregarPareja());
        btnModificar.addActionListener(e -> accionModificarPareja());
        btnEliminar.addActionListener(e -> accionEliminarPareja());

        add(panelInputs, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        actualizarVista();
    }

    private void accionAgregarPareja() {
        try {
            int primerElemento = Integer.parseInt(txtPrimerElemento.getText());
            int segundoElemento = Integer.parseInt(txtSegundoElemento.getText());
            listaParejas.agregar(new Pareja(primerElemento, segundoElemento));
            actualizarVista();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese números válidos.");
        }
    }

    private void accionModificarPareja() {
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

    private void accionEliminarPareja() {
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

