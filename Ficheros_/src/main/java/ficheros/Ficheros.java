package ficheros;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ficheros {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        ejercicio10();
    }

    public static void ejercicio9(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\activdad9"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\resources\\temporal"));
       String linea =" ";
            while ((linea= reader.readLine()) != null){

                String vectorLinea[] = linea.split(" ");

                    for ( String palabra : vectorLinea){

                       palabra= palabra.substring(0,1).toUpperCase() + palabra.substring(1);
                        System.out.println(palabra+" ");
                       writer.write(" "+palabra+" ");


                    }

            }
            reader.close();
            writer.close();
        } catch (IOException e){
            System.out.println(e.getStackTrace());
        }

    }

public static void ejercicio10(){
        try {

            BufferedReader archivo1 = new BufferedReader(new FileReader("C:\\Users\\2smrb\\Documents\\FInalx\\Ficheros_\\src\\main\\resources\\archivo"));
            BufferedReader archivo2 = new BufferedReader(new FileReader("C:\\Users\\2smrb\\Documents\\FInalx\\Ficheros_\\src\\main\\resources\\archivo2"));
            BufferedWriter resultado = new BufferedWriter(new FileWriter("C:\\Users\\2smrb\\Documents\\FInalx\\Ficheros_\\src\\main\\resources\\resultado"));

            String linea;
            Queue<String> cola = new LinkedList<>();

            while ((linea=archivo1.readLine())!= null){

                String palabritas [] = linea.split(" ");

                for (String palabra : palabritas){

                    cola.offer(palabra);

                }



            }

            Queue<String> cola2 = new LinkedList<>();
            while ((linea=archivo2.readLine())!= null){

                String palabritas [] = linea.split(" ");

                for (String palabra : palabritas){

                    cola2.offer(palabra);

                }



            }

            while (!cola.isEmpty() || !cola2.isEmpty()){

            resultado.write(cola.poll()+" "+ cola2.poll()+" ");

            }

            if (cola.isEmpty()) {
                while (!cola2.isEmpty()) {

                    resultado.write(" " + cola2.poll());

                }
            }

            if (cola2.isEmpty()){

                while (!cola.isEmpty()){

                    resultado.write(" "+cola.poll());
                }
            }
            archivo1.close();
            archivo2.close();
            resultado.close();

        }catch (IOException e){

            System.out.println(e.getStackTrace());
        }



}
}