package practica2021a; 

import java.util.LinkedList;
import java.util.ListIterator;

public class ArbolL<E extends Estado> extends Arbol<Estado> {
    private LinkedList<Nodo> lista;

    public ArbolL(LinkedList<Nodo> l) {
        lista = l;
    }

    public ArbolL() {
        lista = new LinkedList<>();
    }
    
    @Override
    public void put(Nodo nodo){
        lista.addLast(nodo);
    }

    @Override
    public Nodo get(Estado estado) {
        boolean encontrado = false;
        ListIterator<Nodo> it = lista.listIterator();
        Nodo nodo = null;
       
        while((it.hasNext()) && (!encontrado)){
            nodo = it.next();
            if (estado.equals(nodo.getEstado())){
                encontrado = true;
            }
        }
        
        return nodo;
    }

    @Override
    public boolean containsKey(Estado estado) {
        boolean encontrado = false;
        ListIterator<Nodo> it = lista.listIterator();
        
        while((it.hasNext()) && (!encontrado)){
            Estado es = it.next().getEstado();
            if (estado.equals(es)) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    @Override
    public void ver() {
        System.out.print("List: \n[ ");
        for(Nodo nodo : lista){
            System.out.print(nodo.toString() + " ");
        }
        System.out.println("]");

    }
    
}
