package practica2021a;

import java.util.LinkedList;

public class ArbolL<E extends Estado> extends Arbol<Estado> {
    private LinkedList<Nodo<EstadoMalla>> lista;

    @Override
    public void put(Nodo nodo) {

    }

    @Override
    public boolean containsKey(Estado estado) {
        return false;
    }

    @Override
    public Nodo get(Estado estado) {
        return null;
    }

    @Override
    public void ver() {
    }
    
}
