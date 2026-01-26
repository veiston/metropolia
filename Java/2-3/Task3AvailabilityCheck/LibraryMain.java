package Task3AvailabilityCheck;

public class LibraryMain {
    public static void main(String[] args) {
        /* Create books*/
        Book book1 = new Book("Olin isisin vanki", "Fatim", 2020);
        Book book2 = new Book("Mikä Liberalismia vaivaa", "Pontus Purokuru", 2018);
        Book book3 = new Book("Homo deus", "Yuval Noah Harari", 2019);

        /* Create library*/
        Library library = new Library();

        /* Add books*/
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        /* Display catalog*/
        library.displayBooks();

        /* Check availability*/
        String title = "Mikä Liberalismia vaivaa";
        System.out.println("\nIs \"" + title + "\" available? " + library.isBookAvailable(title));

        /* Borrow and check*/
        library.borrowBook(title);
        System.out.println("Is \"" + title + "\" available after borrowing? " + library.isBookAvailable(title));
    }
}
