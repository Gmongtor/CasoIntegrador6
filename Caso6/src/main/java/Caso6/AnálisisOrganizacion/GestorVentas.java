package Caso6.AnálisisOrganizacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorVentas {
    private List<Venta> ventas;

    public GestorVentas() {
        this.ventas = new ArrayList<>();
    }

    public void agregarVenta(String nombre, Date fecha, double monto) {
        ventas.add(new Venta(nombre, fecha, monto));
    }

    public boolean eliminarVenta(String nombre) {
        return ventas.removeIf(venta -> venta.getNombre().equals(nombre));
    }

    public void modificarVenta(String nombreOriginal, String nuevoNombre, Date nuevaFecha, double nuevoMonto) {
        for (Venta venta : ventas) {
            if (venta.getNombre().equals(nombreOriginal)) {
                venta.setNombre(nuevoNombre);
                venta.setFecha(nuevaFecha);
                venta.setMonto(nuevoMonto);
                break;  // Si se asume que no hay nombres duplicados
            }
        }
    }

    public Venta[] getVentas() {
        return ventas.toArray(new Venta[0]);
    }
}

