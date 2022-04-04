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

    public String getId() {
        return id;
    }

    public int getRank() {
        return rank;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public int getYear() {
        return year;
    }

    public String getCrew() {
        return crew;
    }

    public double getImDbRating() {
        return imDbRating;
    }

    public int getImDbRatingCount() {
        return imDbRatingCount;
    }
}
