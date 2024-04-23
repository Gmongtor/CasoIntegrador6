package Caso6.AnálisisOrganizacion;

import java.util.Date;

public class Venta {
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
