package practica2021a;

import java.util.ArrayList;
import java.util.List;

public class AbiertosLista<E extends Estado> extends Abiertos<Estado> {
    private List<NodoAB> nodos;

    public AbiertosLista() {
        nodos = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return nodos.isEmpty();
    }

    @Override
    public void offer(int f, Estado e) {
        int i=0;
        NodoAB newNodo = new NodoAB(f, e);
        if (nodos.isEmpty()) {
            nodos.add(newNodo);
        } else {
            while (newNodo.compareTo(nodos.get(i)) > 0) {
                i++;
            }
            nodos.add(i, newNodo);
        }
    }

    @Override
    public Estado poll() {
        Estado res = nodos.get(0).getEstado();
        nodos.remove(0);
        return res;
    }

    @Override
    public void remove(Estado e2) {
        boolean found = false;
        int i=0;
        while (!found && i < nodos.size()) {
            if (nodos.get(i).getEstado().equals(e2)) {
                found = true;
            } else {
                i++;
            }
        }
        if (found) {
            nodos.remove(i);
        }
    }

    @Override
    public int size() {
        return nodos.size();
    }

    @Override
    public void ver() {
        for (int i = 0; i < nodos.size(); i++){
            System.out.print("Estado: ");
            nodos.get(i).getEstado().ver();
            System.out.print("Con prioridad: " + nodos.get(i).getF());
        }
        
    }
}
