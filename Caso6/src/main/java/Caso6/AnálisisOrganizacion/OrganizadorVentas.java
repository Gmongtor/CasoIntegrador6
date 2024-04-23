package Caso6.AnálisisOrganizacion;

import java.util.*;

class OrdenarPorFecha implements Comparator<Venta> {
    @Override
    public int compare(Venta v1, Venta v2) {
        return v1.getFecha().compareTo(v2.getFecha());
    }
}

class OrdenarPorMonto implements Comparator<Venta> {
    @Override
    public int compare(Venta v1, Venta v2) {
        return Double.compare(v1.getMonto(), v2.getMonto());
    }
}

public class OrganizadorVentas {
    private TreeSet<Venta> ventasPorFecha = new TreeSet<>(new OrdenarPorFecha());
    private TreeSet<Venta> ventasPorMonto = new TreeSet<>(new OrdenarPorMonto());

    public void agregarVenta(Venta venta) {
        ventasPorFecha.add(venta);
        ventasPorMonto.add(venta);
    }

    public TreeSet<Venta> getVentasPorFecha() {
        return ventasPorFecha;
    }

    public TreeSet<Venta> getVentasPorMonto() {
        return ventasPorMonto;
    }
}

