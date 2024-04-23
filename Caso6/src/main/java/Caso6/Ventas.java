package Caso6;

import Caso6.AnálisisOrganizacion.GestorVentas;
import Caso6.AnálisisOrganizacion.OrdenadorNombres;
import Caso6.AnálisisOrganizacion.OrganizadorVentas;
import Caso6.AnálisisOrganizacion.Venta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;

public class Ventas extends JFrame {
    private OrganizadorVentas organizadorVentas;
    private OrdenadorNombres ordenadorNombres;
    private GestorVentas gestorVentas;
    private DefaultListModel<String> modeloLista;
    private JList<String> vistaVentas;
    private JTextField txtNombre, txtMonto, txtFecha;
    private JButton btnAgregar, btnMostrar, btnEliminar, btnModificar, btnOrdenar;
    private JComboBox<String> cmbCriterio;

    public Ventas() {
        super("Ventas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        organizadorVentas = new OrganizadorVentas();
        ordenadorNombres = new OrdenadorNombres();
        modeloLista = new DefaultListModel<>();
        vistaVentas = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(vistaVentas);

        JPanel panelInputs = new JPanel(new GridLayout(0, 2));
        txtNombre = new JTextField();
        txtMonto = new JTextField();
        txtFecha = new JTextField();
        btnAgregar = new JButton("Agregar Venta");
        btnEliminar = new JButton("Eliminar Venta");
        btnModificar = new JButton("Modificar Venta");
        btnMostrar = new JButton("Mostrar Ventas");
        btnOrdenar = new JButton("Ordenar");
        cmbCriterio = new JComboBox<>(new String[]{"nombre", "monto", "fecha"});

        panelInputs.add(new JLabel("Nombre:"));
        panelInputs.add(txtNombre);
        panelInputs.add(new JLabel("Monto:"));
        panelInputs.add(txtMonto);
        panelInputs.add(new JLabel("Fecha (dd/mm/yyyy):"));
        panelInputs.add(txtFecha);
        panelInputs.add(btnAgregar);
        panelInputs.add(btnEliminar);
        panelInputs.add(btnModificar);
        panelInputs.add(btnMostrar);
        panelInputs.add(new JLabel("Ordenar por:"));
        panelInputs.add(cmbCriterio);
        panelInputs.add(btnOrdenar);

        add(panelInputs, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        btnAgregar.addActionListener(this::accionAgregarVenta);
        btnMostrar.addActionListener(this::actualizarVista);
        btnEliminar.addActionListener(this::accionEliminarVenta);
        btnModificar.addActionListener(this::accionModificarVenta);
        btnOrdenar.addActionListener(this::accionOrdenarVentas);
    }

    private void actualizarVista(ActionEvent actionEvent) {
    }


    private void accionAgregarVenta(ActionEvent e) {
        try {
            String nombre = txtNombre.getText();
            double monto = Double.parseDouble(txtMonto.getText());
            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(txtFecha.getText());
            Venta nuevaVenta = new Venta(nombre, fecha, monto);
            organizadorVentas.agregarVenta(nuevaVenta);
            ordenadorNombres.agregarNombre(nombre);
            actualizarVista();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ingrese datos válidos.");
        }
    }

    private void accionEliminarVenta(ActionEvent e) {
        String nombre = txtNombre.getText();
        gestorVentas.eliminarVenta(nombre);
        actualizarVista();
    }

    private void accionModificarVenta(ActionEvent e) {
        try {
            String nombreOriginal = txtNombre.getText();
            String nuevoNombre = txtMonto.getText();
            double nuevoMonto = Double.parseDouble(txtMonto.getText());
            Date nuevaFecha = new SimpleDateFormat("dd/MM/yyyy").parse(txtFecha.getText());
            gestorVentas.modificarVenta(nombreOriginal, nuevoNombre, nuevaFecha, nuevoMonto);
            actualizarVista();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ingrese datos válidos.");
        }
    }

    private void accionOrdenarVentas(ActionEvent e) {
        String criterio = (String) cmbCriterio.getSelectedItem();
        TreeSet<Venta> ordenadas;
        if ("monto".equals(criterio)) {
            ordenadas = organizadorVentas.getVentasPorMonto();
        } else {
            ordenadas = organizadorVentas.getVentasPorFecha();
        }
        modeloLista.clear();
        for (Venta venta : ordenadas) {
            modeloLista.addElement("Venta: " + venta.getNombre() + ", Fecha: " + venta.getFecha() + ", Monto: $" + venta.getMonto());
        }
    }

    private void actualizarVista() {
        modeloLista.clear();
        for (Venta venta : organizadorVentas.getVentasPorFecha()) { // Default display by date
            modeloLista.addElement("Venta: " + venta.getNombre() + ", Fecha: " + venta.getFecha() + ", Monto: $" + venta.getMonto());
        }
    }
}

