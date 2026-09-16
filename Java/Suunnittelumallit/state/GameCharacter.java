public class GameCharacter {
    private String name;
    private State state;
    private int experiencePoints;
    private int healthPoints;

    public GameCharacter(String name) {
        this.name = name;
        this.state = new NoviceState();
        this.experiencePoints = 0;
        this.healthPoints = 100;
    }

    public void train() {
        state.train(this);
    }

    public void meditate() {
        state.meditate(this);
    }

    public void fight() {
        state.fight(this);
    }

    public void displayStatus() {
        System.out.println("\n--------------------------------");
        System.out.println("Character: " + name);
        System.out.println("Level: " + state.getLevelName());
        System.out.println("HP: " + healthPoints + " | EXP: " + experiencePoints);
        state.displayAvailableActions();
        System.out.println("--------------------------------");
    }

    public boolean isMaster() {
        return state instanceof MasterState;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void addExperience(int points) {
        this.experiencePoints += points;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void addHealth(int points) {
        this.healthPoints += points;
    }

    public void decreaseHealth(int points) {
        this.healthPoints -= points;
    }
}
