package br.com.alura.entity;

public class Movie {

    private String id;
    private int rank;
    private String title;
    private String fullTitle;
    private int year;
    private String image;
    private String crew;
    private double imDbRating;
    private int imDbRatingCount;

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
