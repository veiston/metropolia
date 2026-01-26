package Task5LibraryStatistics;

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

        book3.setRating(3.0);

        /* Create library*/
        Library library = new Library();

        /* Add books*/
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        /* Display catalog*/
        library.displayBooks();

        /* Display statistics*/
        System.out.println("\nAverage book rating: " + library.getAverageBookRating());

        Book mostReviewed = library.getMostReviewedBook();
        if (mostReviewed != null) {
            System.out.println("Most reviewed book: \"" + mostReviewed.getTitle() + "\" (" + mostReviewed.getReviewCount() + " reviews)");
        }
    }
}
