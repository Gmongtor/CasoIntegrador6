package Caso6.AnálisisOrganizacion;

import java.util.Date;

public class Venta {
    private String nombre;
    private Date fecha;
    private double monto;

    public Venta(String nombre, Date fecha, double monto) {
        this.fecha = fecha;
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public Object getNombre() {
        return null;
    }

    public void setNombre(String nuevoNombre) {
    }

    public void setFecha(Date nuevaFecha) {
    }

    public void setMonto(double nuevoMonto) {
    }
}
