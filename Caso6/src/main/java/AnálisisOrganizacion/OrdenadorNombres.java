package AnálisisOrganizacion;

import java.util.TreeSet;

public class OrdenadorNombres {
    private TreeSet<String> nombres;

    public OrdenadorNombres() {
        nombres = new TreeSet<>();
    }

    public void agregarNombre(String nombre) {
        nombres.add(nombre);
    }

    public TreeSet<String> getNombresOrdenados() {
        return nombres;
    }
}
