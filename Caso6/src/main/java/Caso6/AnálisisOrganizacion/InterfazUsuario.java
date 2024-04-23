package Caso6.AnálisisOrganizacion;

import Caso6.GestiónDatosDinamicos.ListaDinamica;
import Caso6.GestiónDatosDinamicos.Pareja;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazUsuario extends JFrame {
    private ListaDinamica<Double> listaReales;
    private ListaDinamica<Pareja> listaParejas;
    // Componentes de la GUI como botones, campos de texto, etc.

    public InterfazUsuario() {
        // Inicializar las listas
        listaReales = new ListaDinamica<>();
        listaParejas = new ListaDinamica<>();

        // Configurar JFrame
        setSize(400, 300);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Agregar componentes a la GUI
        // Ejemplo: Botones para añadir elementos a las listas, modificarlos y eliminarlos
        // Debes implementar los listeners para manejar las acciones de los botones

        JButton btnAgregarReal = new JButton("Agregar Real");
        btnAgregarReal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí iría el código para agregar un elemento real
            }
        });

        // Añadir más componentes y configuraciones necesarias

        setVisible(true);
    }

    public static void main(String[] args) {
        new InterfazUsuario();
    }
}
