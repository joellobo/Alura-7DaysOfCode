package br.com.alura.integration;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class IMDB {

    public static Top250MoviesResponse search(String key) {
        String url = "https://imdb-api.com/en/API/Top250Movies/%s".formatted(key);
        Top250MoviesResponse movies;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            movies = new Gson().fromJson(response.body(), Top250MoviesResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Bad Things Happen!!!");
        }
        return movies;
    }
}
