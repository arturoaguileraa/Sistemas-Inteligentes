package practica2021a;

import java.util.HashMap;
import java.util.Iterator;

public class ArbolHM<E extends Estado> extends Arbol<Estado> {
    private HashMap<Estado, Nodo> mapa;

    public ArbolHM(HashMap<Estado, Nodo> m){
        mapa = m; 
    }
    public ArbolHM(){
        mapa = new HashMap<Estado, Nodo>();
    }

    @Override
    public void put(Nodo nodo) {
        mapa.put(nodo.getEstado(),  nodo);
    }

    @Override
    public Nodo get(Estado estado) {
        return mapa.get(estado);
    }

    @Override
    public boolean containsKey(Estado estado) {
        return mapa.containsKey(estado);
    }

    @Override
    public void ver() {
        
        System.out.print("HashMap: [  ");
        Iterator<Estado> it = mapa.keySet().iterator();
        Estado sig = it.next();

        System.out.print("(" + sig.toString() + " ~ " + mapa.get(sig).toString() + ")");
        while(it.hasNext()){
            sig = it.next();
            System.out.print(", (" + sig.toString() + " ~ " + mapa.get(sig).toString() + ")");
        }
        
        System.out.print("] \n"); 
        
    }
    
} 
