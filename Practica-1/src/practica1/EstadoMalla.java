package practica1;

import java.util.ArrayList;
import java.util.List;
import java.math.*;

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
		this.malla = malla;
		this.i = i;
		this.j = j;		
	}

	@Override
	public List<? extends Estado> calculaSucesores(Malla m) {
		EstadoMalla estadoFuturo;
		int[][] matrizMalla = malla.getMalla();
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
		int[][] matrizMalla = malla.getMalla();
		return ((x<matrizMalla.length) && (y<matrizMalla[0].length) && (matrizMalla[x][y] != 1));
	}

	
	@Override
	public int coste(Estado e2) {
		EstadoMalla estado2 = (EstadoMalla) e2;
		
	}

	@Override
	public int h(Estado objetivo) {
		EstadoMalla objective = (EstadoMalla) objetivo;
		return (Math.abs(i - objective.i) + Math.abs(j - objective.j));
	}

	@Override
	public boolean equals(Estado e2) {
		EstadoMalla estado2 = (EstadoMalla) e2;
		return (i==estado2.i)&&(estado2.j==j)&&(malla.equals(estado2.malla));
	}

	@Override
	public int hashCode(){
		return malla.hashCode() + Integer.hashCode(i) + Integer.hashCode(j);
	}

	@Override
	public void ver() {
		System.out.print("Posicion actual: (" + this.i + ", " + this.j + ")\n");
		malla.ver();
	}	
}
