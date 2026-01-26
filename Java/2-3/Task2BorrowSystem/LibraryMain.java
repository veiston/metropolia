package Task2BorrowSystem;

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

        /* Borrow book*/
        System.out.println("\nBorrowing: \"Mikä Liberalismia vaivaa\"");
        library.borrowBook("Mikä Liberalismia vaivaa");
        library.displayBooks();

        /* Return book*/
        System.out.println("\nReturning: \"Mikä Liberalismia vaivaa\"");
        library.returnBook(book2);
        library.displayBooks();
    }
}
