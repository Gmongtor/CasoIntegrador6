package Caso6.AnálisisOrganizacion;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AnalizadorTransacciones {
    private List<Venta> ventas;

    public AnalizadorTransacciones(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<Venta> filtrarPorMontoMinimo(double montoMinimo) {
        return ventas.stream()
                .filter(venta -> venta.getMonto() >= montoMinimo)
                .collect(Collectors.toList());
    }

    public List<Venta> filtrarPorFecha(Date desde, Date hasta) {
        return ventas.stream()
                .filter(venta -> (venta.getFecha().after(desde) || venta.getFecha().equals(desde)) &&
                        (venta.getFecha().before(hasta) || venta.getFecha().equals(hasta)))
                .collect(Collectors.toList());
    }
}

