package practica2021a;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.io.FileNotFoundException;

public class Main {
    
    public static void main(String[] args) {
        try {    
            PrintWriter pw  = new PrintWriter("resultadosTestA.txt");
            PrintWriter pw2 = new PrintWriter("resultadosTestB.txt");
            Random seeds = new Random();
            
            for (int i = 10; i <= 400; i+=10){ //la var i indica la dimensión de la malla que se estudia (i=20 implica una malla de 20x20)
                pw.print(i + "x" + i);
                pw2.print(i + "x" + i);

                for (double j = 0; j<=1; j = j+0.05){ //la var j indica el indice de obstaculos por casillas en la malla (j=0,5 implica que el 50% de las casillas son obstaculos)
                    int numobstaculos = (int) (i*i*j);
                    Malla malla = new Malla (seeds.nextInt(), i, i, numobstaculos);
                    Estado es = new EstadoMalla(malla, malla.getposIni()[0], malla.getposIni()[1]);
                    Estado eo = new EstadoMalla(malla, malla.getposFin()[0], malla.getposFin()[1]);
                    
                    AgenteA prueba = new AgenteA();
                    long previous = System.nanoTime();
                    List<Estado> solucion = prueba.resuelve(es, eo);
                    long after = System.nanoTime();
                    long timeSpent = after - previous;
                    pw.print(":" + timeSpent);
                
                    
                    AgenteB prueba2 = new AgenteB();
                    previous = System.nanoTime();
                    solucion = prueba2.resuelve(es, eo);
                    after = System.nanoTime();
                    timeSpent = after - previous;
                    pw2.print(":" + timeSpent);
                } 

                pw.println(" ");
                pw2.println(" ");
            }
            
            pw.close();
            pw2.close();
            
        } catch (FileNotFoundException e){
            System.out.print(e.toString());
        }   
    }
}