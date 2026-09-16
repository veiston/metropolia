import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Game Character Dev System");
        System.out.print("Enter character name (or press Enter for a default name): ");
        
        String name = "Hero";
        if (scanner.hasNextLine()) {
            String inputName = scanner.nextLine().trim();
            if (!inputName.isEmpty()) {
                name = inputName;
            }
        }

        GameCharacter character = new GameCharacter(name);

        while (!character.isMaster()) {
            character.displayStatus();
            System.out.print("Choose action: ");

            if (!scanner.hasNextLine()) {
                break;
            }

            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                character.train();
            } else if (choice.equals("2")) {
                character.meditate();
            } else if (choice.equals("3")) {
                character.fight();
            } else if (choice.equals("0")) {
                System.out.println("Exiting game. Moi moi!");
                break;
            } else {
                System.out.println("That dont work");
            }
        }

        if (character.isMaster()) {
            character.displayStatus();
            System.out.println("\nCongrats! " + character.getName() + " reached Mastery. You won!");
        }

        scanner.close();
    }
}
