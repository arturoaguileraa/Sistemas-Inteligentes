package practica2021a;

import java.util.Random;


public class Malla {
	
	private static Random rnd;
	private int numFilas;
	private int numColumnas;
	private int numObstaculos;
	private int [][] matriz;
	private int posInii;
	private int posInij;
	private int posFini;
	private int posFinj;
	
	
	public Malla (int seed, int nf,int  nc, int nObs) {
		
		rnd = new Random(seed);
		numFilas = nf;
		numColumnas = nc;
		numObstaculos = nObs;
		
		int matriz[][] = new int [nf][nc];
		iniciaracero(matriz, nf, nc);
		meterObstaculos(matriz, rnd);
		inicializarFI(matriz, rnd);

        this.matriz = matriz;
		
	}	

	private void iniciaracero(int matriz[][], int nf, int nc){ ///private
		for(int i=0; i<nf; i++){
			for(int j=0; j<nc; j++){
				matriz[i][j] = 0;
			}
		}
	}

	private void inicializarFI (int [][] matriz, Random rnd){
		int ii, ij, fi, fj;
		do{ 
			ii = rnd.nextInt(numFilas);
			ij = rnd.nextInt(numColumnas);
			
			if (matriz[ii][ij] != 1){
				posInii = ii;
				posInij = ij;
			}
		}while(matriz[ii][ij] == 1);

		do{
			fi = rnd.nextInt(numFilas);
			fj = rnd.nextInt(numColumnas);
			if (matriz[fi][fj] != 1){
				posFini = fi;
				posFinj = fj;
			}
		}while(matriz[fi][fj] == 1);

	}

	private void meterObstaculos(int [][] matriz, Random rnd){ ///private y cambiar nombre
 		int counter = 0;
	
		while (counter < numObstaculos){
			 int lugarfila = rnd.nextInt(numFilas);
			 int lugarcolumna = rnd.nextInt(numColumnas);

			 if(matriz[lugarfila][lugarcolumna]!=1){
        	    matriz[lugarfila][lugarcolumna]=1;
				counter++;
			 }
		}
	}

    public void ver () {  //aquui falta incluir en la malla de forma visual las posiciones inicial y final
		System.out.println("Posicion inicial: (" + posInii + ", " + posInij + ")");
		System.out.println("Posicion final: (" + posFini + ", " + posFinj + ")");
		
		System.out.println("Malla: ");
		System.out.println();
		for(int i=0; i < numFilas; i++){
			for(int j=0; j < numColumnas; j++){
				
				System.out.print(matriz[i][j] + " ");	
			}
			System.out.println();
		}
	}

	public int[][] getMalla(){
		return matriz;
	}

    public int[] getposIni() {
		int[] posIni = new int[2];
		posIni[0] = posInii;
		posIni[1] = posInij;
		return posIni;
	}

	public int[] getposFin() {
		int[] posFin = new int[2];
		posFin[0] = posFini;
		posFin[1] = posFinj;
		return posFin;
	}

	public boolean equals(Malla a){
		return (this.getMalla().equals(a.getMalla()))&&(this.getposIni().equals(a.getposIni()))&&(this.getposFin().equals(a.getposFin()));
	}

	public int hashCode(){
		return Integer.hashCode(numFilas) + Integer.hashCode(numColumnas) + Integer.hashCode(numObstaculos);
	}

}