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
        boolean encontrado = false;
        Iterator<Estado> it = mapa.keySet().iterator();
        Estado sig = null;
        while(it.hasNext() && !encontrado){
            sig = it.next();
            if (sig.equals(estado)){
                encontrado = true;
            }
        }
        return mapa.get(sig);
    }

    @Override
    public boolean containsKey(Estado estado) {
        boolean encontrado = false;
        Iterator<Estado> it = mapa.keySet().iterator();
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
