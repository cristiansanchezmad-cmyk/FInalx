package ficheros;

import java.util.Random;

public class ExamenUD2_Parte2 {
    static void main(String[] args) {
        Random ale = new Random();
        int resultado = 0;
        int numero= ale.nextInt(500,100000)+1;
       String numerillo =Integer.toString(numero);

        int posicion=0;
        System.out.println("Suma descendente del número generado:"+numero);
        for (int i = 0; i < numerillo.length() ; i++) {


            resultado+=Integer.parseInt(numerillo.substring(posicion));


            posicion++;



        }

        System.out.println(resultado);



    }
}
