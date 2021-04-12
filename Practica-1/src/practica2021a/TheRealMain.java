package practica2021a;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.io.FileNotFoundException;

public class TheRealMain {
    
    public static void main(String[] args) {
        try {    
            PrintWriter pw = new PrintWriter("resultadosTest.txt");
            Random seeds = new Random();
            int[] columnas_filas = {10, 20, 30, 40, 50, 60, 70, 100};
            double [] proporcionObstaculos = {0.1, 0.3, 0.5, 0.8};

            for (int i = 0; i < columnas_filas.length; i++){
                pw.println("Dimension: " + columnas_filas[i] + "x" + columnas_filas[i]);
                pw.print("Tiempos: ");
                for (int j = 0; j < proporcionObstaculos.length; j++){
                    int noact = (int) (columnas_filas[i]*proporcionObstaculos[j]);
                    Malla malla = new Malla (seeds.nextInt(), columnas_filas[i], columnas_filas[i], noact);
                    Estado es = new EstadoMalla(malla, malla.getposIni()[0], malla.getposIni()[1]);
                    Estado eo = new EstadoMalla(malla, malla.getposFin()[0], malla.getposFin()[1]);
                    AgenteA prueba = new AgenteA();
                    long previous = System.nanoTime();
                    List<Estado> solucion = prueba.resuelve(es, eo);
                    long after = System.nanoTime();
                    long timeSpent = after - previous;
                    pw.print(proporcionObstaculos[j] + "->" + timeSpent + " ");
                }
                pw.println(" ");
            }
            pw.close();
            
        } catch (FileNotFoundException e){
            System.out.print(e.toString());
        }   
    }
}