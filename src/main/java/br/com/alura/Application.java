package br.com.alura;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Application {

    public static void main(String[] args) {
        String imdbKey = System.getenv("IMDB_KEY");
        String url = "https://imdb-api.com/en/API/Top250Movies/%s".formatted(imdbKey);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            Resposta movies = new Gson().fromJson(response.body(), Resposta.class);

            movies.getItems().forEach(movie -> System.out.println("%s %s".formatted(movie.getTitle(), movie.getImage())));

        } catch (Exception e) {
            throw new RuntimeException("Bad Things Happen!!!");
        }
    }

}
