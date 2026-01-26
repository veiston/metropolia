package Task6LibraryUsers;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayBooks() {
        System.out.println("Library Catalog:");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println((i + 1) + ". Title: \"" + book.getTitle() + "\", Author: \"" + book.getAuthor() + "\", Year: " + book.getPublicationYear());
        }
    }

    public void displayUsers() {
        System.out.println("\nLibrary Users:");
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println((i + 1) + ". Name: \"" + user.getName() + "\", Age: " + user.getAge() + ", Borrowed: " + user.getBorrowedBooks().size());
        }
    }

    public void findBooksByAuthor(String author) {
        System.out.println("\nBooks by Author \"" + author + "\":");
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                System.out.println("Title: \"" + book.getTitle() + "\", Year: " + book.getPublicationYear());
            }
        }
    }

    public void borrowBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                books.remove(i);
                return;
            }
        }
    }

    public boolean borrowBook(User user, String title) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().equals(title)) {
                books.remove(i);
                user.borrowBook(book);
                return true;
            }
        }
        return false;
    }

    public void returnBook(Book book) {
        books.add(book);
    }

    public boolean returnBook(User user, Book book) {
        boolean removed = user.returnBook(book);
        if (removed) {
            books.add(book);
        }
        return removed;
    }

    public boolean isBookAvailable(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public double getAverageBookRating() {
        if (books.size() == 0) {
            return 0.0;
        }

        double total = 0.0;
        for (Book book : books) {
            total += book.getRating();
        }
        return total / books.size();
    }

    public Book getMostReviewedBook() {
        if (books.size() == 0) {
            return null;
        }

        Book mostReviewed = books.get(0);
        for (Book book : books) {
            if (book.getReviewCount() > mostReviewed.getReviewCount()) {
                mostReviewed = book;
            }
        }
        return mostReviewed;
    }
}
