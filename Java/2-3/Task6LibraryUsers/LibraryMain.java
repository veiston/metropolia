package Task6LibraryUsers;

public class LibraryMain {
    public static void main(String[] args) {
        /* Create books*/
        Book book1 = new Book("Olin isisin vanki", "Fatim", 2020);
        Book book2 = new Book("Mikä Liberalismia vaivaa", "Pontus Purokuru", 2018);
        Book book3 = new Book("Homo deus", "Yuval Noah Harari", 2019);

        /* Add ratings and reviews*/
        book1.setRating(4.5);
        book1.addReview("Siis aivan loistava!.");
        book2.setRating(4.0);
        book2.addReview("Mitä helee, mutta hieno.");
        book2.addReview("Ok.");

        book3.setRating(5.0);
        book3.addReview("Iso suositus!");

        /* Create users*/
        User user1 = new User("Veke", 22);
        User user2 = new User("Sami", 25);

        /* Create library*/
        Library library = new Library();

        /* Add books*/
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        /* Add users*/
        library.addUser(user1);
        library.addUser(user2);

        /* Display books and users*/
        library.displayBooks();
        library.displayUsers();

        /* Borrow book*/
        String titleToBorrow = "Mikä Liberalismia vaivaa";
        System.out.println("\nBorrowing for user \"" + user1.getName() + "\": \"" + titleToBorrow + "\"");
        boolean borrowed = library.borrowBook(user1, titleToBorrow);
        System.out.println("Borrowed: " + borrowed);

        /* Check availability and statistics*/
        System.out.println("Is \"" + titleToBorrow + "\" available? " + library.isBookAvailable(titleToBorrow));
        System.out.println("Average book rating (library): " + library.getAverageBookRating());

        Book mostReviewed = library.getMostReviewedBook();
        if (mostReviewed != null) {
            System.out.println("Most reviewed book: \"" + mostReviewed.getTitle() + "\" (" + mostReviewed.getReviewCount() + " reviews)");
        }

        /* Return book*/
        System.out.println("\nReturning the borrowed book");
        library.returnBook(user1, book2);
        System.out.println("Is \"" + titleToBorrow + "\" available after return? " + library.isBookAvailable(titleToBorrow));
        library.displayUsers();
    }
}
