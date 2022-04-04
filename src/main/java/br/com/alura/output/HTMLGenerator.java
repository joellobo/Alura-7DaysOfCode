package br.com.alura.output;

import br.com.alura.entity.Movie;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class HTMLGenerator {

    private final String head =
            """
            <head>
            <meta charset="utf-8">
            </head>
            """;

    private final String divTemplate =
            """
            <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
                <h4 class="card-header">%s</h4>
                <div class="card-body">
                    <img class="card-img" src="%s" alt="%s">
                    <p class="card-text mt-2">Nota: %s - Ano: %s</p>
                </div>
            </div>
            """;

    private Writer writer;

    private HTMLGenerator() {
        // NOP
    }

    public HTMLGenerator(Writer writer) {
        this.writer = writer;
    }

    public void generate(List<Movie> movies) throws IOException {
            writer.append(head);
            for (Movie movie : movies) {
                writer.append(String.format(divTemplate, movie.getTitle(), movie.getImage(),
                        movie.getTitle(), movie.getImDbRating(), movie.getYear()));
            }
            writer.flush();
    }
}
