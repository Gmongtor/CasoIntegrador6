package GestiónDatosDinamicos;

import java.util.ArrayList;
import java.util.List;

public class ListaDinamica<T> {
    private List<T> elementos;

    public ListaDinamica() {
        this.elementos = new ArrayList<>();
    }

    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public T obtener(int indice) {
        if(indice >= 0 && indice < elementos.size()) {
            return elementos.get(indice);
        }
        return null;
    }

    public void modificar(int indice, T nuevoElemento) {
        if(indice >= 0 && indice < elementos.size()) {
            elementos.set(indice, nuevoElemento);
        }
    }

    public void eliminar(int indice) {
        if(indice >= 0 && indice < elementos.size()) {
            elementos.remove(indice);
        }
    }

    public List<T> obtenerTodos() {
        return new ArrayList<>(elementos);
    }
}

