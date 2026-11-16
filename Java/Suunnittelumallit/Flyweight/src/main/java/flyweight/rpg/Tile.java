package flyweight.rpg;

public abstract class Tile {
    private char character;
    private String type;

    protected Tile(char character, String type) {
        this.character = character;
        this.type = type;
    }

    public char getCharacter() {
        return character;
    }

    public String getType() {
        return type;
    }

    public abstract void action();
}
