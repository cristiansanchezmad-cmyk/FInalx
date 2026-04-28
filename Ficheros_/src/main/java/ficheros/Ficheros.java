package ficheros;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ficheros {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        File archivo = new File("src/main/resources/prueba.txt");
        System.out.println("Cuantos archivos quieres crear: ");
        int n = teclado.nextInt();
//        crearFicheros(n);
//        try {
//            if (archivo.createNewFile()) {
//                System.out.println("Archivo creado.");
//            } else {
//                System.out.println("Ruta no valida");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("ruta absoluta: "+archivo.getAbsolutePath());
//        System.out.println("tamaño: "+archivo.length());

//        if (archivo.exists()) {
//
//            System.out.println("Eliminando el archivo " + archivo.getName());
//
//        } else {
//
//            System.out.println("El archivo " + archivo.getName() + " no se ha eliminado");
//
//        }

//        File carpeta = new File("src/main/resources/prueba");
//
//        if (carpeta.mkdir()){
//
//            System.out.println("Carpeta: "+carpeta.getName()+" creada.");
//        }else{
//
//            System.out.println("La carpeta no se ha creado.");
//
//        }

        File carpeta = new File("src/main/resources/prueba");
        String nombre_ficheros [] = carpeta.list();

        for (String nombre : nombre_ficheros){

            System.out.println(nombre);

        }

        File ficheros[] = carpeta.listFiles();

        for (File nombre : ficheros){

            if (nombre.isFile()){

                System.out.println(nombre.getName()+" tamaño "+nombre.length());

            }

        }
    }

    public static void crearFicheros(int num){

        System.out.println("Dime la carpeta donde lo quieres crear");
        teclado.nextLine();
        String carpeta = teclado.nextLine();
        System.out.println("Generando archivos...");
        for (int i = 0; i < num; i++) {

            File file = new File("src/main/resources/"+carpeta+"/prueba"+(i)+".txt");
            try {
                if (file.createNewFile()) {
                    System.out.println("Archivo"+file.getName()+"creado correctamente.");
                    System.out.println("Ruta absoluta"+file.getAbsolutePath());
                } else {
                    System.out.println("Archivo"+file.getName()+"no se pudo crear.");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


}