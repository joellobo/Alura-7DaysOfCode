package br.com.alura.integration;

import br.com.alura.entity.Movie;

import java.util.List;

public class Top250MoviesResponse {

    private List<Movie> items;
    private String errorMessage;

    public List<Movie> getItems() {
        return items;
    }
}
