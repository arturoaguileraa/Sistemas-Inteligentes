package practica2021a;

import java.util.Random;


public class Malla {
	public final String OBSTACULO = "X";
	public final String LIBRE = " ";
	public final String POSI = "I";
	public final String POSF = "F";
	private static Random rnd;
	private int numFilas;
	private int numColumnas;
	private int numObstaculos;
	private String[][] matriz;
	private int posInii;
	private int posInij;
	private int posFini;
	private int posFinj;
	private int semilla;
	
	
	public Malla (int seed, int nf,int  nc, int nObs) {
		semilla = seed;
		rnd = new Random(semilla);
		numFilas = nf;
		numColumnas = nc;
		numObstaculos = nObs;
		
		String[][] matriz = new String[nf][nc];
		iniciarALibre(matriz, nf, nc);
		inicializarFI(matriz, rnd);
		meterPosiciones(matriz);
		meterObstaculos(matriz, rnd);

        this.matriz = matriz;
	}	

	private void iniciarALibre(String[][] matriz, int nf, int nc){ ///private
		for(int i=0; i<nf; i++){
			for(int j=0; j<nc; j++){
				matriz[i][j] = LIBRE;
			}
		}
	}

	private void meterObstaculos(String[][] matriz, Random rnd){ ///private y cambiar nombre
			int counter = 0;
		
			while (counter < numObstaculos){
				int lugarfila = rnd.nextInt(numFilas);
				int lugarcolumna = rnd.nextInt(numColumnas);

				if(matriz[lugarfila][lugarcolumna].equals(LIBRE)) {
					matriz[lugarfila][lugarcolumna] = OBSTACULO;
					counter++;
				}
			}
	}

	private void inicializarFI (String[][] matriz, Random rnd){
		int ii, ij, fi, fj;
		
		ii = rnd.nextInt(numFilas);
		ij = rnd.nextInt(numColumnas);
		if (matriz[ii][ij].equals(LIBRE)){
			posInii = ii;
			posInij = ij;
			
		}
		
		fi = rnd.nextInt(numFilas);
		fj = rnd.nextInt(numColumnas);
		if (matriz[fi][fj].equals(LIBRE)){
			posFini = fi;
			posFinj = fj;
		}
	}

	private void meterPosiciones(String[][] matriz) { //Juanma
        matriz[posFini][posFinj] = POSF;
		matriz[posInii][posInij] = POSI;
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

	public String[][] getMalla(){
		return matriz;
	}

    public int[] getposIni() {
		int[] posIni = new int[] {posInii, posInij};
		return posIni;
	}

	public int[] getposFin() {
		int[] posFin = new int[] {posFini, posFinj};
		return posFin;
	}

	public int getColumnas(){
		return numColumnas;
	}

	public int getFilas() {
		return numFilas;
	}

	public boolean equals(Malla a){
		return (this.getMalla().equals(a.getMalla()))&&(this.getposIni().equals(a.getposIni()))&&(this.getposFin().equals(a.getposFin()));
	}

	public int hashCode(){
		return Integer.hashCode(numFilas) + Integer.hashCode(numColumnas) + Integer.hashCode(numObstaculos) + Integer.hashCode(semilla) + 
		Integer.hashCode(getposIni()[0]) + 	Integer.hashCode(getposIni()[1]) + 	Integer.hashCode(getposFin()[0]) + Integer.hashCode(getposFin()[1]);



	}

}