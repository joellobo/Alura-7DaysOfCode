package br.com.alura;

import br.com.alura.integration.IMDB;
import br.com.alura.integration.Top250MoviesResponse;

public class Application {

    public static void main(String[] args) {
        String imdbKey = System.getenv("IMDB_KEY");
        Top250MoviesResponse movies = IMDB.search(imdbKey);
        movies.getItems().forEach(movie -> System.out.println("%s %s".formatted(movie.getTitle(), movie.getImage())));
    }

}
