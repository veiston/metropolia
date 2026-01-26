package Task5LibraryStatistics;

import java.util.ArrayList;

public class Book {
    /* Declare the book variables*/
    private String title;
    private String author;
    private int publicationYear;

    /* Declare rating and reviews*/
    private double rating;
    private ArrayList<String> reviews = new ArrayList<>();

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.rating = 0.0;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getRating() {
        return rating;
    }

    public int getReviewCount() {
        return reviews.size();
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void addReview(String review) {
        reviews.add(review);
    }
}
