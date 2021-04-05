package practica2021a;

import java.util.Iterator;
import java.util.PriorityQueue;

public class AbiertosPQ<E extends Estado> extends Abiertos<Estado> {
    private PriorityQueue<NodoAB> nodos;

    public AbiertosPQ() {
        nodos = new PriorityQueue<>();
    }

    @Override
    public boolean isEmpty() {
        return nodos.isEmpty();
    }

    @Override
    public void offer(int f, Estado e) {
        NodoAB newNodo = new NodoAB(f, e);
        nodos.add(newNodo);
    }

    @Override
    public Estado poll() {
        return nodos.poll().getEstado();
    }

    @Override
    public void remove(Estado e2) {

    PriorityQueue<NodoAB> placeholder = new PriorityQueue<>();
    while (!nodos.isEmpty()){
       NodoAB node = nodos.poll();
        if(!node.getEstado().equals(e2)){
            placeholder.add(node);
        }

    }
    nodos = placeholder;
    }

    @Override
    public int size() {
        return nodos.size();
    }

    @Override
    public void ver() {
        Iterator<NodoAB> it = nodos.iterator();
        while (it.hasNext()) {
            NodoAB nodo = it.next();
            System.out.print("Estado: ");
            nodo.getEstado().ver();
            System.out.print("Con prioridad: " + nodo.getF());
        }
    }
}
