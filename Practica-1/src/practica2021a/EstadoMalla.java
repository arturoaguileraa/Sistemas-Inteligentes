package practica2021a;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L.Mandow 
 * @date  2021-03-11
 * 
 * Plantilla para representar los estados de la practica
 *
 */

public class EstadoMalla implements Estado {
	private Malla malla;
	private int i;
	private int j;

	public EstadoMalla(Malla malla, int i, int j) {
		this.i = i;
		this.j = j;
		this.malla = malla;
	}

	@Override
	public List<? extends Estado> calculaSucesores() {
		EstadoMalla estadoFuturo;
		List<EstadoMalla> res = new ArrayList<>(4);
	

		if (esValido(i + 1,j)) {	// arriba
			estadoFuturo = new EstadoMalla(this.malla, this.i + 1, this.j);
			res.add(estadoFuturo);
		} 
		if(esValido(i - 1,j)){		// abajo
			estadoFuturo = new EstadoMalla(this.malla, this.i - 1, this.j);
			res.add(estadoFuturo);
		}
		if(esValido(i,j + 1)){		// derecha
			estadoFuturo = new EstadoMalla(this.malla, this.i, this.j + 1);
			res.add(estadoFuturo);
		} 
		if(esValido(i,j - 1)){		// izquierda
			estadoFuturo = new EstadoMalla(this.malla, this.i, this.j - 1);
			res.add(estadoFuturo);
		}
		return res;
	}
	
	protected boolean esValido(int x, int y){
		String[][] matrizMalla = malla.getMalla();
		return ((x>=0) && (y>=0) && (x<malla.getFilas()) && (y<malla.getColumnas()) && (!matrizMalla[x][y].equals(malla.OBSTACULO)));
	}

	
	@Override
	public int coste(Estado e2) {
		return 1;
	}

	@Override
	public int h(Estado objetivo) {
		EstadoMalla objective = (EstadoMalla) objetivo;
		return (Math.abs(i - objective.i) + Math.abs(j - objective.j));
	}

	@Override
	public boolean equals(Object e2) {
		boolean res = false;
		if (e2 instanceof EstadoMalla) {
			EstadoMalla estado2 = (EstadoMalla) e2;
			res = (i==estado2.i) && (estado2.j==j);
		}
		return res;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	@Override
	public int hashCode(){
		return malla.hashCode() + Integer.hashCode(i) + Integer.hashCode(j);
	}

	@Override
	public void ver() {
		System.out.print("Posicion actual: (" + this.i + ", " + this.j + ")\n");
	}
}