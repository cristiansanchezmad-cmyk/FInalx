package ficheros;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PruebaJson {
    static void main(String[] args) {

        Gson json = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Pais> listaPaises=new ArrayList<>(Arrays.asList(
               new Pais("Nueva Zelanda","Oceanía",1500000, Arrays.asList("NuevoZelandes","Ingles","Espanol")),
                new Pais("Mongolia","Asia",25400, Arrays.asList("Mongol","Ingles","Espanol"))


                ));
        Pais espanya = new Pais("España","Europa",6000000,Arrays.asList("Español", "Marooqui","Inglés"));

        System.out.println(listaPaises);

        String pais_json = json.toJson(listaPaises);
        System.out.println(pais_json);

        try {
//            FileWriter escribir = new FileWriter("src/main/resources/paises.json");
//
//            json.toJson(listaPaises,escribir);
//
//            escribir.close();

            FileWriter escribir_esp = new FileWriter("src/main/resources/espanya.json");

            json.toJson(espanya,escribir_esp);
            escribir_esp.close();

        } catch (IOException e) {
            System.out.println(e.getStackTrace());

        }

        try {
            FileReader leer = new FileReader("src/main/resources/espanya.json");
           Pais pais = json.fromJson(leer,Pais.class);
            System.out.println(pais.getNombre());
            leer.close();

            FileReader leer_lista = new FileReader("src/main/resourcer/paises.json");
            Pais paises[] = json.fromJson(leer_lista,Pais[].class);
            ArrayList<Pais> listapaises = new ArrayList<>(Arrays.asList(paises));
            leer_lista.close();

            for (Pais paisito : listapaises){

                System.out.println(paisito.getNombre());
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }


    }



}
