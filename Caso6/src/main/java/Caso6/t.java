package Caso6;

import Caso6.AnálisisOrganizacion.GestorVentas;
import Caso6.AnálisisOrganizacion.Venta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class Ventas extends JFrame {
    private GestorVentas gestorVentas;
    private DefaultListModel<String> modeloLista;
    private JList<String> vistaVentas;
    private JTextField txtNombre, txtMonto, txtFecha;
    private JButton btnAgregar, btnMostrar;

    public Ventas() {
        super("Ventas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        gestorVentas = new GestorVentas();
        modeloLista = new DefaultListModel<>();
        vistaVentas = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(vistaVentas);

        JPanel panelInputs = new JPanel(new GridLayout(0, 2));
        txtNombre = new JTextField();
        txtMonto = new JTextField();
        txtFecha = new JTextField();
        btnAgregar = new JButton("Agregar Venta");
        btnMostrar = new JButton("Mostrar Ventas");

        panelInputs.add(new JLabel("Nombre:"));
        panelInputs.add(txtNombre);
        panelInputs.add(new JLabel("Monto:"));
        panelInputs.add(txtMonto);
        panelInputs.add(new JLabel("Fecha (dd/mm/yyyy):"));
        panelInputs.add(txtFecha);
        panelInputs.add(btnAgregar);
        panelInputs.add(btnMostrar);

        btnAgregar.addActionListener(e -> accionAgregarVenta());
        btnMostrar.addActionListener(e -> actualizarVista());

        add(panelInputs, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void accionAgregarVenta() {
        try {
            String nombre = txtNombre.getText();
            double monto = Double.parseDouble(txtMonto.getText());
            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(txtFecha.getText());
            gestorVentas.agregarVenta(nombre, fecha, monto);
            actualizarVista();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ingrese datos válidos.");
        }
    }

    private void actualizarVista() {
        modeloLista.clear();
        for (Venta venta : gestorVentas.getVentas()) {
            modeloLista.addElement("Venta: " + venta.getNombre() + ", " + venta.getFecha().toString() + ", $" + venta.getMonto());
        }
    }
}
