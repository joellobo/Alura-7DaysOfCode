package br.com.alura;

import br.com.alura.integration.IMDB;
import br.com.alura.output.HTMLGenerator;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Application {

    public static final String IMDB_HTML = "imdb.html";
    public static final String IMDB_KEY = "IMDB_KEY";

    public static void main(String[] args) {
        try (Writer writer = new PrintWriter(IMDB_HTML)) {
            new HTMLGenerator(writer).generate(IMDB.search(System.getenv(IMDB_KEY)).getItems());
        } catch (IOException e) {
            throw new RuntimeException("Bad things happen!!!");
        }
    }
}
