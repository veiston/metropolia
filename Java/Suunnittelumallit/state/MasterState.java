public class MasterState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println(character.getName() + " has already mastered everything.");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println(character.getName() + " meditates in enlightenment.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println(character.getName() + " has no equals left to fight.");
    }

    @Override
    public String getLevelName() {
        return "Master";
    }

    @Override
    public void displayAvailableActions() {
        System.out.println("Master level reached! Game completed.");
    }
}
