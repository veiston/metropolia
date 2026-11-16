package flyweight.rpg;

public class WaterTile extends Tile {
    public WaterTile() {
        super('W', "water");
    }

    @Override
    public void action() {
        System.out.println("Swimming across the water");
    }
}
