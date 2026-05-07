package ficheros;

import java.io.*;

public class Escritor {

    static void main(String[] args) {

        palabras();
    }

    public static void palabras(){

        try {

            BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\2smrb\\Documents\\FInalx\\Ficheros_\\src\\main\\resources\\prueba.txt"));
            BufferedWriter escritor = new BufferedWriter(new FileWriter("C:\\Users\\2smrb\\Documents\\FInalx\\Ficheros_\\src\\main\\resources\\epa.txt"));

            String linea;

            while ((linea=lector.readLine())!=null){
                String palabras_linea[]= linea.split(" ");

                for (String palabrta : palabras_linea){

                    escritor.write(palabrta.substring(0,1).toUpperCase()+palabrta.substring(1));

                }

            }
            lector.close();
            escritor.close();
        }catch (IOException e){

            throw  new RuntimeException(e);
        }


    }
}
