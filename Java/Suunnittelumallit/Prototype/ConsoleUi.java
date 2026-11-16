import java.util.List;
import java.util.Scanner;

public class ConsoleUi {
    private static final int INVALID_NUMBER = -1;
    private static final String END_OF_INPUT = "0"; // Closed input acts as Quit/Save

    private List<Recommendation> recommendations;
    private Scanner scanner = new Scanner(System.in);

    public ConsoleUi(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

    public void run() {
        while (true) {
            System.out.println("\n1) View recommendations  2) Clone and modify  3) Create new  0) Quit");
            switch (readNumber("Choice: ")) {
                case 1 -> showRecommendations();
                case 2 -> cloneRecommendation();
                case 3 -> createRecommendation();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Unknown choice");
            }
        }
    }

    private void showRecommendations() {
        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + recommendations.get(i));
        }
    }

    private void cloneRecommendation() {
        showRecommendations();
        int index = readNumber("Recommendation to clone: ") - 1;
        if (!isRecommendationIndex(index)) {
            System.out.println("No such recommendation");
            return;
        }
        Recommendation copy = recommendations.get(index).clone();
        editAndSave(copy);
    }

    private boolean isRecommendationIndex(int index) {
        return index >= 0 && index < recommendations.size();
    }

    private void createRecommendation() {
        editAndSave(new Recommendation(readText("Target audience: ")));
    }

    private void editAndSave(Recommendation recommendation) {
        while (true) {
            System.out.println("\n" + recommendation);
            System.out.println("1) Change audience  2) Add book  3) Remove book  0) Save");
            switch (readNumber("Choice: ")) {
                case 1 -> recommendation.setTargetAudience(readText("New target audience: "));
                case 2 -> recommendation.addBook(readBook());
                case 3 -> removeBook(recommendation);
                case 0 -> {
                    recommendations.add(recommendation);
                    System.out.println("Saved");
                    return;
                }
                default -> System.out.println("Unknown choice");
            }
        }
    }

    private void removeBook(Recommendation recommendation) {
        int index = readNumber("Book number to remove: ") - 1;
        if (!recommendation.removeBook(index)) {
            System.out.println("No such book");
        }
    }

    private Book readBook() {
        String author = readText("Author: ");
        String title = readText("Title: ");
        String genre = readText("Genre: ");
        int publicationYear = readNumber("Publication year: ");
        return new Book(author, title, genre, publicationYear);
    }

    private String readText(String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) {
            return END_OF_INPUT;
        }
        return scanner.nextLine().trim();
    }

    private int readNumber(String prompt) {
        try {
            return Integer.parseInt(readText(prompt));
        } catch (NumberFormatException e) {
            return INVALID_NUMBER;
        }
    }
}
