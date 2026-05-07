package ficheros;

import java.io.*;

public class Binarios {

    static void main(String[] args) {

        try {
            DataOutputStream binario = new DataOutputStream(new FileOutputStream(("src/main/resources/fichero_binario.bin")));
            binario.writeBoolean(true);
            binario.writeChar('x');
            binario.writeInt(11);
            binario.writeUTF("holaaaaaaaaa");

            binario.close();


        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

    }
}
