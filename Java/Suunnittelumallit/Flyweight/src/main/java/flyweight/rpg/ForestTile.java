package flyweight.rpg;

public class ForestTile extends Tile {
    public ForestTile() {
        super('F', "forest");
    }

    @Override
    public void action() {
        System.out.println("Sneaking through the forest");
    }
}
