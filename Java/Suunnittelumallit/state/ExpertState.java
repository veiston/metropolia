public class ExpertState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println(character.getName() + " trains rigorously and gains 25 experience points.");
        character.addExperience(25);
        checkLevelUp(character);
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println(character.getName() + " meditates deeply and recovers 20 health points.");
        character.addHealth(20);
    }

    @Override
    public void fight(GameCharacter character) {
        if (character.getHealthPoints() <= 25) {
            System.out.println(character.getName() + " is too exhausted to fight. Meditate to restore health first!");
            return;
        }

        System.out.println(character.getName() + " fights courageously! Gained 50 XP and lost 25 HP.");
        character.decreaseHealth(25);
        character.addExperience(50);
        checkLevelUp(character);
    }

    private void checkLevelUp(GameCharacter character) {
        if (character.getExperiencePoints() >= 200) {
            System.out.println("Incredible! " + character.getName() + " has reached Master level!");
            character.setState(new MasterState());
        }
    }

    @Override
    public String getLevelName() {
        return "Expert";
    }

    @Override
    public void displayAvailableActions() {
        System.out.println("Available actions: [1] Train, [2] Meditate, [3] Fight, [0] Quit");
    }
}
