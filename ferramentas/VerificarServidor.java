package ferramentas;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class VerificarServidor {
    public static void main(String[] args) throws IOException {
        String[] urls = {"http://localhost:8080/", "http://localhost:8080/api/produtos"};

        for (String urlString : urls) {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            System.out.println(urlString + " -> HTTP " + status);
            connection.disconnect();
        }
    }
}
