 package practica2021a;

import java.util.HashMap;
import java.util.Iterator;

public class ArbolHM<E extends Estado> extends Arbol<Estado> {
    private HashMap<Nodo<EstadoMalla>, EstadoMalla> mapa;

    @Override
    public void put(Nodo<EstadoMalla> nodo) {
        mapa.put(nodo, nodo.getEstado());
    }

    @Override
    public Nodo<EstadoMalla> get(Estado estado) {
        boolean encontrado = false;
        Iterator<Nodo<EstadoMalla>> it = mapa.keySet().iterator();
        Nodo <EstadoMalla> nodo = it.next();
        while(it.hasNext() && !encontrado){
            if (nodo.getEstado().equals(estado)){
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
        Iterator<Nodo<EstadoMalla>> it = mapa.keySet().iterator();
        Nodo <EstadoMalla> nodo = it.next();
        while(it.hasNext() && !encontrado){
            if (nodo.getEstado().equals(estado)){
                encontrado = true;
            }else{
                 nodo = it.next();
            }
        }
        return encontrado;
    }

    @Override
    public void ver() {
        System.out.print("HashMap: [  ");
        Iterator<Nodo<EstadoMalla>> it = mapa.keySet().iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ~ " + it.next().getEstado() + "  ");
        }
        
        System.out.print("] \n");
    }
    
} 
