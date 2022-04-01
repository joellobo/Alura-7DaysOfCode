package br.com.alura;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Application {

    public static void main(String[] args) {
        String imdbKey = System.getenv("IMDB_KEY");
        String url = "httpsa//imdb-api.com/en/API/Top250Movies/%s".formatted(imdbKey);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement je = JsonParser.parseString(response.body());

            System.out.println(gson.toJson(je));

        } catch (Exception e) {
            throw new RuntimeException("Bad Things Happen!!!", e);
        }
    }
}
