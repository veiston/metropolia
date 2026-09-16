public class NoviceState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println(character.getName() + " trains hard and gains 25 experience points.");
        character.addExperience(25);

        // Check for level advancement
        if (character.getExperiencePoints() >= 50) {
            System.out.println("Congratulations! " + character.getName() + " has reached Intermediate level!");
            character.setState(new IntermediateState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Novices cannot meditate yet.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Novices cannot fight yet.");
    }

    @Override
    public String getLevelName() {
        return "Novice";
    }

    @Override
    public void displayAvailableActions() {
        System.out.println("Available actions: [1] Train, [0] Quit");
    }
}
