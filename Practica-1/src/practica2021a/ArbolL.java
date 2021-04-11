package practica2021a; 

import java.util.LinkedList;
import java.util.ListIterator;

public class ArbolL<E extends Estado> extends Arbol<Estado> {
    private LinkedList<Nodo> lista;

    public ArbolL(LinkedList<Nodo> l){
        lista = l;
    }
    public ArbolL(){
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
        Nodo nodo = it.next();
        while((it.hasNext()) && (encontrado == false)){
            if (estado.equals(nodo.getEstado())){
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
        ListIterator<Nodo> it = lista.listIterator();

        while((it.hasNext()) && (encontrado == false)){
            if (estado.equals(it.next().getEstado())){
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
