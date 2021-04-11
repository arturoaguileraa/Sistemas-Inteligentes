package practica2021a;


public class Main {
    
    public static void main(String[] args) {
         Malla malla = new Malla(27, 10, 10, 25);
         Estado es = new EstadoMalla(malla, malla.getposIni()[0], malla.getposIni()[1]);
         Estado eo = new EstadoMalla(malla, malla.getposFin()[0], malla.getposFin()[1]);

         AgenteA prueba = new AgenteA();
         System.out.println(prueba.resuelve(es, eo).toString());

    }
}