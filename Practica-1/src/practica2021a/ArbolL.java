package practica2021a; 

import java.util.LinkedList;
import java.util.ListIterator;

public class ArbolL<E extends Estado> extends Arbol<Estado> {
    private LinkedList<Nodo<EstadoMalla>> lista;

    @Override
    public void put(Nodo<EstadoMalla> nodo){
        lista.addLast(nodo);
    }

    @Override
    public Nodo<EstadoMalla> get(Estado estado) {
        
        boolean encontrado = false;
        ListIterator<Nodo<EstadoMalla>> it = lista.listIterator();
        Nodo<EstadoMalla> nodo = it.next();
        while((it.hasNext()) && (encontrado == false)){
            if (estado.equals(it.next().getEstado())){
                encontrado = true;
            }else{
                nodo = it.next();
            }
        }
        return encontrado? nodo:null;
    }

    @Override
    public boolean containsKey(Estado estado) {
        boolean encontrado = false;
        ListIterator<Nodo<EstadoMalla>> it = lista.listIterator();

        while((it.hasNext()) && (encontrado == false)){
            if (estado.equals(it.next().getEstado())){
                encontrado = true;
            }
        }
        return encontrado;
    }

    @Override
    public void ver() {
        System.out.print("List: [ ");
        for(Nodo<EstadoMalla> nodo : lista){
            System.out.print(nodo + " ");
        }
        System.out.print("] \n");

    }
    
}
