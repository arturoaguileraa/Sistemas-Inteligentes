package practica2021a;

import java.util.HashMap;
import java.util.Iterator;

public class ArbolHM<E extends Estado> extends Arbol<Estado> {
    private HashMap<EstadoMalla, Nodo<EstadoMalla>> mapa;

    @Override
    public void put(Nodo<EstadoMalla> nodo) {
        mapa.put(nodo.getEstado(), nodo);
    }

    @Override
    public Nodo<EstadoMalla> get(Estado estado) {
        boolean encontrado = false;
        Iterator<EstadoMalla> it = mapa.keySet().iterator();
        EstadoMalla sig = it.next();
        while(it.hasNext() && !encontrado){
            if (sig.equals(estado)){
                encontrado = true;
            }else{
                 sig = it.next();
            }
        }
        return encontrado? mapa.get(sig):null;
    }

    @Override
    public boolean containsKey(Estado estado) {
        boolean encontrado = false;
        Iterator<EstadoMalla> it = mapa.keySet().iterator();
        while(it.hasNext() && !encontrado){
            if (it.next().equals(estado)){
                encontrado = true;
            }
        }
        return encontrado;
    }

    @Override
    public void ver() {
        /*
        System.out.println("HashMap: ");   
        System.out.println(mapa.toString()); //Aquí creo que no expulsaría bien ni el toString del Estado malla ni el del nodo
        */
        
        System.out.print("HashMap: [  ");
        Iterator<EstadoMalla> it = mapa.keySet().iterator();
        EstadoMalla sig = it.next();

        System.out.print("(" + sig.toString() + " ~ " + mapa.get(sig).toString() + ")");
        while(it.hasNext()){
            sig = it.next();
            System.out.print(", (" + sig.toString() + " ~ " + mapa.get(sig).toString() + ")");
        }
        
        System.out.print("] \n"); 
        
    }
    
} 
