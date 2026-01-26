package Task4RatingsReviews;

public class LibraryMain {
    public static void main(String[] args) {
        /* Create books*/
        Book book1 = new Book("Olin isisin vanki", "Fatim", 2020);
        Book book2 = new Book("Mikä Liberalismia vaivaa", "Pontus Purokuru", 2018);
        Book book3 = new Book("Homo deus", "Yuval Noah Harari", 2019);

        /* Add ratings and reviews*/
        book1.setRating(4.5);
        book1.addReview("Very good introduction.");
        book1.addReview("Clear examples.");

        book2.setRating(4.0);
        book2.addReview("Challenging, but useful.");

        book3.setRating(5.0);
        book3.addReview("Highly recommended.");

        /* Create library*/
        Library library = new Library();

        /* Add books*/
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        /* Display catalog*/
        library.displayBooks();

        /* Display ratings and reviews*/
        System.out.println("\nRatings and Reviews:");
        System.out.println("\"" + book1.getTitle() + "\" rating: " + book1.getRating() + ", reviews: " + book1.getReviewCount());
        System.out.println("\"" + book2.getTitle() + "\" rating: " + book2.getRating() + ", reviews: " + book2.getReviewCount());
        System.out.println("\"" + book3.getTitle() + "\" rating: " + book3.getRating() + ", reviews: " + book3.getReviewCount());
    }
}
