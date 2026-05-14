package ficheros;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChistesApp {
    public static void main(String[] args) {
        try {

            String apiUrl = "https://v2.jokeapi.dev/joke/Programming?type=single&lang=es";

            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            Gson gson = new Gson();
            Chistes chiste = gson.fromJson(response.toString(), Chistes.class);

            System.out.println("Chiste:");
            System.out.println(chiste.joke);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


