package ficheros;

import java.io.*;

public class NasaApp {

    static void main(String[] args) {
        Nvae artemis = new Nvae("Artemis II",2000000, 1000);

        try {
            ObjectOutputStream nave = new ObjectOutputStream(new FileOutputStream("artemis2.ser"));

            nave.writeObject(artemis);

            nave.close();

            ObjectInputStream deserializo =  new ObjectInputStream (new FileInputStream("artemis2.ser"));
            Nvae nave_sorpresa = (Nvae) deserializo.readObject();
            System.out.println(nave_sorpresa.getNombre()+" "+nave_sorpresa.getPeso()+" "+nave_sorpresa.getVelovidad());

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
