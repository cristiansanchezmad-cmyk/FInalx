package ficheros;

import java.util.Scanner;

public class ExamenUD2 {
    static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("*** BIENVENIDO A LA APP DE BRONCAS ***");
        System.out.println("---------------------------------------------------");
        int cont=1;
        String opcion;
        int broncafinal=0;


        do {
            int bronca=50;
            System.out.println("Datos de la bronca"+cont);
            System.out.println("Selecciona la persona encargada de la bronca");
            System.out.println("[-]. Profes");
            System.out.println("[-]. Padre");
            System.out.println("[-]. Madre");
            System.out.println("[-]. Monitor (extraescolares)");
            System.out.println("[-]. Suegra");
            System.out.println("Otros");
            System.out.println("----------------------------------------------");
            System.out.print("Elige una opción--> ");
            String familia=teclado.nextLine();

            switch (familia.toLowerCase()){

                case "profes":

                    bronca=bronca*10;

                    break;

                case "padre":

                    bronca=bronca*100;

                    break;

                case "madre":


                    bronca=bronca*100;

                    break;

                case "monitor":

                    bronca=bronca*5;

                    break;

                case "suegra":


                    bronca=bronca*1000;

                    break;


                default:
                    System.out.println("Opcion no válida");
                    break;

            }
            System.out.println("Puntuación de la bronca "+cont+" : "+bronca);
            System.out.print("¿Quieres añadir otra bronca? (S/N) ");
            opcion=teclado.nextLine();
            cont++;
            broncafinal+=bronca;


        }while (opcion.equalsIgnoreCase("s"));

        System.out.println("Resultados semanales:");
        System.out.println("---------------------------------------");
        System.out.println("Puntuación total: "+broncafinal);

        if (broncafinal>=100000){

            System.out.println("ESTA SEMANA SIN PAGA");

        } else if (broncafinal>10000 && broncafinal<100000) {

            System.out.println("ESTA SEMANA MEDIA PAGA");


        } else if (broncafinal<10000) {

            System.out.println("ESTA SEMANA TE LIBRAS");

        }

    }
}
