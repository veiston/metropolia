import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Sample prototypes to clone from
        Recommendation youngAdults = new Recommendation("Young adults");
        youngAdults.addBook(new Book("Suzanne Collins", "The Hunger Games", "Dystopia", 2008));
        youngAdults.addBook(new Book("John Green", "The Fault in Our Stars", "Romance", 2012));

        Recommendation sciFiFans = new Recommendation("Sci-fi fans");
        sciFiFans.addBook(new Book("Frank Herbert", "Dune", "Science fiction", 1965));
        sciFiFans.addBook(new Book("Andy Weir", "The Martian", "Science fiction", 2011));

        List<Recommendation> recommendations = new ArrayList<>(List.of(youngAdults, sciFiFans));
        new ConsoleUi(recommendations).run();
    }
}
