import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books = new ArrayList<>();

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    // Deep copy: the clone gets its own list and its own Book objects
    @Override
    public Recommendation clone() {
        try {
            Recommendation copy = (Recommendation) super.clone();
            copy.books = new ArrayList<>();
            for (Book book : books) {
                copy.books.add(book.clone());
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public List<Book> getBooks() {
        return List.copyOf(books);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(int index) {
        if (!isBookIndex(index)) {
            return false;
        }
        books.remove(index);
        return true;
    }

    private boolean isBookIndex(int index) {
        return index >= 0 && index < books.size();
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("Recommendations for " + targetAudience + ":");
        for (int i = 0; i < books.size(); i++) {
            text.append("\n  ").append(i + 1).append(". ").append(books.get(i));
        }
        return text.toString();
    }
}
