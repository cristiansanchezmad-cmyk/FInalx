package ficheros;

import java.io.File;
import java.io.IOException;

public class Ficheros {

    public static void main(String[] args) {
        File archivo = new File("prueba.txt");

        try {
            if (archivo.createNewFile()){
                System.out.println("Archivo creado.");
            }else{
                System.out.println("Ruta no valida");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
