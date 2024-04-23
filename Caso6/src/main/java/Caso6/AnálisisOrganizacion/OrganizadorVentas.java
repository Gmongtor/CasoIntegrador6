package Caso6.AnálisisOrganizacion;

import java.util.*;

class Venta {
    private Date fecha;
    private double monto;

    public Venta(Date fecha, double monto) {
        this.fecha = fecha;
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }
}

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

