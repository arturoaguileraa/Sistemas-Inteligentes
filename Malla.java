import java.util.Random;



public class Malla {
	
	private static Random rnd;
	private int numfilas;
	private int numColumnas;
	private int numObstaculos;
	private int [][] matriz;
	private int posInii;
	private int posInij;
	private int posFini;
	private int posFinj;
	
	
	public Malla (int seed, int nf,int  nc, int nObs) {
		
		rnd = new Random(seed);
		numfilas = nf;
		numColumnas = nc;
		numObstaculos = nObs;
		
		int matriz[][] = new int [nf][nc];
		meterObstaculos(matriz, rnd);

        this.matriz = matriz;
		
	}
		
	public void ver (Malla a) {

		for(int i=0; i < numfilas; i++){
			for(int j=0; j < numColumnas; j++){
				
				System.out.println(matriz[i][j]);
			}
			System.out.println();
		}
	}

	public void meterObstaculos(int [][] matriz, Random rnd){
 	int counter = 0;
    int posIi, posIj, posFi, posFj;
	
	 while (counter < numObstaculos){
		 int lugarfila = rnd.nextInt(numfilas);
		 int lugarcolumna = rnd.nextInt(numColumnas);

		 if(matriz[lugarfila][lugarcolumna]!=1){
            matriz[lugarfila][lugarcolumna]=1;
			counter++;
		 }
		}

		int ii = rnd.nextInt(numfilas);
		int ij = rnd.nextInt(numColumnas);
		int fi = rnd.nextInt(numfilas);
		int fj = rnd.nextInt(numColumnas);
		if ((matriz[ii][ij] != 1) && (matriz[fi][fj] != 1)){
			posInii = ii;
			posInij = ij;
			posFini = fi;
			posFinj = fj;
		}






        int i = rnd.nextInt(numfilas);
		int j = rnd.nextInt(numColumnas);
        
        while (posIi )



       
        
	}
    
    public void posIni (){
		return System.out.println("Posicion inicial: (" ++ posInii ++ ", " ++ posInij ++ ")");
	}
	public void posFin(){
		
	} 

}