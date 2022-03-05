package practica2021a;


/**
 * 
 * @author Lawrence Mandow
 * @date   2021-03-08
 * 
 * Nodo del �rbol de b�squeda.
 * Se compone del estado, valor g, y el puntero a su nodo padre (null si es la ra�z).
 *
 */
public class Nodo<E extends Estado>{
	E e;
	int g;
	Nodo<E> padre = null;
	
	public Nodo(E e, int g, Nodo<E> padre){
		this.e = e;
		this.g = g;
		this.padre = padre;
	}
	
	public E getEstado() {
		return this.e;
	}

	public int getG() {
		return this.g;
	}

	public Nodo<E> getPadre() {
		return this.padre;
	}
	
	public void setPadre(Nodo<E> p) {
		this.padre = p;
	}
	
	public void setG(int g) {
		this.g = g;
	}
	
	public String toString() {
		return  e.toString() + " (" + this.g + ") ";
	}

}