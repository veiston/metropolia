public class IntermediateState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println(character.getName() + " trains focusedly and gains 25 experience points.");
        character.addExperience(25);

        // Check for level advancement
        if (character.getExperiencePoints() >= 100) {
            System.out.println("Congratulations! " + character.getName() + " has reached Expert level!");
            character.setState(new ExpertState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println(character.getName() + " meditates peacefully and calmly and recovers 20 health points.");
        character.addHealth(20);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Intermediate characters cannot fight yet.");
    }

    @Override
    public String getLevelName() {
        return "Intermediate";
    }

    @Override
    public void displayAvailableActions() {
        System.out.println("Available actions: [1] Train, [2] Meditate, [0] Quit");
    }
}
